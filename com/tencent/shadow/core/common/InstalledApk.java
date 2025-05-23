package com.tencent.shadow.core.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class InstalledApk implements Parcelable {
    public static final Parcelable.Creator<InstalledApk> CREATOR = new Parcelable.Creator<InstalledApk>() { // from class: com.tencent.shadow.core.common.InstalledApk.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledApk createFromParcel(Parcel parcel) {
            return new InstalledApk(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledApk[] newArray(int i3) {
            return new InstalledApk[i3];
        }
    };
    public final String apkFilePath;
    public final String libraryPath;
    public final String oDexPath;
    public final byte[] parcelExtras;

    public InstalledApk(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int length;
        parcel.writeString(this.apkFilePath);
        parcel.writeString(this.oDexPath);
        parcel.writeString(this.libraryPath);
        byte[] bArr = this.parcelExtras;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        parcel.writeInt(length);
        byte[] bArr2 = this.parcelExtras;
        if (bArr2 != null) {
            parcel.writeByteArray(bArr2);
        }
    }

    public InstalledApk(String str, String str2, String str3, byte[] bArr) {
        this.apkFilePath = str;
        this.oDexPath = str2;
        this.libraryPath = str3;
        this.parcelExtras = bArr;
    }

    protected InstalledApk(Parcel parcel) {
        this.apkFilePath = parcel.readString();
        this.oDexPath = parcel.readString();
        this.libraryPath = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.parcelExtras = new byte[readInt];
        } else {
            this.parcelExtras = null;
        }
        byte[] bArr = this.parcelExtras;
        if (bArr != null) {
            parcel.readByteArray(bArr);
        }
    }
}
