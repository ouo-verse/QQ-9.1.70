package com.tencent.mobileqq.minigame.publicaccount.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class MiniGamePubViewpager extends ViewPager {
    private static final String TAG = "QQGamePubViewpager";
    private ViewGroup parent;

    public MiniGamePubViewpager(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.parent;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.parent;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void postDraw() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setNestedpParent(ViewGroup viewGroup) {
        this.parent = viewGroup;
    }

    public MiniGamePubViewpager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            ViewGroup viewGroup = this.parent;
            if (viewGroup != null) {
                viewGroup.requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "QQGamePubViewpager onTouchEvent throwable:" + th5.getMessage());
            return true;
        }
    }
}
