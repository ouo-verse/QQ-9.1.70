package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ba;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i3) {
            return new UserInfoBean[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f97813a;

    /* renamed from: b, reason: collision with root package name */
    public int f97814b;

    /* renamed from: c, reason: collision with root package name */
    public String f97815c;

    /* renamed from: d, reason: collision with root package name */
    public String f97816d;

    /* renamed from: e, reason: collision with root package name */
    public long f97817e;

    /* renamed from: f, reason: collision with root package name */
    public long f97818f;

    /* renamed from: g, reason: collision with root package name */
    public long f97819g;

    /* renamed from: h, reason: collision with root package name */
    public long f97820h;

    /* renamed from: i, reason: collision with root package name */
    public long f97821i;

    /* renamed from: j, reason: collision with root package name */
    public String f97822j;

    /* renamed from: k, reason: collision with root package name */
    public long f97823k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f97824l;

    /* renamed from: m, reason: collision with root package name */
    public String f97825m;

    /* renamed from: n, reason: collision with root package name */
    public String f97826n;

    /* renamed from: o, reason: collision with root package name */
    public int f97827o;

    /* renamed from: p, reason: collision with root package name */
    public int f97828p;

    /* renamed from: q, reason: collision with root package name */
    public int f97829q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f97830r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f97831s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, String> f97832t;

    public UserInfoBean() {
        this.f97823k = 0L;
        this.f97824l = false;
        this.f97825m = "unknown";
        this.f97828p = -1;
        this.f97829q = -1;
        this.f97830r = null;
        this.f97831s = null;
        this.f97832t = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f97814b);
        parcel.writeString(this.f97815c);
        parcel.writeString(this.f97816d);
        parcel.writeLong(this.f97817e);
        parcel.writeLong(this.f97818f);
        parcel.writeLong(this.f97819g);
        parcel.writeLong(this.f97820h);
        parcel.writeLong(this.f97821i);
        parcel.writeString(this.f97822j);
        parcel.writeLong(this.f97823k);
        parcel.writeByte(this.f97824l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f97825m);
        parcel.writeInt(this.f97828p);
        parcel.writeInt(this.f97829q);
        ba.b(parcel, this.f97830r);
        ba.b(parcel, this.f97831s);
        parcel.writeString(this.f97826n);
        parcel.writeInt(this.f97827o);
        ba.b(parcel, this.f97832t);
    }

    public UserInfoBean(Parcel parcel) {
        this.f97823k = 0L;
        this.f97824l = false;
        this.f97825m = "unknown";
        this.f97828p = -1;
        this.f97829q = -1;
        this.f97830r = null;
        this.f97831s = null;
        this.f97832t = null;
        this.f97814b = parcel.readInt();
        this.f97815c = parcel.readString();
        this.f97816d = parcel.readString();
        this.f97817e = parcel.readLong();
        this.f97818f = parcel.readLong();
        this.f97819g = parcel.readLong();
        this.f97820h = parcel.readLong();
        this.f97821i = parcel.readLong();
        this.f97822j = parcel.readString();
        this.f97823k = parcel.readLong();
        this.f97824l = parcel.readByte() == 1;
        this.f97825m = parcel.readString();
        this.f97828p = parcel.readInt();
        this.f97829q = parcel.readInt();
        this.f97830r = ba.b(parcel);
        this.f97831s = ba.b(parcel);
        this.f97826n = parcel.readString();
        this.f97827o = parcel.readInt();
        this.f97832t = ba.b(parcel);
    }
}
