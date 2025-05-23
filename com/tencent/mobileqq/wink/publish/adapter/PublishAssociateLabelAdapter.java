package com.tencent.mobileqq.wink.publish.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.wink.publish.part.af;
import com.tencent.mobileqq.wink.publish.widget.PublishAssociateTagWidget;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.List;

/* loaded from: classes21.dex */
public class PublishAssociateLabelAdapter extends com.tencent.mobileqq.wink.publish.adapter.a<FeedCloudMeta$StTagInfo> {
    private static final int D = ImmersiveUtils.dpToPx(44.0f);
    private RecyclerView C;

    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(Object obj, int i3) {
            View view = this.itemView;
            if (view instanceof PublishAssociateTagWidget) {
                ((PublishAssociateTagWidget) view).setData(obj, i3);
            }
        }
    }

    public PublishAssociateLabelAdapter(Bundle bundle) {
        super(bundle);
    }

    private void i0() {
        RecyclerView recyclerView = this.C;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                this.C.post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.adapter.PublishAssociateLabelAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PublishAssociateLabelAdapter.this.notifyDataSetChanged();
                    }
                });
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void addData(List<FeedCloudMeta$StTagInfo> list) {
        List<E> list2 = this.mDataList;
        list2.addAll(list2.size(), list);
        i0();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void clearData() {
        this.mDataList.clear();
        i0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void j0(RecyclerView recyclerView) {
        this.C = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.mDataList.size() > i3 && (viewHolder instanceof a)) {
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = (FeedCloudMeta$StTagInfo) this.mDataList.get(i3);
            ((a) viewHolder).l(feedCloudMeta$StTagInfo, i3);
            af.P9(viewHolder.itemView, feedCloudMeta$StTagInfo.tagName.get(), feedCloudMeta$StTagInfo.tagType.get());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        PublishAssociateTagWidget publishAssociateTagWidget = new PublishAssociateTagWidget(getContext());
        publishAssociateTagWidget.setLayoutParams(new ViewGroup.LayoutParams(-1, D));
        return new a(publishAssociateTagWidget);
    }

    public void setData(List<FeedCloudMeta$StTagInfo> list) {
        if (list != null) {
            this.mDataList.clear();
            i0();
            this.mDataList.addAll(list);
            i0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
