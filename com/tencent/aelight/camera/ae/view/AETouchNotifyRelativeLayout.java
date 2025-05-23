package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AETouchNotifyRelativeLayout extends RelativeLayout {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
    }

    public AETouchNotifyRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public AETouchNotifyRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AETouchNotifyRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setIaeTouchNotify(a aVar) {
    }
}
