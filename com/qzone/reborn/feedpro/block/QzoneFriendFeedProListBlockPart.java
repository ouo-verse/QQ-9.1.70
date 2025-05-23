package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.model.CoverCacheData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001HB#\u0012\u0006\u0010B\u001a\u00020\u0015\u0012\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010C0\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J,\u0010\u000e\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0014R\u0018\u0010(\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00102\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFriendFeedProListBlockPart;", "Lcom/qzone/reborn/feedpro/block/d;", "", "X9", LocaleUtils.L_JAPANESE, "ha", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "listUIStateData", "ba", "aa", "data", "uiStateData", "ca", "", "isVisible", "la", "ia", "Lcooperation/qzone/model/CoverCacheData;", "cacheData", "", "Y9", "ga", "", "getLogTag", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "onRefreshListener", "W9", "onPartDestroy", "Lcom/qzone/reborn/feedpro/block/ab;", "Z9", "f", "Lcom/qzone/reborn/feedpro/block/ab;", "mFeedListBlock", "Lcom/qzone/reborn/feedpro/viewmodel/p;", tl.h.F, "Lcom/qzone/reborn/feedpro/viewmodel/p;", "mFeedDataViewModel", "Lcom/qzone/reborn/feedx/viewmodel/f;", "i", "Lcom/qzone/reborn/feedx/viewmodel/f;", "mCoverViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsItemDecorationSetup", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView;", "mRefreshHeader", "Lcom/qzone/reborn/feedx/widget/g;", "D", "Lcom/qzone/reborn/feedx/widget/g;", "mDividerView", "Lcom/qzone/reborn/feedpro/block/i;", "E", "Lcom/qzone/reborn/feedpro/block/i;", "mEmptyPageBlock", UserInfo.SEX_FEMALE, "mHasRecoveryLastFeedIndex", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedProListBlockPart extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProRefreshHeaderView mRefreshHeader;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.widget.g mDividerView;

    /* renamed from: E, reason: from kotlin metadata */
    private i mEmptyPageBlock;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mHasRecoveryLastFeedIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ab mFeedListBlock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.p mFeedDataViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.f mCoverViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/block/QzoneFriendFeedProListBlockPart$b", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "", "offSet", "sumOffSet", "", "a", "", "onRelease", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneFeedxRefreshView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.feedpro.viewmodel.n f53881a;

        b(com.qzone.reborn.feedpro.viewmodel.n nVar) {
            this.f53881a = nVar;
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public boolean a(float offSet, float sumOffSet) {
            return this.f53881a.O1(offSet, sumOffSet);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            this.f53881a.P1();
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/qzone/reborn/feedpro/block/QzoneFriendFeedProListBlockPart$c", "Lcom/qzone/reborn/feedpro/viewmodel/e;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.qzone.reborn.feedpro.viewmodel.e {
        c() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProListBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (this.mFeedListBlock != null && this.mEmptyPageBlock != null) {
                break;
            }
            if (multiViewBlock instanceof ab) {
                this.mFeedListBlock = (ab) multiViewBlock;
            } else if (multiViewBlock instanceof i) {
                this.mEmptyPageBlock = (i) multiViewBlock;
            }
        }
        ab abVar = this.mFeedListBlock;
        if (abVar != null) {
            Intrinsics.checkNotNull(abVar);
            abVar.setHasStableIds(true);
        }
    }

    private final void X9() {
        RFWLog.i("QZoneFriendFeedxListBlockPart", RFWLog.USR, "try to clearExtraActiveCountInfo when resume");
        com.qzone.reborn.feedx.util.j jVar = com.qzone.reborn.feedx.util.j.f55760a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (jVar.o(activity)) {
            RFWLog.i("QZoneFriendFeedxListBlockPart", RFWLog.USR, "clearExtraActiveCountInfo when resume");
            jVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Y9(CoverCacheData cacheData) {
        return getActivity().getResources().getColor(R.color.qui_common_border_standard);
    }

    private final void aa() {
        i iVar = this.mEmptyPageBlock;
        if (iVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wd.e eVar = new wd.e();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.c(context2));
            eVar.f(pl.a.f426446a.j() + ef.d.b(104));
            eVar.e(true);
            Unit unit = Unit.INSTANCE;
            iVar.n0(context, eVar);
        }
        i iVar2 = this.mEmptyPageBlock;
        if (iVar2 != null) {
            iVar2.setBlockVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ga() {
        if (QZoneConfigHelper.C() && com.qzone.reborn.feedpro.viewmodel.p.I > 1) {
            O9(com.qzone.reborn.feedpro.viewmodel.p.I, true, com.qzone.reborn.feedpro.viewmodel.p.J - QZoneFeedxViewUtils.e(getActivity()));
            com.qzone.reborn.feedpro.viewmodel.p.INSTANCE.b();
        }
    }

    private final void ha() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = new QzoneFeedProRefreshHeaderView(context, null, 0, 6, null);
        this.mRefreshHeader = qzoneFeedProRefreshHeaderView;
        this.mBlockContainer.setRefreshHeader(qzoneFeedProRefreshHeaderView);
    }

    private final void ia() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, d.f53896e, Y9(null));
        this.mDividerView = gVar;
        Intrinsics.checkNotNull(gVar);
        gVar.f(false);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        com.qzone.reborn.feedx.widget.g gVar2 = this.mDividerView;
        Intrinsics.checkNotNull(gVar2);
        recyclerView.addItemDecoration(gVar2);
    }

    private final void ja() {
        com.qzone.reborn.feedpro.viewmodel.n nVar = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        W9(new b(nVar));
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = this.mRefreshHeader;
        if (qzoneFeedProRefreshHeaderView != null) {
            qzoneFeedProRefreshHeaderView.setRefreshProgressProvider(nVar.U1());
        }
        com.qzone.reborn.feedpro.viewmodel.p pVar = this.mFeedDataViewModel;
        if (pVar != null) {
            pVar.Q1(new c());
        }
    }

    private final void la(boolean isVisible) {
        i iVar = this.mEmptyPageBlock;
        if (iVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wd.e eVar = new wd.e();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.c(context2));
            eVar.f(pl.a.f426446a.j() + ef.d.b(104));
            Unit unit = Unit.INSTANCE;
            iVar.n0(context, eVar);
        }
        i iVar2 = this.mEmptyPageBlock;
        if (iVar2 != null) {
            iVar2.setBlockVisible(isVisible);
        }
    }

    public final void W9(QZoneFeedxRefreshView.b onRefreshListener) {
        Intrinsics.checkNotNullParameter(onRefreshListener, "onRefreshListener");
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = this.mRefreshHeader;
        if (qzoneFeedProRefreshHeaderView != null) {
            qzoneFeedProRefreshHeaderView.c(onRefreshListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.block.d
    /* renamed from: Z9, reason: from getter and merged with bridge method [inline-methods] */
    public ab G9() {
        return this.mFeedListBlock;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedxListBlockPart";
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<CoverCacheData> N1;
        MutableLiveData<UIStateData<List<CommonFeed>>> N12;
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        com.qzone.reborn.feedpro.viewmodel.p pVar = (com.qzone.reborn.feedpro.viewmodel.p) getViewModel(com.qzone.reborn.feedpro.viewmodel.p.class);
        this.mFeedDataViewModel = pVar;
        if (pVar != null && (N12 = pVar.N1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFriendFeedProListBlockPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonFeed>> uIStateData) {
                    invoke2((UIStateData<List<CommonFeed>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<CommonFeed>> uIStateData) {
                    QzoneFriendFeedProListBlockPart.this.ba(uIStateData);
                }
            };
            N12.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.block.ac
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFriendFeedProListBlockPart.da(Function1.this, obj);
                }
            });
        }
        ha();
        com.qzone.reborn.feedx.viewmodel.f fVar = (com.qzone.reborn.feedx.viewmodel.f) getViewModel(com.qzone.reborn.feedx.viewmodel.f.class);
        this.mCoverViewModel = fVar;
        if (fVar != null && (N1 = fVar.N1()) != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<CoverCacheData, Unit> function12 = new Function1<CoverCacheData, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFriendFeedProListBlockPart$onInitView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CoverCacheData coverCacheData) {
                    invoke2(coverCacheData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CoverCacheData coverCacheData) {
                    com.qzone.reborn.feedx.widget.g gVar;
                    com.qzone.reborn.feedx.widget.g gVar2;
                    int Y9;
                    BlockContainer blockContainer;
                    gVar = QzoneFriendFeedProListBlockPart.this.mDividerView;
                    if (gVar != null) {
                        gVar2 = QzoneFriendFeedProListBlockPart.this.mDividerView;
                        Intrinsics.checkNotNull(gVar2);
                        Y9 = QzoneFriendFeedProListBlockPart.this.Y9(coverCacheData);
                        gVar2.g(Y9);
                        blockContainer = ((BlockPart) QzoneFriendFeedProListBlockPart.this).mBlockContainer;
                        blockContainer.invalidate();
                    }
                }
            };
            N1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedpro.block.ad
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFriendFeedProListBlockPart.ea(Function1.this, obj);
                }
            });
        }
        ja();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.qzone.reborn.feedpro.viewmodel.p.INSTANCE.a(this.mBlockContainer);
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            Intrinsics.checkNotNull(blockContainer, "null cannot be cast to non-null type com.qzone.reborn.base.QZoneBaseBlockContainer");
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(UIStateData<List<CommonFeed>> listUIStateData) {
        if (listUIStateData == null || this.mFeedListBlock == null) {
            return;
        }
        QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() state" + listUIStateData.getState());
        int state = listUIStateData.getState();
        boolean z16 = false;
        if (state == 0) {
            QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() return empty data");
            ab abVar = this.mFeedListBlock;
            if (abVar != null) {
                abVar.notifyLoadingComplete(false);
                return;
            }
            return;
        }
        if (state == 2 || state == 3) {
            ab abVar2 = this.mFeedListBlock;
            if (abVar2 != null) {
                abVar2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            ca(listUIStateData.getData(), listUIStateData);
            com.qzone.reborn.feedpro.viewmodel.p pVar = this.mFeedDataViewModel;
            if (pVar != null && pVar.getNeedRefresh()) {
                z16 = true;
            }
            if (z16 || this.mHasRecoveryLastFeedIndex) {
                return;
            }
            this.mHasRecoveryLastFeedIndex = true;
            ga();
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        ab abVar3 = this.mFeedListBlock;
        if (abVar3 != null) {
            abVar3.notifyLoadingComplete(false);
        }
        aa();
    }

    private final void ca(List<CommonFeed> data, UIStateData<List<CommonFeed>> uiStateData) {
        if (data == null) {
            return;
        }
        la(ArrayUtils.isOutOfArrayIndex(0, data));
        if (this.mFeedListBlock == null) {
            this.mFeedListBlock = new ab(null);
        }
        com.qzone.reborn.feedpro.utils.w.f54369a.b(data, uiStateData);
        QLog.d(getTAG(), 1, "handleSuccessState, size=" + data.size());
        ab abVar = this.mFeedListBlock;
        if (abVar != null) {
            abVar.setDatas(data);
        }
        ia();
    }
}
