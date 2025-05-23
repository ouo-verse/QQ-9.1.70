package com.tencent.open.downloadnew.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes22.dex */
public class NoticeParam implements Parcelable {
    public static final Parcelable.Creator<NoticeParam> CREATOR = new a();
    public int C;
    public String D;
    public long E;
    public Intent F;
    public String G;
    public int H;
    public int I;
    public int J;

    /* renamed from: d, reason: collision with root package name */
    public String f341445d;

    /* renamed from: e, reason: collision with root package name */
    public String f341446e;

    /* renamed from: f, reason: collision with root package name */
    public String f341447f;

    /* renamed from: h, reason: collision with root package name */
    public String f341448h;

    /* renamed from: i, reason: collision with root package name */
    public String f341449i;

    /* renamed from: m, reason: collision with root package name */
    public int f341450m;

    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<NoticeParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NoticeParam createFromParcel(Parcel parcel) {
            return new NoticeParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NoticeParam[] newArray(int i3) {
            return new NoticeParam[i3];
        }
    }

    public NoticeParam() {
        this.f341445d = "";
        this.f341446e = "";
        this.f341447f = "";
        this.f341448h = "";
        this.f341449i = "";
        this.D = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f341445d);
        parcel.writeString(this.f341446e);
        parcel.writeString(this.f341447f);
        parcel.writeString(this.f341448h);
        parcel.writeString(this.f341449i);
        parcel.writeInt(this.f341450m);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeLong(this.E);
        parcel.writeParcelable(this.F, i3);
        parcel.writeString(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.J);
        parcel.writeInt(this.I);
    }

    public NoticeParam(Parcel parcel) {
        this.f341445d = "";
        this.f341446e = "";
        this.f341447f = "";
        this.f341448h = "";
        this.f341449i = "";
        this.D = "";
        this.f341445d = parcel.readString();
        this.f341446e = parcel.readString();
        this.f341447f = parcel.readString();
        this.f341448h = parcel.readString();
        this.f341449i = parcel.readString();
        this.f341450m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.E = parcel.readLong();
        this.F = (Intent) parcel.readParcelable(null);
        this.G = parcel.readString();
        this.H = parcel.readInt();
        this.J = parcel.readInt();
        this.I = parcel.readInt();
    }
}
