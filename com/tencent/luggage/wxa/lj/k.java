package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.ok.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.n0;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f133496a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static Map f133497b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        START(1),
        STOP(2),
        CLICK(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f133502a;

        a(int i3) {
            this.f133502a = i3;
        }

        public final int b() {
            return this.f133502a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        NONE(0),
        TIPS(1),
        LBS(2),
        VOICE(4),
        CAMERA(8),
        KOU_BEI(16),
        TRADE_SCORE(32),
        TRADE_COMMENT_DISH_INFO(64);


        /* renamed from: a, reason: collision with root package name */
        public final int f133512a;

        b(int i3) {
            this.f133512a = i3;
        }

        public final int b() {
            return this.f133512a;
        }
    }

    public static final void a(com.tencent.luggage.wxa.kj.v pageView) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        f133497b = b(pageView);
    }

    public static final Map b(com.tencent.luggage.wxa.kj.v pageView) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        int[] iArr = new int[2];
        pageView.D().getLocationInWindow(pageView.W().getCapsuleView(), iArr);
        int width = pageView.W().getCapsuleView().getWidth();
        int height = pageView.W().getCapsuleView().getHeight();
        int i3 = iArr[1];
        int i16 = iArr[0];
        int i17 = i16 + width;
        int i18 = height + i3;
        if (i16 == 0 || width == 0) {
            w.b("MicroMsg.CapsuleBarUtils", "getBoundingRectLegacy with appId[%s] left==0, return null", pageView.getAppId());
            return null;
        }
        Map a16 = a(pageView.getContext(), new Rect(i16, i3, i17, i18));
        w.d("MicroMsg.CapsuleBarUtils", "getBoundingRectLegacy with appId[%s] return %s", pageView.getAppId(), a16);
        return a16;
    }

    public static final Map a() {
        return f133497b;
    }

    public static final Map a(com.tencent.luggage.wxa.ic.l lVar) {
        if (lVar == null) {
            return null;
        }
        com.tencent.luggage.wxa.ok.n b16 = f133496a.b(lVar);
        if (b16 == null) {
            w.b("MicroMsg.CapsuleBarUtils", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", lVar.getAppId());
            return null;
        }
        int a16 = b16.a(lVar);
        n.b N = b16.N();
        int a17 = N.a();
        int b17 = N.b();
        n.a W = b16.W();
        int i3 = n0.b((com.tencent.luggage.wxa.ic.d) lVar)[0];
        int d16 = a16 + (W != null ? W.d() : 0);
        int i16 = b17 + d16;
        int c16 = i3 - (W != null ? W.c() : 0);
        Map a18 = a(lVar.getContext(), new Rect(c16 - a17, d16, c16, i16));
        w.d("MicroMsg.CapsuleBarUtils", "getBoundingRectFallback with appId[%s] return %s", lVar.getAppId(), a18);
        return a18;
    }

    public final com.tencent.luggage.wxa.ok.n b(com.tencent.luggage.wxa.ic.l lVar) {
        return (com.tencent.luggage.wxa.ok.n) lVar.b(com.tencent.luggage.wxa.ok.n.class);
    }

    public static final b b(int i3) {
        return i3 == a.c.LBS.ordinal() ? b.LBS : i3 == a.c.VOICE.ordinal() ? b.VOICE : i3 == a.c.CAMERA.ordinal() ? b.CAMERA : b.NONE;
    }

    public static final boolean a(com.tencent.luggage.wxa.ic.d env) {
        Intrinsics.checkNotNullParameter(env, "env");
        return env.D().shouldInLargeScreenCompatMode();
    }

    public static final Map a(Context context, Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.left = com.tencent.luggage.wxa.tk.g.a(context, rect.left);
        rect.top = com.tencent.luggage.wxa.tk.g.a(context, rect.top);
        rect.right = com.tencent.luggage.wxa.tk.g.a(context, rect.right);
        rect.bottom = com.tencent.luggage.wxa.tk.g.a(context, rect.bottom);
        HashMap hashMap = new HashMap(6);
        hashMap.put("left", Integer.valueOf(rect.left));
        hashMap.put("top", Integer.valueOf(rect.top));
        hashMap.put("right", Integer.valueOf(rect.right));
        hashMap.put("bottom", Integer.valueOf(rect.bottom));
        hashMap.put("width", Integer.valueOf(rect.width()));
        hashMap.put("height", Integer.valueOf(rect.height()));
        return hashMap;
    }

    public static final b a(int i3) {
        return i3 == a.EnumC6443a.KOUBEI.ordinal() ? b.KOU_BEI : i3 == a.EnumC6443a.TRADE.ordinal() ? b.TRADE_SCORE : b.NONE;
    }
}
