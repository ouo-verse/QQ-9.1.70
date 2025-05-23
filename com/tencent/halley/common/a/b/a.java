package com.tencent.halley.common.a.b;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.halley.common.a.c;
import com.tencent.halley.common.a.g;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.a.k;
import com.tencent.halley.common.d.i;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f113217a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f113217a = com.tencent.halley.common.a.h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0060 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:51:0x0019, B:55:0x0040, B:8:0x0068, B:11:0x0099, B:13:0x009f, B:14:0x00c4, B:16:0x00ca, B:17:0x00d7, B:19:0x00dd, B:21:0x00ec, B:22:0x00f1, B:24:0x0159, B:25:0x015f, B:27:0x017f, B:28:0x0185, B:31:0x0191, B:32:0x0194, B:34:0x01ad, B:36:0x01b3, B:39:0x01bd, B:49:0x0060, B:56:0x0023, B:58:0x002c, B:59:0x0034), top: B:50:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void a(String str, int i3, int i16, String str2, Map map, Map map2, boolean z16, int i17) {
        int i18;
        String concat;
        int a16;
        boolean a17;
        Map map3 = map;
        if (z16) {
            try {
                if (c.n()) {
                    i18 = -288;
                } else {
                    c.e();
                    if (c.j()) {
                        i18 = !g.a() ? -3 : i16;
                    } else {
                        d.d("halley-cloud-EventReportExecutor", "fix code NoNetwork");
                        i18 = -4;
                    }
                }
                if (i18 == -3) {
                    concat = "ping failed, ".concat(String.valueOf(str2));
                    d.d("halley-cloud-EventReportExecutor", "fix code PingFail");
                    boolean z17 = true;
                    if (i17 <= 0) {
                        a16 = i17;
                        a17 = true;
                    } else {
                        a16 = b.a(str, i3, i18, (Map<String, String>) map3);
                        a17 = b.a(a16);
                    }
                    d.a("halley-cloud-EventReportExecutor", "getEventDenominator: " + a16 + "," + str + "," + i3 + "," + i18 + ",canReport:" + a17);
                    if (a17) {
                        return;
                    }
                    if (map2 != null) {
                        if (map2.containsKey("B44")) {
                            map2.put("B44", j.b((String) map2.get("B44")));
                            d.b("halley-cloud-EventReportExecutor", "httpBizUrl:" + ((String) map2.get("B44")));
                        }
                        if (map2.containsKey("B49")) {
                            map2.put("B49", j.b((String) map2.get("B49")));
                        }
                        if (map2.containsKey("B47")) {
                            map2.put("B47", j.b((String) map2.get("B47")));
                        }
                    }
                    if (map3 == null) {
                        map3 = new HashMap();
                    }
                    map3.put("B31", String.valueOf(a16));
                    map3.put("B7", String.valueOf(i18));
                    map3.put("B1", com.tencent.halley.common.a.e());
                    map3.put("B2", com.tencent.halley.common.a.f113173b);
                    map3.put("B30", com.tencent.halley.common.a.d());
                    map3.put("B3", String.valueOf(i3));
                    String g16 = com.tencent.halley.common.a.g();
                    if (!TextUtils.isEmpty(g16)) {
                        map3.put("B4", g16);
                    }
                    map3.put("B5", i.a());
                    String c16 = c.c();
                    if (!TextUtils.isEmpty(c16)) {
                        map3.put("B29", c16);
                    }
                    if (h.a("access_report_detail", 0, 1, 1) == 1) {
                        if (map2 != null) {
                            map3.putAll(map2);
                        }
                        map3.put("B6", c.b());
                        if (i18 != -4 && !TextUtils.isEmpty(concat)) {
                            map3.put("B8", concat);
                        }
                    }
                    if (i18 != 0) {
                        z17 = false;
                    }
                    d.c("halley-cloud-EventReportExecutor", "report:" + k.a(str, z17, map3, false) + ",event:" + str + ",reportMap:" + map3);
                    return;
                }
            } catch (Throwable th5) {
                d.b("halley-cloud-EventReportExecutor", "doReport err", th5);
                return;
            }
        } else {
            i18 = i16;
        }
        concat = str2;
        boolean z172 = true;
        if (i17 <= 0) {
        }
        d.a("halley-cloud-EventReportExecutor", "getEventDenominator: " + a16 + "," + str + "," + i3 + "," + i18 + ",canReport:" + a17);
        if (a17) {
        }
    }

    public static void b(String str, int i3, int i16, String str2, Map<String, String> map, Map<String, String> map2, boolean z16) {
        d.c("halley-cloud-EventReportExecutor", "report " + str + ",appId:" + i3 + ",errorCode:" + i16);
        f113217a.post(new Runnable(str, i3, i16, str2, map, map2, z16) { // from class: com.tencent.halley.common.a.b.a.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f113234a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f113235b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f113236c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f113237d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Map f113238e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Map f113239f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f113240g;

            {
                this.f113234a = str;
                this.f113235b = i3;
                this.f113236c = i16;
                this.f113237d = str2;
                this.f113238e = map;
                this.f113239f = map2;
                this.f113240g = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, map, map2, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    a.a(this.f113234a, this.f113235b, this.f113236c, this.f113237d, this.f113238e, this.f113239f, this.f113240g, 0);
                }
            }
        });
    }

    public static boolean a(String str, int i3, int i16, String str2, Map<String, String> map, Map<String, String> map2, boolean z16) {
        boolean a16 = b.a(1);
        d.c("halley-cloud-EventReportExecutor", "EventName:" + str + " denominator:1 canReport:" + a16);
        if (a16) {
            f113217a.post(new Runnable(str, i3, i16, str2, map, map2, z16) { // from class: com.tencent.halley.common.a.b.a.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f113226a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f113227b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ int f113228c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f113229d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f113230e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Map f113231f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ boolean f113232g;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f113233h = 1;

                {
                    this.f113226a = str;
                    this.f113227b = i3;
                    this.f113228c = i16;
                    this.f113229d = str2;
                    this.f113230e = map;
                    this.f113231f = map2;
                    this.f113232g = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, map, map2, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        a.a(this.f113226a, this.f113227b, this.f113228c, this.f113229d, this.f113230e, this.f113231f, this.f113232g, this.f113233h);
                    }
                }
            });
        }
        return a16;
    }
}
