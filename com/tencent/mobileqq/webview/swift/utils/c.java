package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f314739a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f314740b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayMap<String, Long> f314741c;

    /* renamed from: d, reason: collision with root package name */
    private static String f314742d;

    /* renamed from: e, reason: collision with root package name */
    private static int f314743e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f314739a = 0;
        f314740b = null;
        f314741c = null;
        f314742d = "";
        f314743e = -1;
    }

    public static void a(Intent intent, String str, String str2) {
        if (intent != null && f314743e == 1 && intent.getBooleanExtra("aio_open_web", false)) {
            f314740b.put(str, str2);
        }
    }

    public static void b(Intent intent) {
        long j3;
        long j16;
        if (intent == null || !intent.getBooleanExtra("aio_open_web", false)) {
            return;
        }
        intent.removeExtra("aio_open_web");
        HashMap<String, String> hashMap = f314740b;
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("from"))) {
            String str = f314740b.get("safe_check");
            String str2 = f314740b.get("short_link");
            try {
                j3 = Long.parseLong(str);
            } catch (Exception unused) {
                j3 = 0;
            }
            try {
                j16 = Long.parseLong(str2);
            } catch (Exception unused2) {
                j16 = 0;
            }
            if (j3 == 0) {
                f314740b.put("has_safecheck", "2");
            } else {
                f314740b.put("has_safecheck", "1");
            }
            if (j16 == 0) {
                f314740b.put("has_short_link", "2");
            } else {
                f314740b.put("has_short_link", "1");
            }
            ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance(null, "AIOWeb", false, 0L, 0L, f314740b, "", false);
            f314743e = -1;
            com.tencent.mobileqq.webview.util.t m3 = com.tencent.mobileqq.webview.util.t.m("busi_preload_");
            long longValue = ((Long) m3.b("aio_preload_qweb_last", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (longValue == 0) {
                m3.d("aio_preload_qweb_last", Long.valueOf(currentTimeMillis)).a();
            } else if (currentTimeMillis - longValue > 86400000) {
                int intValue = ((Integer) m3.b("aio_preload_qweb_cout", 0)).intValue();
                int intValue2 = ((Integer) m3.b("aio_hit_count", 0)).intValue();
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("hit_count", intValue2 + "");
                hashMap2.put("preload_count", intValue + "");
                ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance(null, "AIOWebPreloadhit", false, 0L, 0L, hashMap2, "", false);
                m3.d("aio_preload_qweb_cout", 0).d("aio_preload_qweb_last", Long.valueOf(currentTimeMillis)).d("aio_hit_count", 0).a();
            }
            f314740b.clear();
            f314741c.clear();
        }
    }

    private static void c(Intent intent, String str) {
        if (intent != null && str != null) {
            if (str.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080")) || str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
                f314742d = str;
                n(intent, null, "safe_check");
            }
        }
    }

    private static void d(Intent intent, String str) {
        if (str != null && j(str)) {
            n(intent, null, "short_link");
        }
    }

    public static void e(Intent intent, String str) {
        if (intent != null && f314743e == 1 && intent.getBooleanExtra("aio_open_web", false)) {
            if (!str.startsWith("http:") && !str.startsWith("https:")) {
                return;
            }
            n(intent, "activity_to_webview", null);
            c(intent, str);
            d(intent, str);
            n(intent, null, "wb_c");
        }
    }

    private static void f(Intent intent, String str) {
        if (intent != null && str != null) {
            String str2 = f314742d;
            if (str2 != null && str2.contains(URLEncoder.encode(str))) {
                n(intent, "safe_check", null);
            }
            f314742d = "";
        }
    }

    private static void g(Intent intent, String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith("http:") || str.startsWith("https:")) {
            n(intent, "short_link", null);
        }
    }

    public static void h(Intent intent, String str) {
        if (intent != null && f314743e == 1 && intent.getBooleanExtra("aio_open_web", false)) {
            f(intent, str);
            g(intent, str);
        }
    }

    public static void i(Intent intent) {
        boolean z16;
        boolean z17;
        String str;
        int i3;
        f314739a++;
        if (intent == null || !intent.getBooleanExtra("aio_open_web", false)) {
            return;
        }
        long longExtra = intent.getLongExtra("from_aio_time", -1L);
        HashMap<String, String> hashMap = f314740b;
        if (hashMap != null && hashMap.size() <= 25) {
            f314740b.clear();
        } else {
            f314740b = new HashMap<>();
        }
        ArrayMap<String, Long> arrayMap = f314741c;
        if (arrayMap != null && arrayMap.size() <= 25) {
            f314741c.clear();
        } else {
            f314741c = new ArrayMap<>();
        }
        if (WebProcessReceiver.f313723b == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (f314739a == 1 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        f314743e = 1;
        f314740b.put("from", intent.getIntExtra("from_aio", 1) + "");
        f314740b.put("use_optimization", intent.getIntExtra("from_aio_opt", 2) + "");
        HashMap<String, String> hashMap2 = f314740b;
        String str2 = "1";
        if (f314739a == 1) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap2.put("first_open", str);
        f314740b.put("network_type", com.tencent.mobileqq.webview.util.g.a() + "");
        HashMap<String, String> hashMap3 = f314740b;
        if (!z16) {
            str2 = "2";
        }
        hashMap3.put("has_pp", str2);
        if (z16) {
            i3 = 1;
        } else if (!SwiftBrowserStatistics.f314343h1 && f314739a <= 1) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        f314740b.put("ps_state", i3 + "");
        a(intent, "click_to_activity", (SystemClock.uptimeMillis() - longExtra) + "");
        f314740b.put("open_finished", "2");
        f314741c.put("web_finish", Long.valueOf(longExtra));
        n(intent, "click_to_activity", "activity_to_webview");
        intent.removeExtra("from_aio");
        intent.removeExtra("from_aio_time");
        intent.removeExtra("from_aio_opt");
        if (z17) {
            com.tencent.mobileqq.webview.util.t.m("busi_preload_").d("aio_hit_count", Integer.valueOf(((Integer) com.tencent.mobileqq.webview.util.t.m("busi_preload_").b("aio_hit_count", 0)).intValue() + 1)).a();
        }
    }

    public static final boolean j(String str) {
        if (!str.startsWith("https://url.cn/") && !str.startsWith("http%3A%2F%2Furl.cn%2F")) {
            return false;
        }
        return true;
    }

    public static void k(Intent intent) {
        HashMap<String, String> hashMap;
        String str;
        if (intent != null && intent.getBooleanExtra("aio_open_web", false) && (hashMap = f314740b) != null && (str = hashMap.get("open_finished")) != null && str.equals("2")) {
            n(intent, "web_finish", null);
        }
    }

    public static void l(Intent intent) {
        if (intent != null && f314743e == 1 && intent.getBooleanExtra("aio_open_web", false)) {
            n(intent, "wb_c", null);
            n(intent, "web_finish", null);
            if (f314743e == 1) {
                f314743e = 2;
                f314740b.put("open_finished", "1");
            }
        }
    }

    public static void m(Intent intent, int i3, int i16) {
        intent.putExtra("aio_open_web", true);
        intent.putExtra("from_aio_opt", i16);
        intent.putExtra("from_aio", i3);
        intent.putExtra("from_aio_time", SystemClock.uptimeMillis());
    }

    public static void n(Intent intent, String str, String str2) {
        Long remove;
        if (intent != null && f314743e == 1 && intent.getBooleanExtra("aio_open_web", false)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (str != null && (remove = f314741c.remove(str)) != null) {
                f314740b.put(str, (uptimeMillis - remove.longValue()) + "");
            }
            if (str2 != null) {
                f314741c.put(str2, Long.valueOf(uptimeMillis));
            }
        }
    }
}
