package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.quicksearch.model.SearchData;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LoadingUtil;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\b*\u0001\u001b\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R \u00103\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "initViewModel", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "G9", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "e", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "feedListView", "f", "Landroid/view/View;", "footerLoadingView", "com/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedListPart$b", tl.h.F, "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedListPart$b;", "scrollListener", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/c;", "i", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/guild/quicksearch/adapter/c;", "feedListAdapter", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchAICardAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E9", "()Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchAICardAdapter;", "aiCardAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lkotlin/Pair;", "", "", "D", "Lkotlin/Pair;", "mediaSizeUtils", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedListPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RFWConcatAdapter concatAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Pair<Integer, Object> mediaSizeUtils;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter feedListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View footerLoadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b scrollListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiCardAdapter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedListPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            RecyclerView.LayoutManager layoutManager;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            f12.d.f397604d.i("guild_search_list", newState);
            Integer value = QuickSearchFeedListPart.this.getViewModel().g2().getValue();
            if (value == null || value.intValue() != 2 || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - 2 && linearLayoutManager.getItemCount() != 0) {
                QuickSearchFeedListPart.this.getViewModel().loadMore();
            }
        }
    }

    public QuickSearchFeedListPart(@NotNull QuickSearchViewModel viewModel) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.scrollListener = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.quicksearch.adapter.c>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedListPart$feedListAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.quicksearch.adapter.c invoke() {
                com.tencent.mobileqq.guild.quicksearch.adapter.c cVar = new com.tencent.mobileqq.guild.quicksearch.adapter.c(new com.tencent.mobileqq.guild.quicksearch.adapter.g(), new com.tencent.mobileqq.guild.quicksearch.adapter.a());
                cVar.setHasStableIds(true);
                return cVar;
            }
        });
        this.feedListAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QuickSearchAICardAdapter>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedListPart$aiCardAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QuickSearchAICardAdapter invoke() {
                return new QuickSearchAICardAdapter(QuickSearchFeedListPart.this);
            }
        });
        this.aiCardAdapter = lazy2;
        RFWConcatAdapter.Config.Builder builder = new RFWConcatAdapter.Config.Builder();
        builder.setIsolateViewTypes(false);
        builder.setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS);
        this.concatAdapter = new RFWConcatAdapter(builder.build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{E9(), F9()});
        this.mediaSizeUtils = ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getSearchFeedMediaUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickSearchAICardAdapter E9() {
        return (QuickSearchAICardAdapter) this.aiCardAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.quicksearch.adapter.c F9() {
        return (com.tencent.mobileqq.guild.quicksearch.adapter.c) this.feedListAdapter.getValue();
    }

    private final void H9(View rootView) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f3e, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R\u2026rch_loading_layout, null)");
        View findViewById = inflate.findViewById(R.id.ys_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "footerView.findViewById(\u2026ding_anim_view_container)");
        ((FrameLayout) findViewById).addView(LoadingUtil.getLoadingView(getContext(), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 2));
        View findViewById2 = inflate.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "footerView.findViewById(R.id.loading_layout)");
        this.footerLoadingView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.i4m);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById3;
        overScrollRecyclerViewWithHeaderFooter.C(inflate);
        overScrollRecyclerViewWithHeaderFooter.setAdapter(this.concatAdapter);
        overScrollRecyclerViewWithHeaderFooter.setItemAnimator(null);
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(overScrollRecyclerViewWithHeaderFooter.getContext(), 1, false));
        overScrollRecyclerViewWithHeaderFooter.addOnScrollListener(this.scrollListener);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Ov\u2026stener)\n                }");
        this.feedListView = overScrollRecyclerViewWithHeaderFooter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        LiveData<SearchData> d26 = this.viewModel.d2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final QuickSearchFeedListPart$initViewModel$1 quickSearchFeedListPart$initViewModel$1 = new QuickSearchFeedListPart$initViewModel$1(this);
        d26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedListPart.I9(Function1.this, obj);
            }
        });
        LiveData<Integer> g26 = this.viewModel.g2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedListPart$initViewModel$2
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
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
                Set of5;
                View view;
                overScrollRecyclerViewWithHeaderFooter = QuickSearchFeedListPart.this.feedListView;
                View view2 = null;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{2, 3, 4});
                overScrollRecyclerViewWithHeaderFooter.setVisibility(of5.contains(num) ? 0 : 8);
                view = QuickSearchFeedListPart.this.footerLoadingView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("footerLoadingView");
                } else {
                    view2 = view;
                }
                view2.setVisibility(num != null && num.intValue() == 3 ? 0 : 8);
            }
        };
        g26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedListPart.J9(Function1.this, obj);
            }
        });
    }

    @NotNull
    /* renamed from: G9, reason: from getter */
    public final QuickSearchViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        E9().l0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        H9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.feedListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.removeOnScrollListener(this.scrollListener);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.feedListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        overScrollRecyclerViewWithHeaderFooter2.setTag(this.mediaSizeUtils.getFirst().intValue(), null);
    }
}
