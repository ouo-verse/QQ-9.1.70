package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VirtualInfo implements Parcelable {
    public static final Parcelable.Creator<VirtualInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f341675d;

    /* renamed from: e, reason: collision with root package name */
    public String f341676e;

    /* renamed from: f, reason: collision with root package name */
    public String f341677f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<VirtualInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VirtualInfo createFromParcel(Parcel parcel) {
            return new VirtualInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VirtualInfo[] newArray(int i3) {
            return new VirtualInfo[i3];
        }
    }

    public VirtualInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VirtualInfo={virtualId=" + this.f341675d + ",nickName=" + this.f341676e + ",avatarUrl=" + this.f341677f + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f341675d);
        parcel.writeString(this.f341676e);
        parcel.writeString(this.f341677f);
    }

    protected VirtualInfo(Parcel parcel) {
        this.f341675d = parcel.readLong();
        this.f341676e = parcel.readString();
        this.f341677f = parcel.readString();
    }
}
