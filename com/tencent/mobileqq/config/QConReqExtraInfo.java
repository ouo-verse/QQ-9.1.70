package com.tencent.mobileqq.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QConReqExtraInfo implements Parcelable {
    public static final Parcelable.Creator<QConReqExtraInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f202243d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f202244e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<QConReqExtraInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QConReqExtraInfo createFromParcel(Parcel parcel) {
            return new QConReqExtraInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QConReqExtraInfo[] newArray(int i3) {
            return new QConReqExtraInfo[i3];
        }
    }

    public QConReqExtraInfo(int i3, boolean z16) {
        this.f202243d = i3;
        this.f202244e = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return "[id:" + this.f202243d + ", reset:" + this.f202244e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f202243d);
        parcel.writeByte(this.f202244e ? (byte) 1 : (byte) 0);
    }

    protected QConReqExtraInfo(Parcel parcel) {
        this.f202243d = 0;
        this.f202244e = false;
        this.f202243d = parcel.readInt();
        this.f202244e = parcel.readByte() != 0;
    }
}
