package com.tencent.widget.pull2refresh.anim;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IAnimManager extends IPullRefreshAnim {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnRefreshPullDistanceListener {
        void onPullDistance(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface PullRefreshComplete {
        void pullRefreshComplete(boolean z16);
    }

    void endOfRefresh();

    boolean isSkinAnimManager();

    void onDestroy();

    void onPullRefreshCancel();

    boolean onTouchEvent(MotionEvent motionEvent);

    void registerRefreshCompleteListener(PullRefreshComplete pullRefreshComplete);

    void setRefreshPullDistanceListener(OnRefreshPullDistanceListener onRefreshPullDistanceListener);
}
