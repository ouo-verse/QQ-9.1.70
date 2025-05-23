package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VConsoleDragView extends ImageView {
    private float downX;
    private float downY;
    private Listener mListener;
    private float startX;
    private float startY;
    private final int touchSlop;
    private int viewHeight;
    private int viewWidth;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Listener {
        void onVConsoleMoveUp();
    }

    public VConsoleDragView(Context context) {
        super(context);
        setClickable(true);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private int getParentHeight() {
        return ((View) getParent()).getHeight();
    }

    private int getParentWidth() {
        return ((View) getParent()).getWidth();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.viewWidth = getMeasuredWidth();
        this.viewHeight = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        Listener listener;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float x16 = (getX() + rawX) - this.startX;
                    float y16 = (getY() + rawY) - this.startY;
                    if (x16 < 0.0f) {
                        x16 = 0.0f;
                    } else if (this.viewWidth + x16 > getParentWidth()) {
                        x16 = getParentWidth() - this.viewWidth;
                    }
                    if (y16 < 0.0f) {
                        y16 = 0.0f;
                    } else if (this.viewHeight + y16 > getParentHeight()) {
                        y16 = getParentHeight() - this.viewHeight;
                    }
                    setX(x16);
                    setY(y16);
                    this.startX = rawX;
                    this.startY = rawY;
                    bringToFront();
                }
            } else {
                if (Math.abs(this.downX - motionEvent.getRawX()) <= this.touchSlop && Math.abs(this.downY - motionEvent.getRawY()) <= this.touchSlop) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && (listener = this.mListener) != null) {
                    listener.onVConsoleMoveUp();
                }
            }
        } else {
            this.startX = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            this.startY = rawY2;
            this.downX = this.startX;
            this.downY = rawY2;
        }
        return true;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }
}
