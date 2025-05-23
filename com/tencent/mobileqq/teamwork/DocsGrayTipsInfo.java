package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DocsGrayTipsInfo implements Parcelable {
    public static final Parcelable.Creator<DocsGrayTipsInfo> CREATOR = new a();
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String P;
    public String Q;

    /* renamed from: d, reason: collision with root package name */
    public String f291464d;

    /* renamed from: e, reason: collision with root package name */
    public String f291465e;

    /* renamed from: f, reason: collision with root package name */
    public String f291466f;

    /* renamed from: h, reason: collision with root package name */
    public String f291467h;

    /* renamed from: i, reason: collision with root package name */
    public String f291468i;

    /* renamed from: m, reason: collision with root package name */
    public String f291469m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<DocsGrayTipsInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DocsGrayTipsInfo createFromParcel(Parcel parcel) {
            return new DocsGrayTipsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DocsGrayTipsInfo[] newArray(int i3) {
            return new DocsGrayTipsInfo[i3];
        }
    }

    public DocsGrayTipsInfo() {
        this.f291464d = "";
        this.f291465e = "";
        this.f291466f = "";
        this.f291467h = "";
        this.f291468i = "";
        this.f291469m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = "";
        this.P = "";
        this.Q = "";
    }

    public int[] a() {
        int[] iArr = new int[2];
        try {
            String[] split = this.f291469m.split("-");
            iArr[0] = Integer.valueOf(split[0]).intValue();
            iArr[1] = Integer.valueOf(split[1]).intValue();
        } catch (Exception e16) {
            QLog.e(t.f292405j, 1, "get height light area exception = " + e16.toString());
        }
        return iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DocsGrayTipsInfo | uin =" + this.f291464d + " , url=" + this.f291465e + " , type = " + this.f291466f + " , optType = " + this.f291467h + " , authTips =" + this.f291468i + " , highlightText =" + this.f291469m + " , setflag =" + this.C + " , setPolicy =" + this.D + " , setOnly =" + this.E + " , sucResult =" + this.F + " , failResult =" + this.G + " , netFailResult =" + this.H + " , policy = " + this.I + " , privilege = " + this.J + " , member_num= " + this.K + " , remainTime=" + this.L + " , setTime= " + this.M + " , bNeedSetTime =" + this.N + " , tipType =" + this.P + " , tipUrl =" + this.Q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f291464d);
        parcel.writeString(this.f291465e);
        parcel.writeString(this.f291466f);
        parcel.writeString(this.f291467h);
        parcel.writeString(this.f291468i);
        parcel.writeString(this.f291469m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
    }

    public DocsGrayTipsInfo(Parcel parcel) {
        this.f291464d = "";
        this.f291465e = "";
        this.f291466f = "";
        this.f291467h = "";
        this.f291468i = "";
        this.f291469m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = "";
        this.P = "";
        this.Q = "";
        this.f291464d = parcel.readString();
        this.f291465e = parcel.readString();
        this.f291466f = parcel.readString();
        this.f291467h = parcel.readString();
        this.f291468i = parcel.readString();
        this.f291469m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
    }
}
