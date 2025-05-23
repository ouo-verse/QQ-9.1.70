package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MigrationFileSystem extends DelegateFileSystem {
    public static final Parcelable.Creator<MigrationFileSystem> CREATOR = new Parcelable.Creator<MigrationFileSystem>() { // from class: com.tencent.mm.vfs.MigrationFileSystem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MigrationFileSystem createFromParcel(Parcel parcel) {
            return new MigrationFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MigrationFileSystem[] newArray(int i3) {
            return new MigrationFileSystem[i3];
        }
    };
    public static final String STAT_DESTINATION = "destination";
    public static final String STAT_DEST_OVERRIDE = "destOverride";
    public static final String STAT_DIRS_CREATED = "dirsCreated";
    public static final String STAT_DIRS_DELETED = "dirsDeleted";
    public static final String STAT_DIRS_MOVED = "dirsMoved";
    public static final String STAT_FILES_COPIED = "filesCopied";
    public static final String STAT_FILES_FAILED = "filesFailed";
    public static final String STAT_MIGRATE_ERROR_DETAIL = "failedDetail";
    public static final String STAT_MIGRATE_FAILED = "failedPathCollections";
    public static final String STAT_MIGRATE_FAST = "fastMigrateState";
    public static final String STAT_MIGRATE_FAST_ERROR = "fastMigrateError";
    public static final String STAT_SIZE_COPIED = "sizeCopied";
    private static final String TAG = "VFS.MigrationFileSystem";
    private static final int VERSION = 3;
    private List<FileSystem> mEffectiveFS;
    private final FileSystem[] mFSList;
    private boolean mPositive;
    private final String mPositiveMacro;
    private boolean mSpeedMigrateSucc;

    public MigrationFileSystem(boolean z16, FileSystem fileSystem, FileSystem... fileSystemArr) {
        this(z16 ? "" : null, fileSystem, fileSystemArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0184 A[Catch: Exception -> 0x029e, TryCatch #1 {Exception -> 0x029e, blocks: (B:15:0x006e, B:19:0x0263, B:20:0x0089, B:24:0x009d, B:25:0x00a1, B:27:0x00a7, B:67:0x00c2, B:69:0x00ce, B:71:0x00fa, B:74:0x0100, B:76:0x0108, B:78:0x0113, B:80:0x013a, B:30:0x0143, B:32:0x014b, B:34:0x0151, B:36:0x015a, B:38:0x0184, B:39:0x018a, B:41:0x0192, B:43:0x0198, B:44:0x01bd, B:48:0x01c3, B:50:0x01ce, B:56:0x01f4, B:58:0x0220, B:61:0x022d, B:86:0x0247, B:87:0x024f, B:89:0x0255, B:108:0x0270, B:110:0x027a, B:111:0x0285, B:117:0x0281), top: B:14:0x006e, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doMaintenance(CancellationSignalCompat cancellationSignalCompat) {
        int i3;
        int i16;
        String obj;
        String basePath;
        String obj2;
        TreeSet treeSet;
        int i17;
        HashSet hashSet;
        boolean z16;
        HashSet hashSet2;
        MigrationFileSystem migrationFileSystem = this;
        boolean z17 = true;
        if (migrationFileSystem.mSpeedMigrateSucc) {
            QLog.d(TAG, 1, "doMaintenance no need! fast move is success!" + toString());
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            FileSystem fileSystem = migrationFileSystem.mEffectiveFS.get(0);
            HashSet hashSet3 = new HashSet();
            cancellationSignalCompat.throwIfCanceled();
            Object[] objArr = new Object[2];
            objArr[0] = "destination";
            if (fileSystem instanceof NativeFileSystem) {
                try {
                    basePath = ((NativeFileSystem) fileSystem).basePath();
                } catch (Exception e16) {
                    e = e16;
                    i3 = 0;
                    if (e instanceof OperationCanceledException) {
                    }
                    QLog.e(TAG, 1, "maintain error!", e);
                    Object[] objArr2 = new Object[8];
                    objArr2[0] = "destination";
                    if (migrationFileSystem.mEffectiveFS.get(0) instanceof NativeFileSystem) {
                    }
                    objArr2[1] = obj;
                    objArr2[2] = STAT_FILES_FAILED;
                    objArr2[3] = Integer.valueOf(i3);
                    objArr2[4] = STAT_MIGRATE_ERROR_DETAIL;
                    objArr2[5] = e.getMessage();
                    objArr2[6] = STAT_MIGRATE_FAILED;
                    objArr2[7] = hashMap;
                    migrationFileSystem.statistics(i16, objArr2);
                    throw e;
                }
            } else {
                basePath = fileSystem.toString();
            }
            objArr[1] = basePath;
            migrationFileSystem.statistics(1, objArr);
            int size = migrationFileSystem.mEffectiveFS.size();
            int i18 = 1;
            i3 = 0;
            while (i18 < size) {
                try {
                    cancellationSignalCompat.throwIfCanceled();
                    FileSystem fileSystem2 = migrationFileSystem.mEffectiveFS.get(i18);
                    Iterable<FileSystem.FileEntry> list = fileSystem2.list("", z17);
                    if (list == null) {
                        i17 = size;
                        hashSet = hashSet3;
                    } else {
                        if ((fileSystem2.capabilityFlags() & 9) == 9) {
                            try {
                                treeSet = new TreeSet();
                            } catch (Exception e17) {
                                e = e17;
                                if (e instanceof OperationCanceledException) {
                                }
                                QLog.e(TAG, 1, "maintain error!", e);
                                Object[] objArr22 = new Object[8];
                                objArr22[0] = "destination";
                                if (migrationFileSystem.mEffectiveFS.get(0) instanceof NativeFileSystem) {
                                }
                                objArr22[1] = obj;
                                objArr22[2] = STAT_FILES_FAILED;
                                objArr22[3] = Integer.valueOf(i3);
                                objArr22[4] = STAT_MIGRATE_ERROR_DETAIL;
                                objArr22[5] = e.getMessage();
                                objArr22[6] = STAT_MIGRATE_FAILED;
                                objArr22[7] = hashMap;
                                migrationFileSystem.statistics(i16, objArr22);
                                throw e;
                            }
                        } else {
                            treeSet = null;
                        }
                        Iterator<FileSystem.FileEntry> it = list.iterator();
                        while (it.hasNext()) {
                            FileSystem.FileEntry next = it.next();
                            cancellationSignalCompat.throwIfCanceled();
                            int i19 = size;
                            Iterator<FileSystem.FileEntry> it5 = it;
                            if (next.isDirectory) {
                                try {
                                    String str = next.relPath;
                                    z16 = fileSystem.moveFile(str, fileSystem2, str);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "migrate file -> moveFile :" + next.relPath + " [" + toString() + "], issucc = " + z16);
                                    }
                                } catch (IOException unused) {
                                    z16 = false;
                                }
                                if (z16) {
                                    hashSet3.add(next.relPath);
                                } else {
                                    if (hashSet3.add(next.relPath)) {
                                        fileSystem.mkdirs(next.relPath);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TAG, 2, "migrate file failed! -> mkdirs :" + next.relPath + " [" + toString() + "]");
                                        }
                                    }
                                    if (treeSet != null) {
                                        treeSet.add(next.relPath);
                                    }
                                }
                                hashSet2 = hashSet3;
                            } else {
                                String parentPath = VFSUtils.getParentPath(next.relPath);
                                if (parentPath != null) {
                                    if (hashSet3.add(parentPath)) {
                                        fileSystem.mkdirs(parentPath);
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            hashSet2 = hashSet3;
                                            sb5.append("migrate file -> mkdirs :");
                                            sb5.append(parentPath);
                                            sb5.append(" [");
                                            sb5.append(toString());
                                            sb5.append("]");
                                            QLog.d(TAG, 2, sb5.toString());
                                            if (treeSet != null) {
                                                treeSet.add(parentPath);
                                            }
                                        }
                                    }
                                    hashSet2 = hashSet3;
                                    if (treeSet != null) {
                                    }
                                } else {
                                    hashSet2 = hashSet3;
                                }
                                if (fileSystem.exists(next.relPath)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "migrate file -> exists :" + next.relPath + " [" + toString() + "]");
                                    }
                                    fileSystem2.delete(next.relPath);
                                } else {
                                    try {
                                        String str2 = next.relPath;
                                        fileSystem.moveFile(str2, fileSystem2, str2);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TAG, 2, "migrate file -> moveFile :" + next.relPath + " [" + toString() + "]");
                                        }
                                    } catch (IOException e18) {
                                        i3++;
                                        QLog.e(TAG, 1, "Failed to migrate file: " + next.relPath + " [" + toString() + "]");
                                        if (hashMap.size() < 3) {
                                            hashMap.put(next.relPath, e18.getMessage());
                                        }
                                        if (treeSet != null) {
                                            while (parentPath != null) {
                                                treeSet.remove(parentPath);
                                                parentPath = VFSUtils.getParentPath(parentPath);
                                            }
                                        }
                                    }
                                }
                            }
                            size = i19;
                            it = it5;
                            hashSet3 = hashSet2;
                        }
                        i17 = size;
                        hashSet = hashSet3;
                        if (treeSet != null) {
                            for (String str3 : treeSet.descendingSet()) {
                                cancellationSignalCompat.throwIfCanceled();
                                fileSystem2.deleteDir(str3, false);
                            }
                        }
                    }
                    i18++;
                    size = i17;
                    hashSet3 = hashSet;
                    z17 = true;
                    migrationFileSystem = this;
                } catch (Exception e19) {
                    e = e19;
                    migrationFileSystem = this;
                    if (e instanceof OperationCanceledException) {
                        i16 = 4;
                    } else {
                        i16 = 5;
                    }
                    QLog.e(TAG, 1, "maintain error!", e);
                    Object[] objArr222 = new Object[8];
                    objArr222[0] = "destination";
                    if (migrationFileSystem.mEffectiveFS.get(0) instanceof NativeFileSystem) {
                        obj = ((NativeFileSystem) migrationFileSystem.mEffectiveFS.get(0)).basePath();
                    } else {
                        obj = migrationFileSystem.mEffectiveFS.get(0).toString();
                    }
                    objArr222[1] = obj;
                    objArr222[2] = STAT_FILES_FAILED;
                    objArr222[3] = Integer.valueOf(i3);
                    objArr222[4] = STAT_MIGRATE_ERROR_DETAIL;
                    objArr222[5] = e.getMessage();
                    objArr222[6] = STAT_MIGRATE_FAILED;
                    objArr222[7] = hashMap;
                    migrationFileSystem.statistics(i16, objArr222);
                    throw e;
                }
            }
            Object[] objArr3 = new Object[6];
            objArr3[0] = "destination";
            if (fileSystem instanceof NativeFileSystem) {
                obj2 = ((NativeFileSystem) fileSystem).basePath();
            } else {
                obj2 = fileSystem.toString();
            }
            objArr3[1] = obj2;
            objArr3[2] = STAT_FILES_FAILED;
            objArr3[3] = Integer.valueOf(i3);
            objArr3[4] = STAT_MIGRATE_FAILED;
            objArr3[5] = hashMap;
            migrationFileSystem = this;
            migrationFileSystem.statistics(3, objArr3);
        } catch (Exception e26) {
            e = e26;
            i3 = 0;
        }
    }

    private void ensureCallback() {
        if (this.mEffectiveFS.get(0) instanceof NativeFileSystem) {
            setStatisticsCallback(((NativeFileSystem) this.mEffectiveFS.get(0)).basePath(), FileSystemManager.statisticsCallback());
        }
    }

    private boolean tryCreateParentDirFromOtherFileSystem(String str) {
        String parentPath = VFSUtils.getParentPath(str);
        if (parentPath == null) {
            return false;
        }
        FileSystem fileSystem = this.mEffectiveFS.get(0);
        if (fileSystem.exists(parentPath)) {
            return false;
        }
        int size = this.mEffectiveFS.size();
        for (int i3 = 1; i3 < size; i3++) {
            FileSystem.FileEntry stat = this.mEffectiveFS.get(i3).stat(parentPath);
            if (stat != null && stat.isDirectory) {
                return fileSystem.mkdirs(parentPath);
            }
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem
    protected Iterable<FileSystem> allFileSystems() {
        return this.mEffectiveFS;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        File file;
        FileSystem[] fileSystemArr;
        String basePath;
        boolean z16 = false;
        for (FileSystem fileSystem : this.mFSList) {
            fileSystem.configure(map);
        }
        ArrayList arrayList = new ArrayList(this.mFSList.length);
        this.mEffectiveFS = arrayList;
        arrayList.add(this.mFSList[0]);
        HashSet hashSet = new HashSet();
        FileSystem fileSystem2 = this.mFSList[0];
        if ((fileSystem2 instanceof NativeFileSystem) && (basePath = ((NativeFileSystem) fileSystem2).basePath()) != null) {
            file = new File(basePath);
            if (file.exists()) {
                file = null;
            }
            hashSet.add(basePath);
        } else {
            file = null;
        }
        String str = "";
        if (!this.mSpeedMigrateSucc) {
            int i3 = 0;
            int i16 = 1;
            while (true) {
                fileSystemArr = this.mFSList;
                if (i16 >= fileSystemArr.length) {
                    break;
                }
                FileSystem fileSystem3 = fileSystemArr[i16];
                if (!(fileSystem3 instanceof NativeFileSystem)) {
                    this.mEffectiveFS.add(fileSystem3);
                } else {
                    NativeFileSystem nativeFileSystem = (NativeFileSystem) fileSystem3;
                    String basePath2 = nativeFileSystem.basePath();
                    if (basePath2 != null) {
                        File file2 = new File(basePath2);
                        if (file2.isDirectory()) {
                            if (file == null) {
                                str = "dest dir is exist, so fast rename is failed";
                            }
                            if (file != null) {
                                if (file2.renameTo(file)) {
                                    i3++;
                                    if (QLog.isColorLevel()) {
                                        QLog.i(TAG, 2, "Fast moved '" + file2 + "' -> '" + file + "'");
                                    }
                                    file = null;
                                } else {
                                    str = "srcDir renameTo destDir is error!";
                                }
                            } else if (hashSet.add(basePath2)) {
                                this.mEffectiveFS.add(nativeFileSystem);
                            }
                        } else {
                            str = "srcDir not is Directory";
                        }
                    }
                }
                i16++;
            }
            if (i3 == fileSystemArr.length - 1) {
                this.mSpeedMigrateSucc = true;
            }
        }
        if (!this.mSpeedMigrateSucc && (this.mEffectiveFS.get(0) instanceof NativeFileSystem)) {
            statistics(7, "destination", ((NativeFileSystem) this.mEffectiveFS.get(0)).basePath(), STAT_MIGRATE_FAST, Boolean.valueOf(this.mSpeedMigrateSucc), STAT_MIGRATE_FAST_ERROR, str);
        }
        if (this.mPositiveMacro != null) {
            z16 = true;
        }
        this.mPositive = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.DelegateFileSystem
    public FileSystem delegate(String str, int i3) {
        if (i3 == 1 || i3 == 3) {
            for (FileSystem fileSystem : this.mEffectiveFS) {
                if (fileSystem.exists(str)) {
                    return fileSystem;
                }
            }
        }
        return this.mEffectiveFS.get(0);
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean exists(String str) {
        Iterator<FileSystem> it = this.mEffectiveFS.iterator();
        while (it.hasNext()) {
            if (it.next().exists(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void maintain(CancellationSignalCompat cancellationSignalCompat) {
        if (this.mPositive) {
            doMaintenance(cancellationSignalCompat);
        }
        super.maintain(cancellationSignalCompat);
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        InputStream openRead;
        Iterator<FileSystem> it = this.mEffectiveFS.iterator();
        FileNotFoundException fileNotFoundException = null;
        while (it.hasNext()) {
            try {
                openRead = it.next().openRead(str);
            } catch (FileNotFoundException e16) {
                if (fileNotFoundException == null) {
                    fileNotFoundException = e16;
                }
            }
            if (openRead != null) {
                return openRead;
            }
        }
        if (fileNotFoundException == null) {
            throw new FileNotFoundException(str + " not found on any file systems.");
        }
        throw fileNotFoundException;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        ReadableByteChannel openReadChannel;
        Iterator<FileSystem> it = this.mEffectiveFS.iterator();
        FileNotFoundException fileNotFoundException = null;
        while (it.hasNext()) {
            try {
                openReadChannel = it.next().openReadChannel(str);
            } catch (FileNotFoundException e16) {
                if (fileNotFoundException == null) {
                    fileNotFoundException = e16;
                }
            }
            if (openReadChannel != null) {
                return openReadChannel;
            }
        }
        if (fileNotFoundException == null) {
            throw new FileNotFoundException(str + " not found on any file systems.");
        }
        throw fileNotFoundException;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        FileSystem fileSystem = this.mEffectiveFS.get(0);
        try {
            return fileSystem.openWrite(str, z16);
        } catch (FileNotFoundException e16) {
            if (!z16 && tryCreateParentDirFromOtherFileSystem(str)) {
                return fileSystem.openWrite(str, false);
            }
            throw e16;
        }
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        FileSystem fileSystem = this.mEffectiveFS.get(0);
        try {
            return fileSystem.openWriteChannel(str, z16);
        } catch (FileNotFoundException e16) {
            if (!z16 && tryCreateParentDirFromOtherFileSystem(str)) {
                return fileSystem.openWriteChannel(str, false);
            }
            throw e16;
        }
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public FileSystem.FileEntry stat(String str) {
        Iterator<FileSystem> it = this.mEffectiveFS.iterator();
        while (it.hasNext()) {
            FileSystem.FileEntry stat = it.next().stat(str);
            if (stat != null) {
                return stat;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("Migration [");
        sb5.append(this.mFSList[0].toString());
        sb5.append(" <= ");
        int i3 = 1;
        while (true) {
            FileSystem[] fileSystemArr = this.mFSList;
            if (i3 < fileSystemArr.length) {
                sb5.append(fileSystemArr[i3].toString());
                sb5.append(", ");
                i3++;
            } else {
                sb5.setLength(sb5.length() - 2);
                sb5.append(']');
                return sb5.toString();
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        VFSUtils.writeFileSystemVersion(parcel, MigrationFileSystem.class, 3);
        parcel.writeInt(this.mSpeedMigrateSucc ? 1 : 0);
        parcel.writeInt(this.mFSList.length);
        for (FileSystem fileSystem : this.mFSList) {
            parcel.writeParcelable(fileSystem, i3);
        }
        parcel.writeString(this.mPositiveMacro);
    }

    public MigrationFileSystem(String str, FileSystem fileSystem, FileSystem... fileSystemArr) {
        this.mSpeedMigrateSucc = false;
        if (fileSystem != null) {
            this.mPositiveMacro = str;
            int i3 = 1;
            int length = fileSystemArr.length + 1;
            FileSystem[] fileSystemArr2 = new FileSystem[length];
            fileSystemArr2[0] = fileSystem;
            for (FileSystem fileSystem2 : fileSystemArr) {
                if (fileSystem2 != null) {
                    fileSystemArr2[i3] = fileSystem2;
                    i3++;
                }
            }
            fileSystemArr2 = i3 != length ? (FileSystem[]) Arrays.copyOf(fileSystemArr2, i3) : fileSystemArr2;
            this.mFSList = fileSystemArr2;
            this.mEffectiveFS = Arrays.asList(fileSystemArr2);
            ensureCallback();
            return;
        }
        throw new IllegalArgumentException("destination == null");
    }

    protected MigrationFileSystem(Parcel parcel) {
        this.mSpeedMigrateSucc = false;
        VFSUtils.checkFileSystemVersion(parcel, MigrationFileSystem.class, 3);
        this.mSpeedMigrateSucc = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        this.mFSList = new FileSystem[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem != null) {
                this.mFSList[i3] = fileSystem;
            } else {
                throw new IllegalArgumentException("Wrong wrapped filesystem.");
            }
        }
        this.mPositiveMacro = parcel.readString();
        this.mEffectiveFS = Arrays.asList(this.mFSList);
        ensureCallback();
    }
}
