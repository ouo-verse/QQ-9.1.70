package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VConsoleDragView extends ImageView {
    private int bottom;
    private int height;
    private boolean isDrag;
    private int lastX;
    private int lastY;
    private int left;
    private DisplayMetrics mDm;
    private Listener mListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private int right;
    private int startX;
    private int startY;
    private int top;
    private int width;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface Listener {
        void onVConsoleMoveUp();
    }

    public VConsoleDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDrag = false;
        initScreenConfig();
    }

    private void initScreenConfig() {
        this.mScreenWidth = ViewUtils.getScreenWidth();
        this.mScreenHeight = ViewUtils.getScreenHeight() + (LiuHaiUtils.isLiuHaiUseValid() ? ImmersiveUtils.getStatusBarHeight(getContext()) : 0);
        this.mDm = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    }

    public int getStatusBarHeight() {
        return getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public boolean isDrag() {
        return this.isDrag;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Listener listener;
        super.onTouchEvent(motionEvent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        this.startX = (int) motionEvent.getRawX();
        this.startY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastX = this.startX;
            this.lastY = this.startY;
        } else if (action == 1) {
            if (!this.isDrag && (listener = this.mListener) != null) {
                listener.onVConsoleMoveUp();
            }
            this.isDrag = false;
        } else if (action == 2) {
            int i3 = this.startX - this.lastX;
            int i16 = this.startY - this.lastY;
            this.left = getLeft() + i3;
            this.top = getTop() + i16;
            this.right = getRight() + i3;
            int bottom = getBottom() + i16;
            this.bottom = bottom;
            if (this.left < 0) {
                this.left = 0;
                this.right = this.width + 0;
            } else {
                int i17 = this.right;
                int i18 = this.mScreenWidth;
                if (i17 > i18) {
                    this.right = i18;
                    this.left = i18 - this.width;
                }
            }
            if (this.top < 0) {
                this.top = 0;
                this.bottom = 0 + this.height;
            } else {
                int i19 = this.mScreenHeight;
                if (bottom > i19) {
                    this.bottom = i19;
                    this.top = i19 - this.height;
                }
            }
            layoutParams.setMargins(this.left, this.top, this.mScreenWidth - this.right, this.mScreenHeight - this.bottom);
            setLayoutParams(layoutParams);
            if (!this.isDrag && (Math.abs(this.startX - this.lastX) > this.mDm.density * 2.0f || Math.abs(this.startY - this.lastY) > this.mDm.density * 2.0f)) {
                this.isDrag = true;
            }
            this.lastX = this.startX;
            this.lastY = this.startY;
        }
        return true;
    }

    public void requestLandscapeLayout() {
        int statusBarHeight;
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (screenWidth > screenHeight) {
            statusBarHeight = screenWidth;
        } else {
            statusBarHeight = (LiuHaiUtils.isLiuHaiUseValid() ? ImmersiveUtils.getStatusBarHeight(getContext()) : 0) + screenHeight;
        }
        this.mScreenWidth = statusBarHeight;
        if (screenWidth > screenHeight) {
            screenWidth = screenHeight;
        }
        this.mScreenHeight = screenWidth;
        this.mDm = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public VConsoleDragView(Context context) {
        super(context);
        this.isDrag = false;
        initScreenConfig();
    }

    public VConsoleDragView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isDrag = false;
        initScreenConfig();
    }
}
