package com.tencent.richframework.widget.refresh.layout.simple;

import androidx.annotation.NonNull;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SimpleMultiListener implements OnMultiListener {
    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NonNull IRefreshLayout iRefreshLayout) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
    public void onRefresh(@NonNull IRefreshLayout iRefreshLayout) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterFinish(IRefreshFooter iRefreshFooter, boolean z16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderFinish(IRefreshHeader iRefreshHeader, boolean z16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterReleased(IRefreshFooter iRefreshFooter, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterStartAnimator(IRefreshFooter iRefreshFooter, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderReleased(IRefreshHeader iRefreshHeader, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderStartAnimator(IRefreshHeader iRefreshHeader, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterMoving(IRefreshFooter iRefreshFooter, boolean z16, float f16, int i3, int i16, int i17) {
    }
}
