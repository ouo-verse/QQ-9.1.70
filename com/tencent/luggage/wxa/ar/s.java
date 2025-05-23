package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebView;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s {

    /* renamed from: j, reason: collision with root package name */
    public static List f121770j = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f121771a;

    /* renamed from: b, reason: collision with root package name */
    public String f121772b;

    /* renamed from: c, reason: collision with root package name */
    public String f121773c;

    /* renamed from: d, reason: collision with root package name */
    public String f121774d;

    /* renamed from: e, reason: collision with root package name */
    public long f121775e;

    /* renamed from: f, reason: collision with root package name */
    public long f121776f;

    /* renamed from: g, reason: collision with root package name */
    public long f121777g;

    /* renamed from: h, reason: collision with root package name */
    public String f121778h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f121779i = false;

    public s(String str, WebView.WebViewKind webViewKind) {
        SharedPreferences d16 = d(str, webViewKind);
        this.f121771a = d16;
        if (d16 == null) {
            x0.f("CrashWatchDog", "scene:" + str + ", kind:" + webViewKind + ", invalid shared preference");
            return;
        }
        this.f121772b = "INIT_START_TIME" + str;
        this.f121773c = "INIT_END_TIME" + str;
        this.f121774d = "INIT_TRY_COUNT" + str;
        this.f121778h = str;
        this.f121775e = this.f121771a.getLong(this.f121772b, 0L);
        this.f121776f = this.f121771a.getLong(this.f121773c, 0L);
        this.f121777g = this.f121771a.getLong(this.f121774d, 0L);
        x0.d("CrashWatchDog", "scene:" + str + ", startTime:" + a(this.f121775e) + ", endTime:" + a(this.f121776f) + ", count:" + this.f121777g);
    }

    public static synchronized s a(String str, WebView.WebViewKind webViewKind, String str2) {
        s b16;
        synchronized (s.class) {
            b16 = b(str + "_" + str2, webViewKind);
        }
        return b16;
    }

    public static synchronized s b(String str, WebView.WebViewKind webViewKind) {
        s sVar;
        synchronized (s.class) {
            sVar = new s(str, webViewKind);
        }
        return sVar;
    }

    public static synchronized s c(String str, WebView.WebViewKind webViewKind) {
        s a16;
        synchronized (s.class) {
            a16 = a(str, webViewKind, WebView.getModuleName());
        }
        return a16;
    }

    public static synchronized SharedPreferences d(String str, WebView.WebViewKind webViewKind) {
        synchronized (s.class) {
            if (webViewKind != WebView.WebViewKind.WV_KIND_PINUS) {
                return null;
            }
            return y0.d(a(str, webViewKind));
        }
    }

    public final synchronized boolean e() {
        if (this.f121771a == null) {
            x0.f("CrashWatchDog", "hasRecentCrashInternal, invalid shared preference");
            return false;
        }
        if (!b(new Date().getTime())) {
            x0.d("CrashWatchDog", "hasRecentCrashInternal, startButNoEnd returns false");
            return false;
        }
        if (this.f121777g > c()) {
            x0.a("CrashWatchDog", "scene:" + this.f121778h + ", crashedTime:" + a(this.f121775e) + ", count:" + this.f121777g);
            return true;
        }
        x0.d("CrashWatchDog", "hasRecentCrashInternal, return false, count:" + this.f121777g);
        return false;
    }

    public synchronized void f() {
        if (this.f121771a == null) {
            x0.f("CrashWatchDog", "logFinished, invalid shared preference");
            return;
        }
        long time = new Date().getTime();
        x0.d("CrashWatchDog", "logFinished, endTime:" + a(time));
        SharedPreferences.Editor edit = this.f121771a.edit();
        edit.putLong(this.f121773c, time);
        edit.putLong(this.f121774d, 0L);
        edit.commit();
        this.f121771a = null;
    }

    public synchronized void g() {
        SharedPreferences sharedPreferences = this.f121771a;
        if (sharedPreferences == null) {
            x0.f("CrashWatchDog", "logStart, invalid shared preference");
            return;
        }
        if (this.f121779i) {
            x0.f("CrashWatchDog", "logStart, already start");
            return;
        }
        this.f121779i = true;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j3 = this.f121777g + 1;
        edit.putLong(this.f121774d, j3);
        long time = new Date().getTime();
        if (b(time)) {
            x0.d("CrashWatchDog", "logStart, startButNoEnd returns true, currentTime:" + a(time) + ", count:" + j3);
            edit.commit();
            return;
        }
        x0.d("CrashWatchDog", "logStart, startTime:" + a(time) + ", count:" + j3);
        edit.putLong(this.f121772b, time);
        edit.commit();
    }

    public final synchronized boolean b(long j3) {
        x0.d("CrashWatchDog", "startButNoEnd, startTime:" + a(this.f121775e) + ", endTime:" + a(this.f121776f) + ", currentTime:" + a(j3));
        long j16 = this.f121775e;
        if (0 == j16) {
            return false;
        }
        if (this.f121776f - j16 < 0 && Math.abs(j3 - j16) <= d()) {
            return this.f121776f < this.f121775e;
        }
        return false;
    }

    public final int c() {
        return CommandCfg.getInstance().getCmdAsInt("crash_watch_count", WebView.getModuleName(), 4);
    }

    public static synchronized boolean a(WebView.WebViewKind webViewKind, String str) {
        synchronized (s.class) {
            if (WebDebugCfg.getInst().getIgnoreCrashWatch()) {
                return false;
            }
            if (a("LOAD_CORE", webViewKind, str).e()) {
                x0.d("CrashWatchDog", "hasRecentCrash, SCENE_LOAD_CORE, module:" + str + ", kind:" + webViewKind);
                n0.a(webViewKind, o0.f121757b);
                return true;
            }
            if (!a("CREATE_WEBVIEW", webViewKind, str).e()) {
                return false;
            }
            x0.d("CrashWatchDog", "hasRecentCrash, SCENE_CREATE_WEBVIEW, module:" + str + ", kind:" + webViewKind);
            n0.a(webViewKind, o0.f121758c);
            return true;
        }
    }

    public final int d() {
        return CommandCfg.getInstance().getCmdAsInt("crash_watch_time", WebView.getModuleName(), 180) * 60 * 1000;
    }

    public static synchronized List b() {
        LinkedList linkedList;
        synchronized (s.class) {
            linkedList = new LinkedList(f121770j);
        }
        return linkedList;
    }

    public static synchronized boolean a(WebView.WebViewKind webViewKind) {
        synchronized (s.class) {
            if (WebDebugCfg.getInst().getIgnoreCrashWatch()) {
                return false;
            }
            if (c("LOAD_CORE", webViewKind).e()) {
                x0.d("CrashWatchDog", "hasRecentCrash, SCENE_LOAD_CORE, module:" + WebView.getModuleName() + ", kind:" + webViewKind);
                n0.a(webViewKind, o0.f121757b);
                return true;
            }
            if (!c("CREATE_WEBVIEW", webViewKind).e()) {
                return false;
            }
            x0.d("CrashWatchDog", "hasRecentCrash, SCENE_CREATE_WEBVIEW, module:" + WebView.getModuleName() + ", kind:" + webViewKind);
            n0.a(webViewKind, o0.f121758c);
            return true;
        }
    }

    public static synchronized void a(String str) {
        synchronized (s.class) {
            if (f121770j.size() > 5) {
                f121770j.remove(0);
            }
            f121770j.add(str);
        }
    }

    public static synchronized void a() {
        synchronized (s.class) {
            f121770j.clear();
        }
    }

    public static String a(String str, WebView.WebViewKind webViewKind) {
        return "INIT_SP_TAG_" + webViewKind.toString() + "_" + str;
    }

    public final String a(long j3) {
        return j3 <= 0 ? "0" : new Date(j3).toLocaleString();
    }
}
