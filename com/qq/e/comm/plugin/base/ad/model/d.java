package com.qq.e.comm.plugin.base.ad.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final Parcelable.Creator<d> f38952a = new Parcelable.Creator<d>() { // from class: com.qq.e.comm.plugin.base.ad.model.d.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private int f38953b;

    /* renamed from: c, reason: collision with root package name */
    private int f38954c;

    /* renamed from: d, reason: collision with root package name */
    private int f38955d;

    /* renamed from: e, reason: collision with root package name */
    private String f38956e;

    /* renamed from: f, reason: collision with root package name */
    private String f38957f;

    /* renamed from: g, reason: collision with root package name */
    private String f38958g;

    /* renamed from: h, reason: collision with root package name */
    private String f38959h;

    /* renamed from: i, reason: collision with root package name */
    private String f38960i;

    /* renamed from: j, reason: collision with root package name */
    private String f38961j;

    /* renamed from: k, reason: collision with root package name */
    private String f38962k;

    /* renamed from: l, reason: collision with root package name */
    private String f38963l;

    /* renamed from: m, reason: collision with root package name */
    private long f38964m;

    /* renamed from: n, reason: collision with root package name */
    private int f38965n;

    /* renamed from: o, reason: collision with root package name */
    private String f38966o;

    /* renamed from: p, reason: collision with root package name */
    private long f38967p;

    /* renamed from: q, reason: collision with root package name */
    private final Bundle f38968q;

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, new Bundle(), i3, str9, System.currentTimeMillis(), 0);
    }

    public long a() {
        return this.f38964m;
    }

    public int b() {
        return this.f38954c;
    }

    public String c() {
        return this.f38961j;
    }

    public String d() {
        return this.f38960i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f38962k;
    }

    public String f() {
        return this.f38963l;
    }

    public String g() {
        return this.f38959h;
    }

    public String h() {
        return this.f38957f;
    }

    public String i() {
        return this.f38958g;
    }

    public String j() {
        return this.f38956e;
    }

    public int k() {
        return this.f38953b;
    }

    public int l() {
        return this.f38965n;
    }

    public int m() {
        return this.f38955d;
    }

    public String n() {
        return this.f38966o;
    }

    public long o() {
        return this.f38967p;
    }

    public Bundle p() {
        return this.f38968q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeString(j());
            parcel.writeString(h());
            parcel.writeString(i());
            parcel.writeString(g());
            parcel.writeString(d());
            parcel.writeString(c());
            parcel.writeString(e());
            parcel.writeString(f());
            parcel.writeBundle(p());
            parcel.writeInt(b());
            parcel.writeString(n());
            parcel.writeLong(o());
            parcel.writeLong(a());
            parcel.writeInt(m());
            parcel.writeInt(k());
            parcel.writeInt(l());
        }
    }

    public void a(int i3) {
        this.f38953b = i3;
    }

    public void b(int i3) {
        this.f38965n = i3;
    }

    public void a(long j3) {
        if (j3 >= 0) {
            this.f38967p += j3;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Bundle bundle, int i3, String str9, long j3, int i16) {
        this.f38954c = 0;
        this.f38965n = 0;
        this.f38967p = 0L;
        this.f38956e = str;
        this.f38957f = str2;
        this.f38958g = str3;
        this.f38959h = str4;
        this.f38960i = str5;
        this.f38961j = str6;
        this.f38962k = str7;
        this.f38963l = str8;
        System.currentTimeMillis();
        this.f38954c = i3;
        this.f38966o = str9;
        this.f38955d = i16;
        this.f38964m = j3;
        this.f38968q = bundle == null ? new Bundle() : bundle;
        a("notifyId", 0);
        a("notifyTag", "GDT_DOWNLOAD_NOTIFI_TAG_" + e());
        if (bundle != null) {
            a("autoInstall", bundle.getBoolean("autoInstall", true));
        } else {
            a("autoInstall", true);
        }
    }

    public int a(String str) {
        return this.f38968q.getInt(str);
    }

    public void a(String str, int i3) {
        a(str, Integer.valueOf(i3));
    }

    public void a(String str, long j3) {
        a(str, Long.valueOf(j3));
    }

    public void a(String str, boolean z16) {
        a(str, Boolean.valueOf(z16));
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, (Object) str2);
    }

    private void a(String str, Object obj) {
        Bundle bundle;
        if (TextUtils.isEmpty(str) || (bundle = this.f38968q) == null) {
            return;
        }
        synchronized (bundle) {
            Bundle bundle2 = this.f38968q;
            if (bundle2 != null) {
                try {
                    if (obj instanceof Integer) {
                        bundle2.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle2.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        bundle2.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Double) {
                        bundle2.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle2.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof String) {
                        bundle2.putString(str, (String) obj);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public d(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readBundle(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readInt());
        a(parcel.readInt());
        b(parcel.readInt());
        a(parcel.readLong());
    }
}
