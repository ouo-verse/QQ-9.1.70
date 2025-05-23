package com.tencent.gamecenter.wadl.sdk.common.d.k.b;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.i;
import com.tencent.gamecenter.wadl.sdk.common.c.b.f;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements Runnable, com.tencent.gamecenter.wadl.sdk.common.d.d {

    /* renamed from: k, reason: collision with root package name */
    private static c f107178k = new c();

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.d.c f107179a;

    /* renamed from: e, reason: collision with root package name */
    private Handler f107183e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f107180b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f107181c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f107182d = false;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, com.tencent.gamecenter.wadl.sdk.common.d.k.b.b> f107184f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private Runnable f107185g = new a();

    /* renamed from: h, reason: collision with root package name */
    private Runnable f107186h = new b();

    /* renamed from: i, reason: collision with root package name */
    private Runnable f107187i = new RunnableC1128c();

    /* renamed from: j, reason: collision with root package name */
    Map<String, d> f107188j = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "delayCheckTask start");
            c.this.f();
            c.this.f107182d = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "checkTask start");
                com.tencent.gamecenter.wadl.sdk.common.b.c.m();
                d a16 = c.this.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int c16 = c.this.c(a16.f107193b);
                long j3 = a16.f107192a;
                if (elapsedRealtime - j3 > c16 || elapsedRealtime < j3) {
                    c.b(2);
                    if (!c.this.f107181c) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "post requestTask");
                        com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().b(c.this.f107187i);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.d.k.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC1128c implements Runnable {
        RunnableC1128c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            String str;
            if (!c.this.f107181c) {
                c.this.f107181c = true;
                try {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "requestTask start");
                    com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.a();
                    Iterator it = c.this.f107184f.values().iterator();
                    while (it.hasNext()) {
                        ((com.tencent.gamecenter.wadl.sdk.common.d.k.b.b) it.next()).a(aVar);
                    }
                    byte[] a16 = aVar.a();
                    if (!g.a(a16)) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "HttpPlatform request:" + new String(a16));
                        f c16 = com.tencent.gamecenter.wadl.sdk.common.c.b.d.a("https://yun-hl.3g.qq.com/halleycloud", false, null, a16, 15000, g.a(), false).c();
                        i3 = c16.f107097a;
                        try {
                            com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "HttpPlatform rspCode:" + i3 + ",httpStatus:" + c16.f107099c);
                            if (c16.f107097a == 0 && c16.f107099c == 200) {
                                if (!g.a(c16.f107100d)) {
                                    try {
                                        str = new String(c16.f107100d);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        str = "";
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject(str);
                                        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "HttpPlatform rspData:" + str);
                                        com.tencent.gamecenter.wadl.sdk.common.b.c.m();
                                        Iterator it5 = c.this.f107184f.values().iterator();
                                        while (it5.hasNext()) {
                                            ((com.tencent.gamecenter.wadl.sdk.common.d.k.b.b) it5.next()).a(jSONObject);
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        th.printStackTrace();
                                        i3 = -321;
                                        c16.f107098b = g.d("yun-hl.3g.qq.com") + "/" + str.substring(0, Math.min(str.length(), 20));
                                        return;
                                    }
                                } else {
                                    i3 = -320;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            try {
                                th.printStackTrace();
                                return;
                            } finally {
                                d a17 = c.this.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b());
                                a17.f107192a = SystemClock.elapsedRealtime();
                                a17.f107193b = i3;
                                c.this.h();
                                c.this.f107181c = false;
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    i3 = 0;
                }
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpPlatformConnection", "isRequesting, just ignore..");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public long f107192a;

        /* renamed from: b, reason: collision with root package name */
        public int f107193b;

        d(c cVar) {
        }

        /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    c() {
    }

    static /* synthetic */ int b(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i3) {
        String str;
        int i16;
        if (i3 == 0) {
            str = "http_platform_update_interval_succ";
        } else {
            str = (i3 == -4 || i3 == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        }
        if (i3 == 0) {
            i16 = 1800000;
        } else {
            i16 = (i3 == -4 || i3 == -3) ? 60000 : 300000;
        }
        return com.tencent.gamecenter.wadl.sdk.common.b.g.a(str, 60000, 43200000, i16);
    }

    public static c d() {
        return f107178k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f107183e.removeCallbacks(this.f107186h);
        this.f107183e.post(this.f107186h);
    }

    private void g() {
        if (this.f107182d) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpPlatformConnection", "timer is on , not do delay check..");
            return;
        }
        this.f107182d = true;
        int nextInt = (new Random().nextInt(com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60 * 1000) + 1000;
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpPlatformConnection", "check with delay PlatformInterval:" + nextInt);
        i.a().a(this.f107185g, (long) nextInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f107188j.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, d> entry : this.f107188j.entrySet()) {
                d value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("lastCode", value.f107193b);
                    jSONObject2.put("lastReqTime", value.f107192a);
                    jSONObject.put(entry.getKey(), jSONObject2);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            com.tencent.gamecenter.wadl.sdk.common.d.i.b("apnrecords", jSONObject.toString(), true);
        }
    }

    public com.tencent.gamecenter.wadl.sdk.common.d.c e() {
        return this.f107179a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.tencent.gamecenter.wadl.sdk.common.b.g.a("http_platform_start_update_on", 0, 1, 1) == 1) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpPlatformConnection", "update on start");
            f();
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpPlatformConnection", "not update on start");
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void b() {
        this.f107184f.get("accessscheduler").b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(String str) {
        JSONObject optJSONObject;
        a aVar = null;
        if (this.f107188j.isEmpty()) {
            try {
                String a16 = com.tencent.gamecenter.wadl.sdk.common.d.i.a("apnrecords", "", true);
                if (!a16.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(a16);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2) && (optJSONObject = jSONObject.optJSONObject(str2)) != null) {
                            d dVar = new d(this, aVar);
                            dVar.f107193b = optJSONObject.optInt("lastCode");
                            dVar.f107192a = optJSONObject.optLong("lastReqTime");
                            this.f107188j.put(str2, dVar);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        d dVar2 = this.f107188j.get(str);
        if (dVar2 != null) {
            return dVar2;
        }
        d dVar3 = new d(this, aVar);
        this.f107188j.put(str, dVar3);
        return dVar3;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void c() {
        this.f107184f.get(QCircleDaTongConstant.ElementParamValue.SETTINGS).c();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.d
    public void a() {
        if (this.f107180b) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpPlatformConnection", "already started");
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpPlatformConnection", "startPlatform");
            Handler g16 = com.tencent.gamecenter.wadl.sdk.common.a.g();
            this.f107183e = g16;
            g16.post(this);
        }
        this.f107179a.d();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void a(int i3) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-HttpPlatformConnection", "onHttpUsed:" + i3);
        if (i3 == 1) {
            f();
        } else if (i3 == 2) {
            g();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.d
    public void a(com.tencent.gamecenter.wadl.sdk.common.d.c cVar) {
        this.f107179a = cVar;
        a(new com.tencent.gamecenter.wadl.sdk.common.d.k.b.h.a());
        a(new com.tencent.gamecenter.wadl.sdk.common.d.k.b.f.b());
        a(new com.tencent.gamecenter.wadl.sdk.common.d.k.b.g.a());
        a(new com.tencent.gamecenter.wadl.sdk.common.d.k.b.d.a());
    }

    private void a(com.tencent.gamecenter.wadl.sdk.common.d.k.b.b bVar) {
        this.f107184f.put(bVar.d(), bVar);
    }
}
