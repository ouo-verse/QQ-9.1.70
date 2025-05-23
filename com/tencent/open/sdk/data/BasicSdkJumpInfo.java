package com.tencent.open.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BasicSdkJumpInfo implements Parcelable {
    public static final Parcelable.Creator<BasicSdkJumpInfo> CREATOR = new a();
    private String C;
    private String D;

    /* renamed from: d, reason: collision with root package name */
    private long f341722d;

    /* renamed from: e, reason: collision with root package name */
    private String f341723e;

    /* renamed from: f, reason: collision with root package name */
    private String f341724f;

    /* renamed from: h, reason: collision with root package name */
    private String f341725h;

    /* renamed from: i, reason: collision with root package name */
    private String f341726i;

    /* renamed from: m, reason: collision with root package name */
    private String f341727m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<BasicSdkJumpInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BasicSdkJumpInfo createFromParcel(Parcel parcel) {
            return new BasicSdkJumpInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BasicSdkJumpInfo[] newArray(int i3) {
            return new BasicSdkJumpInfo[i3];
        }
    }

    public BasicSdkJumpInfo(long j3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f341722d = j3;
        this.f341723e = c(str);
        this.f341724f = TextUtils.isEmpty(str2) ? "unknown" : str2;
        this.f341725h = c(str3);
        this.f341726i = c(str4);
        this.f341727m = c(str5);
        this.C = c(str6);
        this.D = "";
    }

    public String a() {
        return this.D;
    }

    public long b() {
        return this.f341722d;
    }

    protected String c(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f341723e;
    }

    public String f() {
        return this.f341725h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f341722d);
        parcel.writeString(this.f341723e);
        parcel.writeString(this.f341724f);
        parcel.writeString(this.f341725h);
        parcel.writeString(this.f341726i);
        parcel.writeString(this.f341727m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    protected BasicSdkJumpInfo(Parcel parcel) {
        this.f341722d = parcel.readLong();
        this.f341723e = parcel.readString();
        this.f341724f = parcel.readString();
        this.f341725h = parcel.readString();
        this.f341726i = parcel.readString();
        this.f341727m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
    }
}
