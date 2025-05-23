package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ScrollDisableListView extends ListView {

    /* renamed from: d, reason: collision with root package name */
    private int f252993d;

    public ScrollDisableListView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked == 0) {
            this.f252993d = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            return super.dispatchTouchEvent(motionEvent);
        }
        if (actionMasked == 2) {
            return true;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            if (pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == this.f252993d) {
                super.dispatchTouchEvent(motionEvent);
            } else {
                setPressed(false);
                invalidate();
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScrollDisableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollDisableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
