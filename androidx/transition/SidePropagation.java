package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0017, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0026, code lost:
    
        if (r5 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r5 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r0 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int distance(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = this.mSide;
        boolean z16 = true;
        if (i29 == 8388611) {
            if (ViewCompat.getLayoutDirection(view) != 1) {
                z16 = false;
            }
        } else if (i29 == 8388613) {
            if (ViewCompat.getLayoutDirection(view) != 1) {
                z16 = false;
            }
        }
        if (i29 != 3) {
            if (i29 != 5) {
                if (i29 != 48) {
                    if (i29 != 80) {
                        return 0;
                    }
                    return (i16 - i26) + Math.abs(i17 - i3);
                }
                return (i28 - i16) + Math.abs(i17 - i3);
            }
            return (i3 - i19) + Math.abs(i18 - i16);
        }
        return (i27 - i3) + Math.abs(i18 - i16);
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i3 = this.mSide;
        if (i3 != 3 && i3 != 5 && i3 != 8388611 && i3 != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int i16;
        int i17;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 != null && getViewVisibility(transitionValues3) != 0) {
            transitionValues3 = transitionValues2;
            i3 = 1;
        } else {
            i3 = -1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i16 = epicenter.centerX();
            i17 = epicenter.centerY();
        } else {
            i16 = (round + width) / 2;
            i17 = (round2 + height) / 2;
        }
        float distance = distance(viewGroup, viewX, viewY, i16, i17, round, round2, width, height) / getMaxDistance(viewGroup);
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

    public void setSide(int i3) {
        this.mSide = i3;
    }
}
