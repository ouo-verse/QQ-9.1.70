package com.tencent.luggage.wxa.ai;

import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.miniapp.widget.CanvasView;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements com.tencent.luggage.wxa.j8.f {

    /* renamed from: a, reason: collision with root package name */
    public int f121493a;

    /* renamed from: b, reason: collision with root package name */
    public int f121494b;

    /* renamed from: c, reason: collision with root package name */
    public int f121495c;

    /* renamed from: d, reason: collision with root package name */
    public int f121496d;

    /* renamed from: e, reason: collision with root package name */
    public int f121497e;

    /* renamed from: f, reason: collision with root package name */
    public int f121498f;

    /* renamed from: g, reason: collision with root package name */
    public String f121499g;

    /* renamed from: h, reason: collision with root package name */
    public float f121500h;

    /* renamed from: i, reason: collision with root package name */
    public float f121501i;

    @Override // com.tencent.luggage.wxa.j8.f
    public float a() {
        return this.f121500h;
    }

    @Override // com.tencent.luggage.wxa.j8.f
    public float b() {
        return this.f121501i;
    }

    public final void c(float f16, float f17) {
        if (Math.abs(f16 - f17) > 0.05d) {
            int i3 = this.f121493a;
            int i16 = this.f121494b;
            if (i3 < i16) {
                this.f121498f = (int) (i3 / f16);
                this.f121497e = i3;
                return;
            } else {
                this.f121497e = (int) (i16 * f16);
                this.f121498f = i16;
                return;
            }
        }
        int i17 = this.f121493a;
        int i18 = this.f121494b;
        if (i17 > i18) {
            this.f121498f = (int) (i17 / f16);
            this.f121497e = i17;
        } else {
            this.f121497e = (int) (i18 * f16);
            this.f121498f = i18;
        }
    }

    public final void d(float f16, float f17) {
        this.f121498f = this.f121494b;
        this.f121497e = this.f121493a;
    }

    @Override // com.tencent.luggage.wxa.j8.f
    public boolean a(String str, int i3, int i16, int i17, int i18) {
        if (w0.c(str)) {
            w.f("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
            return false;
        }
        if (i3 != 0 && i16 != 0 && i17 != 0 && i18 != 0) {
            if (str.equalsIgnoreCase(this.f121499g) && this.f121493a == i3 && this.f121494b == i16 && this.f121495c == i17 && this.f121496d == i18) {
                w.f("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
                return true;
            }
            this.f121499g = str;
            this.f121493a = i3;
            this.f121494b = i16;
            this.f121495c = i17;
            this.f121496d = i18;
            float f16 = (i17 * 1.0f) / i18;
            float f17 = (i3 * 1.0f) / i16;
            if (str.equalsIgnoreCase(HVideoConstants.ResizeType.RESIZE_CONTAIN)) {
                a(f16, f17);
            } else if (this.f121499g.equalsIgnoreCase(CanvasView.CUSTOM_ACTION_FILL)) {
                d(f16, f17);
            } else if (this.f121499g.equalsIgnoreCase("cover")) {
                b(f16, f17);
            } else {
                c(f16, f17);
            }
            int i19 = this.f121493a;
            this.f121500h = (this.f121497e * 1.0f) / i19;
            this.f121501i = (this.f121498f * 1.0f) / this.f121494b;
            w.a("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(i19), Integer.valueOf(this.f121494b), Integer.valueOf(this.f121495c), Integer.valueOf(this.f121496d), Integer.valueOf(this.f121497e), Integer.valueOf(this.f121498f), Float.valueOf(this.f121500h), Float.valueOf(this.f121501i));
            return true;
        }
        w.f("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
        return false;
    }

    public final void b(float f16, float f17) {
        int i3 = this.f121493a;
        int i16 = this.f121494b;
        if (i3 > i16) {
            int i17 = (int) (i3 / f16);
            this.f121498f = i17;
            this.f121497e = i3;
            if (i17 < i16) {
                this.f121497e = (int) (i16 * f16);
                this.f121498f = i16;
                return;
            }
            return;
        }
        int i18 = (int) (i16 * f16);
        this.f121497e = i18;
        this.f121498f = i16;
        if (i18 < i3) {
            this.f121498f = (int) (i3 / f16);
            this.f121497e = i3;
        }
    }

    public final void a(float f16, float f17) {
        int i3 = this.f121493a;
        int i16 = this.f121494b;
        if (i3 < i16) {
            int i17 = (int) (i3 / f16);
            this.f121498f = i17;
            this.f121497e = i3;
            if (i17 > i16) {
                this.f121497e = (int) (i16 * f16);
                this.f121498f = i16;
                return;
            }
            return;
        }
        int i18 = (int) (i16 * f16);
        this.f121497e = i18;
        this.f121498f = i16;
        if (i18 > i3) {
            this.f121498f = (int) (i3 / f16);
            this.f121497e = i3;
        }
    }
}
