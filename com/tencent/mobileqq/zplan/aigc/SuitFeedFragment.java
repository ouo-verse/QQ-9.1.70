package com.tencent.mobileqq.zplan.aigc;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b*\u0001I\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010+\u001a\u0004\b;\u0010<R\u001b\u0010@\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b?\u0010<R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010GR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010GR&\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00030Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitFeedFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$b;", "", "initView", OcrConfig.CHINESE, "Ch", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "", "enableRootViewSetFitsSystemWindows", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onBackPressed", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel;", "viewModel", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "D", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mLayoutManager", "E", "Z", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "G", "getParentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "H", "wh", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "backGroundPag", "Landroid/widget/ImageView;", "I", "xh", "()Landroid/widget/ImageView;", "backGroundPng", "J", "yh", "liuhaiMask", "Lzd3/a;", "K", "Lzd3/a;", "dtReporter", "Lkotlin/Function0;", "L", "Lkotlin/jvm/functions/Function0;", "onItemCreateClick", "com/tencent/mobileqq/zplan/aigc/SuitFeedFragment$d", "M", "Lcom/tencent/mobileqq/zplan/aigc/SuitFeedFragment$d;", "likeDataCallback", "N", "refreshCallback", "P", "onContractClick", "Lkotlin/Function2;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/jvm/functions/Function2;", "itemViewClickCallBack", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitFeedFragment extends ImmersivePartFragment implements SuitParentFragment.b {

    /* renamed from: C, reason: from kotlin metadata */
    private SuitFeedViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private StaggeredGridLayoutManager mLayoutManager;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isTest = true;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy parentView;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy backGroundPag;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy backGroundPng;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy liuhaiMask;

    /* renamed from: K, reason: from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: L, reason: from kotlin metadata */
    private final Function0<Unit> onItemCreateClick;

    /* renamed from: M, reason: from kotlin metadata */
    private final d likeDataCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private final Function0<Unit> refreshCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private final Function0<Unit> onContractClick;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Function2<Integer, Long, Unit> itemViewClickCallBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitFeedFragment$b", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$b;", "", PreloadTRTCPlayerParams.KEY_SIG, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements SuitFeedViewModel.b {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel.b
        public void a(String sig) {
            RecyclerView.Adapter adapter = SuitFeedFragment.this.getRecyclerView().getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
            ((be3.a) adapter).A0(sig);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitFeedFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            zd3.a aVar;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0 || (aVar = SuitFeedFragment.this.dtReporter) == null) {
                return;
            }
            aVar.B(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            boolean contains;
            boolean contains2;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            StaggeredGridLayoutManager staggeredGridLayoutManager = SuitFeedFragment.this.mLayoutManager;
            if (staggeredGridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                staggeredGridLayoutManager = null;
            }
            int[] lastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = SuitFeedFragment.this.mLayoutManager;
            if (staggeredGridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                staggeredGridLayoutManager2 = null;
            }
            int itemCount = staggeredGridLayoutManager2.getItemCount();
            Intrinsics.checkNotNullExpressionValue(lastVisibleItemPositions, "lastVisibleItemPositions");
            contains = ArraysKt___ArraysKt.contains(lastVisibleItemPositions, itemCount - 2);
            if (contains) {
                SuitFeedViewModel suitFeedViewModel = SuitFeedFragment.this.viewModel;
                if (suitFeedViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    suitFeedViewModel = null;
                }
                Integer value = suitFeedViewModel.a2().getValue();
                if (value != null && value.intValue() == 0) {
                    SuitFeedViewModel suitFeedViewModel2 = SuitFeedFragment.this.viewModel;
                    if (suitFeedViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        suitFeedViewModel2 = null;
                    }
                    Context requireContext = SuitFeedFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    suitFeedViewModel2.U1(requireContext);
                }
                QLog.d("SuitFeedFragment", 2, "dataList:  scrolled to end");
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager3 = SuitFeedFragment.this.mLayoutManager;
            if (staggeredGridLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                staggeredGridLayoutManager3 = null;
            }
            int[] firstCompletelyVisibleItemPositions = staggeredGridLayoutManager3.findFirstCompletelyVisibleItemPositions(null);
            Intrinsics.checkNotNullExpressionValue(firstCompletelyVisibleItemPositions, "firstCompletelyVisibleItemPositions");
            contains2 = ArraysKt___ArraysKt.contains(firstCompletelyVisibleItemPositions, 0);
            if (contains2) {
                SuitFeedFragment.this.yh().setVisibility(4);
            } else if (SuitFeedFragment.this.yh().getVisibility() != 0) {
                SuitFeedFragment.this.yh().setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitFeedFragment$d", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", "data", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements SuitFeedViewModel.c {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel.c
        public void a(long j3) {
            SuitFeedViewModel.c.a.a(this, j3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel.c
        public void b(AIGCFeedItemInfo2 data) {
            Intrinsics.checkNotNullParameter(data, "data");
            SuitFeedViewModel suitFeedViewModel = SuitFeedFragment.this.viewModel;
            if (suitFeedViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                suitFeedViewModel = null;
            }
            suitFeedViewModel.f2(data, null);
        }
    }

    public SuitFeedFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) SuitFeedFragment.this.requireView().findViewById(R.id.qgo);
            }
        });
        this.recyclerView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$parentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitFeedFragment.this.requireView().findViewById(R.id.qbt);
            }
        });
        this.parentView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$backGroundPag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitFeedFragment.this.requireView().findViewById(R.id.ptw);
            }
        });
        this.backGroundPag = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$backGroundPng$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitFeedFragment.this.requireView().findViewById(R.id.qbq);
            }
        });
        this.backGroundPng = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$liuhaiMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitFeedFragment.this.requireView().findViewById(R.id.pzz);
            }
        });
        this.liuhaiMask = lazy5;
        this.onItemCreateClick = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$onItemCreateClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (SuitFeedFragment.this.getParentFragment() != null) {
                    SuitFeedFragment suitFeedFragment = SuitFeedFragment.this;
                    SuitFeedViewModel suitFeedViewModel = suitFeedFragment.viewModel;
                    if (suitFeedViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        suitFeedViewModel = null;
                    }
                    suitFeedViewModel.g2();
                    Bundle bundle = new Bundle();
                    bundle.putInt("subPageId", 0);
                    IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
                    Context requireContext = suitFeedFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    iEntryApi.startAIGCCreationPage(requireContext, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_AIGC_CREATION_ENTRANCE, null, 4, null), bundle);
                }
            }
        };
        this.likeDataCallback = new d();
        this.refreshCallback = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$refreshCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SuitFeedViewModel suitFeedViewModel = SuitFeedFragment.this.viewModel;
                if (suitFeedViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    suitFeedViewModel = null;
                }
                Context requireContext = SuitFeedFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                suitFeedViewModel.U1(requireContext);
            }
        };
        this.onContractClick = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$onContractClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Fragment parentFragment = SuitFeedFragment.this.getParentFragment();
                if (parentFragment != null) {
                    ((SuitParentFragment) parentFragment).Di(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$onContractClick$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, true);
                }
            }
        };
        this.itemViewClickCallBack = new Function2<Integer, Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$itemViewClickCallBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l3) {
                invoke(num.intValue(), l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, long j3) {
                Fragment parentFragment = SuitFeedFragment.this.getParentFragment();
                if (parentFragment != null) {
                    SuitFeedFragment suitFeedFragment = SuitFeedFragment.this;
                    if (((SuitParentFragment) parentFragment).getIsAdLoading()) {
                        QLog.i("SuitFeedFragment", 1, "Ad is loading, do not jump");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("subPageId", 1);
                    bundle.putBoolean("useCacheAvatarData", true);
                    bundle.putInt("from", SuitParentFragment.AigcSuitPreviewFromValue.FEED_PAGE.getValue());
                    bundle.putInt("item_id", i3);
                    bundle.putLong("ugcId", j3);
                    IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
                    Context requireContext = suitFeedFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    iEntryApi.startAIGCCreationPage(requireContext, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_AIGC_CREATION_ENTRANCE, null, 4, null), bundle);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ch() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        int feedFrom = ((SuitParentFragment) parentFragment).getFeedFrom();
        be3.a aVar = new be3.a(new ArrayList(), this.onItemCreateClick, this.onContractClick, this.likeDataCallback, this.refreshCallback, this.itemViewClickCallBack, this.dtReporter);
        aVar.B0(feedFrom);
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        aVar.D0((SuitParentFragment) parentFragment2);
        getRecyclerView().setAdapter(aVar);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mLayoutManager = staggeredGridLayoutManager;
        staggeredGridLayoutManager.setGapStrategy(2);
        aVar.C0(0);
        RecyclerView recyclerView = getRecyclerView();
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.mLayoutManager;
        if (staggeredGridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            staggeredGridLayoutManager2 = null;
        }
        recyclerView.setLayoutManager(staggeredGridLayoutManager2);
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setItemAnimator(null);
        getRecyclerView().addOnScrollListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRecyclerView() {
        Object value = this.recyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recyclerView>(...)");
        return (RecyclerView) value;
    }

    private final void initView() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).qi().o2().postValue(5);
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment.Ji((SuitParentFragment) parentFragment2, "pg_zplan_create_home", false, 2, null);
        Fragment parentFragment3 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment3).Vh(true);
        Fragment parentFragment4 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment.Yh((SuitParentFragment) parentFragment4, false, 1, null);
        xh().setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_feed_background.png", com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.e()));
        SuitPagView.v(wh(), "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading_bg_slow.pag", false, 2, null);
    }

    private final SuitPagView wh() {
        Object value = this.backGroundPag.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backGroundPag>(...)");
        return (SuitPagView) value;
    }

    private final ImageView xh() {
        Object value = this.backGroundPng.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backGroundPng>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView yh() {
        Object value = this.liuhaiMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-liuhaiMask>(...)");
        return (ImageView) value;
    }

    private final void zh() {
        ViewModel viewModel = new ViewModelProvider(this).get(SuitFeedViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026eedViewModel::class.java)");
        SuitFeedViewModel suitFeedViewModel = (SuitFeedViewModel) viewModel;
        this.viewModel = suitFeedViewModel;
        SuitFeedViewModel suitFeedViewModel2 = null;
        if (suitFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suitFeedViewModel = null;
        }
        LiveData<Integer> a26 = suitFeedViewModel.a2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$initFeedData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QLog.d("SuitFeedFragment", 2, "status: " + num);
                if (num != null && num.intValue() == 1) {
                    RecyclerView.Adapter adapter = SuitFeedFragment.this.getRecyclerView().getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
                    ((be3.a) adapter).E0(be3.a.INSTANCE.e());
                } else if (num != null && num.intValue() == 2) {
                    RecyclerView.Adapter adapter2 = SuitFeedFragment.this.getRecyclerView().getAdapter();
                    Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
                    ((be3.a) adapter2).E0(be3.a.INSTANCE.d());
                } else if (num != null && num.intValue() == 3) {
                    RecyclerView.Adapter adapter3 = SuitFeedFragment.this.getRecyclerView().getAdapter();
                    Intrinsics.checkNotNull(adapter3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
                    ((be3.a) adapter3).E0(be3.a.INSTANCE.c());
                }
            }
        };
        a26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitFeedFragment.Ah(Function1.this, obj);
            }
        });
        SuitFeedViewModel suitFeedViewModel3 = this.viewModel;
        if (suitFeedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suitFeedViewModel3 = null;
        }
        LiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> Z1 = suitFeedViewModel3.Z1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.zplan.aigc.data.b>, Unit> function12 = new Function1<List<? extends com.tencent.mobileqq.zplan.aigc.data.b>, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitFeedFragment$initFeedData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.zplan.aigc.data.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.zplan.aigc.data.b> dataList) {
                RecyclerView.Adapter adapter = SuitFeedFragment.this.getRecyclerView().getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
                Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                ((be3.a) adapter).setData(dataList);
                SuitFeedFragment.this.getRecyclerView().invalidate();
                QLog.d("SuitFeedFragment", 2, "dataList: " + dataList.size());
            }
        };
        Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitFeedFragment.Bh(Function1.this, obj);
            }
        });
        SuitFeedViewModel suitFeedViewModel4 = this.viewModel;
        if (suitFeedViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suitFeedViewModel4 = null;
        }
        List<com.tencent.mobileqq.zplan.aigc.data.b> b26 = suitFeedViewModel4.b2();
        RecyclerView.Adapter adapter = getRecyclerView().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
        ((be3.a) adapter).setData(b26);
        if (b26.size() < 2) {
            SuitFeedViewModel suitFeedViewModel5 = this.viewModel;
            if (suitFeedViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                suitFeedViewModel5 = null;
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            suitFeedViewModel5.U1(requireContext);
        }
        SuitFeedViewModel suitFeedViewModel6 = this.viewModel;
        if (suitFeedViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            suitFeedViewModel2 = suitFeedViewModel6;
        }
        suitFeedViewModel2.T1(new b());
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167463dg2;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.SuitParentFragment.b
    public boolean onBackPressed() {
        SuitFeedViewModel suitFeedViewModel = this.viewModel;
        if (suitFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suitFeedViewModel = null;
        }
        suitFeedViewModel.g2();
        requireActivity().finish();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("SuitFeedFragment", 2, "onConfigurationChanged");
        RecyclerView.Adapter adapter = getRecyclerView().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitFeedAdapter");
        ((be3.a) adapter).z0();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView != null) {
            return onCreateView;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        this.dtReporter = ((SuitParentFragment) parentFragment).getDtReporter();
        Ch();
        zh();
        initView();
    }
}
