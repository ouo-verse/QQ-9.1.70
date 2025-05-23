package com.tencent.smtt.sdk;

import android.content.Context;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebAccelerator {
    public static final int INIT_TYPE_TBS = 1;
    public static final int INIT_TYPE_X5CORE = 2;

    public static void createCacheWebView(Context context, boolean z16) {
        p a16 = p.a();
        if (z16) {
            a16.a(context);
        }
        if (a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[]{Context.class}, context);
        }
    }

    public static boolean initTbsEnvironment(Context context, int i3) {
        if (context == null) {
            return false;
        }
        if (i3 == 1) {
            g.a(true).a(context, false, false);
        } else if (i3 == 2) {
            p.a().a(context);
        }
        return p.a().b();
    }

    public static void preConnect(Context context, String str, int i3, boolean z16) {
        p a16 = p.a();
        if (z16) {
            a16.a(context);
        }
        if (a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "preConnect", new Class[]{Context.class, String.class, Integer.TYPE}, context, str, Integer.valueOf(i3));
        }
    }

    public static void prefetchResource(Context context, String str, Map<String, String> map, boolean z16) {
        p a16 = p.a();
        if (z16) {
            a16.a(context);
        }
        if (a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[]{Context.class, String.class, Map.class}, context, str, map);
        }
    }

    public static void setWebViewPoolSize(Context context, int i3, boolean z16) {
        p a16 = p.a();
        if (z16) {
            a16.a(context);
        }
        if (a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[]{Context.class, Integer.TYPE}, context, Integer.valueOf(i3));
        }
    }
}
