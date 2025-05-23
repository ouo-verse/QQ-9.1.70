package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import com.tencent.mobileqq.emoticonview.base.BaseEmotionPanelListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EmotionPanelListView extends BaseEmotionPanelListView {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelListView";
    private boolean enableExtendPanle;
    private PullAndFastScrollListener mPullAndFastScrollListener;
    private boolean showDeleteButton;

    /* loaded from: classes12.dex */
    public interface PullAndFastScrollListener {
        void followHand(MotionEvent motionEvent);

        boolean isPanelOpen();

        void onPullDown();

        void onPullUp();
    }

    public EmotionPanelListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.enableExtendPanle = false;
            this.showDeleteButton = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.enableExtendPanle && motionEvent.getAction() == 0) {
            AbsListView.OnScrollListener onScrollListener = getOnScrollListener();
            if (onScrollListener instanceof EmoticonPanelOnScrollListener) {
                ((EmoticonPanelOnScrollListener) onScrollListener).onTouch(this, motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public PullAndFastScrollListener getPullAndFastScrollListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PullAndFastScrollListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mPullAndFastScrollListener;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.enableExtendPanle) {
            return super.onTouchEvent(motionEvent);
        }
        AbsListView.OnScrollListener onScrollListener = getOnScrollListener();
        if (onScrollListener instanceof EmoticonPanelOnScrollListener) {
            ((EmoticonPanelOnScrollListener) onScrollListener).onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnableExtendPanle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.enableExtendPanle = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.base.BaseEmotionPanelListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onScrollListener);
            return;
        }
        if ((this.enableExtendPanle || this.showDeleteButton) && !(onScrollListener instanceof EmoticonPanelOnScrollListener) && onScrollListener != null) {
            super.setOnScrollListener(new EmoticonPanelOnScrollListener(this, this.mPullAndFastScrollListener, onScrollListener));
        } else {
            super.setOnScrollListener(onScrollListener);
        }
    }

    public void setPullAndFastScrollListener(PullAndFastScrollListener pullAndFastScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pullAndFastScrollListener);
        } else {
            this.mPullAndFastScrollListener = pullAndFastScrollListener;
        }
    }

    public void setShowDeleteButton(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.showDeleteButton = z16;
        }
    }

    public EmotionPanelListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.enableExtendPanle = false;
            this.showDeleteButton = false;
        }
    }

    public EmotionPanelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.enableExtendPanle = false;
            this.showDeleteButton = false;
        }
    }
}
