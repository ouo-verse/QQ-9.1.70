package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class m extends Transition {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f33881d;

        a(TextView textView) {
            this.f33881d = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f33881d.setScaleX(floatValue);
            this.f33881d.setScaleY(floatValue);
        }
    }

    private void captureValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        float f16;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.view;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        float f17 = 1.0f;
        if (map.get("android:textscale:scale") != null) {
            f16 = ((Float) map.get("android:textscale:scale")).floatValue();
        } else {
            f16 = 1.0f;
        }
        if (map2.get("android:textscale:scale") != null) {
            f17 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (f16 == f17) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.addUpdateListener(new a(textView));
        return ofFloat;
    }
}
