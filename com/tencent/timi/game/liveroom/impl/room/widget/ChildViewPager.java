package com.tencent.timi.game.liveroom.impl.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes26.dex */
public class ChildViewPager extends ViewPager {
    public ChildViewPager(Context context) {
        super(context);
    }

    private void a(boolean z16) {
        ViewParent parent = getParent();
        while (!(parent instanceof ViewPager2) && parent != null) {
            parent = parent.getParent();
        }
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                int currentItem = getCurrentItem();
                if (currentItem != getAdapter().getCount() - 1 && currentItem != 0) {
                    a(true);
                } else {
                    a(false);
                }
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
