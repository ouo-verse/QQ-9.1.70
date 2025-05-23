package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f60370d;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        boolean onDown(MotionEvent motionEvent);
    }

    public ExtendLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f60370d) != null && aVar.onDown(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnDownListener(a aVar) {
        this.f60370d = aVar;
    }

    public ExtendLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtendLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
