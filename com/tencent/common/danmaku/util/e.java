package com.tencent.common.danmaku.util;

import android.os.Trace;
import com.tencent.common.danmaku.inject.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static l.a f99818a;

    /* renamed from: b, reason: collision with root package name */
    public static int f99819b;

    /* renamed from: c, reason: collision with root package name */
    private static final StringBuilder f99820c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99819b = 2;
            f99820c = new StringBuilder();
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b(String str, Object... objArr) {
        if (f99819b >= 4 && f99818a != null) {
            a("logger d");
            f99820c.setLength(0);
            for (Object obj : objArr) {
                f99820c.append(obj);
            }
            f99818a.d(str, f99820c.toString());
            d();
        }
    }

    public static void c(String str, Object... objArr) {
        if (f99819b >= 1 && f99818a != null) {
            a("logger e");
            f99820c.setLength(0);
            for (Object obj : objArr) {
                f99820c.append(obj);
            }
            f99818a.e(str, f99820c.toString());
            d();
        }
    }

    public static void d() {
        Trace.endSection();
    }

    public static void e(String str, Object... objArr) {
        if (f99819b >= 3 && f99818a != null) {
            a("logger i");
            f99820c.setLength(0);
            for (Object obj : objArr) {
                f99820c.append(obj);
            }
            f99818a.i(str, f99820c.toString());
            d();
        }
    }

    public static void f(l.a aVar) {
        int i3;
        f99818a = aVar;
        if (com.tencent.common.danmaku.a.b() != null) {
            if (com.tencent.common.danmaku.a.b().a().isDebug()) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            f99819b = i3;
        }
    }

    public static void g(String str, Object... objArr) {
        if (f99819b >= 5 && f99818a != null) {
            a("logger v");
            f99820c.setLength(0);
            for (Object obj : objArr) {
                f99820c.append(obj);
            }
            f99818a.v(str, f99820c.toString());
            d();
        }
    }
}
