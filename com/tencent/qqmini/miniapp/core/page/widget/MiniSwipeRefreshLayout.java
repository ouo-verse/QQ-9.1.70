package com.tencent.qqmini.miniapp.core.page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniSwipeRefreshLayout extends SwipeRefreshLayout {
    public static final String TAG = "MiniSwipeRefreshLayout";
    private float density;
    boolean ismove;
    private float mInitialDownX;
    private float mInitialDownY;
    private int mTouchSlop;

    public MiniSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float abs = Math.abs(motionEvent.getX() - this.mInitialDownX);
                float abs2 = Math.abs(motionEvent.getY() - this.mInitialDownY);
                if (abs2 < this.mTouchSlop || abs > abs2) {
                    return false;
                }
            }
        } else {
            this.mInitialDownX = motionEvent.getX();
            this.mInitialDownY = motionEvent.getY();
            this.ismove = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setTouchSlop(int i3) {
        this.mTouchSlop = (int) (i3 * this.density);
    }

    public MiniSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ismove = false;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.density = DisplayUtil.getDensity(getContext());
    }
}
