package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RedTouchWebView extends TouchWebView {
    public RedTouchWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        if (motionEvent.getAction() == 0) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent, view);
    }

    public RedTouchWebView(Context context) {
        super(context);
    }
}
