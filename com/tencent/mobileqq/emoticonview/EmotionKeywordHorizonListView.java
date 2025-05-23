package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionKeywordHorizonListView extends HorizontalListView {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_EMOTION_KEYWORD = 0;
    public static final int TYPE_ZHITU = 1;
    public int mType;
    private HorizonListViewTouchListener touchListener;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface HorizonListViewTouchListener {
        void touchEventActionChanged(int i3);
    }

    public EmotionKeywordHorizonListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mType = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        HorizonListViewTouchListener horizonListViewTouchListener = this.touchListener;
        if (horizonListViewTouchListener != null) {
            horizonListViewTouchListener.touchEventActionChanged(motionEvent.getAction());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout) && ((com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout) childAt).f205165f) {
                return childAt.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsFromRightToLeft(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isFromRightToLeft = z16;
            invalidate();
        }
    }

    public void setTouchListener(HorizonListViewTouchListener horizonListViewTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) horizonListViewTouchListener);
        } else {
            this.touchListener = horizonListViewTouchListener;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public EmotionKeywordHorizonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mType = 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
