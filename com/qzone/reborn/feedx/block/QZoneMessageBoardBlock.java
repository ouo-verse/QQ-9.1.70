package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.widget.homepage.QZoneMessageBoardView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/feedx/block/QZoneMessageBoardBlock;", "Lcom/qzone/reborn/base/m;", "", "s0", "", "q0", "r0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/content/BroadcastReceiver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/BroadcastReceiver;", "mOpenMessageBoardReceiver", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneMessageBoardView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/homepage/QZoneMessageBoardView;", "mMessageBoardView", "Lcom/qzone/reborn/feedx/viewmodel/w;", "D", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneMessageBoardBlock extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneMessageBoardView mMessageBoardView;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mOpenMessageBoardReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/block/QZoneMessageBoardBlock$b", "Lcom/qzone/reborn/feedx/viewmodel/g;", "", "i6", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneMessageBoardBlock.this.q0();
            if (QZoneMessageBoardBlock.this.s0()) {
                QZoneMessageBoardBlock.this.r0();
            }
        }
    }

    public QZoneMessageBoardBlock(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        if (this.mMessageBoardView == null) {
            this.mMessageBoardView = new QZoneMessageBoardView(getActivity(), getParentFragment(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        this.mOpenMessageBoardReceiver = new QZoneMessageBoardBlock$initBroadcast$1(this);
        if (getActivity() != null) {
            getActivity().registerReceiver(this.mOpenMessageBoardReceiver, new IntentFilter("QzoneUserHome.ACTION_openMsgBoard"));
            if (com.qzone.proxy.feedcomponent.util.j.g()) {
                com.qzone.proxy.feedcomponent.util.j.f("QZoneMessageBoardBlock", "mOpenMessageBoardReceiver registerReceiver");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        return wVar.M2();
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        q0();
        QZoneMessageBoardView qZoneMessageBoardView = this.mMessageBoardView;
        Intrinsics.checkNotNull(qZoneMessageBoardView);
        return qZoneMessageBoardView;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneUserHomeViewModel");
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
        this.mUserHomeViewModel = wVar;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.k2(new b());
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneMessageBoardView qZoneMessageBoardView = this.mMessageBoardView;
        if (qZoneMessageBoardView != null) {
            qZoneMessageBoardView.onDestroy();
        }
        if (getActivity() == null || this.mOpenMessageBoardReceiver == null) {
            return;
        }
        getActivity().unregisterReceiver(this.mOpenMessageBoardReceiver);
        this.mOpenMessageBoardReceiver = null;
        if (com.qzone.proxy.feedcomponent.util.j.g()) {
            com.qzone.proxy.feedcomponent.util.j.f("QZoneMessageBoardBlock", "mOpenMessageBoardReceiver unregisterReceiver");
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        QZoneMessageBoardView qZoneMessageBoardView;
        if (requestCode != 2 || (qZoneMessageBoardView = this.mMessageBoardView) == null) {
            return;
        }
        qZoneMessageBoardView.x0(requestCode, resultCode, data);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
