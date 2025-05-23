package com.tencent.mobileqq.qqexpand.widget.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes16.dex */
public class InterceptHorizontalScrollView extends HorizontalScrollView {
    public InterceptHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        int i29 = (int) (i3 * 0.3f);
        if (i17 + i3 == 0 || (i17 - i19) + i3 == 0) {
            i29 = i3;
        }
        return super.overScrollBy(i29, i16, i17, i18, i19, i26, 180, i28, z16);
    }

    public InterceptHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
