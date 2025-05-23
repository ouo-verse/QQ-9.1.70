package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private int[] mTempLoc;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f16, float f17) {
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    private static float calculateMaxDistance(View view, int i3, int i16) {
        return calculateDistance(Math.max(i3, view.getWidth() - i3), Math.max(i16, view.getHeight() - i16));
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int centerY;
        int i3;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        int i16 = iArr2[0];
        int i17 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i3 = (view.getWidth() / 2) + i16 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i17 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            centerY = epicenter.centerY();
            i3 = centerX;
        }
        float centerX2 = rect.centerX() - i3;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float calculateDistance = calculateDistance(centerX2, centerY2);
        float calculateMaxDistance = calculateMaxDistance(view, i3 - i16, centerY - i17);
        iArr[0] = Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
        iArr[1] = Math.round(calculateMaxDistance * (centerY2 / calculateDistance));
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr = this.mTempLoc;
        int i3 = iArr[0];
        int i16 = iArr[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i3, i16, view.getWidth() + i3, view.getHeight() + i16));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f16;
        float f17;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i3 = rect.left;
        int i16 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(com.tencent.mobileqq.R.id.f100855tm);
        if (iArr != null) {
            f16 = (r7 - rect.left) + translationX;
            f17 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f16 = translationX;
            f17 = translationY;
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(view, transitionValues, i3, i16, translationX, translationY, f16 + iArr2[0], f17 + iArr2[1], sAccelerate, this);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }
}
