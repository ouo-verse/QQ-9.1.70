package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ah extends com.qzone.reborn.base.m {

    /* renamed from: m, reason: collision with root package name */
    private QZoneHomePageTopEntrancePanelView f54771m;

    public ah(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QZoneHomePageTopEntrancePanelView qZoneHomePageTopEntrancePanelView = new QZoneHomePageTopEntrancePanelView(getActivity(), getParentFragment(), this);
        this.f54771m = qZoneHomePageTopEntrancePanelView;
        return qZoneHomePageTopEntrancePanelView;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QZoneHomePageTopEntrancePanelView qZoneHomePageTopEntrancePanelView = this.f54771m;
        if (qZoneHomePageTopEntrancePanelView != null) {
            qZoneHomePageTopEntrancePanelView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
