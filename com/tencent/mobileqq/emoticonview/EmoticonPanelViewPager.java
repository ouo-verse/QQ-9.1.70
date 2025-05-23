package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQViewPager;

/* loaded from: classes12.dex */
public class EmoticonPanelViewPager extends QQViewPager {
    static IPatchRedirector $redirector_;
    private int mDistanceX;
    private boolean mFromLeftToRightScrollDisEnable;
    private boolean mFromRightToLeftScrollDisEnable;
    private int mLeftNoScrollSize;
    private float mMoveX;
    private boolean mOnFingerTouch;
    private int mRightNoScrollItem;
    private float mStartX;

    public EmoticonPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.mDistanceX = 0;
                this.mOnFingerTouch = false;
            }
        } else {
            this.mOnFingerTouch = true;
            this.mDistanceX = 0;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.widget.QQViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mFromLeftToRightScrollDisEnable && !this.mFromRightToLeftScrollDisEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                this.mMoveX = motionEvent.getX() - this.mStartX;
                this.mStartX = motionEvent.getX();
                if (!this.mFromLeftToRightScrollDisEnable || this.mMoveX <= 0.0f) {
                    if (this.mFromRightToLeftScrollDisEnable && this.mMoveX < 0.0f) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            this.mStartX = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mOnFingerTouch && (this.mLeftNoScrollSize != 0 || this.mRightNoScrollItem != 0)) {
            int currentItem = getCurrentItem();
            int i17 = this.mLeftNoScrollSize;
            if (currentItem == i17 && i17 != 0 && this.mFromLeftToRightScrollDisEnable) {
                int scrollX = getScrollX();
                int i18 = this.mDistanceX + (i3 - scrollX);
                this.mDistanceX = i18;
                if (i18 < 0) {
                    i3 = scrollX;
                }
            }
            int currentItem2 = getCurrentItem();
            int i19 = this.mRightNoScrollItem;
            if (currentItem2 == i19 && i19 != 0 && this.mFromRightToLeftScrollDisEnable) {
                int scrollX2 = getScrollX();
                int i26 = this.mDistanceX + (i3 - scrollX2);
                this.mDistanceX = i26;
                if (i26 > 0) {
                    i3 = scrollX2;
                }
            }
            super.scrollTo(i3, i16);
            return;
        }
        super.scrollTo(i3, i16);
    }

    public void setLeftScrollDisEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mFromRightToLeftScrollDisEnable = z16;
        }
    }

    public void setNoScrollItem(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mLeftNoScrollSize = i3;
            this.mRightNoScrollItem = i16;
        }
    }

    public void setRightScrollDisEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mFromLeftToRightScrollDisEnable = z16;
        }
    }

    public EmoticonPanelViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }
}
