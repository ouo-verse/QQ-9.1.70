package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedPropItemView;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        private QFSLayerFeedPropItemView E;

        public a(@NonNull QFSLayerFeedPropItemView qFSLayerFeedPropItemView) {
            super(qFSLayerFeedPropItemView);
            this.E = qFSLayerFeedPropItemView;
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).E.setData(getDataList().get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(new QFSLayerFeedPropItemView(viewGroup.getContext()));
    }
}
