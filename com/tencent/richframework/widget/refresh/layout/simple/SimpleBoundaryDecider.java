package com.tencent.richframework.widget.refresh.layout.simple;

import android.graphics.PointF;
import android.view.View;
import com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SimpleBoundaryDecider implements ScrollBoundaryDecider {
    public ScrollBoundaryDecider boundary;
    public PointF mActionEvent;
    public boolean mEnableLoadMoreWhenContentNotFull = true;

    @Override // com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider
    public boolean canLoadMore(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.boundary;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.canLoadMore(view);
        }
        return SmartUtil.canLoadMore(view, this.mActionEvent, this.mEnableLoadMoreWhenContentNotFull);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider
    public boolean canRefresh(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.boundary;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.canRefresh(view);
        }
        return SmartUtil.canRefresh(view, this.mActionEvent);
    }
}
