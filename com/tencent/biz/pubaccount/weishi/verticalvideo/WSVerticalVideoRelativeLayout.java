package com.tencent.biz.pubaccount.weishi.verticalvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSVerticalVideoRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f81839d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        boolean dispatchTouchEvent(MotionEvent motionEvent);
    }

    public WSVerticalVideoRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f81839d;
        if (aVar == null || !aVar.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void setDispatchTouchEventListener(a aVar) {
        this.f81839d = aVar;
    }

    public WSVerticalVideoRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
