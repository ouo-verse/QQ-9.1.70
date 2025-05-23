package com.qzone.homepage.ui.woo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.qzone.util.ar;
import com.qzone.util.c;
import com.qzone.widget.aa;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends aa {
    private static int D;
    private static int E;
    private static int F;
    private static int G;

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f47862d;

    /* renamed from: e, reason: collision with root package name */
    private final ImageView f47863e;

    /* renamed from: f, reason: collision with root package name */
    private final int f47864f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f47859h = ar.d(5.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f47860i = ar.d(2.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f47861m = ar.d(8.0f);
    private static boolean C = false;

    public b(View view, int i3) {
        super(view);
        h(getResources());
        this.f47864f = i3;
        this.f47862d = (ImageView) view.findViewById(R.id.j2y);
        this.f47863e = (ImageView) view.findViewById(R.id.j2x);
    }

    private TimeInterpolator g() {
        return new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    }

    private static void h(Resources resources) {
        if (C) {
            return;
        }
        D = resources.getDimensionPixelSize(R.dimen.f159571ax2);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.awz);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f159570ax1);
        int i3 = D;
        F = (i3 - dimensionPixelSize2) - dimensionPixelSize2;
        int i16 = dimensionPixelSize + f47859h;
        G = i16;
        E = (i3 - i16) - i16;
        C = true;
    }

    public Rect e() {
        Rect rect = new Rect();
        rect.setEmpty();
        View view = this.rootView;
        if (view != null && view.getVisibility() == 0) {
            this.rootView.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    public ImageView f() {
        return this.f47862d;
    }

    public void i(boolean z16) {
        View view = this.rootView;
        if (view == null) {
            return;
        }
        view.clearAnimation();
        float scaleX = this.rootView.getScaleX();
        float f16 = z16 ? 1.32f : 1.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rootView, BasicAnimation.KeyPath.SCALE_X, scaleX, f16);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.rootView, BasicAnimation.KeyPath.SCALE_Y, scaleX, f16);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(g());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public void j(float f16, float f17, int i3) {
        float f18;
        float f19;
        float f26;
        float f27;
        Log.i("ScaleShadowActionBtnDir", "setScaleProp: " + f16 + " " + f17);
        float f28 = ((float) E) * f16;
        float f29 = ((float) D) - f28;
        int i16 = this.f47864f;
        if (i16 != 1) {
            if (i16 == 2) {
                int i17 = G;
                f19 = i17;
                f27 = f29 - i17;
                f26 = f27;
            } else if (i16 != 3) {
                f27 = f29 / 2.0f;
                f26 = f27;
                f19 = f26;
            } else {
                int i18 = G;
                f19 = i18;
                f18 = f29 / 2.0f;
                f27 = f29 - i18;
                f26 = f18;
            }
            f18 = f19;
        } else {
            float f36 = f29 / 2.0f;
            int i19 = G;
            f18 = i19;
            float f37 = f29 - i19;
            f19 = f36;
            f26 = f37;
            f27 = f19;
        }
        float f38 = f47859h * f16;
        int i26 = (int) (f26 - (f47860i * f16));
        float f39 = (f28 - (F * f17)) / 2.0f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47863e.getLayoutParams();
        marginLayoutParams.setMargins((int) (f27 - f38), i26, (int) (f19 - f38), (int) (f18 - (f47861m * f16)));
        this.f47863e.setLayoutParams(marginLayoutParams);
        c.a(this.f47863e, i3);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47862d.getLayoutParams();
        marginLayoutParams2.setMargins((int) (f27 + f39), (int) (f26 + f39), (int) (f19 + f39), (int) (f18 + f39));
        this.f47862d.setLayoutParams(marginLayoutParams2);
        c.a(this.f47862d, i3);
    }
}
