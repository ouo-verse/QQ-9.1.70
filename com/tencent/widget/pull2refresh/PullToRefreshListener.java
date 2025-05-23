package com.tencent.widget.pull2refresh;

import android.view.View;

/* loaded from: classes27.dex */
public interface PullToRefreshListener {
    void onNotCompleteVisable(View view, int i3);

    void onRefreshCompleted(View view, boolean z16);

    void onViewCompleteVisable(View view);

    boolean onViewCompleteVisableAndReleased(View view);

    void onViewNotCompleteVisableAndReleased(View view);
}
