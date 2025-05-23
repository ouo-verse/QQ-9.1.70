package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.pymk.QFSLayerFeedPYMKUserCardItemView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> {
    private FeedCloudMeta$StFeed C;

    /* renamed from: m, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f84721m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
            View view = this.itemView;
            if (!(view instanceof QFSLayerFeedPYMKUserCardItemView)) {
                return;
            }
            ((QFSLayerFeedPYMKUserCardItemView) view).setFeed(feedCloudMeta$StFeed);
            ((QFSLayerFeedPYMKUserCardItemView) this.itemView).bindData(qQCircleDitto$StItemInfo, i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<QQCircleDitto$StItemInfo> list = this.f84721m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void i0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.C = feedCloudMeta$StFeed;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if ((viewHolder instanceof a) && i3 <= 2 && i3 <= this.f84721m.size() && this.f84721m.get(i3) != null) {
            View view = viewHolder.itemView;
            if (view instanceof QCircleBaseWidgetView) {
                ((QCircleBaseWidgetView) view).setCacheReportBean(getReportBean());
            }
            ((a) viewHolder).l(this.C, this.f84721m.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSLayerFeedPYMKUserCardItemView qFSLayerFeedPYMKUserCardItemView = new QFSLayerFeedPYMKUserCardItemView(viewGroup.getContext());
        qFSLayerFeedPYMKUserCardItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new a(qFSLayerFeedPYMKUserCardItemView);
    }

    public void setData(List<QQCircleDitto$StItemInfo> list) {
        notifyItemRangeRemoved(0, this.f84721m.size());
        this.f84721m.clear();
        this.f84721m.addAll(list);
        notifyItemRangeInserted(0, this.f84721m.size());
    }
}
