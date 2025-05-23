package com.tencent.biz.richframework.part;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public interface IRefreshViewProvider {

    /* loaded from: classes5.dex */
    public interface OnRefreshListener {
        String getRefreshUpdateTips();

        void onRefresh();
    }

    void callRefresh(RecyclerView recyclerView);

    View getRefreshView();

    void handleRefreshGesture(MotionEvent motionEvent);

    /* renamed from: isRefresh */
    boolean getIsManualRefreshing();

    void onDestroy();

    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    void setRefreshing(boolean z16);

    void setState(int i3);
}
