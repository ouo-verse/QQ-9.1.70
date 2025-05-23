package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReSendCmd implements Parcelable {
    public static final Parcelable.Creator<ReSendCmd> CREATOR = new a();
    String C;
    List<String> D;
    int E;

    /* renamed from: d, reason: collision with root package name */
    public int f291501d;

    /* renamed from: e, reason: collision with root package name */
    int f291502e;

    /* renamed from: f, reason: collision with root package name */
    int f291503f;

    /* renamed from: h, reason: collision with root package name */
    public int f291504h;

    /* renamed from: i, reason: collision with root package name */
    public String f291505i;

    /* renamed from: m, reason: collision with root package name */
    int f291506m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<ReSendCmd> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReSendCmd createFromParcel(Parcel parcel) {
            return new ReSendCmd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReSendCmd[] newArray(int i3) {
            return new ReSendCmd[i3];
        }
    }

    public ReSendCmd() {
        this.f291505i = "";
        this.C = "";
        this.E = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "urlSrcType : " + this.E + " | padUrl : " + this.f291505i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f291501d);
        parcel.writeInt(this.f291502e);
        parcel.writeInt(this.f291503f);
        parcel.writeInt(this.f291504h);
        parcel.writeString(this.f291505i);
        parcel.writeInt(this.f291506m);
        parcel.writeString(this.C);
        parcel.writeStringList(this.D);
        parcel.writeInt(this.E);
    }

    public ReSendCmd(Parcel parcel) {
        this.f291505i = "";
        this.C = "";
        this.E = 0;
        this.f291501d = parcel.readInt();
        this.f291502e = parcel.readInt();
        this.f291503f = parcel.readInt();
        this.f291504h = parcel.readInt();
        this.f291505i = parcel.readString();
        this.f291506m = parcel.readInt();
        this.C = parcel.readString();
        if (this.D == null) {
            this.D = new ArrayList();
        }
        parcel.readStringList(this.D);
        this.E = parcel.readInt();
    }
}
