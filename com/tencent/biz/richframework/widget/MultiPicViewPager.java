package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class MultiPicViewPager extends ViewPager {
    private int mTouchSlop;
    private float startX;
    private float startY;

    public MultiPicViewPager(Context context) {
        super(context);
        initParams();
    }

    private int getCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getF373114d();
    }

    private void initParams() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean isMultiPic() {
        if (getCount() > 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(motionEvent.getRawX() - this.startX);
                float abs2 = Math.abs(rawY - this.startY);
                int i3 = this.mTouchSlop;
                if (abs <= i3 && abs2 <= i3) {
                    QLog.d("MultiPicViewPager", 4, "onInterceptTouchEvent move false mTouchSlop: " + this.mTouchSlop + " distanceX" + abs + " distanceY:" + abs2);
                    return false;
                }
                QLog.d("MultiPicViewPager", 4, "onInterceptTouchEvent move true mTouchSlop: " + this.mTouchSlop + " distanceX" + abs + " distanceY:" + abs2);
                return true;
            }
        } else {
            this.startY = motionEvent.getRawY();
            this.startX = motionEvent.getRawX();
            QLog.d("MultiPicViewPager", 4, "onInterceptTouchEvent down");
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public MultiPicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initParams();
    }
}
