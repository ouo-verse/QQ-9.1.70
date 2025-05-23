package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCeilingScrollVIew extends ScrollView {
    public GdtVideoCeilingScrollVIew(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GdtLog.i("GdtVideoCeilingScrollVIew", "dispatchTouchEvent");
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        GdtLog.i("GdtVideoCeilingScrollVIew", NodeProps.ON_INTERCEPT_TOUCH_EVENT);
        return false;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        GdtLog.i("GdtVideoCeilingScrollVIew", "onScrollChanged: t -> " + i16 + ", oldt -> " + i18 + ", l -> " + i3 + ", oldl -> " + i17);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GdtLog.i("GdtVideoCeilingScrollVIew", "onTouchEvent");
        return false;
    }

    public GdtVideoCeilingScrollVIew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GdtVideoCeilingScrollVIew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
