package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;

/* loaded from: classes33.dex */
public class UPloadToolbar extends RelativeLayout {
    public UPloadToolbar(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public UPloadToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UPloadToolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
