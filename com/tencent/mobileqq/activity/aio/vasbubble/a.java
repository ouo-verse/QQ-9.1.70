package com.tencent.mobileqq.activity.aio.vasbubble;

import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f180138a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.vasbubble.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7139a {

        /* renamed from: a, reason: collision with root package name */
        public int f180139a;

        /* renamed from: b, reason: collision with root package name */
        public int f180140b;

        /* renamed from: c, reason: collision with root package name */
        public int f180141c;

        /* renamed from: d, reason: collision with root package name */
        public float f180142d;

        /* renamed from: e, reason: collision with root package name */
        public float f180143e;

        /* renamed from: f, reason: collision with root package name */
        public float f180144f;

        C7139a() {
        }

        public String toString() {
            return "ManagerConfig{bitmapMinWidthPx=" + this.f180139a + ", maxDistanceRgb=" + this.f180140b + ", minColorAlpha=" + this.f180141c + ", minMainColorPercent=" + this.f180142d + ", maxLightnessValue=" + this.f180143e + ", minLightnessValue=" + this.f180144f + '}';
        }
    }

    a() {
    }

    public static a a() {
        return f180138a;
    }

    public C7139a b() {
        C7139a c7139a = new C7139a();
        ToggleProxy toggleProxy = VasToggle.VAS_AIO_TEXT_COLOR_MANAGER;
        c7139a.f180139a = Integer.valueOf(toggleProxy.getStringDataSet("bitmap_min_width_px", "0")).intValue();
        c7139a.f180140b = Integer.valueOf(toggleProxy.getStringDataSet("max_distance_rgb", "0")).intValue();
        c7139a.f180141c = Integer.valueOf(toggleProxy.getStringDataSet("min_color_alpha", "0")).intValue();
        c7139a.f180142d = Float.valueOf(toggleProxy.getStringDataSet("main_color_percent", "0")).floatValue();
        c7139a.f180143e = Float.valueOf(toggleProxy.getStringDataSet("max_lightness_value", "0")).floatValue();
        c7139a.f180144f = Float.valueOf(toggleProxy.getStringDataSet("min_lightness_value", "0")).floatValue();
        return c7139a;
    }

    public boolean c() {
        return VasToggle.VAS_AIO_TEXT_COLOR_MANAGER.isEnable(false);
    }
}
