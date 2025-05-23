package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface FileSystem extends Parcelable {
    public static final int CAP_DIRECTORIES = 8;
    public static final int CAP_DIRECT_ACCESS = 2;
    public static final int CAP_LISTABLE = 4;
    public static final int CAP_SEEKABLE = 16;
    public static final int CAP_WRITABLE = 1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class FileEntry {
        public final long diskSpace;
        final FileSystem fileSystem;
        public final boolean isDirectory;
        public final long modifiedTime;
        public final String name;
        public final String relPath;
        public final long size;

        public FileEntry(FileSystem fileSystem, String str, String str2, long j3, long j16, long j17, boolean z16) {
            this.fileSystem = fileSystem;
            this.relPath = str;
            this.name = str2;
            this.size = j3;
            this.diskSpace = j16;
            this.modifiedTime = j17;
            this.isDirectory = z16;
        }

        public boolean delete() {
            if (this.isDirectory) {
                return this.fileSystem.deleteDir(this.relPath, false);
            }
            return this.fileSystem.delete(this.relPath);
        }

        public InputStream openRead() throws FileNotFoundException {
            return this.fileSystem.openRead(this.relPath);
        }

        public OutputStream openWrite(boolean z16) throws FileNotFoundException {
            return this.fileSystem.openWrite(this.relPath, z16);
        }

        public String toString() {
            String str = this.relPath + " -> " + this.fileSystem.toString();
            if (this.isDirectory) {
                return "[DIR] " + str;
            }
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class FsStat {
        public long availableBlocks;
        public long availableSpace;
        public long blockSize;
        public long totalBlocks;
        public long totalSpace;
    }

    int batchDelete(List<String> list);

    int capabilityFlags();

    void configure(Map<String, String> map);

    long copyFile(String str, FileSystem fileSystem, String str2) throws IOException;

    boolean delete(String str);

    boolean deleteDir(String str, boolean z16);

    boolean exists(String str);

    FsStat fileSystemStat(String str);

    Iterable<FileEntry> list(String str, boolean z16);

    void maintain(CancellationSignalCompat cancellationSignalCompat);

    boolean mkdirs(String str);

    boolean moveFile(String str, FileSystem fileSystem, String str2) throws IOException;

    ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException;

    InputStream openRead(String str) throws FileNotFoundException;

    ReadableByteChannel openReadChannel(String str) throws FileNotFoundException;

    ByteChannel openReadWriteChannel(String str) throws FileNotFoundException;

    OutputStream openWrite(String str, boolean z16) throws FileNotFoundException;

    WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException;

    String realPath(String str, boolean z16);

    boolean setModifiedTime(String str, long j3);

    FileEntry stat(String str);
}
