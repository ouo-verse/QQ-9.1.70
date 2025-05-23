package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ba;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i3) {
            return new StrategyBean[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static String f97836a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f97837b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public static String f97838c;

    /* renamed from: d, reason: collision with root package name */
    public long f97839d;

    /* renamed from: e, reason: collision with root package name */
    public long f97840e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f97841f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f97842g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f97843h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f97844i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f97845j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f97846k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f97847l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f97848m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f97849n;

    /* renamed from: o, reason: collision with root package name */
    public long f97850o;

    /* renamed from: p, reason: collision with root package name */
    public long f97851p;

    /* renamed from: q, reason: collision with root package name */
    public String f97852q;

    /* renamed from: r, reason: collision with root package name */
    public String f97853r;

    /* renamed from: s, reason: collision with root package name */
    public String f97854s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, String> f97855t;

    /* renamed from: u, reason: collision with root package name */
    public int f97856u;

    /* renamed from: v, reason: collision with root package name */
    public long f97857v;

    /* renamed from: w, reason: collision with root package name */
    public long f97858w;

    public StrategyBean() {
        this.f97839d = -1L;
        this.f97840e = -1L;
        this.f97841f = true;
        this.f97842g = true;
        this.f97843h = true;
        this.f97844i = true;
        this.f97845j = false;
        this.f97846k = true;
        this.f97847l = true;
        this.f97848m = true;
        this.f97849n = true;
        this.f97851p = 30000L;
        this.f97852q = f97836a;
        this.f97853r = f97837b;
        this.f97856u = 10;
        this.f97857v = MiniBoxNoticeInfo.MIN_5;
        this.f97858w = -1L;
        this.f97840e = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("S(@L@L@)");
        f97838c = sb5.toString();
        sb5.setLength(0);
        sb5.append("*^@K#K@!");
        this.f97854s = sb5.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f97840e);
        parcel.writeByte(this.f97841f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97842g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97843h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f97852q);
        parcel.writeString(this.f97853r);
        parcel.writeString(this.f97854s);
        ba.b(parcel, this.f97855t);
        parcel.writeByte(this.f97844i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97845j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97848m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97849n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f97851p);
        parcel.writeByte(this.f97846k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97847l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f97850o);
        parcel.writeInt(this.f97856u);
        parcel.writeLong(this.f97857v);
        parcel.writeLong(this.f97858w);
    }

    public StrategyBean(Parcel parcel) {
        this.f97839d = -1L;
        this.f97840e = -1L;
        boolean z16 = true;
        this.f97841f = true;
        this.f97842g = true;
        this.f97843h = true;
        this.f97844i = true;
        this.f97845j = false;
        this.f97846k = true;
        this.f97847l = true;
        this.f97848m = true;
        this.f97849n = true;
        this.f97851p = 30000L;
        this.f97852q = f97836a;
        this.f97853r = f97837b;
        this.f97856u = 10;
        this.f97857v = MiniBoxNoticeInfo.MIN_5;
        this.f97858w = -1L;
        try {
            f97838c = "S(@L@L@)";
            this.f97840e = parcel.readLong();
            this.f97841f = parcel.readByte() == 1;
            this.f97842g = parcel.readByte() == 1;
            this.f97843h = parcel.readByte() == 1;
            this.f97852q = parcel.readString();
            this.f97853r = parcel.readString();
            this.f97854s = parcel.readString();
            this.f97855t = ba.b(parcel);
            this.f97844i = parcel.readByte() == 1;
            this.f97845j = parcel.readByte() == 1;
            this.f97848m = parcel.readByte() == 1;
            this.f97849n = parcel.readByte() == 1;
            this.f97851p = parcel.readLong();
            this.f97846k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z16 = false;
            }
            this.f97847l = z16;
            this.f97850o = parcel.readLong();
            this.f97856u = parcel.readInt();
            this.f97857v = parcel.readLong();
            this.f97858w = parcel.readLong();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
