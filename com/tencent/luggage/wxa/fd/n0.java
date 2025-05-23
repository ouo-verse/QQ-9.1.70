package com.tencent.luggage.wxa.fd;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.hn.bg;
import com.tencent.luggage.wxa.hn.ud;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n0 extends com.tencent.luggage.wxa.q9.l {
    public static final a.C6921a V0 = com.tencent.luggage.wxa.q9.l.a(com.tencent.luggage.wxa.q9.l.class);
    public b R0;
    public d S0;
    public g T0;
    public List U0 = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public String f125864b;

        /* renamed from: d, reason: collision with root package name */
        public String f125866d;

        /* renamed from: e, reason: collision with root package name */
        public int f125867e;

        /* renamed from: f, reason: collision with root package name */
        public int f125868f;

        /* renamed from: g, reason: collision with root package name */
        public List f125869g;

        /* renamed from: h, reason: collision with root package name */
        public List f125870h;

        /* renamed from: i, reason: collision with root package name */
        public List f125871i;

        /* renamed from: j, reason: collision with root package name */
        public List f125872j;

        /* renamed from: k, reason: collision with root package name */
        public List f125873k;

        /* renamed from: l, reason: collision with root package name */
        public List f125874l;

        /* renamed from: m, reason: collision with root package name */
        public List f125875m;

        /* renamed from: n, reason: collision with root package name */
        public String f125876n;

        /* renamed from: o, reason: collision with root package name */
        public int f125877o;

        /* renamed from: p, reason: collision with root package name */
        public String f125878p;

        /* renamed from: q, reason: collision with root package name */
        public String f125879q;

        /* renamed from: u, reason: collision with root package name */
        public int f125883u;

        /* renamed from: v, reason: collision with root package name */
        public int f125884v;

        /* renamed from: w, reason: collision with root package name */
        public int f125885w;

        /* renamed from: x, reason: collision with root package name */
        public bg f125886x;

        /* renamed from: y, reason: collision with root package name */
        public int f125887y;

        /* renamed from: a, reason: collision with root package name */
        public long f125863a = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f125865c = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f125880r = 0;

        /* renamed from: s, reason: collision with root package name */
        public int f125881s = 0;

        /* renamed from: t, reason: collision with root package name */
        public int f125882t = 0;

        /* renamed from: z, reason: collision with root package name */
        public long f125888z = 0;

        public boolean a() {
            return this.f125867e == 4;
        }

        public boolean b() {
            if (this.f125868f <= 0 && this.f125867e != 7) {
                return false;
            }
            return true;
        }

        public static b a(String str) {
            if (w0.c(str)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
                return null;
            }
            w0.a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    bVar.f125863a = optJSONObject.optLong("RunningFlag");
                    bVar.f125864b = optJSONObject.optString("AppOpenForbiddenUrl");
                    bVar.f125865c = optJSONObject.optLong("CanNotStarWxaBeforeTime", 0L);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("Network");
                if (optJSONObject2 != null) {
                    bVar.f125869g = q0.a(optJSONObject2.optJSONArray("RequestDomain"));
                    bVar.f125870h = q0.a(optJSONObject2.optJSONArray("WsRequestDomain"));
                    bVar.f125871i = q0.a(optJSONObject2.optJSONArray("UploadDomain"));
                    bVar.f125872j = q0.a(optJSONObject2.optJSONArray("DownloadDomain"));
                    bVar.f125873k = q0.a(optJSONObject2.optJSONArray("UDPDomain"));
                    bVar.f125874l = q0.a(optJSONObject2.optJSONArray("TCPDomain"));
                    bVar.f125875m = q0.a(optJSONObject2.optJSONArray("PrefetchDNSDomain"));
                }
                bVar.f125866d = jSONObject.optString("Appid");
                bVar.f125868f = jSONObject.optInt("WechatPluginApp", 0);
                bVar.f125867e = jSONObject.optInt("AppServiceType", 0);
                bVar.f125876n = jSONObject.optString("fromBusinessUsername");
                bVar.f125877o = jSONObject.optInt("OriginalFlag", 0);
                bVar.f125878p = jSONObject.optString("OriginalRedirectUrl");
                bVar.f125879q = jSONObject.optString("game_icon_flag_list");
                bVar.f125880r = jSONObject.optInt("ShowRelievedBuyFlag", 0);
                bVar.f125881s = jSONObject.optInt("ShowFlagshipFlag", 0);
                bVar.f125882t = jSONObject.optInt("AgeAppropriateLevel", 0);
                bVar.f125883u = jSONObject.optInt("SystemAuthBizScene", 0);
                bVar.f125884v = jSONObject.optInt("SystemAuthFrequencyLimitFlag", 0);
                bVar.f125885w = jSONObject.optInt("LaunchFallbackMinVersion", 0);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("MigrateInfo");
                if (optJSONObject3 != null) {
                    bg bgVar = new bg();
                    bVar.f125886x = bgVar;
                    bgVar.f127364d = optJSONObject3.optString("target_appid");
                }
                bVar.f125887y = jSONObject.optInt("BatchPreFetchBusiFlag", 0);
                bVar.f125888z = jSONObject.optLong("depend_lib_bit_flag", 0L);
                return bVar;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", str, e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125889a;

        /* renamed from: b, reason: collision with root package name */
        public String f125890b;

        /* renamed from: c, reason: collision with root package name */
        public String f125891c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f125892d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f125893e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        public c() {
        }

        public static List a(JSONArray jSONArray) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            if (jSONObject != null) {
                                c cVar = new c();
                                cVar.f125889a = jSONObject.optString("root");
                                cVar.f125890b = jSONObject.optString("entry_page_path");
                                cVar.f125891c = jSONObject.optString("desc");
                                cVar.f125892d = b(jSONObject.optJSONArray("scopes"));
                                cVar.f125893e = b(jSONObject.optJSONArray("supported_materials"));
                                linkedList.add(cVar);
                            }
                        }
                        return linkedList;
                    }
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes", "parse json array, e = %s", e16);
                }
            }
            return null;
        }

        public static String[] b(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() > 0) {
                String[] strArr = new String[jSONArray.length()];
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    strArr[i3] = jSONArray.optString(i3);
                }
                return strArr;
            }
            return new String[0];
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f125889a);
            parcel.writeString(this.f125890b);
            parcel.writeString(this.f125891c);
            parcel.writeStringArray(this.f125892d);
            parcel.writeStringArray(this.f125893e);
        }

        public c(Parcel parcel) {
            this.f125889a = parcel.readString();
            this.f125890b = parcel.readString();
            this.f125891c = parcel.readString();
            this.f125892d = parcel.createStringArray();
            this.f125893e = parcel.createStringArray();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public a f125894a = new a();

        /* renamed from: b, reason: collision with root package name */
        public List f125895b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C6211a();
            public int C;
            public int D;
            public boolean E;
            public int F;
            public int G;
            public boolean H;
            public boolean I;
            public boolean J;
            public int K;
            public int L;
            public int M;
            public boolean N;
            public boolean O;
            public int P;
            public long Q;
            public long R;
            public long S;
            public long T;
            public byte[] U;
            public long V;
            public String W;

            /* renamed from: a, reason: collision with root package name */
            public int f125896a;

            /* renamed from: b, reason: collision with root package name */
            public int f125897b;

            /* renamed from: c, reason: collision with root package name */
            public int f125898c;

            /* renamed from: d, reason: collision with root package name */
            public int f125899d;

            /* renamed from: e, reason: collision with root package name */
            public int f125900e;

            /* renamed from: f, reason: collision with root package name */
            public int f125901f;

            /* renamed from: g, reason: collision with root package name */
            public int f125902g;

            /* renamed from: h, reason: collision with root package name */
            public int f125903h;

            /* renamed from: i, reason: collision with root package name */
            public int f125904i;

            /* renamed from: j, reason: collision with root package name */
            public int f125905j;

            /* renamed from: k, reason: collision with root package name */
            public boolean f125906k;

            /* renamed from: l, reason: collision with root package name */
            public boolean f125907l;

            /* renamed from: m, reason: collision with root package name */
            public int f125908m;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.fd.n0$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6211a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i3) {
                    return new a[i3];
                }
            }

            public a() {
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a clone() {
                Parcel obtain = Parcel.obtain();
                obtain.setDataPosition(0);
                writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                try {
                    return CREATOR.createFromParcel(obtain);
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f125896a);
                parcel.writeInt(this.f125897b);
                parcel.writeInt(this.f125898c);
                parcel.writeInt(this.f125899d);
                parcel.writeInt(this.f125900e);
                parcel.writeInt(this.f125901f);
                parcel.writeInt(this.f125902g);
                parcel.writeInt(this.f125903h);
                parcel.writeInt(this.f125904i);
                parcel.writeInt(this.f125905j);
                parcel.writeByte(this.f125906k ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f125907l ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f125908m);
                parcel.writeInt(this.C);
                parcel.writeInt(this.D);
                parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.F);
                parcel.writeInt(this.G);
                parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.K);
                parcel.writeInt(this.L);
                parcel.writeInt(this.M);
                parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.P);
                parcel.writeLong(this.Q);
                parcel.writeLong(this.R);
                parcel.writeLong(this.S);
                parcel.writeLong(this.T);
                parcel.writeByteArray(this.U);
                parcel.writeLong(this.V);
                parcel.writeString(this.W);
            }

            public a(Parcel parcel) {
                this.f125896a = parcel.readInt();
                this.f125897b = parcel.readInt();
                this.f125898c = parcel.readInt();
                this.f125899d = parcel.readInt();
                this.f125900e = parcel.readInt();
                this.f125901f = parcel.readInt();
                this.f125902g = parcel.readInt();
                this.f125903h = parcel.readInt();
                this.f125904i = parcel.readInt();
                this.f125905j = parcel.readInt();
                this.f125906k = parcel.readByte() != 0;
                this.f125907l = parcel.readByte() != 0;
                this.f125908m = parcel.readInt();
                this.C = parcel.readInt();
                this.D = parcel.readInt();
                this.E = parcel.readByte() != 0;
                this.F = parcel.readInt();
                this.G = parcel.readInt();
                this.H = parcel.readByte() != 0;
                this.I = parcel.readByte() != 0;
                this.J = parcel.readByte() != 0;
                this.K = parcel.readInt();
                this.L = parcel.readInt();
                this.M = parcel.readInt();
                this.N = parcel.readByte() != 0;
                this.O = parcel.readByte() != 0;
                this.P = parcel.readInt();
                this.Q = parcel.readLong();
                this.R = parcel.readLong();
                this.S = parcel.readLong();
                this.T = parcel.readLong();
                this.U = parcel.createByteArray();
                this.V = parcel.readLong();
                this.W = parcel.readString();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125918a;

        /* renamed from: b, reason: collision with root package name */
        public String f125919b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        public f() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f125918a);
            parcel.writeString(this.f125919b);
        }

        public f(Parcel parcel) {
            this.f125918a = parcel.readString();
            this.f125919b = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h implements Parcelable {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125933a;

        /* renamed from: b, reason: collision with root package name */
        public String f125934b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f125935c;

        /* renamed from: d, reason: collision with root package name */
        public int f125936d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f125937e;

        /* renamed from: f, reason: collision with root package name */
        public List f125938f;

        /* renamed from: g, reason: collision with root package name */
        public String f125939g;

        /* renamed from: h, reason: collision with root package name */
        public List f125940h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f125941i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f125942j;

        /* renamed from: k, reason: collision with root package name */
        public JSONObject f125943k;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h() {
        }

        public static List a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            try {
                LinkedList linkedList = new LinkedList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        h hVar = new h();
                        hVar.f125943k = jSONObject;
                        hVar.f125933a = jSONObject.getString("name");
                        if (jSONObject.has("md5")) {
                            hVar.f125934b = jSONObject.getString("md5");
                        } else if (jSONObject.has("checkSumMd5")) {
                            hVar.f125934b = jSONObject.getString("checkSumMd5");
                        }
                        hVar.f125936d = jSONObject.optInt("size", 0);
                        hVar.f125935c = jSONObject.optBoolean("independent", false);
                        hVar.f125937e = a(jSONObject);
                        hVar.f125939g = jSONObject.optString("without_lib_md5");
                        List a16 = i.a(jSONObject.optJSONArray("widget_list"));
                        hVar.f125940h = a16;
                        hVar.f125938f = e.a(a16, jSONObject.opt("separated_plugin_list"), 23);
                        hVar.f125941i = jSONObject.optBoolean("brotli", false);
                        hVar.f125942j = jSONObject.optBoolean("parallelDownloadOnLaunchStage", false);
                        linkedList.add(hVar);
                    }
                }
                return linkedList;
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", e16);
                return null;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f125933a);
            parcel.writeString(this.f125934b);
            parcel.writeByte(this.f125935c ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f125936d);
            parcel.writeStringArray(this.f125937e);
            parcel.writeTypedList(this.f125938f);
            parcel.writeString(this.f125939g);
            parcel.writeTypedList(this.f125940h);
            parcel.writeByte(this.f125941i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f125942j ? (byte) 1 : (byte) 0);
        }

        public h(Parcel parcel) {
            this.f125933a = parcel.readString();
            this.f125934b = parcel.readString();
            this.f125935c = parcel.readByte() != 0;
            this.f125936d = parcel.readInt();
            this.f125937e = parcel.createStringArray();
            this.f125938f = parcel.createTypedArrayList(e.CREATOR);
            this.f125939g = parcel.readString();
            this.f125940h = parcel.createTypedArrayList(i.CREATOR);
            this.f125941i = parcel.readByte() != 0;
            this.f125942j = parcel.readByte() != 0;
        }

        public static List a(String str) {
            if (w0.c(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                return a(jSONArray);
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", str, e16);
                return null;
            }
        }

        public static String[] a(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(NotificationActivity.KEY_ALIAS);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return new String[0];
            }
            String[] strArr = new String[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                strArr[i3] = optJSONArray.optString(i3);
            }
            return strArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i implements Parcelable {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f125944a;

        /* renamed from: b, reason: collision with root package name */
        public String f125945b;

        /* renamed from: c, reason: collision with root package name */
        public List f125946c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i3) {
                return new i[i3];
            }
        }

        public i() {
        }

        public static List a(String str) {
            if (w0.c(str)) {
                return null;
            }
            try {
                return a(new JSONArray(str));
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e16);
                return null;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f125944a);
            parcel.writeString(this.f125945b);
            parcel.writeTypedList(this.f125946c);
        }

        public i(Parcel parcel) {
            this.f125944a = parcel.readInt();
            this.f125945b = parcel.readString();
            this.f125946c = parcel.createTypedArrayList(e.CREATOR);
        }

        public static List a(JSONArray jSONArray) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            if (jSONObject != null) {
                                i iVar = new i();
                                iVar.f125944a = jSONObject.optInt("package_type");
                                iVar.f125945b = jSONObject.optString("wxapkg_md5");
                                if (ArrayUtils.contains(com.tencent.luggage.wxa.ip.a.f130732b, iVar.f125944a)) {
                                    iVar.f125946c = e.a(jSONObject.opt("separated_plugin_list"));
                                    linkedList.add(iVar);
                                }
                            }
                        }
                        return linkedList;
                    }
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e16);
                }
            }
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.q9.l, com.tencent.luggage.wxa.xn.a
    public void a(Cursor cursor) {
        super.a(cursor);
        this.R0 = null;
        this.S0 = null;
        this.T0 = null;
        this.U0 = null;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return V0;
    }

    public b f() {
        if (this.R0 == null) {
            this.R0 = b.a(this.f138487z);
        }
        return this.R0;
    }

    public d g() {
        JSONObject jSONObject;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        if (this.S0 == null) {
            try {
                jSONObject = new JSONObject(this.J);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.S0 = new d();
            w0.a();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.S0.f125894a.f125896a = optJSONObject.optInt("Uint32MaxLocalstorageSizeInMB", 5);
            this.S0.f125894a.f125897b = optJSONObject.optInt("Uint32OpendataMaxLocalstorageSizeInMB", 5);
            this.S0.f125894a.f125898c = optJSONObject.optInt("MaxCodeSize", 5);
            this.S0.f125894a.f125899d = optJSONObject.optInt("ExpendedMaxWebviewDepth", 5);
            this.S0.f125894a.f125900e = optJSONObject.optInt("MaxBackgroundLifespan", 600);
            this.S0.f125894a.f125901f = optJSONObject.optInt("MaxRequestConcurrent", 10);
            this.S0.f125894a.f125902g = optJSONObject.optInt("MaxUploadConcurrent", 10);
            this.S0.f125894a.f125903h = optJSONObject.optInt("MaxDownloadConcurrent", 10);
            this.S0.f125894a.f125904i = optJSONObject.optInt("MaxWebsocketConnect", 5);
            boolean z29 = true;
            this.S0.f125894a.f125905j = optJSONObject.optInt("MaxWorkerConcurrent", 1);
            d.a aVar = this.S0.f125894a;
            if (optJSONObject.optInt("WebsocketSkipPortCheck", 0) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f125906k = z16;
            d.a aVar2 = this.S0.f125894a;
            if (optJSONObject.optInt("TLSSkipHostnameCheck", 0) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            aVar2.f125907l = z17;
            this.S0.f125894a.f125908m = optJSONObject.optInt("Uint32MaxFileStorageSizeInMB", 10);
            this.S0.f125894a.C = optJSONObject.optInt("Uint32MaxTempFileStorageSizeInMB", 300);
            this.S0.f125894a.D = optJSONObject.optInt("Uint32MinTempFileStorageSizeInMB", 100);
            d.a aVar3 = this.S0.f125894a;
            if (optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar3.E = z18;
            this.S0.f125894a.F = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.S0.f125894a.G = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            d.a aVar4 = this.S0.f125894a;
            if (optJSONObject.optInt("ScanCodeEnableZZM", 0) != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            aVar4.H = z19;
            d.a aVar5 = this.S0.f125894a;
            if (optJSONObject.optInt("CanPreFetchData", 0) > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            aVar5.I = z26;
            d.a aVar6 = this.S0.f125894a;
            if (optJSONObject.optInt("CanPeriodFetchData", 0) > 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            aVar6.J = z27;
            this.S0.f125894a.K = optJSONObject.optInt("PeriodFetchData", 0);
            this.S0.f125894a.L = optJSONObject.optInt("PeriodFetchDataDay", 7);
            this.S0.f125894a.M = optJSONObject.optInt("GuaranteeFlag", 0);
            d.a aVar7 = this.S0.f125894a;
            if (optJSONObject.optInt("CanShowLoadingAdvert", 0) > 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            aVar7.N = z28;
            d.a aVar8 = this.S0.f125894a;
            if (optJSONObject.optInt("CanShowGameLoadingAdvert", 0) <= 0) {
                z29 = false;
            }
            aVar8.O = z29;
            this.S0.f125894a.P = optJSONObject.optInt("BrandOfficialLabel", 0);
            this.S0.f125894a.Q = optJSONObject.optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
            this.S0.f125894a.R = optJSONObject.optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
            this.S0.f125894a.S = optJSONObject.optLong("OpenWxaWaitUpdateMinMicSec", 0L);
            this.S0.f125894a.T = optJSONObject.optLong("NextTryOpenWxaDisMicSec", 10000L);
            this.S0.f125894a.U = optJSONObject.optString("PreCgiCallByteBeforeLaunch", "").getBytes(StandardCharsets.UTF_8);
            this.S0.f125894a.V = optJSONObject.optLong("Uint32WxaLibPrivateMaxFileStorageSizeInMB", 200L);
            this.S0.f125894a.W = b(optJSONObject.optString("GameABTestControlBytes"));
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.S0.f125895b = new LinkedList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        this.S0.f125895b.add(new Pair(optJSONObject2.optString(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST), optJSONObject2.optString(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND)));
                    }
                }
            }
        }
        return this.S0;
    }

    public g h() {
        if (this.T0 == null && !w0.c(this.B)) {
            g a16 = g.a(this.B);
            this.T0 = a16;
            return a16;
        }
        return this.T0;
    }

    public String i() {
        HashMap hashMap = new HashMap();
        hashMap.put("NickName", this.f138469h);
        hashMap.put("BrandIconURL", this.f138473l);
        hashMap.put("BigHeadImgUrl", this.f138477p);
        hashMap.put("SmallHeadImgUrl", this.f138479r);
        hashMap.put("Signature", this.f138481t);
        hashMap.put("WxAppOpt", Integer.valueOf(this.f138483v));
        hashMap.put("RegisterSource", a(this.f138485x));
        hashMap.put("WxaAppInfo", a(this.f138487z));
        hashMap.put("WxaAppVersionInfo", a(this.B));
        hashMap.put("BindWxaInfo", a(this.H));
        hashMap.put("WxaAppDynamic", a(this.J));
        hashMap.put("MMBizMenu", a(this.R));
        return new JSONObject(hashMap).toString();
    }

    public String toString() {
        return "WxaAttributes{field_username='" + this.f138465d + "', field_appId='" + this.f138467f + "', field_nickname='" + this.f138469h + "', field_signature='" + this.f138481t + "', field_registerSource='" + this.f138485x + "', field_appInfo='" + this.f138487z + "', field_versionInfo='" + this.B + "', field_bindWxaInfo='" + this.H + "', field_dynamicInfo='" + this.J + "', field_bizMenu='" + this.R + "'}";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125909a;

        /* renamed from: b, reason: collision with root package name */
        public int f125910b;

        /* renamed from: c, reason: collision with root package name */
        public String f125911c;

        /* renamed from: d, reason: collision with root package name */
        public String f125912d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f125913e;

        /* renamed from: f, reason: collision with root package name */
        public List f125914f;

        /* renamed from: g, reason: collision with root package name */
        public long f125915g;

        /* renamed from: h, reason: collision with root package name */
        public String f125916h;

        /* renamed from: i, reason: collision with root package name */
        public String f125917i;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e() {
            this.f125914f = new LinkedList();
        }

        public static List a(List list, Object obj, int i3) {
            List list2 = null;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.f125944a == i3) {
                        list2 = iVar.f125946c;
                    }
                }
            }
            return list2 == null ? a(obj) : list2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f125909a);
            parcel.writeInt(this.f125910b);
            parcel.writeString(this.f125911c);
            parcel.writeString(this.f125912d);
            parcel.writeByte(this.f125913e ? (byte) 1 : (byte) 0);
            parcel.writeList(this.f125914f);
            parcel.writeLong(this.f125915g);
            parcel.writeString(this.f125916h);
            parcel.writeString(this.f125917i);
        }

        public e(Parcel parcel) {
            this.f125914f = new LinkedList();
            this.f125909a = parcel.readString();
            this.f125910b = parcel.readInt();
            this.f125911c = parcel.readString();
            this.f125912d = parcel.readString();
            this.f125913e = parcel.readByte() == 1;
            if (this.f125914f == null) {
                this.f125914f = new LinkedList();
            }
            parcel.readList(this.f125914f, Integer.class.getClassLoader());
            this.f125915g = parcel.readLong();
            this.f125916h = parcel.readString();
            this.f125917i = parcel.readString();
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[Catch: JSONException -> 0x00e0, LOOP:1: B:34:0x009d->B:36:0x00a3, LOOP_END, TryCatch #0 {JSONException -> 0x00e0, blocks: (B:7:0x000c, B:9:0x0010, B:11:0x0035, B:14:0x003d, B:15:0x0043, B:17:0x0049, B:22:0x0051, B:24:0x0080, B:28:0x008a, B:30:0x0095, B:34:0x009d, B:36:0x00a3, B:38:0x00bc, B:40:0x00b3, B:46:0x0018, B:48:0x001c, B:49:0x0020), top: B:6:0x000c }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static List a(Object obj) {
            JSONArray jSONArray;
            boolean z16;
            JSONArray optJSONArray;
            int i3;
            if (obj == null) {
                return null;
            }
            try {
                if (obj instanceof String) {
                    jSONArray = new JSONArray((String) obj);
                } else if (obj instanceof JSONArray) {
                    jSONArray = (JSONArray) obj;
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", obj.getClass().getName());
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() != 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i16);
                        if (jSONObject != null) {
                            e eVar = new e();
                            eVar.f125909a = jSONObject.optString("plugin_id");
                            eVar.f125910b = jSONObject.optInt("inner_version");
                            eVar.f125911c = jSONObject.optString("md5");
                            eVar.f125912d = jSONObject.optString("prefix_path");
                            if (!jSONObject.optBoolean(WadlProxyConsts.VIA_AUTO_UPDATE) && jSONObject.optInt(WadlProxyConsts.VIA_AUTO_UPDATE, 0) <= 0) {
                                z16 = false;
                                eVar.f125913e = z16;
                                optJSONArray = jSONObject.optJSONArray("contexts");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                        eVar.f125914f.add(Integer.valueOf(optJSONArray.optInt(i3)));
                                    }
                                    eVar.f125915g = jSONObject.optLong("dev_key");
                                    eVar.f125916h = jSONObject.optString("version_desc");
                                    eVar.f125917i = jSONObject.optString("semver");
                                    linkedList.add(eVar);
                                }
                                eVar.f125914f.add(0);
                                eVar.f125915g = jSONObject.optLong("dev_key");
                                eVar.f125916h = jSONObject.optString("version_desc");
                                eVar.f125917i = jSONObject.optString("semver");
                                linkedList.add(eVar);
                            }
                            z16 = true;
                            eVar.f125913e = z16;
                            optJSONArray = jSONObject.optJSONArray("contexts");
                            if (optJSONArray != null) {
                                while (i3 < optJSONArray.length()) {
                                }
                                eVar.f125915g = jSONObject.optLong("dev_key");
                                eVar.f125916h = jSONObject.optString("version_desc");
                                eVar.f125917i = jSONObject.optString("semver");
                                linkedList.add(eVar);
                            }
                            eVar.f125914f.add(0);
                            eVar.f125915g = jSONObject.optLong("dev_key");
                            eVar.f125916h = jSONObject.optString("version_desc");
                            eVar.f125917i = jSONObject.optString("semver");
                            linkedList.add(eVar);
                        }
                    }
                    return linkedList;
                }
                return null;
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e16);
                return null;
            }
        }
    }

    public final String b(String str) {
        try {
            if (w0.c(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            ud e16 = ud.e();
            e16.a(decode);
            byte[] a16 = e16.f128841d.a();
            String trim = new String(Base64.encode(a16, 0)).trim();
            StringBuilder sb5 = new StringBuilder("[");
            if (a16 != null) {
                for (int i3 = 0; i3 < a16.length; i3++) {
                    byte b16 = a16[i3];
                    if (i3 != 0) {
                        sb5.append(",");
                    }
                    sb5.append((int) b16);
                }
            }
            sb5.append("]");
            b f16 = f();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WxaAttributes", "dl: GameABTestControlBytes[%s]: \"%s\" -> %s -> \"%s\"", f16 != null ? f16.f125866d : null, str, sb5, trim);
            return trim;
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.WxaAttributes", e17, "dl: GameABTestControlBytes, error, \"%s\"", str);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C6210a();

        /* renamed from: a, reason: collision with root package name */
        public String f125862a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.n0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6210a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(Parcel parcel) {
            this.f125862a = "default";
            this.f125862a = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f125862a);
        }

        public a() {
            this.f125862a = "default";
        }
    }

    public static JSONObject a(String str) {
        if (w0.c(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.WxaAttributes", e16, "createJsonObjectOrNull", new Object[0]);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public List C;
        public long D;
        public String E;
        public String F;
        public String G;
        public String H;
        public boolean I;
        public a J;
        public long K;
        public String L;
        public transient JSONObject M;
        public boolean N;
        public long O;
        public List P;

        /* renamed from: a, reason: collision with root package name */
        public int f125920a;

        /* renamed from: b, reason: collision with root package name */
        public String f125921b;

        /* renamed from: c, reason: collision with root package name */
        public int f125922c;

        /* renamed from: d, reason: collision with root package name */
        public String f125923d;

        /* renamed from: e, reason: collision with root package name */
        public String f125924e;

        /* renamed from: f, reason: collision with root package name */
        public f f125925f;

        /* renamed from: g, reason: collision with root package name */
        public List f125926g;

        /* renamed from: h, reason: collision with root package name */
        public int f125927h;

        /* renamed from: i, reason: collision with root package name */
        public List f125928i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f125929j;

        /* renamed from: k, reason: collision with root package name */
        public String f125930k;

        /* renamed from: l, reason: collision with root package name */
        public String f125931l;

        /* renamed from: m, reason: collision with root package name */
        public String f125932m;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        public g() {
            this.E = "";
            this.F = "";
            this.G = "";
            this.H = "";
            this.I = false;
            this.O = 0L;
        }

        public static g a(String str) {
            if (w0.c(str)) {
                return null;
            }
            w0.a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                g gVar = new g();
                gVar.M = jSONObject;
                gVar.f125920a = jSONObject.optInt("AppVersion", 0);
                gVar.f125921b = jSONObject.optString("custom_version");
                gVar.f125922c = jSONObject.optInt("VersionState", -1);
                gVar.f125923d = jSONObject.optString("VersionMD5");
                gVar.f125924e = jSONObject.optString("device_orientation");
                gVar.f125931l = jSONObject.optString("client_js_ext_info");
                gVar.f125927h = jSONObject.optInt("code_size");
                JSONObject optJSONObject = jSONObject.optJSONObject("loading_image_info");
                if (optJSONObject != null) {
                    f fVar = new f();
                    gVar.f125925f = fVar;
                    fVar.f125918a = optJSONObject.optString("url");
                    gVar.f125925f.f125919b = optJSONObject.optString("progressbar_color");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("fake_native_loading_style_info");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("white_style");
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("black_style");
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.has("navigation_bar_text_color")) {
                            gVar.E = optJSONObject3.optString("navigation_bar_text_color");
                        }
                        if (optJSONObject3.has("background_color")) {
                            gVar.F = optJSONObject3.optString("background_color");
                        }
                    }
                    if (optJSONObject4 != null) {
                        if (optJSONObject4.has("navigation_bar_text_color")) {
                            gVar.G = optJSONObject4.optString("navigation_bar_text_color");
                        }
                        if (optJSONObject4.has("background_color")) {
                            gVar.H = optJSONObject4.optString("background_color");
                        }
                    }
                }
                gVar.f125928i = h.a(jSONObject.optJSONArray("module_list"));
                gVar.f125929j = jSONObject.optBoolean("UseModule", false);
                gVar.f125930k = jSONObject.optString("EntranceModule");
                gVar.f125932m = jSONObject.optString("without_lib_md5");
                List a16 = i.a(jSONObject.optJSONArray("widget_list"));
                gVar.C = a16;
                gVar.f125926g = e.a(a16, jSONObject.opt("separated_plugin_list"), 22);
                gVar.D = jSONObject.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
                gVar.I = jSONObject.optBoolean("resizable", false);
                JSONObject optJSONObject5 = jSONObject.optJSONObject("halfPage");
                a aVar = new a();
                gVar.J = aVar;
                if (optJSONObject5 != null) {
                    aVar.f125862a = optJSONObject5.optString("firstPageNavigationStyle");
                }
                gVar.K = jSONObject.optLong("template_id", -1L);
                gVar.L = jSONObject.optString("renderer");
                if (jSONObject.has("isTransparentBackgroundSupport")) {
                    String trim = w0.d(jSONObject.optString("isTransparentBackgroundSupport")).trim();
                    if (StringUtils.equalsIgnoreCase("true", trim)) {
                        gVar.N = true;
                    } else if (StringUtils.equalsIgnoreCase("false", trim)) {
                        gVar.N = false;
                    } else {
                        gVar.N = "1".equals(trim);
                    }
                }
                gVar.O = jSONObject.optLong("depend_lib_bit_flag", 0L);
                gVar.P = c.a(jSONObject.optJSONArray("chat_tools"));
                return gVar;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f125920a);
            parcel.writeString(this.f125921b);
            parcel.writeInt(this.f125922c);
            parcel.writeString(this.f125923d);
            parcel.writeString(this.f125924e);
            parcel.writeParcelable(this.f125925f, i3);
            parcel.writeTypedList(this.f125926g);
            parcel.writeInt(this.f125927h);
            parcel.writeTypedList(this.f125928i);
            parcel.writeByte(this.f125929j ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f125930k);
            parcel.writeString(this.f125931l);
            parcel.writeString(this.f125932m);
            parcel.writeTypedList(this.C);
            parcel.writeString(this.E);
            parcel.writeString(this.F);
            parcel.writeString(this.G);
            parcel.writeString(this.H);
            parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.K);
            parcel.writeParcelable(this.J, i3);
            parcel.writeString(this.L);
            parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
            parcel.writeTypedList(this.P);
        }

        public g(Parcel parcel) {
            this.E = "";
            this.F = "";
            this.G = "";
            this.H = "";
            this.I = false;
            this.O = 0L;
            this.f125920a = parcel.readInt();
            this.f125921b = parcel.readString();
            this.f125922c = parcel.readInt();
            this.f125923d = parcel.readString();
            this.f125924e = parcel.readString();
            this.f125925f = (f) parcel.readParcelable(f.class.getClassLoader());
            this.f125926g = parcel.createTypedArrayList(e.CREATOR);
            this.f125927h = parcel.readInt();
            this.f125928i = parcel.createTypedArrayList(h.CREATOR);
            this.f125929j = parcel.readByte() != 0;
            this.f125930k = parcel.readString();
            this.f125931l = parcel.readString();
            this.f125932m = parcel.readString();
            this.C = parcel.createTypedArrayList(i.CREATOR);
            this.E = parcel.readString();
            this.F = parcel.readString();
            this.G = parcel.readString();
            this.H = parcel.readString();
            this.I = parcel.readByte() > 0;
            this.K = parcel.readLong();
            this.J = (a) parcel.readParcelable(a.class.getClassLoader());
            this.L = parcel.readString();
            this.N = parcel.readByte() > 0;
            this.P = parcel.createTypedArrayList(c.CREATOR);
        }
    }
}
