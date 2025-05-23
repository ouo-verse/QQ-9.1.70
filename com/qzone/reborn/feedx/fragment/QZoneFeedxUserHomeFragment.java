package com.qzone.reborn.feedx.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.QZoneBaseFeedxFragment;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.feedx.block.QZoneMessageBoardBlock;
import com.qzone.reborn.feedx.block.ab;
import com.qzone.reborn.feedx.block.ad;
import com.qzone.reborn.feedx.block.ae;
import com.qzone.reborn.feedx.block.ag;
import com.qzone.reborn.feedx.block.ah;
import com.qzone.reborn.feedx.part.bj;
import com.qzone.reborn.feedx.part.cl;
import com.qzone.reborn.feedx.viewmodel.w;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.state.report.SquareReportConst;
import gf.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ve.i;
import ve.m;
import ve.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\bs\u0010tJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0012\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J$\u0010'\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040%0$j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040%`&H\u0016J\u0012\u0010(\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020*H\u0014J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020-0,H\u0014R\"\u00106\u001a\u00020/8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010R\u001a\u00020K8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010Z\u001a\u00020S8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010b\u001a\u00020[8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010j\u001a\u00020c8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010r\u001a\u00020k8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u00a8\u0006u"}, d2 = {"Lcom/qzone/reborn/feedx/fragment/QZoneFeedxUserHomeFragment;", "Lcom/qzone/reborn/base/QZoneBaseFeedxFragment;", "Lgf/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "contentView", "", OcrConfig.CHINESE, "initViewModel", "", "Ah", "event", "handleHolidayRefreshEvent", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onActivityCreated", "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "getPageType", "enableRootViewSetFitsSystemWindows", "Ltc/b;", "getFeedxViewModel", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedx/block/b;", "getHeaderBlock", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Lcom/qzone/reborn/feedx/block/QZoneMessageBoardBlock;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/block/QZoneMessageBoardBlock;", "xh", "()Lcom/qzone/reborn/feedx/block/QZoneMessageBoardBlock;", "Ih", "(Lcom/qzone/reborn/feedx/block/QZoneMessageBoardBlock;)V", "mMessageBoardBlock", "Lcom/qzone/reborn/feedx/viewmodel/w;", "D", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/part/cl;", "E", "Lcom/qzone/reborn/feedx/part/cl;", "vh", "()Lcom/qzone/reborn/feedx/part/cl;", "Gh", "(Lcom/qzone/reborn/feedx/part/cl;)V", "mListBlockPart", "Lcom/qzone/reborn/feedx/block/ag;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/block/ag;", "th", "()Lcom/qzone/reborn/feedx/block/ag;", "Eh", "(Lcom/qzone/reborn/feedx/block/ag;)V", "mFeedListBlockPart", "Lcom/qzone/reborn/feedx/block/k;", "G", "Lcom/qzone/reborn/feedx/block/k;", "rh", "()Lcom/qzone/reborn/feedx/block/k;", "Ch", "(Lcom/qzone/reborn/feedx/block/k;)V", "mEmptyPageBlock", "Lcom/qzone/reborn/feedx/block/ae;", "H", "Lcom/qzone/reborn/feedx/block/ae;", "uh", "()Lcom/qzone/reborn/feedx/block/ae;", "Fh", "(Lcom/qzone/reborn/feedx/block/ae;)V", "mHeaderBlock", "Lcom/qzone/reborn/feedx/block/ah;", "I", "Lcom/qzone/reborn/feedx/block/ah;", "yh", "()Lcom/qzone/reborn/feedx/block/ah;", "Jh", "(Lcom/qzone/reborn/feedx/block/ah;)V", "mTopEntranceBlock", "Lcom/qzone/reborn/feedx/block/ad;", "J", "Lcom/qzone/reborn/feedx/block/ad;", "sh", "()Lcom/qzone/reborn/feedx/block/ad;", "Dh", "(Lcom/qzone/reborn/feedx/block/ad;)V", "mEntranceBlock", "Lcom/qzone/reborn/feedx/block/ab;", "K", "Lcom/qzone/reborn/feedx/block/ab;", "wh", "()Lcom/qzone/reborn/feedx/block/ab;", "Hh", "(Lcom/qzone/reborn/feedx/block/ab;)V", "mLoadMoreUpBlock", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFeedxUserHomeFragment extends QZoneBaseFeedxFragment implements k, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    protected QZoneMessageBoardBlock mMessageBoardBlock;

    /* renamed from: D, reason: from kotlin metadata */
    private w mUserHomeViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    protected cl mListBlockPart;

    /* renamed from: F, reason: from kotlin metadata */
    protected ag mFeedListBlockPart;

    /* renamed from: G, reason: from kotlin metadata */
    protected com.qzone.reborn.feedx.block.k mEmptyPageBlock;

    /* renamed from: H, reason: from kotlin metadata */
    protected ae mHeaderBlock;

    /* renamed from: I, reason: from kotlin metadata */
    protected ah mTopEntranceBlock;

    /* renamed from: J, reason: from kotlin metadata */
    protected ad mEntranceBlock;

    /* renamed from: K, reason: from kotlin metadata */
    protected ab mLoadMoreUpBlock;

    private final boolean Ah() {
        w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        return wVar.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(QZoneFeedxUserHomeFragment this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleHolidayRefreshEvent(simpleBaseEvent);
    }

    private final void handleHolidayRefreshEvent(SimpleBaseEvent event) {
        RFWLog.i("QZoneBaseFragment", RFWLog.USR, "receive holiday refresh event: " + event);
        w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.M2()) {
            vh().refresh();
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneUserHomeViewModel::class.java)");
        this.mUserHomeViewModel = (w) viewModel;
    }

    private final void zh(View contentView) {
        registerIoc(this, k.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ch(com.qzone.reborn.feedx.block.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.mEmptyPageBlock = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Dh(ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "<set-?>");
        this.mEntranceBlock = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Eh(ag agVar) {
        Intrinsics.checkNotNullParameter(agVar, "<set-?>");
        this.mFeedListBlockPart = agVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Fh(ae aeVar) {
        Intrinsics.checkNotNullParameter(aeVar, "<set-?>");
        this.mHeaderBlock = aeVar;
    }

    protected final void Gh(cl clVar) {
        Intrinsics.checkNotNullParameter(clVar, "<set-?>");
        this.mListBlockPart = clVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Hh(ab abVar) {
        Intrinsics.checkNotNullParameter(abVar, "<set-?>");
        this.mLoadMoreUpBlock = abVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ih(QZoneMessageBoardBlock qZoneMessageBoardBlock) {
        Intrinsics.checkNotNullParameter(qZoneMessageBoardBlock, "<set-?>");
        this.mMessageBoardBlock = qZoneMessageBoardBlock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jh(ah ahVar) {
        Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
        this.mTopEntranceBlock = ahVar;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> c16;
        ArrayList arrayList = new ArrayList();
        Gh(new cl(R.id.nch, buildBlockList()));
        arrayList.add(vh());
        i e16 = new i().g("2").e(getTabReportPageId());
        w wVar = this.mUserHomeViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        i f16 = e16.h(wVar.getMUin()).f(getChildDaTongPageParams());
        w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar3 = null;
        }
        if (wVar3.M2()) {
            c16 = new n().c(f16);
            Intrinsics.checkNotNullExpressionValue(c16, "{\n            QZoneUserH\u2026eParts(builder)\n        }");
        } else {
            c16 = new m().c(f16);
            Intrinsics.checkNotNullExpressionValue(c16, "{\n            QZoneUserH\u2026eParts(builder)\n        }");
        }
        arrayList.addAll(c16);
        w wVar4 = this.mUserHomeViewModel;
        if (wVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar4;
        }
        arrayList.add(new com.qzone.reborn.feedx.part.e(wVar2.getMUin()));
        if (Ah()) {
            arrayList.add(new bj());
        }
        return arrayList;
    }

    public List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        Fh(new ae(null));
        arrayList.add(uh());
        Jh(new ah(null));
        arrayList.add(yh());
        Dh(new ad(null));
        arrayList.add(sh());
        Ih(new QZoneMessageBoardBlock(null));
        arrayList.add(xh());
        Ch(new com.qzone.reborn.feedx.block.k(null));
        rh().setBlockVisible(false);
        arrayList.add(rh());
        Hh(new ab(null));
        wh().setBlockVisible(false);
        arrayList.add(wh());
        Eh(new ag(null));
        arrayList.add(th());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.base.c getBlockPart() {
        return vh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ci7;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_personal_homepage";
    }

    @Override // com.qzone.reborn.feedx.viewmodel.a
    public tc.b getFeedxViewModel() {
        w wVar = this.mUserHomeViewModel;
        if (wVar != null) {
            return wVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.feedx.block.b getHeaderBlock() {
        return uh();
    }

    @Override // gf.k
    public int getPageType() {
        return 3;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QZoneHolidayRefreshFeedEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.fragment.e
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxUserHomeFragment.Bh(QZoneFeedxUserHomeFragment.this, event);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewModel();
        if (getActivity() != null) {
            w wVar = this.mUserHomeViewModel;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                wVar = null;
            }
            FragmentActivity activity = getActivity();
            wVar.b3(activity != null ? activity.getIntent() : null);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        zh(contentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.reborn.feedx.block.k rh() {
        com.qzone.reborn.feedx.block.k kVar = this.mEmptyPageBlock;
        if (kVar != null) {
            return kVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyPageBlock");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ad sh() {
        ad adVar = this.mEntranceBlock;
        if (adVar != null) {
            return adVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEntranceBlock");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ag th() {
        ag agVar = this.mFeedListBlockPart;
        if (agVar != null) {
            return agVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedListBlockPart");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ae uh() {
        ae aeVar = this.mHeaderBlock;
        if (aeVar != null) {
            return aeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderBlock");
        return null;
    }

    protected final cl vh() {
        cl clVar = this.mListBlockPart;
        if (clVar != null) {
            return clVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListBlockPart");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ab wh() {
        ab abVar = this.mLoadMoreUpBlock;
        if (abVar != null) {
            return abVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreUpBlock");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZoneMessageBoardBlock xh() {
        QZoneMessageBoardBlock qZoneMessageBoardBlock = this.mMessageBoardBlock;
        if (qZoneMessageBoardBlock != null) {
            return qZoneMessageBoardBlock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMessageBoardBlock");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ah yh() {
        ah ahVar = this.mTopEntranceBlock;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTopEntranceBlock");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[4];
        w wVar = this.mUserHomeViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        pairArr[0] = TuplesKt.to("touin", Long.valueOf(wVar.getMUin()));
        w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar3 = null;
        }
        if (wVar3.M2()) {
            str = LoginData.getInstance().getUid();
        } else {
            str = "";
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
        w wVar4 = this.mUserHomeViewModel;
        if (wVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar4;
        }
        pairArr[2] = TuplesKt.to("open_visit_state", Integer.valueOf(!wVar2.M2() ? 1 : 0));
        pairArr[3] = TuplesKt.to("is_authentication_space", 0);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneHolidayRefreshFeedEvent.class);
        return arrayListOf;
    }
}
