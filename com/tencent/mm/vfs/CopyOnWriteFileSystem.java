package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CopyOnWriteFileSystem extends WrapperFileSystem<NativeFileSystem> implements Handler.Callback {
    private static final String COW_DIR = ".cow/";
    private static final char COW_LINK = '\u200b';
    private static final char COW_REFCOUNT = '\u200c';
    public static final Parcelable.Creator<CopyOnWriteFileSystem> CREATOR = new Parcelable.Creator<CopyOnWriteFileSystem>() { // from class: com.tencent.mm.vfs.CopyOnWriteFileSystem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CopyOnWriteFileSystem createFromParcel(Parcel parcel) {
            return new CopyOnWriteFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CopyOnWriteFileSystem[] newArray(int i3) {
            return new CopyOnWriteFileSystem[i3];
        }
    };
    private static final String TAG = "VFS.CopyOnWriteFileSystem";
    private static final int VERSION = 1;
    private volatile String mCowPath;
    private final HashSet<String> mCreatedDir;
    private final HashSet<String> mFlushCache;
    private final Handler mFlushHandler;
    private final long mThreshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes9.dex */
    public static final class Compat21 {
        Compat21() {
        }

        static long getINode(RandomAccessFile randomAccessFile) throws IOException {
            try {
                return Os.fstat(randomAccessFile.getFD()).st_ino;
            } catch (ErrnoException e16) {
                throw new IOException(e16);
            }
        }

        static FileSystem.FileEntry toFileEntry(String str, FileSystem fileSystem, String str2, String str3) {
            try {
                StructStat stat = Os.stat(str);
                if (stat == null) {
                    return null;
                }
                return new FileSystem.FileEntry(fileSystem, str2, str3, stat.st_size, stat.st_blocks * 512, stat.st_mtime * 1000, OsConstants.S_ISDIR(stat.st_mode));
            } catch (ErrnoException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class INodeLock {
        private static final HashSet<Long> inodeTable = new HashSet<>();

        INodeLock() {
        }

        static void lock(long j3) {
            synchronized (inodeTable) {
                while (true) {
                    HashSet<Long> hashSet = inodeTable;
                    if (!hashSet.add(Long.valueOf(j3))) {
                        try {
                            LockMethodProxy.wait(hashSet);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }

        static void unlock(long j3) {
            HashSet<Long> hashSet = inodeTable;
            synchronized (hashSet) {
                if (hashSet.remove(Long.valueOf(j3))) {
                    hashSet.notifyAll();
                }
            }
        }
    }

    public CopyOnWriteFileSystem(NativeFileSystem nativeFileSystem, long j3) {
        super(nativeFileSystem);
        this.mCowPath = null;
        this.mCreatedDir = new HashSet<>();
        this.mFlushCache = new HashSet<>();
        this.mThreshold = j3;
        this.mFlushHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int addRef(String str, int i3) {
        RandomAccessFile randomAccessFile;
        long j3;
        long j16;
        int i16 = Integer.MIN_VALUE;
        FileLock fileLock = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
            } catch (IOException e16) {
                e = e16;
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
            }
            try {
                j3 = Compat21.getINode(randomAccessFile);
            } catch (IOException e17) {
                e = e17;
                j3 = -1;
                QLog.e(TAG, 1, "Failed to update reference count.", e);
                if (fileLock != null) {
                }
                if (j3 != -1) {
                }
                VFSUtils.closeQuietly(randomAccessFile);
                return i16;
            } catch (Throwable th6) {
                th = th6;
                if (0 != 0) {
                }
                if (-1 != -1) {
                }
                VFSUtils.closeQuietly(randomAccessFile);
                throw th;
            }
            try {
                INodeLock.lock(j3);
                fileLock = randomAccessFile.getChannel().lock();
                int size = (int) randomAccessFile.getChannel().size();
                if (i3 == 0) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (j3 != -1) {
                        INodeLock.unlock(j3);
                    }
                    VFSUtils.closeQuietly(randomAccessFile);
                    return size;
                }
                i16 = size + i3;
                if (i16 <= 0) {
                    j16 = 0;
                } else {
                    j16 = i16;
                }
                randomAccessFile.setLength(j16);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused2) {
                    }
                }
                if (j3 != -1) {
                    INodeLock.unlock(j3);
                }
                VFSUtils.closeQuietly(randomAccessFile);
                return i16;
            } catch (IOException e18) {
                e = e18;
                QLog.e(TAG, 1, "Failed to update reference count.", e);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                if (j3 != -1) {
                    INodeLock.unlock(j3);
                }
                VFSUtils.closeQuietly(randomAccessFile);
                return i16;
            }
        } catch (Throwable th7) {
            th = th7;
            if (0 != 0) {
                try {
                    fileLock.release();
                } catch (IOException unused4) {
                }
            }
            if (-1 != -1) {
                INodeLock.unlock(-1L);
            }
            VFSUtils.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    private static void copyFile(String str, String str2) {
        try {
            FileChannel channel = new FileOutputStream(str2).getChannel();
            FileChannel channel2 = new FileInputStream(str).getChannel();
            channel.transferFrom(channel2, 0L, channel2.size());
        } catch (IOException e16) {
            QLog.e(TAG, 1, "Failed to copy file: " + str + " -> " + str2, e16);
        }
    }

    private FileSystem.FileEntry cowStat(FileSystem.FileEntry fileEntry) {
        String pathWithoutSuffix = pathWithoutSuffix(fileEntry.relPath);
        String resolveCowLink = resolveCowLink(pathWithoutSuffix);
        if (resolveCowLink == null) {
            return null;
        }
        return Compat21.toFileEntry(resolveCowLink, this, pathWithoutSuffix, pathWithoutSuffix(fileEntry.name));
    }

    private static String pathWithoutSuffix(String str) {
        return str.substring(0, str.length() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String resolveCowLink(String str) {
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (this.mCowPath == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((NativeFileSystem) this.mFS).realPath(str, false));
        sb5.append(COW_LINK);
        String sb6 = sb5.toString();
        try {
            try {
                fileInputStream = new FileInputStream(sb6);
                try {
                    byte[] bArr = new byte[4096];
                    int i3 = 0;
                    while (i3 < 4096) {
                        int read = fileInputStream.read(bArr, i3, 4096 - i3);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                    }
                    String str2 = new String(bArr, 0, i3);
                    VFSUtils.closeQuietly(fileInputStream);
                    return str2;
                } catch (FileNotFoundException unused) {
                    VFSUtils.closeQuietly(fileInputStream);
                    return null;
                } catch (IOException e16) {
                    e = e16;
                    QLog.e(TAG, 1, "Cannot read link file: " + sb6, e);
                    VFSUtils.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (FileNotFoundException unused2) {
                fileInputStream = null;
            } catch (IOException e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                VFSUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = sb5;
            VFSUtils.closeQuietly(closeable);
            throw th;
        }
    }

    private boolean unlinkCow(String str, boolean z16) {
        String resolveCowLink = resolveCowLink(str);
        if (resolveCowLink == null) {
            return false;
        }
        String str2 = resolveCowLink + COW_REFCOUNT;
        int addRef = addRef(str2, -1);
        if (!z16) {
            if (addRef == 0) {
                new File(resolveCowLink).delete();
                new File(str2).delete();
            }
        } else {
            String realPath = ((NativeFileSystem) this.mFS).realPath(str, true);
            if (addRef == 0) {
                if (!new File(resolveCowLink).renameTo(new File(realPath))) {
                    copyFile(resolveCowLink, realPath);
                    new File(resolveCowLink).delete();
                }
                new File(str2).delete();
            } else {
                copyFile(resolveCowLink, realPath);
            }
        }
        return true;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public int batchDelete(List<String> list) {
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (delete(it.next())) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return ((NativeFileSystem) this.mFS).capabilityFlags();
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        ((NativeFileSystem) this.mFS).configure(map);
        String basePath = ((NativeFileSystem) this.mFS).basePath();
        if (basePath != null) {
            String str = basePath + '/' + COW_DIR;
            if (str.equals(((NativeFileSystem) this.mFS).realPath(COW_DIR, false))) {
                if (!str.equals(this.mCowPath)) {
                    this.mCowPath = str;
                    new File(this.mCowPath).mkdirs();
                    synchronized (this.mCreatedDir) {
                        this.mCreatedDir.clear();
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("realPath is illegal with filesystem: " + ((NativeFileSystem) this.mFS).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem
    public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        if (fileSystem instanceof CopyOnWriteFileSystem) {
            CopyOnWriteFileSystem copyOnWriteFileSystem = (CopyOnWriteFileSystem) fileSystem;
            FileSystem.FileEntry stat = ((NativeFileSystem) copyOnWriteFileSystem.mFS).stat(str2);
            if (stat == null) {
                String resolveCowLink = copyOnWriteFileSystem.resolveCowLink(str2);
                if (resolveCowLink != null) {
                    delete(str);
                    addRef(resolveCowLink + COW_REFCOUNT, 1);
                    return ((NativeFileSystem) this.mFS).copyFileImpl(str + COW_LINK, copyOnWriteFileSystem.mFS, str2 + COW_LINK);
                }
                throw new FileNotFoundException("File not found: " + str2);
            }
            if (stat.size >= this.mThreshold) {
                return -1L;
            }
            return ((NativeFileSystem) this.mFS).copyFileImpl(str, copyOnWriteFileSystem.mFS, str2);
        }
        return ((NativeFileSystem) this.mFS).copyFileImpl(str, fileSystem, str2);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean delete(String str) {
        return ((NativeFileSystem) this.mFS).delete(str) | unlinkCow(str, false);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean deleteDir(String str, boolean z16) {
        return false;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean exists(String str) {
        if (!((NativeFileSystem) this.mFS).exists(str)) {
            if (!((NativeFileSystem) this.mFS).exists(str + COW_LINK)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public FileSystem.FsStat fileSystemStat(String str) {
        return ((NativeFileSystem) this.mFS).fileSystemStat(str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public Iterable<FileSystem.FileEntry> list(String str, boolean z16) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem
    public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        return false;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        try {
            InputStream openRead = ((NativeFileSystem) this.mFS).openRead(str);
            if (openRead != null) {
                return openRead;
            }
            throw new FileNotFoundException("Filesystem returns null for path: " + str + ", FS: " + ((NativeFileSystem) this.mFS).toString());
        } catch (FileNotFoundException e16) {
            String resolveCowLink = resolveCowLink(str);
            if (resolveCowLink != null) {
                return new NativeFileSystem.SeekableFileInputStream(resolveCowLink);
            }
            throw e16;
        }
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        InputStream openRead = openRead(str);
        if (openRead instanceof FileInputStream) {
            return ((FileInputStream) openRead).getChannel();
        }
        return Channels.newChannel(openRead);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        unlinkCow(str, true);
        return ((NativeFileSystem) this.mFS).openReadWriteChannel(str);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        unlinkCow(str, z16);
        return ((NativeFileSystem) this.mFS).openWrite(str, z16);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        OutputStream openWrite = openWrite(str, z16);
        if (openWrite instanceof FileOutputStream) {
            return ((FileOutputStream) openWrite).getChannel();
        }
        return Channels.newChannel(openWrite);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public String realPath(String str, boolean z16) {
        String realPath = ((NativeFileSystem) this.mFS).realPath(str, z16);
        if (!z16 && !new File(realPath).exists()) {
            String resolveCowLink = resolveCowLink(str);
            if (new File(resolveCowLink).exists()) {
                return resolveCowLink;
            }
        }
        return realPath;
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean setModifiedTime(String str, long j3) {
        if (((NativeFileSystem) this.mFS).setModifiedTime(str, j3)) {
            return true;
        }
        return ((NativeFileSystem) this.mFS).setModifiedTime(str + COW_LINK, j3);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public FileSystem.FileEntry stat(String str) {
        FileSystem.FileEntry stat = ((NativeFileSystem) this.mFS).stat(str);
        if (stat != null) {
            return stat;
        }
        FileSystem.FileEntry stat2 = ((NativeFileSystem) this.mFS).stat(str + COW_LINK);
        if (stat2 == null) {
            return null;
        }
        return cowStat(stat2);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        VFSUtils.writeFileSystemVersion(parcel, CopyOnWriteFileSystem.class, 1);
        parcel.writeLong(this.mThreshold);
    }

    protected CopyOnWriteFileSystem(Parcel parcel) {
        super(parcel);
        this.mCowPath = null;
        this.mCreatedDir = new HashSet<>();
        this.mFlushCache = new HashSet<>();
        VFSUtils.checkFileSystemVersion(parcel, CopyOnWriteFileSystem.class, 1);
        this.mThreshold = parcel.readLong();
        this.mFlushHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
    }
}
