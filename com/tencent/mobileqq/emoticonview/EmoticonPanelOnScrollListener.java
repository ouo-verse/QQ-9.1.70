package com.tencent.mobileqq.emoticonview;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes12.dex */
public class EmoticonPanelOnScrollListener implements AbsListView.OnScrollListener, View.OnTouchListener {
    static IPatchRedirector $redirector_ = null;
    private static final int PULL_UP_THRESHOLD = 120;
    private static final int REBOUNCE_INDEX = 5;
    private static final String TAG = "EmotionPanelListView";
    private float downY;
    private EmotionPanelListView emotionPanelListView;
    private boolean isPanelNeedPullUp;
    boolean isPanelOpen;
    private int mLastState;
    private int mLastTop;
    private AbsListView.OnScrollListener onScrollListener;
    private int[] point;
    private EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;

    public EmoticonPanelOnScrollListener(EmotionPanelListView emotionPanelListView, EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener, AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, emotionPanelListView, pullAndFastScrollListener, onScrollListener);
            return;
        }
        this.mLastTop = 0;
        this.mLastState = 0;
        this.point = new int[2];
        this.downY = 0.0f;
        this.isPanelOpen = false;
        this.isPanelNeedPullUp = false;
        this.onScrollListener = onScrollListener;
        this.emotionPanelListView = emotionPanelListView;
        this.pullAndFastScrollListener = pullAndFastScrollListener;
    }

    private boolean isFirstCompletelyVisible(ListView listView) {
        if (listView.getChildCount() <= 0 || listView.getFirstVisiblePosition() != 0 || listView.getChildAt(0) == null || listView.getChildAt(0).getTop() < listView.getPaddingTop()) {
            return false;
        }
        return true;
    }

    private void updateOnScrollStateChanged(AbsListView absListView, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
        if (i3 != this.mLastState) {
            this.mLastState = i3;
            if (QLog.isColorLevel()) {
                QLog.d("EmotionPanelListView", 2, "onScrollStateChanged mLastState :" + this.mLastState);
            }
        }
    }

    public void needFollowHand(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent);
            return;
        }
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener = this.pullAndFastScrollListener;
        if (pullAndFastScrollListener != null) {
            pullAndFastScrollListener.followHand(motionEvent);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
        if (isFirstCompletelyVisible(this.emotionPanelListView) && this.mLastState == 2 && this.pullAndFastScrollListener != null) {
            updateOnScrollStateChanged(absListView, 0);
        }
        this.mLastTop = this.emotionPanelListView.getListViewScrollY();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
            return;
        }
        updateOnScrollStateChanged(absListView, i3);
        if (absListView.getFirstVisiblePosition() == absListView.getCount() - 1 && i3 == 0) {
            absListView.post(new Runnable(absListView) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AbsListView val$view;

                {
                    this.val$view = absListView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelOnScrollListener.this, (Object) absListView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.val$view.smoothScrollToPosition(r0.getLastVisiblePosition() - 5);
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downY = motionEvent.getY();
            EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener3 = this.pullAndFastScrollListener;
            if (pullAndFastScrollListener3 != null) {
                this.isPanelOpen = pullAndFastScrollListener3.isPanelOpen();
            }
        } else if (action == 1 && this.isPanelOpen && !this.isPanelNeedPullUp) {
            if (isFirstCompletelyVisible(this.emotionPanelListView) && this.emotionPanelListView.getListViewScrollY() < this.mLastTop && (pullAndFastScrollListener2 = this.pullAndFastScrollListener) != null) {
                pullAndFastScrollListener2.onPullDown();
                if (QLog.isColorLevel()) {
                    QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
                }
            } else if (isFirstCompletelyVisible(this.emotionPanelListView) && motionEvent.getY() > this.downY && (pullAndFastScrollListener = this.pullAndFastScrollListener) != null) {
                pullAndFastScrollListener.onPullDown();
                if (QLog.isColorLevel()) {
                    QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
                }
            }
        } else if (action == 2 && motionEvent.getY() <= 0.0f) {
            needFollowHand(motionEvent);
            this.isPanelNeedPullUp = true;
        } else if (action == 1 && this.isPanelNeedPullUp) {
            pullUpEmoticonPanel();
            this.isPanelNeedPullUp = false;
        }
        return false;
    }

    public void pullUpEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener = this.pullAndFastScrollListener;
        if (pullAndFastScrollListener != null) {
            pullAndFastScrollListener.onPullUp();
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "needBeMaxSize");
        }
    }
}
