package com.qzone.reborn.feedpro.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.base.b;
import com.qzone.reborn.base.c;
import com.qzone.reborn.feedpro.block.e;
import com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment;
import com.qzone.reborn.feedpro.part.n;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneBaseFeedProFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lcom/qzone/reborn/feedpro/viewmodel/a;", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedAfterPartInit", "", "hasFocus", "onWindowFocusChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onPostThemeChanged", "onFragmentViewDestroyed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/richframework/part/PartManager;", "getPartManager", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedpro/block/e;", "rh", "Lcom/qzone/reborn/feedpro/part/n;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/part/n;", "feedProPartManager", "Lcom/qzone/reborn/feedpro/part/a;", "D", "Lcom/qzone/reborn/feedpro/part/a;", "lifecycleCallback", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneBaseFeedProFragment extends QZoneBaseFragment implements com.qzone.reborn.feedpro.viewmodel.a {

    /* renamed from: C, reason: from kotlin metadata */
    private n feedProPartManager;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.part.a lifecycleCallback;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/fragment/QzoneBaseFeedProFragment$a", "Lcom/qzone/reborn/feedpro/part/a;", "", "c9", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements com.qzone.reborn.feedpro.part.a {
        a() {
        }

        @Override // com.qzone.reborn.feedpro.part.a
        public void c9() {
            n nVar = QzoneBaseFeedProFragment.this.feedProPartManager;
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QzoneBaseFeedProFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Le().L1();
    }

    public abstract c getBlockPart();

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public PartManager getPartManager() {
        if (this.feedProPartManager == null) {
            this.feedProPartManager = new n(this, getFragmentContentView());
        }
        return this.feedProPartManager;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        e rh5 = rh();
        if (rh5 != null) {
            rh5.j0(newConfig);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.qzone.reborn.feedpro.viewmodel.c Le = Le();
        if (Le != null) {
            Le.R1();
        }
        com.qzone.reborn.feedx.widget.picmixvideo.a.b(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        if (this.lifecycleCallback != null) {
            com.qzone.reborn.feedpro.viewmodel.c Le = Le();
            com.qzone.reborn.feedpro.part.a aVar = this.lifecycleCallback;
            Intrinsics.checkNotNull(aVar);
            Le.T1(aVar);
        }
        this.lifecycleCallback = null;
        this.feedProPartManager = null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        e rh5 = rh();
        if (rh5 != null) {
            rh5.onPostThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        b blockMerger;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        QZoneBaseBlockContainer blockContainer = getBlockPart().getBlockContainer();
        if (blockContainer != null && (blockMerger = blockContainer.getBlockMerger()) != null) {
            blockMerger.k0(new b.a() { // from class: ce.a
                @Override // com.qzone.reborn.base.b.a
                public final void S() {
                    QzoneBaseFeedProFragment.sh(QzoneBaseFeedProFragment.this);
                }
            });
        }
        a aVar = new a();
        this.lifecycleCallback = aVar;
        Le().Q1(aVar);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        e rh5 = rh();
        if (rh5 != null) {
            rh5.k0(hasFocus);
        }
    }

    public abstract e rh();
}
