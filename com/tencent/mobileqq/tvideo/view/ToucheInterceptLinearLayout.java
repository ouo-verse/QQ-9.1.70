package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ToucheInterceptLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f304820d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(int i3);
    }

    public ToucheInterceptLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 1) && (aVar = this.f304820d) != null) {
            aVar.a(motionEvent.getAction());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnActionListener(a aVar) {
        this.f304820d = aVar;
    }

    public ToucheInterceptLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToucheInterceptLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
