package com.tencent.gdtad.basics.twist;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.twist.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1160a {

        /* renamed from: a, reason: collision with root package name */
        private final float f109132a;

        /* renamed from: b, reason: collision with root package name */
        private final float f109133b;

        /* renamed from: c, reason: collision with root package name */
        private final float f109134c;

        /* renamed from: d, reason: collision with root package name */
        private final float f109135d;

        public C1160a(float f16, float f17, float f18, float f19) {
            this.f109132a = f16;
            this.f109133b = f17;
            this.f109134c = f18;
            this.f109135d = f19;
        }

        public String toString() {
            return "IconParams{iconX=" + this.f109132a + ", iconY=" + this.f109133b + ", iconWidth=" + this.f109134c + ", iconHeight=" + this.f109135d + '}';
        }
    }

    private static RotationAnimator a(AnimatorLayer animatorLayer, float f16, float f17, long j3, float f18, float f19, float f26, float f27) {
        RotationAnimator rotationAnimator = new RotationAnimator(animatorLayer);
        rotationAnimator.setRotationDegrees(f16, f17).setDuration(j3).setRepeatCount(1);
        rotationAnimator.setPathInterpolator(f18, f19, f26, f27);
        return rotationAnimator;
    }

    public static Animator b(AnimatorLayer animatorLayer, int i3, Animator.AnimatorProgressListener animatorProgressListener) {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
        sequentialAnimator.setAnimatorProgressListener(animatorProgressListener);
        if (i3 == 2) {
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, -30.0f, 640L, 0.33f, 0.0f, 0.67f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -30.0f, -30.0f, 240L, 0.33f, 0.0f, 0.67f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -30.0f, 5.0f, 240L, 0.17f, 0.0f, 0.0f, 0.99f));
            sequentialAnimator.addAnimator(a(animatorLayer, 5.0f, -5.0f, 120L, 0.22f, 0.0f, 0.7f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -5.0f, 0.0f, 120L, 0.33f, 0.0f, 0.67f, 1.35f));
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, 30.0f, 720L, 0.33f, -0.35f, 0.67f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 30.0f, 30.0f, 240L, 0.33f, -0.35f, 0.67f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 30.0f, -5.0f, 240L, 0.3f, 0.0f, 0.17f, 1.44f));
            sequentialAnimator.addAnimator(a(animatorLayer, -5.0f, 5.0f, 120L, 0.26f, 0.24f, 0.58f, 0.89f));
            sequentialAnimator.addAnimator(a(animatorLayer, 5.0f, 0.0f, 120L, 0.29f, -0.14f, 0.62f, 1.01f));
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, 0.0f, 200L, 0.29f, -0.14f, 0.62f, 1.01f));
        } else if (i3 == 1) {
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, 0.0f, 100L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, -45.0f, 700L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -45.0f, -45.0f, 200L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -45.0f, 5.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 5.0f, -5.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -5.0f, 0.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
        } else if (i3 == 0) {
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, 0.0f, 100L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 0.0f, 45.0f, 700L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 45.0f, 45.0f, 200L, 0.42f, 0.0f, 0.58f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 45.0f, -5.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, -5.0f, 5.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
            sequentialAnimator.addAnimator(a(animatorLayer, 5.0f, 0.0f, 200L, 0.25f, 0.1f, 0.25f, 1.0f));
        }
        sequentialAnimator.setRepeatCount(0);
        sequentialAnimator.setRepeatInterval(0L);
        sequentialAnimator.setRepeatMode(1);
        return sequentialAnimator;
    }

    public static AnimatorLayer c(Context context, C1160a c1160a) {
        if (c1160a == null) {
            return null;
        }
        Logger.i("TwistAnimationHelper", "getIconAnimatorLayer, params:" + c1160a);
        Bitmap bitmapFromBase64StringSafe = Utils.bitmapFromBase64StringSafe("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", (int) c1160a.f109134c, (int) c1160a.f109135d);
        if (bitmapFromBase64StringSafe == null) {
            return null;
        }
        AnimatorLayer height = new BitmapLayer(bitmapFromBase64StringSafe).setX(c1160a.f109132a).setY(c1160a.f109133b).setWidth((int) c1160a.f109134c).setHeight((int) c1160a.f109135d);
        d(height, c1160a);
        return height;
    }

    private static void d(AnimatorLayer animatorLayer, C1160a c1160a) {
        float f16 = c1160a.f109132a + c1160a.f109134c;
        float f17 = c1160a.f109133b + c1160a.f109135d;
        float f18 = f16 - (c1160a.f109134c * 0.5f);
        float f19 = f17 - (c1160a.f109135d * 0.5f);
        animatorLayer.setPx(f18);
        animatorLayer.setPy(f19);
    }
}
