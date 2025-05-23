package com.tencent.mobileqq.guild.discoveryv2.content.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GuildStaggeredGridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsListUIState;
import qh1.MVPFeedsUIState;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u000278B\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R \u00103\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00060/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "", "args", "C9", "E9", "onInitView", "", "action", "handleBroadcastMessage", "getMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;", "getConfig", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "f", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "getReportTask", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Landroidx/recyclerview/widget/RecyclerView;", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "i", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "B9", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "contentAdapter", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "contentLoadMoreAdapter", "Lkotlin/Pair;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Pair;", "mediaSizeUtils", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "D", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ContentPart extends MVPFeedsPart {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Pair<Integer, Object> mediaSizeUtils;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b config;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IPerformanceReportTask reportTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.content.base.e contentAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.content.base.f contentLoadMoreAdapter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull RecyclerView recyclerView) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            }
        }

        void a(@NotNull RecyclerView recyclerView);
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "RECOMMEND_SPACE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int RECOMMEND_SPACE = bi.b(3);

        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            StaggeredGridLayoutManager.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            boolean z16 = false;
            if (layoutParams != null && layoutParams.isFullSpan()) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            super.getItemOffsets(outRect, view, parent, state);
            int i3 = this.RECOMMEND_SPACE;
            outRect.set(i3, i3, i3, i3);
        }
    }

    static {
        rh1.d.f431454a.l();
    }

    public /* synthetic */ ContentPart(b bVar, IPerformanceReportTask iPerformanceReportTask, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i3 & 2) != 0 ? null : iPerformanceReportTask);
    }

    private final void C9(Object args) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        if (!(args instanceof ContentMessage.ScrollToPositionMessage)) {
            return;
        }
        ContentMessage.ScrollToPositionMessage scrollToPositionMessage = (ContentMessage.ScrollToPositionMessage) args;
        QLog.i("DiscoveryV2.ContentContentPart", 1, "handleScrollToTopPosition callSource = " + scrollToPositionMessage.getCallSource());
        RecyclerView recyclerView = this.recyclerView;
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.stopScroll();
        if (scrollToPositionMessage.getPosition() == 0) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            E9(recyclerView2);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        } else {
            staggeredGridLayoutManager = null;
        }
        if (staggeredGridLayoutManager != null) {
            staggeredGridLayoutManager.scrollToPositionWithOffset(scrollToPositionMessage.getPosition(), 0);
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        RecyclerView.LayoutManager layoutManager2 = recyclerView4.getLayoutManager();
        if (layoutManager2 instanceof StaggeredGridLayoutManager) {
            staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) layoutManager2;
        }
        if (staggeredGridLayoutManager2 != null) {
            staggeredGridLayoutManager2.invalidateSpanAssignments();
        }
    }

    private final void D9(View rootView) {
        View findViewById = rootView.findViewById(R.id.uiw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026scovery_v2_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        VideoReport.enableAndroidXRVExposure(recyclerView);
        VideoReport.enableScrollExposureReport(recyclerView, true);
        recyclerView.setHasFixedSize(false);
        recyclerView.setItemAnimator(null);
        GuildStaggeredGridLayoutManager guildStaggeredGridLayoutManager = new GuildStaggeredGridLayoutManager(2, 1);
        guildStaggeredGridLayoutManager.setGapStrategy(0);
        recyclerView.setLayoutManager(guildStaggeredGridLayoutManager);
        recyclerView.setRecycledViewPool(new a());
        recyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.contentAdapter, this.contentLoadMoreAdapter}));
        recyclerView.addItemDecoration(new c());
        if (QQGuildUIUtil.z()) {
            recyclerView.getLayoutParams().width = x9().getContentWidth();
        }
        this.config.a(recyclerView);
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            qw1.b.q(iPerformanceReportTask, recyclerView, null, 2, null);
        }
        recyclerView.setTag(this.mediaSizeUtils.getFirst().intValue(), this.mediaSizeUtils.getSecond());
        Object broadcastGetMessage = broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
        Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy((StateFlow) broadcastGetMessage, new Function1<MVPFeedsUIState, MVPFeedsListUIState>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart$initRecyclerView$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final MVPFeedsListUIState invoke(@NotNull MVPFeedsUIState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getListState();
            }
        });
        LifecycleOwner a16 = d.a(this);
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = a16.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new ContentPart$initRecyclerView$$inlined$collectIn$default$1(lifecycle, state, distinctUntilChangedBy, null, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x000d, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E9(View view) {
        ViewGroup viewGroup;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
            while (viewGroup != null) {
                if (viewGroup instanceof NestedScrollView) {
                    ((NestedScrollView) viewGroup).scrollTo(0, 0);
                    return;
                } else {
                    ViewParent parent2 = viewGroup.getParent();
                    if (parent2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent2;
                    }
                }
            }
            return;
        }
        viewGroup = null;
    }

    @NotNull
    /* renamed from: B9, reason: from getter */
    public final com.tencent.mobileqq.guild.discoveryv2.content.base.e getContentAdapter() {
        return this.contentAdapter;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_get_load_more_adapter")) {
            return this.contentLoadMoreAdapter;
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_scroll_to_top_position")) {
            C9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        if (QQGuildUIUtil.z()) {
            RecyclerView recyclerView = this.recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.getLayoutParams().width = x9().getContentWidth();
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            recyclerView3.requestLayout();
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView4;
            }
            RecyclerView.Adapter adapter = recyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        D9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(null);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setTag(this.mediaSizeUtils.getFirst().intValue(), null);
    }

    public ContentPart(@NotNull b config, @Nullable IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.reportTask = iPerformanceReportTask;
        com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar = new com.tencent.mobileqq.guild.discoveryv2.content.base.e(new com.tencent.mobileqq.guild.discoveryv2.content.base.d(), new com.tencent.mobileqq.guild.discoveryv2.content.base.c());
        eVar.setHasStableIds(true);
        this.contentAdapter = eVar;
        com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar = new com.tencent.mobileqq.guild.discoveryv2.content.base.f();
        fVar.setHasStableIds(true);
        this.contentLoadMoreAdapter = fVar;
        this.mediaSizeUtils = ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getRecommendFeedMediaUtils();
    }
}
