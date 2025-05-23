package com.qzone.reborn.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.b;
import com.qzone.reborn.feedx.part.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.PartManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/base/QZoneBaseFeedxFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lcom/qzone/reborn/feedx/viewmodel/a;", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedAfterPartInit", "", "hasFocus", "onWindowFocusChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onPostThemeChanged", "onFragmentViewDestroyed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/richframework/part/PartManager;", "getPartManager", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedx/block/b;", "getHeaderBlock", "Lcom/qzone/reborn/feedx/part/ar;", "mQZoneFeedxPartManager", "Lcom/qzone/reborn/feedx/part/ar;", "Lcom/qzone/reborn/feedx/viewmodel/b;", "mLifecycleCallback", "Lcom/qzone/reborn/feedx/viewmodel/b;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneBaseFeedxFragment extends QZoneBaseFragment implements com.qzone.reborn.feedx.viewmodel.a {
    private com.qzone.reborn.feedx.viewmodel.b mLifecycleCallback;
    private ar mQZoneFeedxPartManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0013"}, d2 = {"com/qzone/reborn/base/QZoneBaseFeedxFragment$a", "Lcom/qzone/reborn/feedx/viewmodel/b;", "", "p4", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "loadType", "j7", "i6", "Lcom/qzone/common/business/result/QZoneResult;", "result", "v0", "i5", "f7", "Landroid/os/Message;", "msg", "onHandleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements com.qzone.reborn.feedx.viewmodel.b {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void f7(QZoneResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.b(result);
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.c(result);
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.a();
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void j7(List<? extends BusinessFeedData> feedsData, int loadType) {
            Intrinsics.checkNotNullParameter(feedsData, "feedsData");
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.g(feedsData, loadType);
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.e(msg2);
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void p4() {
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.d();
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ar arVar = QZoneBaseFeedxFragment.this.mQZoneFeedxPartManager;
            if (arVar != null) {
                arVar.f(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreatedAfterPartInit$lambda$0(QZoneBaseFeedxFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFeedxViewModel().O1();
    }

    public abstract c getBlockPart();

    public abstract com.qzone.reborn.feedx.block.b getHeaderBlock();

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public PartManager getPartManager() {
        if (this.mQZoneFeedxPartManager == null) {
            this.mQZoneFeedxPartManager = new ar(this, getFragmentContentView());
        }
        return this.mQZoneFeedxPartManager;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        com.qzone.reborn.feedx.block.b headerBlock = getHeaderBlock();
        if (headerBlock != null) {
            headerBlock.j0(newConfig);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tc.b feedxViewModel = getFeedxViewModel();
        if (feedxViewModel != null) {
            feedxViewModel.L1();
        }
        com.qzone.reborn.feedx.widget.picmixvideo.a.b(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        if (this.mLifecycleCallback != null) {
            tc.b feedxViewModel = getFeedxViewModel();
            com.qzone.reborn.feedx.viewmodel.b bVar = this.mLifecycleCallback;
            Intrinsics.checkNotNull(bVar);
            feedxViewModel.m2(bVar);
        }
        this.mLifecycleCallback = null;
        this.mQZoneFeedxPartManager = null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        com.qzone.reborn.feedx.block.b headerBlock = getHeaderBlock();
        if (headerBlock != null) {
            headerBlock.onPostThemeChanged();
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
            blockMerger.k0(new b.a() { // from class: com.qzone.reborn.base.e
                @Override // com.qzone.reborn.base.b.a
                public final void S() {
                    QZoneBaseFeedxFragment.onViewCreatedAfterPartInit$lambda$0(QZoneBaseFeedxFragment.this);
                }
            });
        }
        this.mLifecycleCallback = new a();
        tc.b feedxViewModel = getFeedxViewModel();
        com.qzone.reborn.feedx.viewmodel.b bVar = this.mLifecycleCallback;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.IQZoneFeedxLifecycle");
        feedxViewModel.k2(bVar);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        com.qzone.reborn.feedx.block.b headerBlock = getHeaderBlock();
        if (headerBlock != null) {
            headerBlock.k0(hasFocus);
        }
    }
}
