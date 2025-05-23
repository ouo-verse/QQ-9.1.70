package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.HorizontalListView;

/* loaded from: classes33.dex */
public class MiniGameProfileLv extends HorizontalListView {
    private float lastX;
    private float lastY;
    private int touchSlop;

    public MiniGameProfileLv(Context context) {
        super(context);
        this.touchSlop = -1;
    }

    private int getTouchSlop() {
        int i3 = this.touchSlop;
        if (i3 > 0) {
            return i3;
        }
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.touchSlop = scaledTouchSlop;
        return scaledTouchSlop;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean z16 = true;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float x16 = motionEvent.getX();
                    float abs = Math.abs(motionEvent.getY() - this.lastY);
                    if (Math.abs(x16 - this.lastX) < abs && abs > getTouchSlop()) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        z16 = false;
                    }
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        }
        if (z16) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public MiniGameProfileLv(Context context, boolean z16) {
        super(context, z16);
        this.touchSlop = -1;
    }

    public MiniGameProfileLv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.touchSlop = -1;
    }

    public MiniGameProfileLv(Context context, AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet, z16);
        this.touchSlop = -1;
    }
}
