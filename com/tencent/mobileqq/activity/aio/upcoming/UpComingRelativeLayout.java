package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UpComingRelativeLayout extends RelativeLayout {
    public UpComingRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public UpComingRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UpComingRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
