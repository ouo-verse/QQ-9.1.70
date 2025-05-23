package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class QQPhotoInfo implements Parcelable {

    /* renamed from: id, reason: collision with root package name */
    private long f203113id;
    private String mPath;
    private int selectStatus;
    private static List<WeakReference<QQPhotoInfo>> photoInfoCache = new ArrayList();
    public static final Parcelable.Creator<QQPhotoInfo> CREATOR = new a();

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<QQPhotoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQPhotoInfo createFromParcel(Parcel parcel) {
            return new QQPhotoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQPhotoInfo[] newArray(int i3) {
            return new QQPhotoInfo[i3];
        }
    }

    QQPhotoInfo(Parcel parcel) {
        this.f203113id = parcel.readLong();
        this.mPath = parcel.readString();
        this.selectStatus = parcel.readInt();
    }

    private boolean compare(QQPhotoInfo qQPhotoInfo) {
        return this.mPath.equals(qQPhotoInfo.mPath);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof QQPhotoInfo)) {
            return compare((QQPhotoInfo) obj);
        }
        return false;
    }

    public int hashCode() {
        return this.mPath.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f203113id);
        parcel.writeString(this.mPath);
        parcel.writeInt(this.selectStatus);
    }
}
