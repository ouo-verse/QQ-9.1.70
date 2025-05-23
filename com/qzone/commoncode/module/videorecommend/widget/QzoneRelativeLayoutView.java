package com.qzone.commoncode.module.videorecommend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneRelativeLayoutView extends RelativeLayout {
    public QzoneRelativeLayoutView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        GdtFeedUtilForQZone.y(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public QzoneRelativeLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QzoneRelativeLayoutView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
