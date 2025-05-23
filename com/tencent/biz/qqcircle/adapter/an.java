package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchBannerResultView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$StSearchBannerInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class an extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSSearchBannerResultView C;
    private boolean D;

    public an(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchBannerResultView qFSSearchBannerResultView = new QFSSearchBannerResultView(viewGroup.getContext());
        this.C = qFSSearchBannerResultView;
        return qFSSearchBannerResultView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchBannerResultBlock";
    }

    public void i0(boolean z16) {
        this.D = z16;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || i3 < 0 || list.size() <= i3 || this.C == null || !(this.mDataList.get(i3) instanceof FeedCloudRead$StSearchBannerInfo)) {
            return;
        }
        if (this.D) {
            this.C.setBackground(ie0.a.f().k(getContext(), R.color.qui_common_bg_middle_standard, 0.0f, 1000));
            this.C.setGameCollectionExist(this.D);
        } else {
            this.C.setBackground(ie0.a.f().k(getContext(), R.color.qui_common_bg_bottom_light, 0.0f, 1000));
        }
        this.C.setData((FeedCloudRead$StSearchBannerInfo) this.mDataList.get(i3));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
