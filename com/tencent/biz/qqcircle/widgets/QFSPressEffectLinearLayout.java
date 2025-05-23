package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes5.dex */
public class QFSPressEffectLinearLayout extends LinearLayout {
    public QFSPressEffectLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public QFSPressEffectLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPressEffectLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
