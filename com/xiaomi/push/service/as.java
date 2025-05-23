package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.xiaomi.push.ev;
import com.xiaomi.push.fs;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class as {

    /* renamed from: o, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile as f389643o;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f389644a;

    /* renamed from: h, reason: collision with root package name */
    private long f389651h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f389652i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f389653j;

    /* renamed from: l, reason: collision with root package name */
    private final Context f389655l;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f389645b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private String f389646c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f389647d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f389648e = null;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f389649f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f389650g = new AtomicInteger(0);

    /* renamed from: k, reason: collision with root package name */
    private int f389654k = -1;

    /* renamed from: m, reason: collision with root package name */
    private long f389656m = -1;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f389657n = C();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String b(String str) {
            return String.format("HB_%s", str);
        }

        public static String c() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String d(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String e() {
            return "record_hb_count_start";
        }

        public static String f() {
            return "record_short_hb_count";
        }

        public static String g() {
            return "record_long_hb_count";
        }

        public static String h() {
            return "record_hb_change";
        }

        public static String i() {
            return "record_mobile_ptc";
        }

        public static String j() {
            return "record_wifi_ptc";
        }

        public static String k() {
            return "record_ptc_start";
        }

        public static String l() {
            return "keep_short_hb_effective_time";
        }
    }

    as(Context context) {
        this.f389655l = context;
        this.f389653j = hz.j(context);
        this.f389652i = ah.d(context).m(gk.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f389644a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.e(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.e(), currentTimeMillis).apply();
        }
        long j3 = sharedPreferences.getLong(a.k(), -1L);
        this.f389651h = j3;
        if (j3 == -1) {
            this.f389651h = currentTimeMillis;
            sharedPreferences.edit().putLong(a.k(), currentTimeMillis).apply();
        }
    }

    private boolean A() {
        if (this.f389651h == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f389651h;
        if (j3 <= currentTimeMillis && currentTimeMillis - j3 < 259200000) {
            return false;
        }
        return true;
    }

    private void B() {
        int i3;
        boolean z16;
        String[] split;
        String[] split2;
        if (s()) {
            String string = this.f389644a.getString(a.h(), null);
            char c16 = 1;
            char c17 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i16 = 0;
                while (i16 < split.length) {
                    if (!TextUtils.isEmpty(split[i16]) && (split2 = split[i16].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c17];
                        String str2 = split2[c16];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put("model", ia.a());
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put(WidgetCacheConstellationData.INTERVAL, str3);
                        hashMap.put("timestamp", str4);
                        h("category_hb_change", null, hashMap);
                        jz4.c.m("[HB] report hb changed events.");
                    }
                    i16++;
                    c16 = 1;
                    c17 = 0;
                }
                this.f389644a.edit().remove(a.h()).apply();
            }
            if (this.f389644a.getBoolean(a.a(), false)) {
                long j3 = this.f389644a.getLong(a.c(), 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j3 > 1296000000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
                    hashMap2.put("model", ia.a());
                    hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    h("category_hb_change", null, hashMap2);
                    jz4.c.m("[HB] report support wifi digest events.");
                    this.f389644a.edit().putLong(a.c(), currentTimeMillis).apply();
                }
            }
            if (y()) {
                int i17 = this.f389644a.getInt(a.f(), 0);
                int i18 = this.f389644a.getInt(a.g(), 0);
                if (i17 > 0 || i18 > 0) {
                    long j16 = this.f389644a.getLong(a.e(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j16);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(WidgetCacheConstellationData.INTERVAL, valueOf);
                        jSONObject.put("c_short", String.valueOf(i17));
                        jSONObject.put("c_long", String.valueOf(i18));
                        jSONObject.put("count", String.valueOf(i17 + i18));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        h("category_hb_count", jSONObject2, hashMap3);
                        jz4.c.m("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f389644a.edit().putInt(a.f(), 0).putInt(a.g(), 0).putLong(a.e(), System.currentTimeMillis()).apply();
            }
            if (A()) {
                String valueOf4 = String.valueOf(this.f389651h);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i19 = this.f389644a.getInt(a.i(), 0);
                if (i19 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i19);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        h("category_lc_ptc", jSONObject4, hashMap4);
                        jz4.c.m("[HB] report ping timeout count events of mobile network.");
                        this.f389644a.edit().putInt(a.i(), 0).apply();
                    } catch (Throwable unused2) {
                        i3 = 0;
                        this.f389644a.edit().putInt(a.i(), 0).apply();
                    }
                }
                i3 = 0;
                int i26 = this.f389644a.getInt(a.j(), i3);
                if (i26 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i26);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        h("category_lc_ptc", jSONObject6, hashMap5);
                        jz4.c.m("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f389644a.edit().putInt(a.j(), 0).apply();
                }
                this.f389651h = System.currentTimeMillis();
                this.f389644a.edit().putLong(a.k(), this.f389651h).apply();
            }
        }
    }

    private boolean C() {
        return ah.d(this.f389655l).m(gk.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }

    private int a() {
        if (TextUtils.isEmpty(this.f389646c)) {
            return -1;
        }
        try {
            return this.f389644a.getInt(a.b(this.f389646c), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static as c(Context context) {
        if (f389643o == null) {
            synchronized (as.class) {
                if (f389643o == null) {
                    f389643o = new as(context);
                }
            }
        }
        return f389643o;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(String str, String str2, Map<String, String> map) {
        String str3;
        fs a16;
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c("hb_name");
        gjVar.a("hb_channel");
        gjVar.a(1L);
        gjVar.b(str2);
        gjVar.a(false);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(this.f389655l.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        au b16 = av.b(this.f389655l);
        if (b16 != null && !TextUtils.isEmpty(b16.f389664a)) {
            String[] split = b16.f389664a.split("@");
            if (split.length > 0) {
                str3 = split[0];
                map.put("uuid", str3);
                map.put("model", ia.a());
                Context context = this.f389655l;
                map.put("avc", String.valueOf(com.xiaomi.push.g.b(context, context.getPackageName())));
                map.put("pvc", String.valueOf(50909));
                map.put("cvc", String.valueOf(48));
                gjVar.a(map);
                a16 = fs.a(this.f389655l);
                if (a16 == null) {
                    a16.e(gjVar, this.f389655l.getPackageName());
                    return;
                }
                return;
            }
        }
        str3 = null;
        map.put("uuid", str3);
        map.put("model", ia.a());
        Context context2 = this.f389655l;
        map.put("avc", String.valueOf(com.xiaomi.push.g.b(context2, context2.getPackageName())));
        map.put("pvc", String.valueOf(50909));
        map.put("cvc", String.valueOf(48));
        gjVar.a(map);
        a16 = fs.a(this.f389655l);
        if (a16 == null) {
        }
    }

    private void i(boolean z16) {
        AtomicInteger atomicInteger;
        Object obj;
        String g16;
        if (!s()) {
            return;
        }
        if (z16) {
            atomicInteger = this.f389649f;
        } else {
            atomicInteger = this.f389650g;
        }
        int incrementAndGet = atomicInteger.incrementAndGet();
        Object[] objArr = new Object[2];
        String str = Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
        if (z16) {
            obj = Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
        } else {
            obj = PoiListCacheRecord.TIMESTAMP_TYPE;
        }
        objArr[0] = obj;
        objArr[1] = Integer.valueOf(incrementAndGet);
        jz4.c.w(String.format("[HB] %s ping interval count: %s", objArr));
        if (incrementAndGet >= 5) {
            if (z16) {
                g16 = a.f();
            } else {
                g16 = a.g();
            }
            int i3 = this.f389644a.getInt(g16, 0) + incrementAndGet;
            this.f389644a.edit().putInt(g16, i3).apply();
            Object[] objArr2 = new Object[2];
            if (!z16) {
                str = PoiListCacheRecord.TIMESTAMP_TYPE;
            }
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(i3);
            jz4.c.m(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
            if (z16) {
                this.f389649f.set(0);
            } else {
                this.f389650g.set(0);
            }
        }
    }

    private boolean j() {
        if (this.f389645b.get() >= Math.max(ah.d(this.f389655l).a(gk.IntelligentHeartbeatNATCountInt.a(), 3), 3)) {
            return true;
        }
        return false;
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("W-") && !str.startsWith("M-")) {
            return false;
        }
        return true;
    }

    private void n(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f389646c;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.f389657n) {
                    this.f389646c = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f389646c = null;
                }
            }
        } else {
            this.f389646c = str;
        }
        int i3 = this.f389644a.getInt(a.b(this.f389646c), -1);
        long j3 = this.f389644a.getLong(a.d(this.f389646c), -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != -1) {
            if (j3 == -1) {
                this.f389644a.edit().putLong(a.d(this.f389646c), currentTimeMillis + t()).apply();
            } else if (currentTimeMillis > j3) {
                this.f389644a.edit().remove(a.b(this.f389646c)).remove(a.d(this.f389646c)).apply();
            }
        }
        this.f389645b.getAndSet(0);
        if (!TextUtils.isEmpty(this.f389646c) && a() == -1) {
            this.f389647d = true;
        } else {
            this.f389647d = false;
        }
        jz4.c.m(String.format("[HB] network changed, netid:%s, %s", this.f389646c, Boolean.valueOf(this.f389647d)));
    }

    private boolean o() {
        if (!TextUtils.isEmpty(this.f389646c)) {
            if (this.f389646c.startsWith("M-")) {
                if (!ah.d(this.f389655l).m(gk.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (this.f389646c.equals("W-NETWORK_ID_WIFI_DEFAULT") && !C()) {
                return true;
            }
        }
        return false;
    }

    private long p() {
        return this.f389644a.getLong(a.l(), -1L);
    }

    private void r(String str) {
        if (!k(str)) {
            return;
        }
        this.f389644a.edit().putInt(a.b(str), 235000).apply();
        this.f389644a.edit().putLong(a.d(this.f389646c), System.currentTimeMillis() + t()).apply();
    }

    private boolean s() {
        boolean m3 = ah.d(this.f389655l).m(gk.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true);
        if (w() && m3 && com.xiaomi.push.n.China.name().equals(ag.a(this.f389655l).b())) {
            return true;
        }
        return false;
    }

    private long t() {
        return ah.d(this.f389655l).c(gk.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    private void v(String str) {
        String str2;
        String str3;
        if (!s() || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("W-")) {
            str2 = "W";
        } else if (str.startsWith("M-")) {
            str2 = "M";
        } else {
            return;
        }
        String valueOf = String.valueOf(235000);
        String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(":::");
        sb5.append(str2);
        sb5.append(":::");
        sb5.append(valueOf);
        sb5.append(":::");
        sb5.append(valueOf2);
        String string = this.f389644a.getString(a.h(), null);
        if (TextUtils.isEmpty(string)) {
            str3 = sb5.toString();
        } else {
            str3 = string + "###" + sb5.toString();
        }
        this.f389644a.edit().putString(a.h(), str3).apply();
    }

    private boolean w() {
        boolean z16;
        if (p() >= System.currentTimeMillis()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f389653j && (this.f389652i || this.f389657n || z16)) {
            return true;
        }
        return false;
    }

    private void x() {
        if (!this.f389644a.getBoolean(a.a(), false)) {
            this.f389644a.edit().putBoolean(a.a(), true).apply();
        }
    }

    private boolean y() {
        long j3 = this.f389644a.getLong(a.e(), -1L);
        if (j3 == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 <= currentTimeMillis && currentTimeMillis - j3 < 259200000) {
            return false;
        }
        return true;
    }

    private void z() {
        String i3;
        int i16 = this.f389654k;
        if (i16 != 0) {
            if (i16 != 1) {
                i3 = null;
            } else {
                i3 = a.j();
            }
        } else {
            i3 = a.i();
        }
        if (!TextUtils.isEmpty(i3)) {
            if (this.f389644a.getLong(a.k(), -1L) == -1) {
                this.f389651h = System.currentTimeMillis();
                this.f389644a.edit().putLong(a.k(), this.f389651h).apply();
            }
            this.f389644a.edit().putInt(i3, this.f389644a.getInt(i3, 0) + 1).apply();
        }
    }

    public long b() {
        int a16;
        long f16 = ev.f();
        boolean z16 = true;
        if (this.f389653j && !o() && ((ah.d(this.f389655l).m(gk.IntelligentHeartbeatSwitchBoolean.a(), true) || p() >= System.currentTimeMillis()) && (a16 = a()) != -1)) {
            f16 = a16;
        }
        if (!TextUtils.isEmpty(this.f389646c) && !"WIFI-ID-UNKNOWN".equals(this.f389646c) && this.f389654k == 1) {
            if (f16 >= MiniBoxNoticeInfo.MIN_5) {
                z16 = false;
            }
            i(z16);
        }
        this.f389656m = f16;
        jz4.c.m("[HB] ping interval:" + f16);
        return f16;
    }

    public void e(int i3) {
        this.f389644a.edit().putLong(a.l(), System.currentTimeMillis() + (i3 * 1000)).apply();
    }

    public synchronized void f(com.xiaomi.push.x xVar) {
        if (w()) {
            String str = null;
            if (xVar != null) {
                if (xVar.a() == 0) {
                    String h16 = xVar.h();
                    if (!TextUtils.isEmpty(h16) && !"UNKNOWN".equalsIgnoreCase(h16)) {
                        str = "M-" + h16;
                    }
                    n(str);
                    this.f389654k = 0;
                } else {
                    if (xVar.a() != 1 && xVar.a() != 6) {
                        n(null);
                        this.f389654k = -1;
                    }
                    n("WIFI-ID-UNKNOWN");
                    this.f389654k = 1;
                }
            } else {
                n(null);
                this.f389654k = -1;
            }
        }
    }

    public synchronized void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            x();
        }
        if (w() && !TextUtils.isEmpty(str)) {
            n("W-" + str);
        }
    }

    public long l() {
        return this.f389656m;
    }

    public void m() {
        if (w()) {
            z();
            if (this.f389647d && !TextUtils.isEmpty(this.f389646c) && this.f389646c.equals(this.f389648e)) {
                this.f389645b.getAndIncrement();
                jz4.c.m("[HB] ping timeout count:" + this.f389645b);
                if (j()) {
                    jz4.c.m("[HB] change hb interval for net:" + this.f389646c);
                    r(this.f389646c);
                    this.f389647d = false;
                    this.f389645b.getAndSet(0);
                    v(this.f389646c);
                }
            }
        }
    }

    public void q() {
        if (w()) {
            this.f389648e = this.f389646c;
        }
    }

    public void u() {
        if (w()) {
            B();
            if (this.f389647d) {
                this.f389645b.getAndSet(0);
            }
        }
    }

    public void d() {
    }
}
