package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArWebInfo implements Parcelable {
    public static final Parcelable.Creator<ArWebInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f198432d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f198433e;

    /* renamed from: f, reason: collision with root package name */
    public String f198434f;

    /* renamed from: h, reason: collision with root package name */
    public String f198435h;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArWebInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArWebInfo createFromParcel(Parcel parcel) {
            return new ArWebInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArWebInfo[] newArray(int i3) {
            return new ArWebInfo[i3];
        }
    }

    public ArWebInfo() {
    }

    public boolean a() {
        return this.f198433e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArWebInfo{");
        stringBuffer.append("isUrlAutoJump='");
        stringBuffer.append(this.f198432d);
        stringBuffer.append('\'');
        stringBuffer.append(", isUrlTransparent=");
        stringBuffer.append(this.f198433e);
        stringBuffer.append('\'');
        stringBuffer.append(", webJumpUrl=");
        stringBuffer.append(this.f198434f);
        stringBuffer.append('\'');
        stringBuffer.append(", htmlOfflineBid=");
        stringBuffer.append(this.f198435h);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.f198432d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f198433e ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f198434f);
        parcel.writeString(this.f198435h);
    }

    protected ArWebInfo(Parcel parcel) {
        this.f198432d = parcel.readByte() != 0;
        this.f198433e = parcel.readByte() != 0;
        this.f198434f = parcel.readString();
        this.f198435h = parcel.readString();
    }
}
