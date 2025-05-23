package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;

/* loaded from: classes39.dex */
public class ViewPagerMatchParent extends CenterViewPager {
    int height;
    int mDefaultHeight;
    int mDownX;
    int mDownY;
    boolean mMeasured;
    boolean scrollDirectionDetermined;

    public ViewPagerMatchParent(Context context) {
        super(context);
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r2 != 3) goto L20;
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
                    if (!this.scrollDirectionDetermined) {
                        int abs = Math.abs(x16 - this.mDownX);
                        int abs2 = Math.abs(y16 - this.mDownY);
                        if (Math.max(abs, abs2) > AreaConst.SCROLL_DIRECTION_THRESHHOLD) {
                            this.scrollDirectionDetermined = true;
                        }
                        if (abs < abs2) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
            this.scrollDirectionDetermined = false;
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mDownX = x16;
            this.mDownY = y16;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ViewPagerMatchParent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
    }
}
