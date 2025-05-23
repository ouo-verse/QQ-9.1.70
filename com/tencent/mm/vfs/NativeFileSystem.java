package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.VFSUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
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
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NativeFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<NativeFileSystem> CREATOR = new Parcelable.Creator<NativeFileSystem>() { // from class: com.tencent.mm.vfs.NativeFileSystem.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeFileSystem createFromParcel(Parcel parcel) {
            return new NativeFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeFileSystem[] newArray(int i3) {
            return new NativeFileSystem[i3];
        }
    };
    private static final long DEFAULT_BLOCK_SIZE = 4096;
    private static final String TAG = "VFS.NativeFileSystem";
    private static final int VERSION = 2;
    private final String mBasePath;
    private boolean mBasePathCreateSuccess;
    private boolean mBasePathCreated;
    private boolean mHasMacro;
    private final boolean mMacroFree;
    private volatile String mRealBasePath;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes9.dex */
    public static final class Compat21 {
        Compat21() {
        }

        static boolean rename(String str, String str2) throws IOException {
            try {
                Os.rename(str, str2);
                return true;
            } catch (ErrnoException e16) {
                if (e16.errno == OsConstants.EXDEV) {
                    return false;
                }
                if (e16.errno == OsConstants.ENOENT) {
                    throw new FileNotFoundException("Cannot move file " + str + " to " + str2 + MsgSummary.STR_COLON + e16.getMessage());
                }
                throw new IOException("Cannot move file " + str + " to " + str2 + MsgSummary.STR_COLON + e16.getMessage());
            }
        }

        static FileSystem.FileEntry toFileEntry(File file, FileSystem fileSystem, String str, String str2) {
            try {
                StructStat stat = Os.stat(file.getPath());
                if (stat == null) {
                    return null;
                }
                return new FileSystem.FileEntry(fileSystem, str, str2, stat.st_size, stat.st_blocks * 512, stat.st_mtime * 1000, OsConstants.S_ISDIR(stat.st_mode));
            } catch (ErrnoException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class FileEntryIterator extends VFSUtils.CascadeIterator<File, FileSystem.FileEntry> {
        private final boolean mRecursive;

        FileEntryIterator(NativeFileSystem nativeFileSystem, File file, boolean z16, boolean z17) {
            this((List<File>) Collections.singletonList(file), z16, z17);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.mm.vfs.VFSUtils.CascadeIterator
        public FileSystem.FileEntry convert(File file) {
            return NativeFileSystem.this.toFileEntry(file);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.mm.vfs.VFSUtils.CascadeIterator
        public Iterator<? extends FileSystem.FileEntry> traversal(File file, FileSystem.FileEntry fileEntry) {
            File[] listFiles;
            if (!this.mRecursive) {
                return null;
            }
            if ((fileEntry != null && !fileEntry.isDirectory) || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return null;
            }
            return new FileEntryIterator((List<File>) Arrays.asList(listFiles), this.mChildrenFirst, true);
        }

        FileEntryIterator(List<File> list, boolean z16, boolean z17) {
            super(list.iterator(), z16);
            this.mRecursive = z17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class SeekableFileInputStream extends FileInputStream {
        private long mMarkPosition;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SeekableFileInputStream(String str) throws FileNotFoundException {
            super(str);
            this.mMarkPosition = 0L;
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            try {
                this.mMarkPosition = getChannel().position();
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            getChannel().position(this.mMarkPosition);
        }
    }

    public NativeFileSystem(String str) {
        this(str, true);
    }

    private static long channelCopy(String str, FileSystem fileSystem, String str2) throws IOException {
        ReadableByteChannel readableByteChannel;
        long j3;
        try {
            readableByteChannel = fileSystem.openReadChannel(str2);
        } catch (Throwable th5) {
            th = th5;
            readableByteChannel = null;
        }
        try {
            FileChannel channel = new FileOutputStream(str).getChannel();
            if (Build.VERSION.SDK_INT > 23) {
                j3 = channel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            } else {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192);
                j3 = 0;
                while (readableByteChannel.read(allocateDirect) >= 0) {
                    allocateDirect.flip();
                    j3 += channel.write(allocateDirect);
                    allocateDirect.clear();
                }
            }
            VFSUtils.closeQuietly(channel);
            VFSUtils.closeQuietly(readableByteChannel);
            return j3;
        } catch (Throwable th6) {
            th = th6;
            VFSUtils.closeQuietly((Closeable) null);
            VFSUtils.closeQuietly(readableByteChannel);
            throw th;
        }
    }

    private void ensureBasePath(String str) {
        File absoluteFile;
        if (this.mHasMacro) {
            File file = new File(str);
            try {
                absoluteFile = file.getCanonicalFile();
            } catch (IOException unused) {
                absoluteFile = file.getAbsoluteFile();
            }
            if (!absoluteFile.isDirectory() && absoluteFile.exists()) {
                QLog.e(TAG, 1, "Base directory exists but is not a directory, delete and proceed.Base path: " + absoluteFile.getPath());
                absoluteFile.delete();
            }
            this.mRealBasePath = absoluteFile.getPath();
        } else {
            this.mRealBasePath = str;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Real path resolved: " + this.mBasePath + " => " + this.mRealBasePath);
        }
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (!"w".equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                return 704643072;
            }
            if ("rw".equals(str)) {
                return 939524096;
            }
            if ("rwt".equals(str)) {
                return 1006632960;
            }
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return 738197504;
    }

    private static boolean recursiveDelete(File file, boolean z16) {
        boolean delete;
        File[] listFiles = file.listFiles();
        boolean z17 = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    delete = recursiveDelete(file2, false);
                } else {
                    delete = file2.delete();
                }
                z17 &= delete;
            }
        }
        if (!z16) {
            return z17 & file.delete();
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileSystem.FileEntry toFileEntry(File file) {
        String substring;
        String str = this.mRealBasePath;
        if (file.getPath().startsWith(str)) {
            if (file.getPath().length() == str.length()) {
                substring = "";
            } else {
                substring = file.getPath().substring(str.length() + 1);
            }
            return Compat21.toFileEntry(file, this, substring, file.getName());
        }
        throw new RuntimeException("Illegal file: " + file + " (base: " + str + ")");
    }

    public String basePath() {
        return this.mRealBasePath;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return 31;
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        if (!this.mMacroFree) {
            String str = this.mRealBasePath;
            String str2 = this.mBasePath;
            if (this.mHasMacro) {
                str2 = VFSUtils.macroResolve(str2, map);
            }
            if (str2 != null && !str2.equals(str)) {
                ensureBasePath(str2);
                this.mBasePathCreated = false;
            } else if (str2 == null) {
                this.mRealBasePath = null;
                this.mBasePathCreated = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        String realPath = realPath(str, true);
        if (realPath != null) {
            return channelCopy(realPath, fileSystem, str2);
        }
        throw new IOException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean delete(String str) {
        String realPath = realPath(str, false);
        if (realPath == null) {
            return false;
        }
        return new File(realPath).delete();
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean deleteDir(String str, boolean z16) {
        boolean z17;
        if (!str.isEmpty() && !str.equals("/")) {
            z17 = false;
        } else {
            z17 = true;
        }
        File file = new File(realPath(str, false));
        if (!file.isDirectory()) {
            return false;
        }
        if (z16) {
            return recursiveDelete(file, z17);
        }
        return file.delete();
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean exists(String str) {
        String realPath = realPath(str, false);
        if (realPath == null || !new File(realPath).exists()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FsStat fileSystemStat(String str) {
        if (str == null) {
            str = "";
        }
        try {
            StatFs statFs = new StatFs(realPath(str, false));
            FileSystem.FsStat fsStat = new FileSystem.FsStat();
            fsStat.blockSize = statFs.getBlockSizeLong();
            fsStat.availableBlocks = statFs.getAvailableBlocksLong();
            long blockCountLong = statFs.getBlockCountLong();
            fsStat.totalBlocks = blockCountLong;
            long j3 = fsStat.availableBlocks;
            long j16 = fsStat.blockSize;
            fsStat.availableSpace = j3 * j16;
            fsStat.totalSpace = blockCountLong * j16;
            return fsStat;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public Iterable<FileSystem.FileEntry> list(String str, final boolean z16) {
        final File file = new File(realPath(str, false));
        if (!file.isDirectory()) {
            return null;
        }
        return new Iterable<FileSystem.FileEntry>() { // from class: com.tencent.mm.vfs.NativeFileSystem.1
            @Override // java.lang.Iterable
            public Iterator<FileSystem.FileEntry> iterator() {
                return new FileEntryIterator(file, false, z16) { // from class: com.tencent.mm.vfs.NativeFileSystem.1.1
                    {
                        NativeFileSystem nativeFileSystem = NativeFileSystem.this;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.tencent.mm.vfs.NativeFileSystem.FileEntryIterator, com.tencent.mm.vfs.VFSUtils.CascadeIterator
                    public FileSystem.FileEntry convert(File file2) {
                        return null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.tencent.mm.vfs.NativeFileSystem.FileEntryIterator, com.tencent.mm.vfs.VFSUtils.CascadeIterator
                    public Iterator<? extends FileSystem.FileEntry> traversal(File file2, FileSystem.FileEntry fileEntry) {
                        File[] listFiles = file2.listFiles();
                        if (listFiles == null) {
                            return null;
                        }
                        return new FileEntryIterator(Arrays.asList(listFiles), this.mChildrenFirst, z16);
                    }
                };
            }
        };
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean mkdirs(String str) {
        String realPath = realPath(str, true);
        if (realPath == null) {
            return false;
        }
        if (this.mBasePathCreateSuccess && TextUtils.equals(realPath, this.mRealBasePath)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mkdirs is called! basePath has been created!");
            }
            return true;
        }
        return new File(realPath).mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        if ((fileSystem.capabilityFlags() & 2) != 0) {
            String realPath = fileSystem.realPath(str2, false);
            String realPath2 = realPath(str, true);
            if (realPath != null && realPath2 != null) {
                return Compat21.rename(realPath, realPath2);
            }
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
        String realPath = realPath(str, true);
        if (realPath != null) {
            return ParcelFileDescriptor.open(new File(realPath), modeToMode(str2));
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        String realPath = realPath(str, false);
        if (realPath != null) {
            return new SeekableFileInputStream(realPath);
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        String realPath = realPath(str, false);
        if (realPath != null) {
            return new FileInputStream(realPath).getChannel();
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        String realPath = realPath(str, true);
        if (realPath != null) {
            return new RandomAccessFile(realPath, "rw").getChannel();
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        String realPath = realPath(str, true);
        if (realPath != null) {
            return new FileOutputStream(realPath, z16);
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        String realPath = realPath(str, true);
        if (realPath != null) {
            return new FileOutputStream(realPath, z16).getChannel();
        }
        throw new FileNotFoundException("Invalid path: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public String realPath(String str, boolean z16) {
        String str2 = this.mRealBasePath;
        if (str2 != null) {
            if (z16 && !this.mBasePathCreated) {
                this.mBasePathCreateSuccess = new File(this.mRealBasePath).mkdirs();
                this.mBasePathCreated = true;
            }
            if (!str.isEmpty()) {
                return str2 + '/' + str;
            }
            return str2;
        }
        throw new IllegalStateException("Base path cannot be resolved: " + this.mBasePath);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean setModifiedTime(String str, long j3) {
        return new File(realPath(str, true)).setLastModified(j3);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FileEntry stat(String str) {
        return toFileEntry(new File(realPath(str, false)));
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Native [");
        if (this.mRealBasePath == null) {
            str = this.mBasePath;
        } else {
            str = this.mRealBasePath;
        }
        sb5.append(str);
        sb5.append("]");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        VFSUtils.writeFileSystemVersion(parcel, NativeFileSystem.class, 2);
        parcel.writeInt(this.mHasMacro ? 1 : 0);
        parcel.writeString(this.mBasePath);
    }

    public NativeFileSystem(String str, boolean z16) {
        String normalizePathSimple = VFSUtils.normalizePathSimple(str);
        this.mBasePath = normalizePathSimple;
        this.mHasMacro = z16;
        if (normalizePathSimple.isEmpty()) {
            this.mRealBasePath = normalizePathSimple;
            this.mMacroFree = true;
            this.mBasePathCreated = true;
            return;
        }
        normalizePathSimple = z16 ? VFSUtils.macroResolve(normalizePathSimple, FileSystemManager.instance().staticEnvironment()) : normalizePathSimple;
        if (normalizePathSimple != null) {
            ensureBasePath(normalizePathSimple);
            this.mMacroFree = true;
        } else {
            this.mRealBasePath = null;
            this.mMacroFree = false;
        }
        this.mBasePathCreated = false;
    }

    protected NativeFileSystem(Parcel parcel) {
        VFSUtils.checkFileSystemVersion(parcel, NativeFileSystem.class, 2);
        this.mHasMacro = parcel.readInt() == 1;
        String readString = parcel.readString();
        String normalizePathSimple = readString == null ? "" : VFSUtils.normalizePathSimple(readString);
        this.mBasePath = normalizePathSimple;
        if (normalizePathSimple.isEmpty()) {
            this.mRealBasePath = normalizePathSimple;
            this.mMacroFree = true;
            this.mBasePathCreated = true;
            return;
        }
        normalizePathSimple = this.mHasMacro ? VFSUtils.macroResolve(normalizePathSimple, FileSystemManager.instance().staticEnvironment()) : normalizePathSimple;
        if (normalizePathSimple != null) {
            ensureBasePath(normalizePathSimple);
            this.mMacroFree = true;
        } else {
            this.mRealBasePath = null;
            this.mMacroFree = false;
        }
        this.mBasePathCreated = false;
    }
}
