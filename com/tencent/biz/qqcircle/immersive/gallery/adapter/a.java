package com.tencent.biz.qqcircle.immersive.gallery.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryPreItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import feedcloud.FeedCloudMeta$StImage;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseListViewAdapter<FeedCloudMeta$StImage> {
    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (!ab0.a.a(i3, getDataList())) {
            ((QFSGalleryPreItemView) viewHolder.itemView).setData(getDataList().get(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListViewAdapter.BaseVH(new QFSGalleryPreItemView(viewGroup.getContext()));
    }
}
