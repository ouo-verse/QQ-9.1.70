package com.tencent.richframework.widget.refresh.layout.listener;

import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface OnMultiListener extends OnRefreshListener, OnLoadMoreListener, OnStateChangedListener {
    void onFooterFinish(IRefreshFooter iRefreshFooter, boolean z16);

    void onFooterMoving(IRefreshFooter iRefreshFooter, boolean z16, float f16, int i3, int i16, int i17);

    void onFooterReleased(IRefreshFooter iRefreshFooter, int i3, int i16);

    void onFooterStartAnimator(IRefreshFooter iRefreshFooter, int i3, int i16);

    void onHeaderFinish(IRefreshHeader iRefreshHeader, boolean z16);

    void onHeaderMoving(IRefreshHeader iRefreshHeader, boolean z16, float f16, int i3, int i16, int i17);

    void onHeaderReleased(IRefreshHeader iRefreshHeader, int i3, int i16);

    void onHeaderStartAnimator(IRefreshHeader iRefreshHeader, int i3, int i16);
}
