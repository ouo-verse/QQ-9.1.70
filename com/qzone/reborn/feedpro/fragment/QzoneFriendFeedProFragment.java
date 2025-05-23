package com.qzone.reborn.feedpro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.app.ResourcePreloader;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.reborn.feedpro.block.QzoneFriendFeedProListBlockPart;
import com.qzone.reborn.feedpro.block.QzoneFriendFeedProPublishEntranceBlock;
import com.qzone.reborn.feedpro.block.ab;
import com.qzone.reborn.feedpro.block.i;
import com.qzone.reborn.feedpro.block.l;
import com.qzone.reborn.feedpro.block.y;
import com.qzone.reborn.feedpro.fragment.QzoneFriendFeedProFragment;
import com.qzone.reborn.feedpro.viewmodel.c;
import com.qzone.reborn.feedpro.viewmodel.p;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pad.d;
import com.tencent.mobileqq.pad.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import gf.k;
import ho.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lg.g;
import mqq.app.Constants;
import nd.a;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001bJ\b\u0010!\u001a\u00020 H\u0014J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020$H\u0014J\b\u0010&\u001a\u00020\u0007H\u0017J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020)H\u0016J\n\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010-\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040/\u0018\u00010.H\u0016J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020$H\u0016J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020\u0007H\u0016R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFriendFeedProFragment;", "Lcom/qzone/reborn/feedpro/fragment/QzoneBaseFeedProFragment;", "Lgf/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/pad/f;", "Lcom/tencent/mobileqq/pad/d;", "", "initViewModel", "Landroid/content/Intent;", "intent", "parseIntent", "event", "handleRefreshEvent", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onActivityCreated", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "newIntent", "onNewIntent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getDaTongPageId", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "Le", "", "enableRootViewSetFitsSystemWindows", "initIoc", "getPageType", "getReportPageId", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedpro/block/e;", "rh", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "qOnBackPressed", "qOnNewIntent", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "onPostThemeChanged", "Lcom/qzone/reborn/feedpro/block/QzoneFriendFeedProListBlockPart;", "E", "Lcom/qzone/reborn/feedpro/block/QzoneFriendFeedProListBlockPart;", "mListBlockPart", "Lcom/qzone/reborn/feedpro/viewmodel/p;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/p;", "mFeedDataViewModel", "Lcom/qzone/reborn/feedpro/block/y;", "G", "Lcom/qzone/reborn/feedpro/block/y;", "mHeaderBlock", "Lcom/qzone/reborn/feedpro/block/l;", "H", "Lcom/qzone/reborn/feedpro/block/l;", "hotBannerBlock", "Lcom/qzone/reborn/feedpro/block/ab;", "I", "Lcom/qzone/reborn/feedpro/block/ab;", "mFeedListBlock", "Lcom/qzone/reborn/feedpro/block/i;", "J", "Lcom/qzone/reborn/feedpro/block/i;", "mEmptyPageBlock", "Lnd/a;", "K", "Lnd/a;", "hotBannerManagerIoc", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFriendFeedProFragment extends QzoneBaseFeedProFragment implements k, SimpleEventReceiver<SimpleBaseEvent>, f, d {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFriendFeedProListBlockPart mListBlockPart;

    /* renamed from: F, reason: from kotlin metadata */
    private p mFeedDataViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private y mHeaderBlock;

    /* renamed from: H, reason: from kotlin metadata */
    private l hotBannerBlock;

    /* renamed from: I, reason: from kotlin metadata */
    private ab mFeedListBlock;

    /* renamed from: J, reason: from kotlin metadata */
    private i mEmptyPageBlock;

    /* renamed from: K, reason: from kotlin metadata */
    private a hotBannerManagerIoc;

    private final void handleRefreshEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.qzone.reborn.event.QZoneFeedxRefreshEvent");
        QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = (QZoneFeedxRefreshEvent) event;
        if ((qZoneFeedxRefreshEvent.getContext() == null || qZoneFeedxRefreshEvent.getContext() == getActivity()) && this.mListBlockPart != null) {
            RFWLog.d("QzoneFriendFeedProFragment", RFWLog.USR, "receive a refresh event, context: " + qZoneFeedxRefreshEvent.getContext() + ", scrollToTop: " + qZoneFeedxRefreshEvent.getIsScrollToTop());
            QzoneFriendFeedProListBlockPart qzoneFriendFeedProListBlockPart = this.mListBlockPart;
            if (qzoneFriendFeedProListBlockPart != null) {
                qzoneFriendFeedProListBlockPart.P9();
            }
        }
    }

    private final void initViewModel() {
        p pVar = (p) getViewModel(p.class);
        this.mFeedDataViewModel = pVar;
        if (pVar != null) {
            FragmentActivity activity = getActivity();
            pVar.setContextHashCode(activity != null ? activity.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(QzoneFriendFeedProFragment this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleRefreshEvent(simpleBaseEvent);
    }

    @Override // com.qzone.reborn.feedpro.viewmodel.a
    public c Le() {
        return this.mFeedDataViewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QzoneFriendFeedProListBlockPart qzoneFriendFeedProListBlockPart = new QzoneFriendFeedProListBlockPart(R.id.n2d, buildBlockList());
        this.mListBlockPart = qzoneFriendFeedProListBlockPart;
        Intrinsics.checkNotNull(qzoneFriendFeedProListBlockPart);
        arrayList.add(qzoneFriendFeedProListBlockPart);
        arrayList.addAll(new kd.f().c(new ve.i().e(getMFromDtPageId())));
        return arrayList;
    }

    public final List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        y yVar = new y(null);
        this.mHeaderBlock = yVar;
        Intrinsics.checkNotNull(yVar);
        arrayList.add(yVar);
        arrayList.add(new QzoneFriendFeedProPublishEntranceBlock(null));
        l lVar = new l(null);
        this.hotBannerBlock = lVar;
        Intrinsics.checkNotNull(lVar);
        arrayList.add(lVar);
        i iVar = new i(null);
        this.mEmptyPageBlock = iVar;
        Intrinsics.checkNotNull(iVar);
        arrayList.add(iVar);
        ab abVar = new ab(null);
        this.mFeedListBlock = abVar;
        Intrinsics.checkNotNull(abVar);
        arrayList.add(abVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public com.qzone.reborn.base.c getBlockPart() {
        QzoneFriendFeedProListBlockPart qzoneFriendFeedProListBlockPart = this.mListBlockPart;
        Intrinsics.checkNotNull(qzoneFriendFeedProListBlockPart);
        return qzoneFriendFeedProListBlockPart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ci8;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_bas_social_updates";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxRefreshEvent.class);
        return arrayList;
    }

    @Override // gf.k
    public int getPageType() {
        return 1;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 12;
    }

    public void initIoc() {
        registerIoc(this, k.class);
        l lVar = this.hotBannerBlock;
        if (lVar != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            pd.a aVar = new pd.a(requireActivity, lVar);
            this.hotBannerManagerIoc = aVar;
            registerIoc(aVar, a.class);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        p pVar = this.mFeedDataViewModel;
        if (pVar != null) {
            pVar.j2(System.currentTimeMillis());
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        g.f414459a.k(System.currentTimeMillis());
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        p pVar = this.mFeedDataViewModel;
        if (pVar != null) {
            pVar.m2(newIntent);
        }
        p pVar2 = this.mFeedDataViewModel;
        if (pVar2 != null) {
            pVar2.Z1();
        }
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        if (getActivity() != null && pl.a.f426446a.A() && com.qzone.reborn.configx.g.f53821a.b().n0()) {
            QLog.i("QzoneFriendFeedProFragment", 1, "recreateFriendFeedWhenThemeChange");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            e j3 = ho.i.j();
            FragmentActivity activity2 = getActivity();
            FragmentActivity activity3 = getActivity();
            j3.a(activity2, activity3 != null ? activity3.getIntent() : null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QZoneFeedxRefreshEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ce.e
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFriendFeedProFragment.uh(QzoneFriendFeedProFragment.this, event);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        syncLoginStatus();
        ResourcePreloader.b().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        QLog.d("QzoneFriendFeedProFragment", 1, "contentView.getContext: " + contentView.getContext());
        initIoc();
        initViewModel();
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            parseIntent(activity != null ? activity.getIntent() : null);
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public com.qzone.reborn.feedpro.block.e rh() {
        return this.mHeaderBlock;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return true;
    }

    private final void parseIntent(Intent intent) {
        p pVar;
        if (intent == null || (pVar = this.mFeedDataViewModel) == null) {
            return;
        }
        pVar.m2(intent);
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}
