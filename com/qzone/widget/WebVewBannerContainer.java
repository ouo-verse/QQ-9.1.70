package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class WebVewBannerContainer extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    boolean f60692d;

    public WebVewBannerContainer(Context context) {
        super(context);
        this.f60692d = false;
    }

    public void a(boolean z16) {
        this.f60692d = z16;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (motionEvent.getAction() == 0 && this.f60692d && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public WebVewBannerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60692d = false;
    }

    public WebVewBannerContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60692d = false;
    }
}
