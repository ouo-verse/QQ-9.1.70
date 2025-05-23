package com.tencent.aelight.camera.aioeditor.capture.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ez;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final int f67204d;

        /* renamed from: e, reason: collision with root package name */
        final int f67205e;

        /* renamed from: f, reason: collision with root package name */
        final int f67206f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f67207h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f67208i;

        a(int i3, View view) {
            this.f67207h = i3;
            this.f67208i = view;
            this.f67204d = Color.red(i3);
            this.f67205e = Color.green(i3);
            this.f67206f = Color.blue(i3);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f67208i.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.f67204d, this.f67205e, this.f67206f));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements ez.f<Float> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f67209a;

        b(View view) {
            this.f67209a = view;
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Float> ezVar, float f16, Float f17, Transformation transformation) {
            if (QLog.isColorLevel()) {
                QLog.e("QIMAnimationUtils", 2, "alphaAnimation value = " + f17);
            }
            float floatValue = f17.floatValue();
            View view = this.f67209a;
            if (view != null) {
                view.setAlpha(floatValue);
                this.f67209a.invalidate();
            }
        }
    }

    public static Animation b(View view, float f16, float f17) {
        return new ez(Float.valueOf(f16), Float.valueOf(f17), new b(view));
    }

    public static Animator a(View view, int i3, int i16, int i17) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i17);
        ofInt.addUpdateListener(new a(i3, view));
        return ofInt;
    }
}
