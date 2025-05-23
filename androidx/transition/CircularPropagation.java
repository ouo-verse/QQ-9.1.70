package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f16, float f17, float f18, float f19) {
        float f26 = f18 - f16;
        float f27 = f19 - f17;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int round;
        int i16;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 != null && getViewVisibility(transitionValues) != 0) {
            transitionValues = transitionValues2;
            i3 = 1;
        } else {
            i3 = -1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i16 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            i16 = round2;
        }
        float distance = distance(viewX, viewY, i16, round) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i3)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f16) {
        if (f16 != 0.0f) {
            this.mPropagationSpeed = f16;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
