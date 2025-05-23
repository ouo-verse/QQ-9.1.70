package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import j53.a;

/* loaded from: classes20.dex */
public class PressEffectLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f317181d;

    public PressEffectLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f317181d = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled() && !this.f317181d) {
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

    public void setDisableEffect(boolean z16) {
        this.f317181d = z16;
    }
}
