package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.qzone.module.feedcomponent.ui.AreaConst;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ConsumeTouchFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    int f59594d;

    /* renamed from: e, reason: collision with root package name */
    int f59595e;

    /* renamed from: f, reason: collision with root package name */
    boolean f59596f;

    public ConsumeTouchFrameLayout(Context context) {
        super(context);
        this.f59594d = 0;
        this.f59595e = 0;
        this.f59596f = false;
    }

    private void a(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r2 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.f59596f) {
                        int abs = Math.abs(x16 - this.f59594d);
                        int abs2 = Math.abs(y16 - this.f59595e);
                        if (Math.max(abs, abs2) > AreaConst.SCROLL_DIRECTION_THRESHHOLD) {
                            this.f59596f = true;
                        }
                        if (abs < abs2) {
                            a(false);
                        }
                    }
                }
            }
            this.f59596f = false;
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        } else {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
            a(true);
            this.f59594d = x16;
            this.f59595e = y16;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ConsumeTouchFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59594d = 0;
        this.f59595e = 0;
        this.f59596f = false;
    }

    public ConsumeTouchFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f59594d = 0;
        this.f59595e = 0;
        this.f59596f = false;
    }
}
