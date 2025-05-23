package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailAdBlockView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends com.qzone.reborn.base.m {
    private BusinessFeedData C;

    /* renamed from: m, reason: collision with root package name */
    private QZoneFeedxDetailAdBlockView f54776m;

    public g(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QZoneFeedxDetailAdBlockView qZoneFeedxDetailAdBlockView = new QZoneFeedxDetailAdBlockView(viewGroup.getContext());
        this.f54776m = qZoneFeedxDetailAdBlockView;
        qZoneFeedxDetailAdBlockView.setHostActivity(getActivity());
        return this.f54776m;
    }

    public void l0(BusinessFeedData businessFeedData) {
        this.C = businessFeedData;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        QZoneFeedxDetailAdBlockView qZoneFeedxDetailAdBlockView = this.f54776m;
        if (qZoneFeedxDetailAdBlockView != null) {
            qZoneFeedxDetailAdBlockView.setData(this.C, i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneFeedxDetailAdBlockView qZoneFeedxDetailAdBlockView = this.f54776m;
        if (qZoneFeedxDetailAdBlockView != null) {
            qZoneFeedxDetailAdBlockView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QZoneFeedxDetailAdBlockView qZoneFeedxDetailAdBlockView = this.f54776m;
        if (qZoneFeedxDetailAdBlockView != null) {
            qZoneFeedxDetailAdBlockView.v0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QZoneFeedxDetailAdBlockView qZoneFeedxDetailAdBlockView = this.f54776m;
        if (qZoneFeedxDetailAdBlockView != null) {
            qZoneFeedxDetailAdBlockView.w0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
