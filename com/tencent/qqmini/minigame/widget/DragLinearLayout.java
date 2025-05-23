package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tencent.qqmini.sdk.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DragLinearLayout extends RelativeLayout {
    private static final String TAG = "DragLinearLayout";
    int bottom;
    private float downX;
    private float downY;
    private int height;
    private boolean isDrag;
    int left;
    int right;
    private int screenHeight;
    private int screenWidth;
    int top;
    private int width;

    public DragLinearLayout(Context context) {
        super(context);
        this.isDrag = false;
        initScreenConfig();
    }

    private void initScreenConfig() {
        this.screenWidth = ViewUtils.getScreenWidth();
        this.screenHeight = ViewUtils.getScreenHeight();
    }

    public int getStatusBarHeight() {
        return getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public boolean isDrag() {
        return this.isDrag;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        setPressed(false);
                    }
                } else {
                    float x16 = motionEvent.getX() - this.downX;
                    float y16 = motionEvent.getY() - this.downY;
                    if (Math.abs(x16) > 30.0f || Math.abs(y16) > 30.0f) {
                        this.isDrag = true;
                        int left = (int) (getLeft() + x16);
                        this.left = left;
                        this.right = left + this.width;
                        int top = (int) (getTop() + y16);
                        this.top = top;
                        int i3 = this.height;
                        int i16 = top + i3;
                        this.bottom = i16;
                        if (this.left < 0) {
                            this.left = 0;
                            this.right = this.width + 0;
                        } else {
                            int i17 = this.right;
                            int i18 = this.screenWidth;
                            if (i17 > i18) {
                                this.right = i18;
                                this.left = i18 - this.width;
                            }
                        }
                        if (top < 0) {
                            this.top = 0;
                            this.bottom = 0 + i3;
                        } else {
                            int i19 = this.screenHeight;
                            if (i16 > i19) {
                                this.bottom = i19;
                                this.top = i19 - i3;
                            }
                        }
                        layoutParams.setMargins(this.left, this.top, this.screenWidth - this.right, this.screenHeight - this.bottom);
                        setLayoutParams(layoutParams);
                    }
                    bringToFront();
                }
            } else {
                setPressed(false);
                layoutParams.setMargins(this.left, this.top, this.screenWidth - this.right, (this.screenHeight - this.bottom) - getStatusBarHeight());
                setLayoutParams(layoutParams);
                bringToFront();
            }
        } else {
            this.isDrag = false;
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
        }
        return true;
    }

    public DragLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDrag = false;
        initScreenConfig();
    }

    public DragLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isDrag = false;
        initScreenConfig();
    }

    @RequiresApi(api = 21)
    public DragLinearLayout(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.isDrag = false;
        initScreenConfig();
    }
}
