package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LBSInfo implements Parcelable {
    public static final Parcelable.Creator<LBSInfo> CREATOR = new a();
    static String I = "LBSInfo";
    String C;
    String D;
    double E;
    double F;
    double G;
    String[] H;

    /* renamed from: d, reason: collision with root package name */
    String f74313d;

    /* renamed from: e, reason: collision with root package name */
    String f74314e;

    /* renamed from: f, reason: collision with root package name */
    String f74315f;

    /* renamed from: h, reason: collision with root package name */
    String f74316h;

    /* renamed from: i, reason: collision with root package name */
    String f74317i;

    /* renamed from: m, reason: collision with root package name */
    String f74318m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<LBSInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LBSInfo createFromParcel(Parcel parcel) {
            return new LBSInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LBSInfo[] newArray(int i3) {
            return new LBSInfo[i3];
        }
    }

    public LBSInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, double d16, double d17, double d18, String[] strArr) {
        this.f74313d = str6;
        this.f74314e = str5;
        this.f74315f = str8;
        this.f74316h = str7;
        this.f74317i = str2;
        this.f74318m = str4;
        this.C = str;
        this.D = str3;
        this.E = d16;
        this.F = d17;
        this.G = d18;
        this.H = strArr;
    }

    public String[] a() {
        return this.H;
    }

    public void b(Parcel parcel) {
        try {
            this.C = parcel.readString();
            this.f74317i = parcel.readString();
            this.D = parcel.readString();
            this.f74318m = parcel.readString();
            this.f74314e = parcel.readString();
            this.f74313d = parcel.readString();
            this.f74316h = parcel.readString();
            this.f74315f = parcel.readString();
            this.E = parcel.readDouble();
            this.F = parcel.readDouble();
            this.G = parcel.readDouble();
            this.H = parcel.createStringArray();
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(I, 2, "readFromParcel RuntimeException", e16);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LBSInfo)) {
            return false;
        }
        LBSInfo lBSInfo = (LBSInfo) obj;
        if (this.C.equals(lBSInfo.C) && this.f74317i.equals(lBSInfo.f74317i) && this.D.equals(lBSInfo.D) && this.f74318m.equals(lBSInfo.f74318m) && this.f74314e.equals(lBSInfo.f74314e) && this.f74313d.equals(lBSInfo.f74313d) && this.f74316h.equals(lBSInfo.f74316h) && this.f74315f.equals(lBSInfo.f74315f) && this.E == lBSInfo.E && this.F == lBSInfo.F && this.G == lBSInfo.G) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeString(this.C);
            parcel.writeString(this.f74317i);
            parcel.writeString(this.D);
            parcel.writeString(this.f74318m);
            parcel.writeString(this.f74314e);
            parcel.writeString(this.f74313d);
            parcel.writeString(this.f74316h);
            parcel.writeString(this.f74315f);
            parcel.writeDouble(this.E);
            parcel.writeDouble(this.F);
            parcel.writeDouble(this.G);
            parcel.writeArray(this.H);
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(I, 2, "writeToParcel RuntimeException", e16);
            }
        }
    }

    public LBSInfo() {
        this.f74313d = "";
        this.f74314e = "";
        this.f74315f = "";
        this.f74316h = "";
        this.f74317i = "";
        this.f74318m = "";
        this.C = "";
        this.D = "";
        this.E = 0.0d;
        this.F = 0.0d;
        this.G = 0.0d;
        this.H = null;
    }

    public LBSInfo(Parcel parcel) {
        this.f74313d = "";
        this.f74314e = "";
        this.f74315f = "";
        this.f74316h = "";
        this.f74317i = "";
        this.f74318m = "";
        this.C = "";
        this.D = "";
        this.E = 0.0d;
        this.F = 0.0d;
        this.G = 0.0d;
        this.H = null;
        b(parcel);
    }
}
