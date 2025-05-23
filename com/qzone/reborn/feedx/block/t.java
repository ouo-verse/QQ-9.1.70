package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.qzone.reborn.feedx.widget.entrance.QZoneFeedxTopEntranceManagerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends com.qzone.reborn.base.m {

    /* renamed from: m, reason: collision with root package name */
    private QZoneFeedxTopEntranceManagerView f54793m;

    public t(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QZoneFeedxTopEntranceManagerView qZoneFeedxTopEntranceManagerView = new QZoneFeedxTopEntranceManagerView(getActivity());
        this.f54793m = qZoneFeedxTopEntranceManagerView;
        return qZoneFeedxTopEntranceManagerView;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneFeedxTopEntranceManagerView qZoneFeedxTopEntranceManagerView = this.f54793m;
        if (qZoneFeedxTopEntranceManagerView != null) {
            qZoneFeedxTopEntranceManagerView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QZoneFeedxTopEntranceManagerView qZoneFeedxTopEntranceManagerView = this.f54793m;
        if (qZoneFeedxTopEntranceManagerView != null) {
            qZoneFeedxTopEntranceManagerView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QZoneFeedxTopEntranceManagerView qZoneFeedxTopEntranceManagerView = this.f54793m;
        if (qZoneFeedxTopEntranceManagerView != null) {
            qZoneFeedxTopEntranceManagerView.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
