package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes20.dex */
public class PressAlphaTextView extends TextView {
    public PressAlphaTextView(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                setAlpha(1.0f);
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public PressAlphaTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PressAlphaTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
