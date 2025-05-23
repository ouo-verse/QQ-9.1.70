package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.VFSUtils;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class DelegateFileSystem extends AbstractFileSystem {
    protected static final int DELEGATE_MAIN = 0;
    protected static final int DELEGATE_READ = 1;
    protected static final int DELEGATE_WRITE = 2;
    protected static final int DELEGATE_WRITE_EXISTING = 3;

    protected abstract Iterable<FileSystem> allFileSystems();

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public int batchDelete(List<String> list) {
        Iterator<FileSystem> it = allFileSystems().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().batchDelete(list);
        }
        return i3;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return delegate("", 0).capabilityFlags();
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        Iterator<FileSystem> it = allFileSystems().iterator();
        while (it.hasNext()) {
            it.next().configure(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public final long copyFileImpl(String str, FileSystem fileSystem, String str2) {
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract FileSystem delegate(String str, int i3);

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean delete(String str) {
        Iterator<FileSystem> it = allFileSystems().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= it.next().delete(str);
        }
        return z16;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean deleteDir(String str, boolean z16) {
        Iterator<FileSystem> it = allFileSystems().iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            z17 |= it.next().deleteDir(str, z16);
        }
        return z17;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean exists(String str) {
        FileSystem delegate = delegate(str, 1);
        if (delegate != null && delegate.exists(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FsStat fileSystemStat(String str) {
        FileSystem delegate = delegate(str, 0);
        if (delegate != null) {
            return delegate.fileSystemStat(str);
        }
        throw new RuntimeException("Cannot delegate path to filesystem: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public Iterable<FileSystem.FileEntry> list(final String str, final boolean z16) {
        return new Iterable<FileSystem.FileEntry>() { // from class: com.tencent.mm.vfs.DelegateFileSystem.1
            @Override // java.lang.Iterable
            public Iterator<FileSystem.FileEntry> iterator() {
                return new VFSUtils.CascadeIterator<FileSystem, FileSystem.FileEntry>(DelegateFileSystem.this.allFileSystems().iterator()) { // from class: com.tencent.mm.vfs.DelegateFileSystem.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.tencent.mm.vfs.VFSUtils.CascadeIterator
                    public FileSystem.FileEntry convert(FileSystem fileSystem) {
                        return null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.tencent.mm.vfs.VFSUtils.CascadeIterator
                    public Iterator<? extends FileSystem.FileEntry> traversal(FileSystem fileSystem, FileSystem.FileEntry fileEntry) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Iterable<FileSystem.FileEntry> list = fileSystem.list(str, z16);
                        if (list == null) {
                            return null;
                        }
                        return list.iterator();
                    }
                };
            }
        };
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        for (FileSystem fileSystem : allFileSystems()) {
            cancellationSignalCompat.throwIfCanceled();
            fileSystem.maintain(cancellationSignalCompat);
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean mkdirs(String str) {
        FileSystem delegate = delegate(str, 2);
        if (delegate != null && delegate.mkdirs(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public final boolean moveFileImpl(String str, FileSystem fileSystem, String str2) {
        throw new AssertionError();
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ParcelFileDescriptor openParcelFd(String str, String str2) throws FileNotFoundException {
        int i3;
        if (str2.contains("rw")) {
            i3 = 3;
        } else if (str2.contains("w")) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        FileSystem delegate = delegate(str, i3);
        if (delegate != null) {
            return delegate.openParcelFd(str, str2);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        FileSystem delegate = delegate(str, 1);
        if (delegate != null) {
            return delegate.openRead(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        FileSystem delegate = delegate(str, 1);
        if (delegate != null) {
            return delegate.openReadChannel(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ByteChannel openReadWriteChannel(String str) throws FileNotFoundException {
        FileSystem delegate = delegate(str, 3);
        if (delegate != null) {
            return delegate.openReadWriteChannel(str);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        int i3;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        FileSystem delegate = delegate(str, i3);
        if (delegate != null) {
            return delegate.openWrite(str, z16);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        int i3;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        FileSystem delegate = delegate(str, i3);
        if (delegate != null) {
            return delegate.openWriteChannel(str, z16);
        }
        throw new FileNotFoundException("Path not found on any filesystems: " + str);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public String realPath(String str, boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        FileSystem delegate = delegate(str, i3);
        if (delegate == null) {
            return null;
        }
        return delegate.realPath(str, z16);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public boolean setModifiedTime(String str, long j3) {
        FileSystem delegate = delegate(str, 3);
        if (delegate != null && delegate.setModifiedTime(str, j3)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.FileEntry stat(String str) {
        FileSystem delegate = delegate(str, 1);
        if (delegate == null) {
            return null;
        }
        return delegate.stat(str);
    }
}
