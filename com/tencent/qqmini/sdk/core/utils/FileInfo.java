package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>() { // from class: com.tencent.qqmini.sdk.core.utils.FileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfo[] newArray(int i3) {
            return new FileInfo[i3];
        }
    };
    private String apkPackeageName;
    private long date;
    private String description;
    private String groupName;
    private boolean igonFilename;
    private boolean isDirectory;
    private boolean litePath;
    private int mediaId;
    private String name;
    private String path;
    private long size;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class InvalidImageException extends Exception {
        private static final long serialVersionUID = 1;

        public InvalidImageException(String str) {
            super(str);
        }
    }

    private boolean compare(FileInfo fileInfo) {
        if (getSize() == fileInfo.getSize() && getDate() == fileInfo.getDate() && getPath().equals(fileInfo.getPath())) {
            return true;
        }
        return false;
    }

    public static FileInfo create(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (file.length() != 0) {
            try {
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        return new FileInfo(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof FileInfo)) {
            return compare((FileInfo) obj);
        }
        return false;
    }

    public String getApkPackeageName() {
        return this.apkPackeageName;
    }

    public long getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getMediaId() {
        return this.mediaId;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (getName() + getSize() + getDate()).hashCode();
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public boolean isIgonFilename() {
        return this.igonFilename;
    }

    public boolean isLitePath() {
        return this.litePath;
    }

    public void setApkPackeageName(String str) {
        this.apkPackeageName = str;
    }

    public void setDate(long j3) {
        this.date = j3;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDirectory(boolean z16) {
        this.isDirectory = z16;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIgonFilename() {
        this.igonFilename = true;
    }

    public void setLitePath(boolean z16) {
        this.litePath = z16;
    }

    public void setMediaId(int i3) {
        this.mediaId = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j3) {
        this.size = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.path);
        parcel.writeString(this.name);
        parcel.writeLong(this.size);
        parcel.writeLong(this.date);
        parcel.writeString(this.description);
        parcel.writeString(this.apkPackeageName);
        parcel.writeString(this.groupName);
    }

    public FileInfo() {
        this.igonFilename = false;
        this.litePath = false;
        this.isDirectory = false;
        setPath("");
        setName("");
        setSize(0L);
        setDate(System.currentTimeMillis());
        setDescription("");
        setApkPackeageName("");
        setGroupName("");
    }

    public FileInfo(String str) throws FileNotFoundException {
        this.igonFilename = false;
        this.litePath = false;
        this.isDirectory = false;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                setDirectory(file.isDirectory());
                setPath(file.getAbsolutePath());
                setName(file.getName());
                setSize(file.length());
                setDate(file.lastModified());
                setApkPackeageName("");
                setGroupName("");
                return;
            }
            throw new FileNotFoundException("file not exist!");
        }
        throw new FileNotFoundException("file path is null!");
    }

    FileInfo(Parcel parcel) {
        this.igonFilename = false;
        this.litePath = false;
        this.isDirectory = false;
        setPath(parcel.readString());
        setName(parcel.readString());
        setSize(parcel.readLong());
        setDate(parcel.readLong());
        setDescription(parcel.readString());
        setApkPackeageName(parcel.readString());
        setGroupName(parcel.readString());
    }
}
