package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ClickableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name */
    private float f60197d;

    public ClickableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60197d = -1.0f;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f60197d = motionEvent.getX();
        } else if (action == 1) {
            float f16 = this.f60197d;
            if (f16 != -1.0f && Math.abs(f16 - motionEvent.getX()) < 5.0f) {
                this.f60197d = -1.0f;
                performClick();
            }
        } else if (action == 2) {
            float f17 = this.f60197d;
            if (f17 != -1.0f && Math.abs(f17 - motionEvent.getX()) >= 5.0f) {
                this.f60197d = -1.0f;
            }
        } else if (action == 3) {
            this.f60197d = -1.0f;
        }
        return super.onTouchEvent(motionEvent);
    }
}
