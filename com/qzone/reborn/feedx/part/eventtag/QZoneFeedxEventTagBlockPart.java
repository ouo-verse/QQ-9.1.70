package com.qzone.reborn.feedx.part.eventtag;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.block.QZoneFeedxEventTagListAdapter;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001%\u0018\u0000 .2\u00020\u0001:\u0001/B#\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010*0\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagBlockPart;", "Lcom/qzone/reborn/base/d;", "", "X9", "", "R9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "listUIStateData", "S9", "data", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "U9", "position", "T9", "Lwe/b;", "C9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "e", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mFeedViewModel", "Lcom/qzone/reborn/feedx/viewmodel/r;", "f", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/block/QZoneFeedxEventTagListAdapter;", tl.h.F, "Lcom/qzone/reborn/feedx/block/QZoneFeedxEventTagListAdapter;", "mEventTagListAdapter", "com/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagBlockPart$b", "i", "Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagBlockPart$b;", "mScrollListener", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagBlockPart extends com.qzone.reborn.base.d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxEventTagViewModel mFeedViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxEventTagListAdapter mEventTagListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b mScrollListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagBlockPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            StaggeredGridLayoutManager staggeredGridLayoutManager = layoutManager instanceof StaggeredGridLayoutManager ? (StaggeredGridLayoutManager) layoutManager : null;
            if (staggeredGridLayoutManager == null) {
                return;
            }
            int[] iArr = new int[2];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(iArr[0], iArr[1]);
            if (coerceAtMost <= QZoneFeedxEventTagBlockPart.this.R9()) {
                staggeredGridLayoutManager.invalidateSpanAssignments();
                QLog.i("QZoneFeedxEventTagBlockPart", 2, "invalidateSpanAssignments occur!");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxEventTagBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (Object obj : peerBlocks) {
            if (((MultiViewBlock) obj) instanceof QZoneFeedxEventTagListAdapter) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.feedx.block.QZoneFeedxEventTagListAdapter");
                this.mEventTagListAdapter = (QZoneFeedxEventTagListAdapter) obj;
                this.mScrollListener = new b();
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R9() {
        List<BusinessFeedData> dataList;
        QZoneFeedxEventTagListAdapter qZoneFeedxEventTagListAdapter = this.mEventTagListAdapter;
        if (qZoneFeedxEventTagListAdapter == null || (dataList = qZoneFeedxEventTagListAdapter.getDataList()) == null) {
            return 0;
        }
        Iterator<BusinessFeedData> it = dataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(UIStateData<List<BusinessFeedData>> listUIStateData) {
        QZoneFeedxEventTagListAdapter qZoneFeedxEventTagListAdapter;
        Intrinsics.checkNotNull(listUIStateData);
        int state = listUIStateData.getState();
        if (state == 0) {
            QZoneFeedxEventTagListAdapter qZoneFeedxEventTagListAdapter2 = this.mEventTagListAdapter;
            if (qZoneFeedxEventTagListAdapter2 != null) {
                qZoneFeedxEventTagListAdapter2.notifyLoadingComplete(false);
                return;
            }
            return;
        }
        if (state == 2 || state == 3) {
            QZoneFeedxEventTagListAdapter qZoneFeedxEventTagListAdapter3 = this.mEventTagListAdapter;
            if (qZoneFeedxEventTagListAdapter3 != null) {
                qZoneFeedxEventTagListAdapter3.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            U9(listUIStateData.getData(), listUIStateData.getIsLoadMore());
            return;
        }
        if (state == 4 && (qZoneFeedxEventTagListAdapter = this.mEventTagListAdapter) != null) {
            qZoneFeedxEventTagListAdapter.notifyLoadingComplete(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(int position) {
        if (this.mBlockContainer.getRecyclerView() != null && (this.mBlockContainer.getRecyclerView().getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            this.mBlockContainer.getRecyclerView().stopScroll();
            RecyclerView.LayoutManager layoutManager = this.mBlockContainer.getRecyclerView().getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(position, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9() {
        BlockContainer blockContainer = this.mBlockContainer;
        blockContainer.setEnableLoadMore(true);
        blockContainer.setEnableRefresh(false);
        blockContainer.setParentFragment(getHostFragment());
        blockContainer.setLayoutManagerType(3, 2);
        blockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        blockContainer.getBlockMerger().setStaggeredRemainCountToTriggerPreload(6);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setOverScrollMode(2);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        defaultItemAnimator.setChangeDuration(0L);
        recyclerView.setItemAnimator(defaultItemAnimator);
        QZoneFeedxEventTagListAdapter.Companion companion = QZoneFeedxEventTagListAdapter.INSTANCE;
        recyclerView.setPadding(companion.a(), companion.a(), companion.a(), companion.a());
        recyclerView.setRecycledViewPool(new com.qzone.reborn.feedx.util.b());
    }

    @Override // com.qzone.reborn.base.d
    protected we.b<?> C9() {
        return this.mEventTagListAdapter;
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        super.onInitView(mRootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (com.qzone.reborn.feedx.viewmodel.r) viewModel;
        ViewModel viewModel2 = getViewModel(QZoneFeedxEventTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneFeedxE\u2026TagViewModel::class.java)");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) viewModel2;
        this.mFeedViewModel = qZoneFeedxEventTagViewModel;
        com.qzone.reborn.feedx.viewmodel.r rVar = null;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        MutableLiveData<UIStateData<List<BusinessFeedData>>> x26 = qZoneFeedxEventTagViewModel.x2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends BusinessFeedData>>, Unit> function1 = new Function1<UIStateData<List<? extends BusinessFeedData>>, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagBlockPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends BusinessFeedData>> uIStateData) {
                invoke2((UIStateData<List<BusinessFeedData>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<BusinessFeedData>> uIStateData) {
                QZoneFeedxEventTagBlockPart.this.S9(uIStateData);
            }
        };
        x26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagBlockPart.V9(Function1.this, obj);
            }
        });
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = this.mFeedViewModel;
        if (qZoneFeedxEventTagViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedViewModel");
            qZoneFeedxEventTagViewModel2 = null;
        }
        MutableLiveData<Boolean> y26 = qZoneFeedxEventTagViewModel2.y2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagBlockPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isScrollTop) {
                Intrinsics.checkNotNullExpressionValue(isScrollTop, "isScrollTop");
                if (isScrollTop.booleanValue()) {
                    QZoneFeedxEventTagBlockPart.this.T9(0);
                }
            }
        };
        y26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagBlockPart.W9(Function1.this, obj);
            }
        });
        com.qzone.reborn.feedx.viewmodel.r rVar2 = this.mScrollViewModel;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
        } else {
            rVar = rVar2;
        }
        rVar.N1(this.mScrollListener);
        X9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mFeedViewModel;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        qZoneFeedxEventTagViewModel.L1();
    }

    private final void U9(List<? extends BusinessFeedData> data, boolean isLoadMore) {
        if (data == null) {
            return;
        }
        if (this.mEventTagListAdapter == null) {
            this.mEventTagListAdapter = new QZoneFeedxEventTagListAdapter(null);
        }
        QZoneFeedxEventTagListAdapter qZoneFeedxEventTagListAdapter = this.mEventTagListAdapter;
        if (qZoneFeedxEventTagListAdapter != null) {
            qZoneFeedxEventTagListAdapter.setDatas(data);
        }
    }
}
