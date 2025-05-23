package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes5.dex */
public class QFSPressEffectTextView extends TextView {
    public QFSPressEffectTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
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

    public QFSPressEffectTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPressEffectTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
