package com.tencent.qq.effect.engine;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Layout {
    static IPatchRedirector $redirector_ = null;
    public static final int ABSOLUTE_LAYOUT = 0;
    public static final int SCALE_LAYOUT = 1;

    public Layout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Rect absoluteLayout(Context context, QEffectData qEffectData, int i3, int i16) {
        Rect rect = new Rect();
        float f16 = qEffectData.f344466w;
        if (f16 != -1.0f) {
            i3 = 0;
        }
        float f17 = qEffectData.f344465h;
        if (f17 != -1.0f) {
            i16 = 0;
        }
        if (f16 > 0.0f) {
            i3 = getLayoutPx(context, (int) f16);
            float f18 = qEffectData.f344465h;
            if (f18 > 0.0f) {
                i16 = getLayoutPx(context, (int) f18);
            } else {
                float f19 = qEffectData.aspectRatio;
                if (f19 > 0.0f) {
                    i16 = (int) (i3 * f19);
                }
            }
        } else if (f17 > 0.0f) {
            i16 = getLayoutPx(context, (int) f17);
            float f26 = qEffectData.f344466w;
            if (f26 > 0.0f) {
                i3 = getLayoutPx(context, (int) f26);
            } else {
                float f27 = qEffectData.aspectRatio;
                if (f27 > 0.0f) {
                    i3 = (int) (i16 * f27);
                }
            }
        }
        int layoutPx = getLayoutPx(context, (int) qEffectData.f344467x);
        int layoutPx2 = getLayoutPx(context, (int) qEffectData.f344468y);
        rect.set(layoutPx, layoutPx2, i3 + layoutPx, i16 + layoutPx2);
        return rect;
    }

    public static FrameLayout.LayoutParams getLayoutParams(Context context, QEffectData qEffectData, int i3, int i16) {
        Rect absoluteLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int i17 = qEffectData.layoutType;
        if (i17 != 0) {
            if (i17 != 1) {
                absoluteLayout = new Rect();
            } else {
                absoluteLayout = scaleLayout(qEffectData, i3, i16);
            }
        } else {
            absoluteLayout = absoluteLayout(context, qEffectData, i3, i16);
        }
        if (qEffectData.f344466w >= 0.0f) {
            layoutParams.width = absoluteLayout.width();
        }
        if (qEffectData.f344465h >= 0.0f) {
            layoutParams.height = absoluteLayout.height();
        }
        layoutParams.leftMargin = absoluteLayout.left;
        layoutParams.topMargin = absoluteLayout.top;
        return layoutParams;
    }

    public static int getLayoutPx(Context context, int i3) {
        return (int) (i3 / layoutScale(context));
    }

    public static float layoutScale(Context context) {
        return 750.0f / context.getResources().getDisplayMetrics().widthPixels;
    }

    public static Rect scaleLayout(QEffectData qEffectData, int i3, int i16) {
        int i17;
        float f16;
        Rect rect = new Rect();
        float f17 = qEffectData.f344466w;
        int i18 = 0;
        if (f17 == -1.0f) {
            i17 = i3;
        } else {
            i17 = 0;
        }
        float f18 = qEffectData.f344465h;
        if (f18 == -1.0f) {
            i18 = i16;
        }
        if (f17 > 0.0f) {
            i17 = (int) (i3 * f17);
            if (f18 > 0.0f) {
                i18 = (int) (i16 * f18);
            } else {
                float f19 = qEffectData.aspectRatio;
                if (f19 > 0.0f) {
                    i18 = (int) (i17 * f19);
                }
            }
        } else if (f18 > 0.0f) {
            i18 = (int) (i16 * f18);
            if (f17 > 0.0f) {
                f16 = i3;
            } else {
                f17 = qEffectData.aspectRatio;
                if (f17 > 0.0f) {
                    f16 = i18;
                }
            }
            i17 = (int) (f16 * f17);
        }
        int i19 = (int) (i3 * qEffectData.f344467x);
        int i26 = (int) (i16 * qEffectData.f344468y);
        rect.set(i19, i26, i17 + i19, i18 + i26);
        return rect;
    }
}
