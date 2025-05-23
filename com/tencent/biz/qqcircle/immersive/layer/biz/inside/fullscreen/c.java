package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFullScreenVideoItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.ad.QFSLayerFullScreenAdVideoItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.immersive.adapter.m {
    public c(Fragment fragment) {
        super(fragment);
    }

    private View L0(ViewGroup viewGroup, int i3) {
        QFSLayerFullScreenAdVideoItemView qFSLayerFullScreenAdVideoItemView = new QFSLayerFullScreenAdVideoItemView(viewGroup.getContext(), i3);
        qFSLayerFullScreenAdVideoItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerFullScreenAdVideoItemView.setReportBean(getReportBean());
        return qFSLayerFullScreenAdVideoItemView;
    }

    private View M0(ViewGroup viewGroup, int i3) {
        QFSLayerFullScreenVideoItemView qFSLayerFullScreenVideoItemView = new QFSLayerFullScreenVideoItemView(viewGroup.getContext(), i3);
        qFSLayerFullScreenVideoItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerFullScreenVideoItemView.setReportBean(getReportBean());
        return qFSLayerFullScreenVideoItemView;
    }

    private View N0(ViewGroup viewGroup, int i3) {
        QCircleDefaultFeedItemView qCircleDefaultFeedItemView = new QCircleDefaultFeedItemView(viewGroup.getContext(), i3);
        qCircleDefaultFeedItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return qCircleDefaultFeedItemView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m
    protected View D0(ViewGroup viewGroup, int i3) {
        if (i3 == -1008) {
            return M0(viewGroup, i3);
        }
        if (i3 == -1009) {
            return L0(viewGroup, i3);
        }
        return N0(viewGroup, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() != null && !ab0.a.a(i3, getDataList())) {
            return com.tencent.biz.qqcircle.immersive.adapter.n.d(getDataList().get(i3).g());
        }
        QLog.d("QFSFullScreenLayerPageAdapter", 1, "getItemViewType() return ITEM_ACTIVE_FEED_FULL_SCREEN");
        return -1008;
    }
}
