package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import bo1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002&*\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J:\u0010\u0011\u001a\u00020\u000320\u0010\u0010\u001a,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\u0007j\u0002`\u000fH\u0002J&\u0010\u0012\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lco1/g;", "", "G9", "F9", "I9", "Lbo1/a$e;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchSuccessState;", "state", "C9", "H9", "", "isSearchModeArgs", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lzi1/a;", "d", "Lkotlin/Lazy;", "D9", "()Lzi1/a;", "binding", "com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$a", "e", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$a;", "adapterHolder", "com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$c", "f", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$c;", "loadMoreListener", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", "viewModel", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "collectorJob", "Lvi1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvi1/a;", "adapterOperationApi", "O0", "()Landroid/view/View;", "hostView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultListPart extends Part implements co1.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a adapterHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c loadMoreListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedBatchManageSearchViewModel viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job collectorJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private vi1.a adapterOperationApi;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$a", "", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "a", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "concatAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "c", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", tl.h.F, "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;)V", "loadMoreAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "f", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;)V", "feedListAdapter", "", "d", "Z", "()Z", "g", "(Z)V", "isInitialized", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public RFWConcatAdapter concatAdapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public com.tencent.mobileqq.guild.feed.feedsquare.adapter.j loadMoreAdapter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public GuildFeedSquareListAdapter feedListAdapter;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isInitialized;

        a() {
        }

        @NotNull
        public final RFWConcatAdapter a() {
            RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
            if (rFWConcatAdapter != null) {
                return rFWConcatAdapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            return null;
        }

        @NotNull
        public final GuildFeedSquareListAdapter b() {
            GuildFeedSquareListAdapter guildFeedSquareListAdapter = this.feedListAdapter;
            if (guildFeedSquareListAdapter != null) {
                return guildFeedSquareListAdapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            return null;
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.feedsquare.adapter.j c() {
            com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = this.loadMoreAdapter;
            if (jVar != null) {
                return jVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            return null;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsInitialized() {
            return this.isInitialized;
        }

        public final void e(@NotNull RFWConcatAdapter rFWConcatAdapter) {
            Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<set-?>");
            this.concatAdapter = rFWConcatAdapter;
        }

        public final void f(@NotNull GuildFeedSquareListAdapter guildFeedSquareListAdapter) {
            Intrinsics.checkNotNullParameter(guildFeedSquareListAdapter, "<set-?>");
            this.feedListAdapter = guildFeedSquareListAdapter;
        }

        public final void g(boolean z16) {
            this.isInitialized = z16;
        }

        public final void h(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar) {
            Intrinsics.checkNotNullParameter(jVar, "<set-?>");
            this.loadMoreAdapter = jVar;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$b", "Lvi1/a;", "", "position", "", "m6", "notifyDataSetChanged", "", "payload", "U0", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements vi1.a {
        b() {
        }

        @Override // vi1.a
        public void U0(@NotNull Object payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (FeedBatchManageSearchResultListPart.this.adapterHolder.getIsInitialized()) {
                GuildFeedSquareListAdapter b16 = FeedBatchManageSearchResultListPart.this.adapterHolder.b();
                b16.notifyItemRangeChanged(0, b16.getNUM_BACKGOURND_ICON(), payload);
            }
        }

        @Override // vi1.a
        public void m6(int position) {
            if (FeedBatchManageSearchResultListPart.this.adapterHolder.getIsInitialized()) {
                FeedBatchManageSearchResultListPart.this.adapterHolder.b().notifyItemChanged(position);
            }
        }

        @Override // vi1.a
        public void notifyDataSetChanged() {
            if (FeedBatchManageSearchResultListPart.this.adapterHolder.getIsInitialized()) {
                FeedBatchManageSearchResultListPart.this.adapterHolder.b().notifyDataSetChanged();
            }
        }
    }

    public FeedBatchManageSearchResultListPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<zi1.a>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultListPart$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final zi1.a invoke() {
                Context context = FeedBatchManageSearchResultListPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new zi1.a(context);
            }
        });
        this.binding = lazy;
        this.adapterHolder = new a();
        this.loadMoreListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(a.SuccessState<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs> state) {
        int i3;
        Integer num;
        RecyclerView.Adapter adapter = null;
        if (QLog.isDevelopLevel()) {
            int length = state.getKeyword().length();
            List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a16 = state.d().a();
            if (a16 != null) {
                num = Integer.valueOf(a16.size());
            } else {
                num = null;
            }
            QLog.d("FeedBatchManagement.Search.List", 4, "consumeSuccessState|query=" + length + ", dataSize=" + num + ", isFinished=" + state.d().getIsFinished());
        }
        zi1.a D9 = D9();
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a17 = state.d().a();
        if (a17 != null && !a17.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        D9.g(i3);
        RecyclerView feedRecyclerView = D9.getFeedRecyclerView();
        if (feedRecyclerView != null) {
            adapter = feedRecyclerView.getAdapter();
        }
        if (adapter == null) {
            F9();
            RecyclerView feedRecyclerView2 = D9.getFeedRecyclerView();
            if (feedRecyclerView2 != null) {
                feedRecyclerView2.setAdapter(this.adapterHolder.a());
            }
        }
        H9(state.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zi1.a D9() {
        return (zi1.a) this.binding.getValue();
    }

    private final void E9(Object isSearchModeArgs) {
        if (!(isSearchModeArgs instanceof Boolean)) {
            return;
        }
        if (((Boolean) isSearchModeArgs).booleanValue()) {
            I9();
            return;
        }
        FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = this.viewModel;
        if (feedBatchManageSearchViewModel != null) {
            feedBatchManageSearchViewModel.i2();
        }
        Job job = this.collectorJob;
        if (job != null) {
            job.cancel(new CancellationException("exit search mode"));
        }
        this.collectorJob = null;
    }

    private final void F9() {
        a aVar = this.adapterHolder;
        if (!aVar.getIsInitialized()) {
            GuildFeedSquareListAdapter guildFeedSquareListAdapter = new GuildFeedSquareListAdapter(new GuildFeedSquareItemDiffCallback(), yj1.d.f450494a);
            guildFeedSquareListAdapter.setHasStableIds(true);
            aVar.f(guildFeedSquareListAdapter);
            com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.j(0, 0, 0, 7, null);
            jVar.setHasStableIds(true);
            jVar.registerLoadMoreListener(this.loadMoreListener);
            jVar.i0("\u6682\u65e0\u66f4\u591a\u5185\u5bb9");
            aVar.h(jVar);
            aVar.e(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{aVar.b(), aVar.c()}));
            aVar.g(true);
        }
    }

    private final void G9() {
        b bVar = new b();
        PartIOCKt.registerIoc(this, bVar, vi1.a.class);
        this.adapterOperationApi = bVar;
    }

    private final void H9(do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer> state) {
        boolean z16;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a16 = state.a();
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.adapterHolder.b().setItems(new ArrayList());
            this.adapterHolder.c().setLoadState(false, !state.getIsFinished());
            return;
        }
        this.adapterHolder.b().setItems(state.a());
        this.adapterHolder.b();
        RecyclerView feedRecyclerView = D9().getFeedRecyclerView();
        if (feedRecyclerView != null) {
            feedRecyclerView.smoothScrollToPosition(0);
        }
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j c16 = this.adapterHolder.c();
        c16.show();
        c16.setLoadState(false, !state.getIsFinished());
    }

    private final void I9() {
        StateFlow<bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>> X1;
        Flow onEach;
        Flow m2026catch;
        Job job = this.collectorJob;
        boolean z16 = false;
        if (job != null && job.isActive()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = this.viewModel;
        Job job2 = null;
        if (feedBatchManageSearchViewModel != null && (X1 = feedBatchManageSearchViewModel.X1()) != null && (onEach = FlowKt.onEach(X1, new FeedBatchManageSearchResultListPart$startObserveViewModel$1(this, null))) != null && (m2026catch = FlowKt.m2026catch(onEach, new FeedBatchManageSearchResultListPart$startObserveViewModel$2(null))) != null) {
            job2 = FlowKt.launchIn(m2026catch, com.tencent.mobileqq.guild.feed.part.a.d(this));
        }
        this.collectorJob = job2;
    }

    @Override // co1.g
    @NotNull
    public View O0() {
        return D9().getMRv();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_search_mode_change")) {
            E9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        this.viewModel = (FeedBatchManageSearchViewModel) getViewModel(FeedBatchManageSearchViewModel.class);
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(this, vi1.a.class);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultListPart$c", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ILoadMoreProvider$LoadMoreListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = FeedBatchManageSearchResultListPart.this.viewModel;
            if (feedBatchManageSearchViewModel != null) {
                feedBatchManageSearchViewModel.loadMore();
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
