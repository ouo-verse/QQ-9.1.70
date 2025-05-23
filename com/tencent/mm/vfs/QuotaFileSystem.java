package com.tencent.mm.vfs;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QuotaFileSystem extends DelegateFileSystem implements Handler.Callback {
    public static final Parcelable.Creator<QuotaFileSystem> CREATOR = new Parcelable.Creator<QuotaFileSystem>() { // from class: com.tencent.mm.vfs.QuotaFileSystem.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuotaFileSystem createFromParcel(Parcel parcel) {
            return new QuotaFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuotaFileSystem[] newArray(int i3) {
            return new QuotaFileSystem[i3];
        }
    };
    public static final String STAT_DESTINATION = "destination";
    public static final String STAT_DIR_COUNT = "dirCount";
    public static final String STAT_FILE_COUNT = "fileCount";
    public static final String STAT_TOTAL_SIZE = "totalSize";
    private static final String TAG = "VFS.QuotaFileSystem";
    private static final int VERSION = 2;
    private HashMap<String, Long> mAccessTimeCache;
    private final long mCleaningThreshold;
    private final boolean mEmulateAccessTime;
    private final long mExpireTime;
    private final FileSystem mFS;
    private final Iterable<FileSystem> mFSList;
    private final Handler mFlushCacheHandler;
    private final long mTargetSize;
    private final Object mCacheLock = new Object();
    private final long FLUSH_CACHE_DELAY = 60000;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class DirEntry {
        int childCount = 0;
        FileSystem.FileEntry entry;

        DirEntry(FileSystem.FileEntry fileEntry) {
            this.entry = fileEntry;
        }

        public String toString() {
            return "children: " + this.childCount + " [" + this.entry + "]";
        }
    }

    public QuotaFileSystem(FileSystem fileSystem, long j3, long j16, long j17, boolean z16) {
        this.mFS = fileSystem;
        this.mFSList = Collections.singletonList(fileSystem);
        this.mTargetSize = j3;
        this.mCleaningThreshold = j16;
        this.mExpireTime = j17;
        this.mEmulateAccessTime = z16;
        if (z16) {
            this.mAccessTimeCache = new HashMap<>();
            this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
        } else {
            this.mAccessTimeCache = null;
            this.mFlushCacheHandler = null;
        }
        checkParameters();
    }

    private void checkParameters() {
        if (this.mCleaningThreshold >= this.mTargetSize) {
        } else {
            throw new IllegalArgumentException("Cleaning threshold must not less than target size.");
        }
    }

    private void doMaintenance(CancellationSignalCompat cancellationSignalCompat) {
        int i3;
        int i16;
        int i17;
        int i18;
        HashMap hashMap;
        HashMap<String, Long> hashMap2;
        long j3 = 0;
        try {
            int capabilityFlags = this.mFS.capabilityFlags();
            if ((capabilityFlags & 1) == 0) {
                QLog.e(TAG, 1, "No quota operation can be done on read-only file system: " + this.mFS.toString());
                return;
            }
            if ((capabilityFlags & 4) == 0) {
                QLog.e(TAG, 1, "No quota operation can be done on non-listable file system: " + this.mFS.toString());
                return;
            }
            cancellationSignalCompat.throwIfCanceled();
            statistics(1, "destination", this.mFS);
            if (this.mEmulateAccessTime) {
                synchronized (this.mCacheLock) {
                    if (!this.mAccessTimeCache.isEmpty()) {
                        hashMap2 = this.mAccessTimeCache;
                        this.mAccessTimeCache = new HashMap<>();
                    } else {
                        hashMap2 = null;
                    }
                }
                if (hashMap2 != null) {
                    for (Map.Entry<String, Long> entry : hashMap2.entrySet()) {
                        cancellationSignalCompat.throwIfCanceled();
                        this.mFS.setModifiedTime(entry.getKey(), entry.getValue().longValue());
                    }
                }
            }
            cancellationSignalCompat.throwIfCanceled();
            ArrayList<FileSystem.FileEntry> arrayList = new ArrayList();
            Iterable<FileSystem.FileEntry> list = this.mFS.list("", true);
            if (list == null) {
                QLog.e(TAG, 1, "Unable to list files in FS: " + toString());
                return;
            }
            long j16 = 0;
            i16 = 0;
            int i19 = 0;
            for (FileSystem.FileEntry fileEntry : list) {
                try {
                    cancellationSignalCompat.throwIfCanceled();
                    long j17 = fileEntry.diskSpace;
                    if (j17 < 0) {
                        j17 = fileEntry.size;
                    }
                    j16 += j17;
                    if (fileEntry.isDirectory) {
                        i19++;
                    } else {
                        i16++;
                    }
                    arrayList.add(fileEntry);
                } catch (Exception e16) {
                    e = e16;
                    j3 = j16;
                    i3 = i19;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "Total size: " + j16 + ", Cleaning threshold: " + this.mCleaningThreshold);
            }
            statistics(2, STAT_FILE_COUNT, Integer.valueOf(i16), STAT_DIR_COUNT, Integer.valueOf(i19), "totalSize", Long.valueOf(j16));
            if (j16 <= this.mCleaningThreshold) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Threshold not reached, skip cleaning.");
                }
                statistics(6, STAT_FILE_COUNT, Integer.valueOf(i16), STAT_DIR_COUNT, Integer.valueOf(i19), "totalSize", Long.valueOf(j16));
                return;
            }
            if ((capabilityFlags & 8) != 0) {
                hashMap = new HashMap();
                for (FileSystem.FileEntry fileEntry2 : arrayList) {
                    if (fileEntry2.isDirectory && !hashMap.containsKey(fileEntry2.relPath)) {
                        hashMap.put(fileEntry2.relPath, new DirEntry(fileEntry2));
                    }
                    String parentPath = VFSUtils.getParentPath(fileEntry2.relPath);
                    if (parentPath != null) {
                        DirEntry dirEntry = (DirEntry) hashMap.get(parentPath);
                        if (dirEntry == null) {
                            dirEntry = new DirEntry(fileEntry2);
                            hashMap.put(parentPath, dirEntry);
                        }
                        dirEntry.childCount++;
                    }
                }
                cancellationSignalCompat.throwIfCanceled();
            } else {
                hashMap = null;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (FileSystem.FileEntry fileEntry3 : arrayList) {
                if (!fileEntry3.isDirectory) {
                    arrayList2.add(fileEntry3);
                }
            }
            Collections.sort(arrayList2, new Comparator<FileSystem.FileEntry>() { // from class: com.tencent.mm.vfs.QuotaFileSystem.1
                private final long timeThreshold;

                {
                    this.timeThreshold = System.currentTimeMillis() - QuotaFileSystem.this.mExpireTime;
                }

                @Override // java.util.Comparator
                public int compare(FileSystem.FileEntry fileEntry4, FileSystem.FileEntry fileEntry5) {
                    int longSigning;
                    long j18 = fileEntry4.modifiedTime;
                    long j19 = this.timeThreshold;
                    return ((j18 >= j19 || fileEntry5.modifiedTime >= j19) && (longSigning = QuotaFileSystem.longSigning(fileEntry5.modifiedTime - j18)) != 0) ? longSigning : QuotaFileSystem.longSigning(fileEntry4.diskSpace - fileEntry5.diskSpace);
                }
            });
            int size = arrayList2.size() - 1;
            while (j16 > this.mTargetSize && size >= 0) {
                cancellationSignalCompat.throwIfCanceled();
                int i26 = size - 1;
                FileSystem.FileEntry fileEntry4 = (FileSystem.FileEntry) arrayList2.get(size);
                String str = fileEntry4.relPath;
                if (this.mFS.delete(str)) {
                    long j18 = fileEntry4.diskSpace;
                    if (j18 < 0) {
                        j18 = fileEntry4.size;
                    }
                    j16 -= j18;
                    i16--;
                }
                if (hashMap != null) {
                    for (String parentPath2 = VFSUtils.getParentPath(str); parentPath2 != null; parentPath2 = VFSUtils.getParentPath(parentPath2)) {
                        DirEntry dirEntry2 = (DirEntry) hashMap.get(parentPath2);
                        if (dirEntry2 == null) {
                            break;
                        }
                        int i27 = dirEntry2.childCount - 1;
                        dirEntry2.childCount = i27;
                        if (i27 == 0 && this.mFS.deleteDir(parentPath2, false)) {
                            FileSystem.FileEntry fileEntry5 = dirEntry2.entry;
                            long j19 = fileEntry5.diskSpace;
                            if (j19 < 0) {
                                j19 = fileEntry5.size;
                            }
                            j16 -= j19;
                            i19--;
                            hashMap.remove(parentPath2);
                        }
                    }
                }
                size = i26;
            }
            if (hashMap != null) {
                for (DirEntry dirEntry3 : hashMap.values()) {
                    if (dirEntry3.childCount == 0) {
                        cancellationSignalCompat.throwIfCanceled();
                        if (this.mFS.deleteDir(dirEntry3.entry.relPath, false)) {
                            FileSystem.FileEntry fileEntry6 = dirEntry3.entry;
                            long j26 = fileEntry6.diskSpace;
                            if (j26 < 0) {
                                j26 = fileEntry6.size;
                            }
                            j16 -= j26;
                            i19--;
                        }
                    }
                }
            }
            j3 = j16;
            i3 = i19;
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "Maintenance done. files: " + i16 + ", dirs: " + i3 + ", totalSize: " + j3);
                }
                statistics(3, STAT_FILE_COUNT, Integer.valueOf(i16), STAT_DIR_COUNT, Integer.valueOf(i3), "totalSize", Long.valueOf(j3));
            } catch (Exception e17) {
                e = e17;
                if (e instanceof OperationCanceledException) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "Maintenance cancelled. files: " + i16 + ", dirs: " + i3 + ", totalSize: " + j3);
                    }
                    i18 = 4;
                    i17 = 6;
                } else {
                    QLog.e(TAG, 1, "Maintenance failed.", e);
                    i17 = 6;
                    i18 = 5;
                }
                Object[] objArr = new Object[i17];
                objArr[0] = STAT_FILE_COUNT;
                objArr[1] = Integer.valueOf(i16);
                objArr[2] = STAT_DIR_COUNT;
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = "totalSize";
                objArr[5] = Long.valueOf(j3);
                statistics(i18, objArr);
                throw e;
            }
        } catch (Exception e18) {
            e = e18;
            i3 = 0;
            i16 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int longSigning(long j3) {
        if (j3 == 0) {
            return 0;
        }
        if (j3 > 0) {
            return 1;
        }
        return -1;
    }

    private void updateAccessTime(String str, boolean z16) {
        boolean isEmpty;
        if (!this.mEmulateAccessTime) {
            return;
        }
        if (z16) {
            synchronized (this.mCacheLock) {
                this.mAccessTimeCache.remove(str);
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mCacheLock) {
            isEmpty = this.mAccessTimeCache.isEmpty();
            this.mAccessTimeCache.put(str, Long.valueOf(currentTimeMillis));
        }
        if (isEmpty) {
            this.mFlushCacheHandler.sendMessageDelayed(Message.obtain(), 60000L);
        }
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem
    protected Iterable<FileSystem> allFileSystems() {
        return this.mFSList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.DelegateFileSystem
    public FileSystem delegate(String str, int i3) {
        return this.mFS;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        HashMap<String, Long> hashMap;
        synchronized (this.mCacheLock) {
            if (!this.mAccessTimeCache.isEmpty()) {
                hashMap = this.mAccessTimeCache;
                this.mAccessTimeCache = new HashMap<>();
            } else {
                hashMap = null;
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                this.mFS.setModifiedTime(entry.getKey(), entry.getValue().longValue());
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "Flush access time cache entries: " + hashMap.size());
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        doMaintenance(cancellationSignalCompat);
        super.maintain(cancellationSignalCompat);
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
        ParcelFileDescriptor openParcelFd = this.mFS.openParcelFd(str, str2);
        updateAccessTime(str, str2.contains("w"));
        return openParcelFd;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        InputStream openRead = this.mFS.openRead(str);
        updateAccessTime(str, false);
        return openRead;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        ReadableByteChannel openReadChannel = this.mFS.openReadChannel(str);
        updateAccessTime(str, false);
        return openReadChannel;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        ByteChannel openReadWriteChannel = this.mFS.openReadWriteChannel(str);
        updateAccessTime(str, true);
        return openReadWriteChannel;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        OutputStream openWrite = this.mFS.openWrite(str, z16);
        updateAccessTime(str, true);
        return openWrite;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        WritableByteChannel openWriteChannel = this.mFS.openWriteChannel(str, z16);
        updateAccessTime(str, true);
        return openWriteChannel;
    }

    public String toString() {
        return "QuotaFS [" + ((this.mTargetSize / 1024) / 1024) + "MB | " + this.mFS.toString() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        VFSUtils.writeFileSystemVersion(parcel, QuotaFileSystem.class, 2);
        parcel.writeParcelable(this.mFS, i3);
        parcel.writeLong(this.mTargetSize);
        parcel.writeLong(this.mCleaningThreshold);
        parcel.writeLong(this.mExpireTime);
        parcel.writeByte(this.mEmulateAccessTime ? (byte) 1 : (byte) 0);
    }

    protected QuotaFileSystem(Parcel parcel) {
        VFSUtils.checkFileSystemVersion(parcel, QuotaFileSystem.class, 2);
        FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        this.mFS = fileSystem;
        if (fileSystem != null) {
            this.mFSList = Collections.singletonList(fileSystem);
            this.mTargetSize = parcel.readLong();
            this.mCleaningThreshold = parcel.readLong();
            this.mExpireTime = parcel.readLong();
            boolean z16 = parcel.readByte() != 0;
            this.mEmulateAccessTime = z16;
            if (z16) {
                this.mAccessTimeCache = new HashMap<>();
                this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
            } else {
                this.mAccessTimeCache = null;
                this.mFlushCacheHandler = null;
            }
            checkParameters();
            return;
        }
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
}
