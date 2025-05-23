package com.tencent.biz.pubaccount.weishi.verticalvideo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f82371d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    public WSSwipeRefreshLayout(Context context) {
        super(context);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        a aVar = this.f82371d;
        parent.requestDisallowInterceptTouchEvent(aVar != null && aVar.a());
        a aVar2 = this.f82371d;
        if (aVar2 == null || aVar2.b()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnInterceptTouchEventListener(a aVar) {
        this.f82371d = aVar;
    }

    public WSSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
