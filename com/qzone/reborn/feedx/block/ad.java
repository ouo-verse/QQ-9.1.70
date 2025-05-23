package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.widget.homepage.QZoneHomePageEntrancePanelView;
import com.tencent.biz.richframework.part.BaseListAdapterIOCKt;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/block/ad;", "Lcom/qzone/reborn/base/m;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "onBackEvent", "Lcom/qzone/reborn/feedx/viewmodel/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageEntrancePanelView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageEntrancePanelView;", "mUserHomeEntranceView", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneHomePageEntrancePanelView mUserHomeEntranceView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    public ad(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QZoneHomePageEntrancePanelView qZoneHomePageEntrancePanelView = new QZoneHomePageEntrancePanelView(getActivity(), getParentFragment(), this);
        this.mUserHomeEntranceView = qZoneHomePageEntrancePanelView;
        return qZoneHomePageEntrancePanelView;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean onBackEvent() {
        QZoneHomePageEntrancePanelView qZoneHomePageEntrancePanelView = this.mUserHomeEntranceView;
        boolean z16 = false;
        if (qZoneHomePageEntrancePanelView != null && qZoneHomePageEntrancePanelView.u0()) {
            z16 = true;
        }
        if (z16) {
            QZoneHomePageEntrancePanelView qZoneHomePageEntrancePanelView2 = this.mUserHomeEntranceView;
            if (qZoneHomePageEntrancePanelView2 != null) {
                qZoneHomePageEntrancePanelView2.q0();
            }
            return true;
        }
        gf.l lVar = (gf.l) BaseListAdapterIOCKt.getIocInterface(this, gf.l.class);
        if (lVar != null && lVar.R7()) {
            lVar.e3();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneUserHomeViewModel");
        this.mUserHomeViewModel = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneHomePageEntrancePanelView qZoneHomePageEntrancePanelView = this.mUserHomeEntranceView;
        if (qZoneHomePageEntrancePanelView != null) {
            qZoneHomePageEntrancePanelView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
