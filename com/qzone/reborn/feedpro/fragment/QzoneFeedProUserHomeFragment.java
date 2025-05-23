package com.qzone.reborn.feedpro.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.feedpro.block.QzoneFeedProFeedOnlySelfBlock;
import com.qzone.reborn.feedpro.block.QzoneFeedProLoadMoreUpBlock;
import com.qzone.reborn.feedpro.block.QzoneFeedProUserHomeListBlockPart;
import com.qzone.reborn.feedpro.block.ae;
import com.qzone.reborn.feedpro.block.af;
import com.qzone.reborn.feedpro.block.j;
import com.qzone.reborn.feedpro.block.r;
import com.qzone.reborn.feedpro.block.t;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProUserHomeFragment;
import com.qzone.reborn.feedpro.viewmodel.c;
import com.qzone.reborn.feedpro.viewmodel.m;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.MainPageControl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.state.report.SquareReportConst;
import gf.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kd.d;
import kd.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import ve.i;
import wd.h;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b_\u0010`J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0012\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"`#H\u0016J\u0012\u0010%\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020'H\u0014J\b\u0010*\u001a\u00020)H\u0016J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020,0+H\u0014J\u0018\u0010.\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+H\u0014R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010R\u001a\u00020K8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010Z\u001a\u00020S8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006a"}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFeedProUserHomeFragment;", "Lcom/qzone/reborn/feedpro/fragment/QzoneBaseFeedProFragment;", "Lgf/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "contentView", "", OcrConfig.CHINESE, "initViewModel", "event", "handleHolidayRefreshEvent", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onActivityCreated", "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "getPageType", "", "enableRootViewSetFitsSystemWindows", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedpro/block/e;", "rh", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "Le", "", "", "getChildDaTongPageParams", "getChildDaTongDynamicParams", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "E", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart;", "wh", "()Lcom/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart;", "Dh", "(Lcom/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart;)V", "mListBlockPart", "Lcom/qzone/reborn/feedpro/block/af;", "G", "Lcom/qzone/reborn/feedpro/block/af;", "yh", "()Lcom/qzone/reborn/feedpro/block/af;", "Fh", "(Lcom/qzone/reborn/feedpro/block/af;)V", "questionPageBlock", "Lcom/qzone/reborn/feedpro/block/ae;", "H", "Lcom/qzone/reborn/feedpro/block/ae;", "uh", "()Lcom/qzone/reborn/feedpro/block/ae;", "Bh", "(Lcom/qzone/reborn/feedpro/block/ae;)V", "mEmptyPageBlock", "Lcom/qzone/reborn/feedpro/block/r;", "I", "Lcom/qzone/reborn/feedpro/block/r;", "vh", "()Lcom/qzone/reborn/feedpro/block/r;", "Ch", "(Lcom/qzone/reborn/feedpro/block/r;)V", "mHeaderBlock", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "J", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "xh", "()Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "Eh", "(Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;)V", "mLoadMoreUpBlock", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "K", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "mFeedOnlySelfBlock", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFeedProUserHomeFragment extends QzoneBaseFeedProFragment implements k, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private m mUserHomeViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    protected QzoneFeedProUserHomeListBlockPart mListBlockPart;

    /* renamed from: G, reason: from kotlin metadata */
    protected af questionPageBlock;

    /* renamed from: H, reason: from kotlin metadata */
    protected ae mEmptyPageBlock;

    /* renamed from: I, reason: from kotlin metadata */
    protected r mHeaderBlock;

    /* renamed from: J, reason: from kotlin metadata */
    protected QzoneFeedProLoadMoreUpBlock mLoadMoreUpBlock;

    /* renamed from: K, reason: from kotlin metadata */
    private QzoneFeedProFeedOnlySelfBlock mFeedOnlySelfBlock;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(QzoneFeedProUserHomeFragment this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleHolidayRefreshEvent(simpleBaseEvent);
    }

    private final void handleHolidayRefreshEvent(SimpleBaseEvent event) {
        RFWLog.i("QZoneBaseFragment", RFWLog.USR, "receive holiday refresh event: " + event);
        m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        if (mVar.m2()) {
            wh().refresh();
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(m.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026omeViewModel::class.java)");
        this.mUserHomeViewModel = (m) viewModel;
    }

    private final void zh(View contentView) {
        registerIoc(this, k.class);
    }

    protected final void Bh(ae aeVar) {
        Intrinsics.checkNotNullParameter(aeVar, "<set-?>");
        this.mEmptyPageBlock = aeVar;
    }

    protected final void Ch(r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<set-?>");
        this.mHeaderBlock = rVar;
    }

    protected final void Dh(QzoneFeedProUserHomeListBlockPart qzoneFeedProUserHomeListBlockPart) {
        Intrinsics.checkNotNullParameter(qzoneFeedProUserHomeListBlockPart, "<set-?>");
        this.mListBlockPart = qzoneFeedProUserHomeListBlockPart;
    }

    protected final void Eh(QzoneFeedProLoadMoreUpBlock qzoneFeedProLoadMoreUpBlock) {
        Intrinsics.checkNotNullParameter(qzoneFeedProLoadMoreUpBlock, "<set-?>");
        this.mLoadMoreUpBlock = qzoneFeedProLoadMoreUpBlock;
    }

    protected final void Fh(af afVar) {
        Intrinsics.checkNotNullParameter(afVar, "<set-?>");
        this.questionPageBlock = afVar;
    }

    @Override // com.qzone.reborn.feedpro.viewmodel.a
    public c Le() {
        m mVar = this.mUserHomeViewModel;
        if (mVar != null) {
            return mVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> c16;
        ArrayList arrayList = new ArrayList();
        Dh(new QzoneFeedProUserHomeListBlockPart(R.id.nch, buildBlockList()));
        arrayList.add(wh());
        i e16 = new i().g("2").e(getMFromDtPageId());
        m mVar = this.mUserHomeViewModel;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        i f16 = e16.h(mVar.getHostUin()).f(getChildDaTongPageParams());
        m mVar3 = this.mUserHomeViewModel;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            mVar2 = mVar3;
        }
        if (mVar2.m2()) {
            c16 = new e().c(f16);
        } else {
            c16 = new d().c(f16);
        }
        arrayList.addAll(c16);
        return arrayList;
    }

    public List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        Ch(new r(null));
        arrayList.add(vh());
        QzoneFeedProFeedOnlySelfBlock qzoneFeedProFeedOnlySelfBlock = new QzoneFeedProFeedOnlySelfBlock(null);
        this.mFeedOnlySelfBlock = qzoneFeedProFeedOnlySelfBlock;
        arrayList.add(qzoneFeedProFeedOnlySelfBlock);
        arrayList.add(new j(null, getPartManager()));
        Fh(new af(null));
        yh().setBlockVisible(false);
        arrayList.add(yh());
        Bh(new ae(null));
        uh().setBlockVisible(false);
        arrayList.add(uh());
        Eh(new QzoneFeedProLoadMoreUpBlock(null));
        xh().setBlockVisible(false);
        arrayList.add(xh());
        arrayList.add(new t(null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public com.qzone.reborn.base.c getBlockPart() {
        return wh();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        GetMainPageHeadRsp headRsp;
        MainPageControl mainPageControl;
        int coerceAtLeast;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        h value = mVar.d2().getValue();
        if (value != null && (headRsp = value.getHeadRsp()) != null && (mainPageControl = headRsp.mainPageControl) != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mainPageControl.relation - 1, 0);
            linkedHashMap.put("page_visit_state", Integer.valueOf(coerceAtLeast));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167287ci1;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_personal_homepage";
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

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QZoneHolidayRefreshFeedEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ce.d
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProUserHomeFragment.Ah(QzoneFeedProUserHomeFragment.this, event);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewModel();
        if (getActivity() != null) {
            m mVar = this.mUserHomeViewModel;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                mVar = null;
            }
            FragmentActivity activity = getActivity();
            mVar.y2(activity != null ? activity.getIntent() : null);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        zh(contentView);
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public com.qzone.reborn.feedpro.block.e rh() {
        return vh();
    }

    protected final ae uh() {
        ae aeVar = this.mEmptyPageBlock;
        if (aeVar != null) {
            return aeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyPageBlock");
        return null;
    }

    protected final r vh() {
        r rVar = this.mHeaderBlock;
        if (rVar != null) {
            return rVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderBlock");
        return null;
    }

    protected final QzoneFeedProUserHomeListBlockPart wh() {
        QzoneFeedProUserHomeListBlockPart qzoneFeedProUserHomeListBlockPart = this.mListBlockPart;
        if (qzoneFeedProUserHomeListBlockPart != null) {
            return qzoneFeedProUserHomeListBlockPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListBlockPart");
        return null;
    }

    protected final QzoneFeedProLoadMoreUpBlock xh() {
        QzoneFeedProLoadMoreUpBlock qzoneFeedProLoadMoreUpBlock = this.mLoadMoreUpBlock;
        if (qzoneFeedProLoadMoreUpBlock != null) {
            return qzoneFeedProLoadMoreUpBlock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreUpBlock");
        return null;
    }

    protected final af yh() {
        af afVar = this.questionPageBlock;
        if (afVar != null) {
            return afVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("questionPageBlock");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[5];
        m mVar = this.mUserHomeViewModel;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        pairArr[0] = TuplesKt.to("touin", Long.valueOf(mVar.getHostUin()));
        m mVar3 = this.mUserHomeViewModel;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar3 = null;
        }
        if (mVar3.m2()) {
            str = LoginData.getInstance().getUid();
        } else {
            str = "";
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
        m mVar4 = this.mUserHomeViewModel;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar4 = null;
        }
        pairArr[2] = TuplesKt.to("open_visit_state", Integer.valueOf(!mVar4.m2() ? 1 : 0));
        pairArr[3] = TuplesKt.to("is_authentication_space", 0);
        m mVar5 = this.mUserHomeViewModel;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            mVar2 = mVar5;
        }
        pairArr[4] = TuplesKt.to("authentication_account", Long.valueOf(mVar2.getHostUin()));
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
