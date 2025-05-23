package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.vfs.FileSystem;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ExpireFileSystem extends DelegateFileSystem {
    public static final Parcelable.Creator<ExpireFileSystem> CREATOR = new Parcelable.Creator<ExpireFileSystem>() { // from class: com.tencent.mm.vfs.ExpireFileSystem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExpireFileSystem createFromParcel(Parcel parcel) {
            return new ExpireFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExpireFileSystem[] newArray(int i3) {
            return new ExpireFileSystem[i3];
        }
    };
    private static final int VERSION = 1;
    private final long mExpireTime;
    private final FileSystem mFS;
    private final Iterable<FileSystem> mFSList;

    public ExpireFileSystem(FileSystem fileSystem, long j3) {
        this.mFS = fileSystem;
        this.mFSList = Collections.singletonList(fileSystem);
        this.mExpireTime = j3;
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

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        long currentTimeMillis = System.currentTimeMillis() - this.mExpireTime;
        Iterable<FileSystem.FileEntry> list = this.mFS.list("", true);
        if (list != null) {
            for (FileSystem.FileEntry fileEntry : list) {
                cancellationSignalCompat.throwIfCanceled();
                if (!fileEntry.isDirectory && fileEntry.modifiedTime <= currentTimeMillis) {
                    fileEntry.delete();
                }
            }
        }
        super.maintain(cancellationSignalCompat);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        VFSUtils.writeFileSystemVersion(parcel, ExpireFileSystem.class, 1);
        parcel.writeParcelable(this.mFS, i3);
        parcel.writeLong(this.mExpireTime);
    }

    protected ExpireFileSystem(Parcel parcel) {
        VFSUtils.checkFileSystemVersion(parcel, ExpireFileSystem.class, 1);
        FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        this.mFS = fileSystem;
        if (fileSystem != null) {
            this.mFSList = Collections.singletonList(fileSystem);
            this.mExpireTime = parcel.readLong();
            return;
        }
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
}
