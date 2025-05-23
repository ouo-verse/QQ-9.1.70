package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RecvMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RecvMsg> CREATOR = new a();
    static String K = "RecvMsg";
    String C;
    public int D;
    public int E;
    public int F;
    public long G;
    public int H;
    public int I;
    public boolean J;

    /* renamed from: d, reason: collision with root package name */
    int f74365d;

    /* renamed from: e, reason: collision with root package name */
    String f74366e;

    /* renamed from: f, reason: collision with root package name */
    String f74367f;

    /* renamed from: h, reason: collision with root package name */
    String f74368h;

    /* renamed from: i, reason: collision with root package name */
    String f74369i;

    /* renamed from: m, reason: collision with root package name */
    String f74370m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<RecvMsg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecvMsg createFromParcel(Parcel parcel) {
            return new RecvMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecvMsg[] newArray(int i3) {
            return new RecvMsg[i3];
        }
    }

    public RecvMsg() {
        this.J = false;
        this.f74365d = 0;
        this.f74367f = null;
        this.f74368h = null;
        this.f74369i = null;
        this.f74370m = null;
        this.f74366e = null;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0L;
        this.C = "";
    }

    public void a(Parcel parcel) {
        try {
            this.f74365d = parcel.readInt();
            this.f74367f = parcel.readString();
            this.f74368h = parcel.readString();
            this.f74369i = parcel.readString();
            this.f74370m = parcel.readString();
            this.f74366e = parcel.readString();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readInt();
            this.G = parcel.readLong();
            this.C = parcel.readString();
            this.H = parcel.readInt();
            this.I = parcel.readInt();
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(K, 2, "readFromParcel RuntimeException", e16);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return K + ", mVipBubbleId:" + this.f74365d + ", mAccountUin:" + this.f74367f + ", mFriendUin:" + this.f74368h + ", mSenderUin:" + this.f74369i + ", mSenderName:" + this.f74370m + ", mMsg:" + this.f74366e + ", msgType:" + this.H;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.f74365d);
            parcel.writeString(this.f74367f);
            parcel.writeString(this.f74368h);
            parcel.writeString(this.f74369i);
            parcel.writeString(this.f74370m);
            parcel.writeString(this.f74366e);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeInt(this.F);
            parcel.writeLong(this.G);
            parcel.writeString(this.C);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(K, 2, "writeToParcel RuntimeException", e16);
            }
        }
    }

    public RecvMsg(Parcel parcel) {
        this.J = false;
        a(parcel);
    }
}
