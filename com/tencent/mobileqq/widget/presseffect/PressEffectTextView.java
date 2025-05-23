package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import j53.a;

/* loaded from: classes20.dex */
public class PressEffectTextView extends TextView {
    public PressEffectTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
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
