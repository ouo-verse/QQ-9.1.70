package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import j53.a;

/* loaded from: classes20.dex */
public class PressEffectImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f317180d;

    public PressEffectImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f317180d = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled() && !this.f317180d) {
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
        this.f317180d = z16;
    }

    public PressEffectImageView(Context context) {
        super(context);
        this.f317180d = false;
    }
}
