package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedpro.viewmodel.QzoneFeedProMoodListViewModel;
import com.qzone.reborn.feedpro.viewmodel.b;
import com.qzone.reborn.feedx.block.QZoneLoadingStateBlock;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001HB#\u0012\u0006\u0010B\u001a\u00020\u0016\u0012\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010C0\b\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J&\u0010\u0014\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0014R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListBlockPart;", "Lcom/qzone/reborn/feedpro/block/d;", "Lcom/qzone/common/event/IObserver$main;", "", "initViewModel", "aa", "da", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "listUIStateData", "X9", "", "errorMsg", "W9", "Z9", "", "isVisible", "ga", "isFinish", "Y9", "ea", "", "V9", "Landroid/view/View;", "mRootView", "onInitView", "Lcom/qzone/common/event/Event;", "event", "onEventUIThread", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lvd/b;", "G9", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListAdapter;", "f", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListAdapter;", "mFeedListAdapter", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", tl.h.F, "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "mFeedOnlySelfBlock", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "i", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "mFeedDataViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsItemDecorationSetup", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView;", "mRefreshHeader", "Lcom/qzone/reborn/feedx/widget/g;", "D", "Lcom/qzone/reborn/feedx/widget/g;", "mDividerView", "Lcom/qzone/reborn/feedpro/block/i;", "E", "Lcom/qzone/reborn/feedpro/block/i;", "mEmptyPageBlock", "Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock;", "mLoadingStateBlock", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMoodListBlockPart extends d implements IObserver.main {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneFeedxRefreshView mRefreshHeader;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.widget.g mDividerView;

    /* renamed from: E, reason: from kotlin metadata */
    private i mEmptyPageBlock;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneLoadingStateBlock mLoadingStateBlock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProMoodListAdapter mFeedListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProFeedOnlySelfBlock mFeedOnlySelfBlock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProMoodListViewModel mFeedDataViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMoodListBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (this.mFeedListAdapter != null && this.mEmptyPageBlock != null) {
                return;
            }
            if (multiViewBlock instanceof QzoneFeedProMoodListAdapter) {
                this.mFeedListAdapter = (QzoneFeedProMoodListAdapter) multiViewBlock;
            } else if (multiViewBlock instanceof i) {
                this.mEmptyPageBlock = (i) multiViewBlock;
            } else if (multiViewBlock instanceof QZoneLoadingStateBlock) {
                this.mLoadingStateBlock = (QZoneLoadingStateBlock) multiViewBlock;
            } else if (multiViewBlock instanceof QzoneFeedProFeedOnlySelfBlock) {
                this.mFeedOnlySelfBlock = (QzoneFeedProFeedOnlySelfBlock) multiViewBlock;
            }
        }
    }

    private final int V9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private final void W9(String errorMsg) {
        List<CommonFeed> dataList;
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter = this.mFeedListAdapter;
        boolean z16 = false;
        if (qzoneFeedProMoodListAdapter != null && (dataList = qzoneFeedProMoodListAdapter.getDataList()) != null && (!dataList.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        i iVar = this.mEmptyPageBlock;
        if (iVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wd.e eVar = new wd.e();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.d(context2));
            eVar.f(ef.d.b(156));
            eVar.e(true);
            Unit unit = Unit.INSTANCE;
            iVar.n0(context, eVar);
        }
        i iVar2 = this.mEmptyPageBlock;
        if (iVar2 != null) {
            iVar2.setBlockVisible(true);
        }
    }

    private final void aa() {
        EventCenter.getInstance().addUIObserver(this, "Feed", 25);
        EventCenter.getInstance().addUIObserver(this, "Feed", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void da() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        QZoneFeedxRefreshView qZoneFeedxRefreshView = new QZoneFeedxRefreshView(getContext());
        this.mRefreshHeader = qZoneFeedxRefreshView;
        this.mBlockContainer.setRefreshHeader(qZoneFeedxRefreshView);
    }

    private final void ea() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, d.f53896e, V9());
        this.mDividerView = gVar;
        Intrinsics.checkNotNull(gVar);
        gVar.f(false);
        com.qzone.reborn.feedx.widget.g gVar2 = this.mDividerView;
        Intrinsics.checkNotNull(gVar2);
        gVar2.e(false);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        com.qzone.reborn.feedx.widget.g gVar3 = this.mDividerView;
        Intrinsics.checkNotNull(gVar3);
        recyclerView.addItemDecoration(gVar3);
    }

    private final void ga(boolean isVisible) {
        i iVar = this.mEmptyPageBlock;
        if (iVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wd.e eVar = new wd.e();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.d(context2));
            eVar.f(ef.d.b(156));
            Unit unit = Unit.INSTANCE;
            iVar.n0(context, eVar);
        }
        i iVar2 = this.mEmptyPageBlock;
        if (iVar2 != null) {
            iVar2.setBlockVisible(isVisible);
        }
    }

    private final void initViewModel() {
        MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1;
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = (QzoneFeedProMoodListViewModel) getViewModel(QzoneFeedProMoodListViewModel.class);
        this.mFeedDataViewModel = qzoneFeedProMoodListViewModel;
        if (qzoneFeedProMoodListViewModel != null && (N1 = qzoneFeedProMoodListViewModel.N1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProMoodListBlockPart$initViewModel$1
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
                    QzoneFeedProMoodListBlockPart.this.X9(uIStateData);
                }
            };
            N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.block.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProMoodListBlockPart.ba(Function1.this, obj);
                }
            });
        }
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel2 = this.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel2 == null || (O1 = qzoneFeedProMoodListViewModel2.O1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function12 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProMoodListBlockPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
            
                r3 = r2.this$0.mLoadingStateBlock;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
            
                r3 = r2.this$0.mLoadingStateBlock;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                QZoneLoadingStateBlock qZoneLoadingStateBlock;
                QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel3;
                QZoneLoadingStateBlock qZoneLoadingStateBlock2;
                b.Companion companion = com.qzone.reborn.feedpro.viewmodel.b.INSTANCE;
                if (Intrinsics.areEqual(bVar, companion.c())) {
                    qzoneFeedProMoodListViewModel3 = QzoneFeedProMoodListBlockPart.this.mFeedDataViewModel;
                    boolean z16 = false;
                    if (qzoneFeedProMoodListViewModel3 != null && qzoneFeedProMoodListViewModel3.c2()) {
                        z16 = true;
                    }
                    if (!z16 || qZoneLoadingStateBlock2 == null) {
                        return;
                    }
                    qZoneLoadingStateBlock2.n0();
                    return;
                }
                if (!Intrinsics.areEqual(bVar, companion.d()) || qZoneLoadingStateBlock == null) {
                    return;
                }
                qZoneLoadingStateBlock.n0();
            }
        };
        O1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedpro.block.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProMoodListBlockPart.ca(Function1.this, obj);
            }
        });
    }

    @Override // com.qzone.reborn.feedpro.block.d
    protected vd.b<?> G9() {
        return this.mFeedListAdapter;
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel;
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = event.what;
        if (i3 != 2) {
            if (i3 != 25) {
                return;
            }
            broadcastMessage("SCROLL_TO_TOP", null);
        } else {
            if (!Intrinsics.areEqual("TimerShuoShuo", event.source.getName()) || (qzoneFeedProMoodListViewModel = this.mFeedDataViewModel) == null) {
                return;
            }
            qzoneFeedProMoodListViewModel.X1();
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        initViewModel();
        da();
        aa();
        QzoneFeedProFeedOnlySelfBlock qzoneFeedProFeedOnlySelfBlock = this.mFeedOnlySelfBlock;
        if (qzoneFeedProFeedOnlySelfBlock != null) {
            QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
            qzoneFeedProFeedOnlySelfBlock.n0(qzoneFeedProMoodListViewModel != null ? qzoneFeedProMoodListViewModel.Z1() : null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            Intrinsics.checkNotNull(blockContainer, "null cannot be cast to non-null type com.qzone.reborn.base.QZoneBaseBlockContainer");
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel != null) {
            qzoneFeedProMoodListViewModel.R1();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    private final void Y9(UIStateData<List<CommonFeed>> listUIStateData, boolean isFinish) {
        Object lastOrNull;
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter;
        if (listUIStateData == null || listUIStateData.getData() == null || !isFinish) {
            return;
        }
        List<CommonFeed> data = listUIStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) data);
        CommonFeed commonFeed = (CommonFeed) lastOrNull;
        boolean z16 = false;
        if (commonFeed != null && !CommonFeedExtKt.isMemorySealFeed(commonFeed)) {
            z16 = true;
        }
        if (z16 || (qzoneFeedProMoodListAdapter = this.mFeedListAdapter) == null) {
            return;
        }
        Intrinsics.checkNotNull(qzoneFeedProMoodListAdapter);
        if (qzoneFeedProMoodListAdapter.getBlockMerger() == null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter2 = this.mFeedListAdapter;
        Intrinsics.checkNotNull(qzoneFeedProMoodListAdapter2);
        qzoneFeedProMoodListAdapter2.getBlockMerger().setCustomNoMoreDataView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(UIStateData<List<CommonFeed>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        QLog.e("QzoneFeedProMoodListBlockPart", 1, "handleFeedListRsp() state" + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            QLog.e("QzoneFeedProMoodListBlockPart", 1, "handleFeedListRsp() return empty data");
            QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter = this.mFeedListAdapter;
            if (qzoneFeedProMoodListAdapter != null) {
                qzoneFeedProMoodListAdapter.notifyLoadingComplete(false);
                return;
            }
            return;
        }
        if (state == 2 || state == 3) {
            QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter2 = this.mFeedListAdapter;
            if (qzoneFeedProMoodListAdapter2 != null) {
                qzoneFeedProMoodListAdapter2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            Z9(listUIStateData);
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QzoneFeedProMoodListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter3 = this.mFeedListAdapter;
        if (qzoneFeedProMoodListAdapter3 != null) {
            qzoneFeedProMoodListAdapter3.notifyLoadingComplete(false);
        }
        String msg2 = listUIStateData.getMsg();
        if (msg2 == null) {
            msg2 = "";
        }
        W9(msg2);
    }

    private final void Z9(UIStateData<List<CommonFeed>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        List<CommonFeed> data = listUIStateData.getData();
        boolean isFinish = listUIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        ga(ArrayUtils.isOutOfArrayIndex(0, data));
        if (this.mEmptyPageBlock != null && !bl.b(data)) {
            i iVar = this.mEmptyPageBlock;
            Intrinsics.checkNotNull(iVar);
            iVar.setBlockVisible(false);
        }
        if (this.mFeedListAdapter == null) {
            this.mFeedListAdapter = new QzoneFeedProMoodListAdapter(null);
        }
        Y9(listUIStateData, isFinish);
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter = this.mFeedListAdapter;
        if (qzoneFeedProMoodListAdapter != null) {
            qzoneFeedProMoodListAdapter.setDatas(new ArrayList(data));
        }
        ea();
    }
}
