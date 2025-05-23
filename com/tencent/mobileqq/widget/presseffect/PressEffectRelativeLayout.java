package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import j53.a;

/* loaded from: classes20.dex */
public class PressEffectRelativeLayout extends RelativeLayout {
    public PressEffectRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    a.b(this);
                }
                return super.onTouchEvent(motionEvent);
            }
            a.a(this);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
