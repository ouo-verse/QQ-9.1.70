package com.qzone.adapter.feedcomponent;

import android.content.res.Configuration;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.media.image.processor.OvalProcessor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    public static int A = 0;

    /* renamed from: a, reason: collision with root package name */
    public static int f41854a = 400;

    /* renamed from: b, reason: collision with root package name */
    public static int f41855b = 300;

    /* renamed from: c, reason: collision with root package name */
    public static int f41856c = 200;

    /* renamed from: d, reason: collision with root package name */
    public static int f41857d = 150;

    /* renamed from: e, reason: collision with root package name */
    public static int f41858e = com.qzone.proxy.feedcomponent.util.g.a(66.7f);

    /* renamed from: f, reason: collision with root package name */
    public static int f41859f = com.qzone.proxy.feedcomponent.util.g.a(50.0f);

    /* renamed from: g, reason: collision with root package name */
    public static int f41860g = com.qzone.proxy.feedcomponent.util.g.a(24.0f);

    /* renamed from: h, reason: collision with root package name */
    public static int f41861h;

    /* renamed from: i, reason: collision with root package name */
    public static int f41862i;

    /* renamed from: j, reason: collision with root package name */
    private static int f41863j;

    /* renamed from: k, reason: collision with root package name */
    public static int f41864k;

    /* renamed from: l, reason: collision with root package name */
    private static int f41865l;

    /* renamed from: m, reason: collision with root package name */
    private static int f41866m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f41867n;

    /* renamed from: o, reason: collision with root package name */
    public static final OvalProcessor f41868o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f41869p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f41870q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f41871r;

    /* renamed from: s, reason: collision with root package name */
    public static final int f41872s;

    /* renamed from: t, reason: collision with root package name */
    public static final int f41873t;

    /* renamed from: u, reason: collision with root package name */
    private static int f41874u;

    /* renamed from: v, reason: collision with root package name */
    public static int f41875v;

    /* renamed from: w, reason: collision with root package name */
    public static int f41876w;

    /* renamed from: x, reason: collision with root package name */
    public static int f41877x;

    /* renamed from: y, reason: collision with root package name */
    public static int f41878y;

    /* renamed from: z, reason: collision with root package name */
    public static int f41879z;

    public static int a() {
        return f41865l;
    }

    public static int b() {
        return f41874u;
    }

    public static int c() {
        return f41866m;
    }

    public static void d(Configuration configuration) {
        if (f41863j != FeedGlobalEnv.g().getScreenWidth()) {
            int screenWidth = FeedGlobalEnv.g().getScreenWidth();
            f41863j = screenWidth;
            int i3 = f41864k;
            f41865l = screenWidth - (i3 * 2);
            f41866m = screenWidth - (i3 * 2);
            f41874u = ((screenWidth - com.qzone.proxy.feedcomponent.util.g.a(58.0f)) - com.qzone.proxy.feedcomponent.util.g.a(10.0f)) / 3;
        }
    }

    static {
        f41861h = 8;
        f41862i = -1;
        int screenWidth = FeedGlobalEnv.g().getScreenWidth();
        f41861h = 8;
        if (screenWidth < 640) {
            f41861h = 7;
        }
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(40.0f);
        int a17 = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
        int a18 = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
        int i3 = (screenWidth - a16) - a17;
        int i16 = f41861h;
        int i17 = (i3 - ((i16 - 1) * a18)) / i16;
        f41862i = i17;
        if (i17 <= 0) {
            f41862i = -1;
        }
        f41863j = FeedGlobalEnv.g().getScreenWidth();
        int a19 = com.qzone.proxy.feedcomponent.util.g.a(8.0f);
        f41864k = a19;
        int i18 = f41863j;
        f41865l = i18 - (a19 * 2);
        f41866m = i18 - (a19 * 2);
        f41867n = com.qzone.proxy.feedcomponent.util.g.a(37.0f);
        f41868o = new OvalProcessor();
        f41869p = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
        f41870q = com.qzone.proxy.feedcomponent.util.g.a(2.0f);
        int a26 = com.qzone.proxy.feedcomponent.util.g.a(77.0f);
        f41871r = a26;
        f41872s = a26;
        f41873t = a26;
        f41874u = ((f41863j - com.qzone.proxy.feedcomponent.util.g.a(58.0f)) - com.qzone.proxy.feedcomponent.util.g.a(10.0f)) / 3;
        f41875v = com.qzone.proxy.feedcomponent.util.g.a(70.0f);
        f41876w = (int) (FeedGlobalEnv.g().getScaledDensity() * 115.0f);
        f41877x = f41863j;
        f41878y = (int) (FeedGlobalEnv.g().getScaledDensity() * 100.0f);
        f41879z = (int) (FeedGlobalEnv.g().getScaledDensity() * 250.0f);
        A = (int) (FeedGlobalEnv.g().getScaledDensity() * 100.0f);
    }
}
