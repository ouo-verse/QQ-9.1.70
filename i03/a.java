package i03;

import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasNtToggle;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f406989a = new a();

    /* compiled from: P */
    /* renamed from: i03.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C10499a {

        /* renamed from: a, reason: collision with root package name */
        public int f406990a;

        /* renamed from: b, reason: collision with root package name */
        public int f406991b;

        /* renamed from: c, reason: collision with root package name */
        public int f406992c;

        /* renamed from: d, reason: collision with root package name */
        public float f406993d;

        /* renamed from: e, reason: collision with root package name */
        public float f406994e;

        /* renamed from: f, reason: collision with root package name */
        public float f406995f;

        public String toString() {
            return "ManagerConfig{bitmapMinWidthPx=" + this.f406990a + ", maxDistanceRgb=" + this.f406991b + ", minColorAlpha=" + this.f406992c + ", minMainColorPercent=" + this.f406993d + ", maxLightnessValue=" + this.f406994e + ", minLightnessValue=" + this.f406995f + '}';
        }
    }

    a() {
    }

    public static a a() {
        return f406989a;
    }

    public C10499a b() {
        C10499a c10499a = new C10499a();
        ToggleProxy toggleProxy = VasNtToggle.VAS_AIO_TEXT_COLOR_MANAGER;
        String stringDataSet = toggleProxy.getStringDataSet("bitmap_min_width_px", "10");
        Objects.requireNonNull(stringDataSet);
        c10499a.f406990a = Integer.parseInt(stringDataSet);
        String stringDataSet2 = toggleProxy.getStringDataSet("max_distance_rgb", "130000");
        Objects.requireNonNull(stringDataSet2);
        c10499a.f406991b = Integer.parseInt(stringDataSet2);
        String stringDataSet3 = toggleProxy.getStringDataSet("min_color_alpha", "50");
        Objects.requireNonNull(stringDataSet3);
        c10499a.f406992c = Integer.parseInt(stringDataSet3);
        String stringDataSet4 = toggleProxy.getStringDataSet("main_color_percent", "0.7");
        Objects.requireNonNull(stringDataSet4);
        c10499a.f406993d = Float.parseFloat(stringDataSet4);
        String stringDataSet5 = toggleProxy.getStringDataSet("max_lightness_value", "0.85");
        Objects.requireNonNull(stringDataSet5);
        c10499a.f406994e = Float.parseFloat(stringDataSet5);
        String stringDataSet6 = toggleProxy.getStringDataSet("min_lightness_value", "0.15");
        Objects.requireNonNull(stringDataSet6);
        c10499a.f406995f = Float.parseFloat(stringDataSet6);
        return c10499a;
    }

    public boolean c() {
        return VasNtToggle.VAS_AIO_TEXT_COLOR_MANAGER.isEnable(false);
    }
}
