package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ConsumeEventTopGestureLayout extends TopGestureLayout {
    public ConsumeEventTopGestureLayout(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public ConsumeEventTopGestureLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConsumeEventTopGestureLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
