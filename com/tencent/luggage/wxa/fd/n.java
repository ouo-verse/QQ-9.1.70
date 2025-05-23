package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f125847a;

    /* renamed from: b, reason: collision with root package name */
    public String f125848b;

    /* renamed from: c, reason: collision with root package name */
    public String f125849c;

    /* renamed from: d, reason: collision with root package name */
    public String f125850d;

    /* renamed from: e, reason: collision with root package name */
    public String f125851e;

    /* renamed from: f, reason: collision with root package name */
    public String f125852f;

    /* renamed from: g, reason: collision with root package name */
    public String f125853g;

    /* renamed from: h, reason: collision with root package name */
    public int f125854h;

    /* renamed from: i, reason: collision with root package name */
    public String f125855i;

    /* renamed from: j, reason: collision with root package name */
    public b f125856j;

    /* renamed from: k, reason: collision with root package name */
    public String f125857k;

    /* renamed from: l, reason: collision with root package name */
    public String f125858l;

    /* renamed from: m, reason: collision with root package name */
    public String f125859m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i3) {
            return new n[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f125860a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f125861b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public /* synthetic */ b(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "OpenBusinessViewExtraArgs{sticky=" + this.f125860a + ", disableVisibilityEvent=" + this.f125861b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeByte(this.f125860a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f125861b ? (byte) 1 : (byte) 0);
        }

        public b() {
        }

        public b(Parcel parcel) {
            this.f125860a = parcel.readByte() != 0;
            this.f125861b = parcel.readByte() != 0;
        }
    }

    public /* synthetic */ n(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void a(Parcel parcel) {
        this.f125847a = parcel.readInt();
        this.f125848b = parcel.readString();
        this.f125849c = parcel.readString();
        this.f125850d = parcel.readString();
        this.f125852f = parcel.readString();
        this.f125853g = parcel.readString();
        this.f125854h = parcel.readInt();
        this.f125855i = parcel.readString();
        this.f125851e = parcel.readString();
        this.f125857k = parcel.readString();
        this.f125858l = parcel.readString();
        this.f125859m = parcel.readString();
        this.f125856j = (b) parcel.readParcelable(b.class.getClassLoader());
    }

    public JSONObject b() {
        Object obj;
        try {
            obj = new JSONObject(this.f125849c);
        } catch (Exception unused) {
            obj = this.f125849c;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.f125848b);
            jSONObject.put(WadlProxyConsts.EXTRA_DATA, obj);
            int i3 = this.f125847a;
            if ((i3 == 1 || i3 == 3 || i3 == 2 || i3 == 10) && !w0.c(this.f125850d)) {
                jSONObject.put("privateExtraData", new JSONObject(this.f125850d));
            }
            if (this.f125847a == 6 && !w0.c(this.f125851e)) {
                jSONObject.put("messageExtraData", new JSONObject(this.f125851e));
            }
            if (this.f125847a == 7 && !w0.c(this.f125857k)) {
                jSONObject.put("openapiInvokeData", new JSONObject(this.f125857k));
            }
            if (this.f125847a == 7 && !w0.c(this.f125858l)) {
                jSONObject.put("transitiveData", new JSONObject(this.f125858l));
            }
            if (this.f125847a == 9 && !w0.c(this.f125859m)) {
                jSONObject.put("gameLiveInfo", new JSONObject(this.f125859m));
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", e16);
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AppBrandLaunchReferrer{launchScene=");
        sb5.append(this.f125847a);
        sb5.append(", appId='");
        sb5.append(this.f125848b);
        sb5.append('\'');
        sb5.append(", extraData='");
        sb5.append(this.f125849c);
        sb5.append('\'');
        sb5.append(", url='");
        sb5.append(this.f125852f);
        sb5.append('\'');
        sb5.append(", agentId='");
        sb5.append(this.f125853g);
        sb5.append('\'');
        sb5.append(", sourceType='");
        sb5.append(this.f125854h);
        sb5.append('\'');
        sb5.append(", businessType='");
        sb5.append(this.f125855i);
        sb5.append('\'');
        if (this.f125856j != null) {
            str = ", openBusinessViewExtraArgs=" + this.f125856j;
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f125847a);
        parcel.writeString(this.f125848b);
        parcel.writeString(this.f125849c);
        parcel.writeString(this.f125850d);
        parcel.writeString(this.f125852f);
        parcel.writeString(this.f125853g);
        parcel.writeInt(this.f125854h);
        parcel.writeString(this.f125855i);
        parcel.writeString(this.f125851e);
        parcel.writeString(this.f125857k);
        parcel.writeString(this.f125858l);
        parcel.writeString(this.f125859m);
        parcel.writeParcelable(this.f125856j, i3);
    }

    public n() {
    }

    public n(Parcel parcel) {
        a(parcel);
    }

    public void a() {
        a(new n());
    }

    public void a(n nVar) {
        if (nVar == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        nVar.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        a(obtain);
        OaidMonitor.parcelRecycle(obtain);
    }
}
