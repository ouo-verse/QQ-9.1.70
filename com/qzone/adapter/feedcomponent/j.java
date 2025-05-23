package com.qzone.adapter.feedcomponent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import cooperation.vip.vipcomponent.util.ZipResDownloadManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    static o f41898a;

    /* renamed from: b, reason: collision with root package name */
    private static int f41899b;

    /* renamed from: c, reason: collision with root package name */
    private static int f41900c;

    /* renamed from: d, reason: collision with root package name */
    private static Drawable f41901d;

    /* renamed from: e, reason: collision with root package name */
    private static Drawable f41902e;

    /* renamed from: f, reason: collision with root package name */
    private static Drawable f41903f;

    /* renamed from: g, reason: collision with root package name */
    private static int f41904g;

    /* renamed from: h, reason: collision with root package name */
    private static int f41905h;

    /* renamed from: i, reason: collision with root package name */
    private static int f41906i;

    /* renamed from: j, reason: collision with root package name */
    private static int f41907j;

    /* renamed from: k, reason: collision with root package name */
    private static int f41908k;

    /* renamed from: l, reason: collision with root package name */
    private static int f41909l;

    /* renamed from: m, reason: collision with root package name */
    private static int f41910m;

    /* renamed from: n, reason: collision with root package name */
    private static int f41911n;

    /* renamed from: o, reason: collision with root package name */
    private static int f41912o;

    /* renamed from: p, reason: collision with root package name */
    private static int f41913p;

    /* renamed from: q, reason: collision with root package name */
    private static int f41914q;

    /* renamed from: r, reason: collision with root package name */
    private static int f41915r;

    /* renamed from: s, reason: collision with root package name */
    private static int f41916s;

    /* renamed from: t, reason: collision with root package name */
    private static Drawable f41917t;

    /* renamed from: u, reason: collision with root package name */
    private static Drawable f41918u;

    /* renamed from: v, reason: collision with root package name */
    private static Drawable f41919v;

    /* renamed from: w, reason: collision with root package name */
    private static HashMap<String, Integer> f41920w;

    public static Drawable A() {
        if (f41918u == null) {
            f41918u = g(405);
        }
        return f41918u;
    }

    public static int B() {
        if (f41915r == 0) {
            f41915r = c(42);
        }
        return f41915r;
    }

    public static int C() {
        if (f41916s == 0) {
            f41916s = c(43);
        }
        return f41916s;
    }

    public static String D(String str) {
        return (TextUtils.isEmpty(str) || !i.H().p1()) ? str : str.replace("/day/", "/night/");
    }

    public static int E() {
        if (f41900c == 0) {
            f41900c = c(38);
        }
        return f41900c;
    }

    public static int F() {
        if (f41906i == 0) {
            f41906i = c(2);
        }
        return f41906i;
    }

    public static Drawable G() {
        if (f41902e == null) {
            f41902e = g(868);
        }
        return f41902e;
    }

    public static int H() {
        if (f41910m == 0) {
            f41910m = c(39);
        }
        return f41910m;
    }

    public static int I() {
        if (f41907j == 0) {
            f41907j = c(3);
        }
        return f41907j;
    }

    public static int J() {
        if (f41908k == 0) {
            f41908k = c(33);
        }
        return f41908k;
    }

    public static String K(int i3) {
        return a().getString(i3);
    }

    public static Object L(int i3) {
        return a().e(i3);
    }

    public static CharSequence M(int i3) {
        return a().getText(i3);
    }

    public static float N(String str) {
        return a().c(str);
    }

    public static int O(int i3) {
        return a().getViewId(i3);
    }

    public static void P(o oVar) {
        f41898a = oVar;
    }

    public static boolean Q(int i3) {
        if (i3 >= 1911 && i3 <= 2183) {
            return true;
        }
        return false;
    }

    public static boolean R() {
        return i.H().p1();
    }

    public static void T(Context context, String str) {
        ZipResDownloadManager.C().G(str);
    }

    public static void W() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("skinFeedBackgroundColor", Integer.valueOf(m()));
        hashMap.put("skinFeedSecondBackgroundColor", Integer.valueOf(E()));
        hashMap.put("skinFeedForwardBackgroundColor", Integer.valueOf(E()));
        hashMap.put("skinFeedForwardSecondBackgroundColor", Integer.valueOf(m()));
        hashMap.put("skinFeedDarkModePicMaskColor", Integer.valueOf(p()));
        hashMap.put("skinFeedContentTextColor", Integer.valueOf(o()));
        hashMap.put("skinFeedSecondContentTextColor", Integer.valueOf(F()));
        hashMap.put("skinFeedTextLinkColor", Integer.valueOf(I()));
        hashMap.put("skinFeedGapColor", Integer.valueOf(s()));
        hashMap.put("skinFeedSplitLineColor", Integer.valueOf(H()));
        hashMap.put("skinFeedInputBoxBgColor", Integer.valueOf(u()));
        hashMap.put("skinFeedInputBoxHintColor", Integer.valueOf(v()));
        hashMap.put("skinFeedQUIMainButtonColor", Integer.valueOf(x()));
        hashMap.put("skinFeedQUISecondButtonColor", Integer.valueOf(z()));
        hashMap.put("skinFeedQUISecondButtonOnBgColor", Integer.valueOf(B()));
        hashMap.put("skinFeedQUIThirdButtonColor", Integer.valueOf(C()));
        f41920w = hashMap;
    }

    public static o a() {
        if (f41898a == null) {
            f41898a = com.qzone.util.i.e();
        }
        o oVar = f41898a;
        if (oVar != null) {
            return oVar;
        }
        throw new RuntimeException("IFeedResources does not init");
    }

    public static int b(int i3) {
        return a().getAnimationId(i3);
    }

    public static int c(int i3) {
        try {
            return a().getColor(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static int d(int i3) {
        return a().d(i3);
    }

    public static float e(int i3) {
        return a().a(i3);
    }

    public static int f(int i3) {
        return a().b(i3);
    }

    public static Drawable g(int i3) {
        return a().getDrawable(i3);
    }

    public static int h(int i3) {
        return a().getDrawableId(i3);
    }

    public static int i(int i3) {
        return a().getInteger(i3);
    }

    public static int j(int i3) {
        return a().getLayoutId(i3);
    }

    public static Drawable k(int i3) {
        return null;
    }

    public static HashMap<String, Integer> l() {
        if (f41920w == null) {
            W();
        }
        return f41920w;
    }

    public static Drawable n() {
        if (f41901d == null) {
            f41901d = g(822);
        }
        return f41901d;
    }

    public static int o() {
        if (f41905h == 0) {
            f41905h = c(1);
        }
        return f41905h;
    }

    public static int p() {
        if (f41904g == 0) {
            f41904g = Color.parseColor("#4D000000");
        }
        return f41904g;
    }

    public static int q() {
        return E();
    }

    public static int r() {
        return m();
    }

    public static int s() {
        if (f41909l == 0) {
            f41909l = c(13);
        }
        return f41909l;
    }

    public static Drawable t() {
        if (f41919v == null) {
            f41919v = g(905);
        }
        return f41919v;
    }

    public static int u() {
        if (f41911n == 0) {
            f41911n = c(46);
        }
        return f41911n;
    }

    public static int v() {
        if (f41912o == 0) {
            f41912o = c(4);
        }
        return f41912o;
    }

    public static Drawable w() {
        if (f41903f == null) {
            f41903f = g(883);
        }
        return f41903f;
    }

    public static int x() {
        if (f41913p == 0) {
            f41913p = c(40);
        }
        return f41913p;
    }

    public static Drawable y() {
        if (f41917t == null) {
            f41917t = g(404);
        }
        return f41917t;
    }

    public static int z() {
        if (f41914q == 0) {
            f41914q = c(41);
        }
        return f41914q;
    }

    public static void S() {
        f41899b = c(20);
        f41900c = c(38);
        f41901d = g(822);
        f41902e = g(868);
        f41903f = g(883);
        f41905h = c(1);
        f41906i = c(2);
        f41907j = c(3);
        f41908k = c(33);
        f41909l = c(13);
        f41910m = c(39);
        f41911n = c(46);
        f41912o = c(4);
        f41913p = c(40);
        f41914q = c(41);
        f41915r = c(42);
        f41916s = c(43);
        f41917t = g(404);
        f41918u = g(405);
        f41919v = g(905);
        W();
        if (com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.a("FeedResources", "onPostThemeChanged() skinFeedBackgroundColor: " + String.format("%x", Integer.valueOf(f41899b)));
        }
    }

    public static void U(Drawable drawable) {
        if (drawable != null) {
            if (i.H().p1()) {
                drawable.setColorFilter(p(), PorterDuff.Mode.SRC_ATOP);
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    public static void V(ImageView imageView) {
        if (imageView != null) {
            if (i.H().p1()) {
                imageView.setColorFilter(p());
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public static int m() {
        int c16 = c(20);
        int i3 = f41899b;
        if (i3 != 0 && c16 != i3) {
            S();
        }
        f41899b = c16;
        return c16;
    }
}
