package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
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
public abstract class WrapperFileSystem<T extends FileSystem> extends AbstractFileSystem {
    private static final int VERSION = 1;
    protected final T mFS;

    /* JADX INFO: Access modifiers changed from: protected */
    public WrapperFileSystem(T t16) {
        this.mFS = t16;
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public int batchDelete(List<String> list) {
        return this.mFS.batchDelete(list);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return this.mFS.capabilityFlags();
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        this.mFS.configure(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        T t16 = this.mFS;
        if (t16 instanceof AbstractFileSystem) {
            return ((AbstractFileSystem) t16).copyFileImpl(str, fileSystem, str2);
        }
        return t16.copyFile(str, fileSystem, str2);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean delete(String str) {
        return this.mFS.delete(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean deleteDir(String str, boolean z16) {
        return this.mFS.deleteDir(str, z16);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean exists(String str) {
        return this.mFS.exists(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FsStat fileSystemStat(String str) {
        return this.mFS.fileSystemStat(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public Iterable<FileSystem.FileEntry> list(String str, boolean z16) {
        return this.mFS.list(str, z16);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        this.mFS.maintain(cancellationSignalCompat);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean mkdirs(String str) {
        return this.mFS.mkdirs(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        T t16 = this.mFS;
        if (t16 instanceof AbstractFileSystem) {
            return ((AbstractFileSystem) t16).moveFileImpl(str, fileSystem, str2);
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
        return this.mFS.openParcelFd(str, str2);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        return this.mFS.openRead(str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        return this.mFS.openReadWriteChannel(str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        return this.mFS.openReadWriteChannel(str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        return this.mFS.openWrite(str, z16);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        return this.mFS.openWriteChannel(str, z16);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public String realPath(String str, boolean z16) {
        return this.mFS.realPath(str, z16);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean setModifiedTime(String str, long j3) {
        return this.mFS.setModifiedTime(str, j3);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FileEntry stat(String str) {
        return this.mFS.stat(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        VFSUtils.writeFileSystemVersion(parcel, WrapperFileSystem.class, 1);
        parcel.writeParcelable(this.mFS, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WrapperFileSystem(Parcel parcel) {
        VFSUtils.checkFileSystemVersion(parcel, WrapperFileSystem.class, 1);
        T t16 = (T) parcel.readParcelable(getClass().getClassLoader());
        this.mFS = t16;
        if (t16 == null) {
            throw new IllegalArgumentException("Wrong wrapped filesystem.");
        }
    }
}
