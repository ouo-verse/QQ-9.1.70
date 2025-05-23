package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ExtendGridView extends GridView {
    int mHorizontalSpacing;
    int mNumColumns;
    boolean mPenetrateTouch;
    int mScreenWidth;
    boolean mStretchable;
    int mVerticalSpacing;

    public ExtendGridView(Context context) {
        this(context, null);
    }

    public int computeItemWidth() {
        int measuredWidth;
        if (getWidth() > 0) {
            measuredWidth = getWidth();
        } else {
            measuredWidth = getMeasuredWidth();
        }
        if (measuredWidth <= 0) {
            measuredWidth = this.mScreenWidth;
        }
        int horizontalSpacing = getHorizontalSpacing();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int numColumns = getNumColumns();
        int i3 = ((measuredWidth - paddingLeft) - ((numColumns - 1) * horizontalSpacing)) / numColumns;
        if (i3 < 0) {
            return -2;
        }
        return i3;
    }

    @Override // android.widget.GridView
    public int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    @Override // android.widget.GridView
    public int getNumColumns() {
        return this.mNumColumns;
    }

    @Override // android.widget.GridView
    public int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    void init() {
        updateScreenSize();
    }

    public boolean isPenetrateTouch() {
        return this.mPenetrateTouch;
    }

    public boolean isStretchable() {
        return this.mStretchable;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateScreenSize();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mStretchable) {
            i16 = View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!this.mPenetrateTouch || pointToPosition >= 0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i3) {
        super.setHorizontalSpacing(i3);
        this.mHorizontalSpacing = i3;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i3) {
        super.setNumColumns(i3);
        this.mNumColumns = i3;
    }

    public void setPenetrateTouch(boolean z16) {
        this.mPenetrateTouch = z16;
    }

    public void setStretchable(boolean z16) {
        if (this.mStretchable != z16) {
            this.mStretchable = z16;
            requestLayout();
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i3) {
        super.setVerticalSpacing(i3);
        this.mVerticalSpacing = i3;
    }

    void updateScreenSize() {
        this.mScreenWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public ExtendGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
