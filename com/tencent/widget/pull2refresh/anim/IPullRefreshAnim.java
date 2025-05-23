package com.tencent.widget.pull2refresh.anim;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes27.dex */
public interface IPullRefreshAnim {
    int getPullRefreshAreaHeight();

    View getRefreshView(ViewGroup viewGroup);

    void onPullRefreshComplete(boolean z16);

    void onPullRefreshing(int i3, boolean z16);

    void onTouchPullDistance(int i3, int i16);

    void showPullRefresh();

    void showRefreshResult(boolean z16, String str);
}
