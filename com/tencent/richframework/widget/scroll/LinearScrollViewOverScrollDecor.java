package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public class LinearScrollViewOverScrollDecor implements IOverScrollDecor {
    protected int mOrientation = 1;

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public void initAnimationAttributes(View view, AnimationAttributes animationAttributes) {
        if (this.mOrientation == 1) {
            animationAttributes.mProperty = View.TRANSLATION_Y;
            animationAttributes.mAbsOffset = view.getTranslationY();
            animationAttributes.mMaxOffset = view.getHeight();
        } else {
            animationAttributes.mProperty = View.TRANSLATION_X;
            animationAttributes.mAbsOffset = view.getTranslationX();
            animationAttributes.mMaxOffset = view.getWidth();
        }
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public boolean initMotionAttributes(View view, MotionAttributes motionAttributes, MotionEvent motionEvent) {
        boolean z16 = false;
        if (motionEvent.getHistorySize() == 0) {
            return false;
        }
        float y16 = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
        float x16 = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
        if (this.mOrientation == 1) {
            if (Math.abs(y16) < Math.abs(x16)) {
                return false;
            }
            motionAttributes.mAbsOffset = view.getTranslationY();
            motionAttributes.mDeltaOffset = y16;
            if (y16 > 0.0f) {
                z16 = true;
            }
            motionAttributes.mDir = z16;
        } else {
            if (Math.abs(x16) < Math.abs(y16)) {
                return false;
            }
            motionAttributes.mAbsOffset = view.getTranslationX();
            motionAttributes.mDeltaOffset = x16;
            if (x16 > 0.0f) {
                z16 = true;
            }
            motionAttributes.mDir = z16;
        }
        return true;
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public boolean isInAbsoluteEnd(View view) {
        if (this.mOrientation == 1) {
            return !view.canScrollVertically(1);
        }
        return !view.canScrollHorizontally(1);
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public boolean isInAbsoluteStart(View view) {
        if (this.mOrientation == 1) {
            return !view.canScrollVertically(-1);
        }
        return !view.canScrollHorizontally(-1);
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public void setOrientation(int i3) {
        this.mOrientation = i3;
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public void translateView(View view, float f16) {
        if (this.mOrientation == 1) {
            view.setTranslationY(f16);
            dispatchOffsetYToListener(f16);
        } else {
            view.setTranslationX(f16);
            dispatchOffsetXToListener(f16);
        }
    }

    @Override // com.tencent.richframework.widget.scroll.IOverScrollDecor
    public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
        if (this.mOrientation == 1) {
            view.setTranslationY(f16);
            dispatchOffsetYToListener(f16);
            motionEvent.offsetLocation(0.0f, f16 - motionEvent.getY(0));
        } else {
            view.setTranslationX(f16);
            dispatchOffsetXToListener(f16);
            motionEvent.offsetLocation(f16 - motionEvent.getX(0), 0.0f);
        }
    }

    private void dispatchOffsetXToListener(float f16) {
    }

    private void dispatchOffsetYToListener(float f16) {
    }
}
