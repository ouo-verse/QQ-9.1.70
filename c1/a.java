package c1;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.R;
import g1.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final int f30224f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f30225a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30226b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30227c;

    /* renamed from: d, reason: collision with root package name */
    private final int f30228d;

    /* renamed from: e, reason: collision with root package name */
    private final float f30229e;

    public a(@NonNull Context context) {
        this(b.b(context, R.attr.ade, false), z0.a.b(context, R.attr.add, 0), z0.a.b(context, R.attr.adc, 0), z0.a.b(context, R.attr.a8g, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(@ColorInt int i3) {
        if (ColorUtils.setAlphaComponent(i3, 255) == this.f30228d) {
            return true;
        }
        return false;
    }

    public float a(float f16) {
        if (this.f30229e <= 0.0f || f16 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f16 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int b(@ColorInt int i3, float f16) {
        int i16;
        float a16 = a(f16);
        int alpha = Color.alpha(i3);
        int h16 = z0.a.h(ColorUtils.setAlphaComponent(i3, 255), this.f30226b, a16);
        if (a16 > 0.0f && (i16 = this.f30227c) != 0) {
            h16 = z0.a.g(h16, ColorUtils.setAlphaComponent(i16, f30224f));
        }
        return ColorUtils.setAlphaComponent(h16, alpha);
    }

    @ColorInt
    public int c(@ColorInt int i3, float f16) {
        if (this.f30225a && f(i3)) {
            return b(i3, f16);
        }
        return i3;
    }

    @ColorInt
    public int d(float f16) {
        return c(this.f30228d, f16);
    }

    public boolean e() {
        return this.f30225a;
    }

    public a(boolean z16, @ColorInt int i3, @ColorInt int i16, @ColorInt int i17, float f16) {
        this.f30225a = z16;
        this.f30226b = i3;
        this.f30227c = i16;
        this.f30228d = i17;
        this.f30229e = f16;
    }
}
