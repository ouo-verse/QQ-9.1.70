package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import com.tencent.mobileqq.guild.discovery.widget.DiscoveryLoadingHeaderView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u000245B/\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u00100\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendContent;", "Lcom/tencent/biz/richframework/part/BlockPart;", "", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "d", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "parentHost", "", "e", "I", "D9", "()I", "pageFrom", "f", "Ljava/lang/String;", "C9", "()Ljava/lang/String;", "mainSource", tl.h.F, "F9", "subSource", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "i", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "viewModel", "Lih1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "B9", "()Lih1/a;", "block", "Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView;", BdhLogUtil.LogTag.Tag_Conn, "E9", "()Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView;", "refreshHeader", "blockId", "<init>", "(Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;IILjava/lang/String;Ljava/lang/String;)V", "D", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendContent extends BlockPart {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy refreshHeader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u parentHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int pageFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subSource;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRecommendDetailViewModel viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy block;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendContent$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "", "d", "I", "leftInset", "e", "dividerHeight", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int leftInset;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int dividerHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paint paint;

        public b(@NotNull Context context, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.leftInset = i3;
            Paint paint = new Paint();
            this.paint = paint;
            paint.setColor(context.getResources().getColor(R.color.qui_common_border_standard));
            paint.setStyle(Paint.Style.FILL);
            this.dividerHeight = (int) TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int paddingLeft = parent.getPaddingLeft() + this.leftInset;
            int width = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i3 = 1; i3 < childCount; i3++) {
                if (i3 != 1 || !(parent.getChildAt(0) instanceof IRefreshViewProvider)) {
                    View childAt = parent.getChildAt(i3);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                    c16.drawRect(paddingLeft, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).topMargin) - this.dividerHeight, width, r5 + r4, this.paint);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendContent$c", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "", "d", "Z", "getFirstTime", "()Z", "setFirstTime", "(Z)V", "firstTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.AdapterDataObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean firstTime = true;

        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            if (this.firstTime) {
                this.firstTime = false;
                GuildRecommendContent.this.getBlockContainer().getRecyclerView().scrollToPosition(0);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildRecommendContent(@NotNull u parentHost, int i3, int i16, @NotNull String mainSource, @NotNull String subSource) {
        super(i3, r0, 1, 1);
        List emptyList;
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(parentHost, "parentHost");
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.parentHost = parentHost;
        this.pageFrom = i16;
        this.mainSource = mainSource;
        this.subSource = subSource;
        this.viewModel = parentHost.y7();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ih1.a>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendContent$block$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ih1.a invoke() {
                LifecycleOwner hostLifecycleOwner = GuildRecommendContent.this.getPartHost().getHostLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "partHost.hostLifecycleOwner");
                return new ih1.a(hostLifecycleOwner, GuildRecommendContent.this.getPageFrom(), GuildRecommendContent.this.getMainSource(), GuildRecommendContent.this.getSubSource());
            }
        });
        this.block = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DiscoveryLoadingHeaderView>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendContent$refreshHeader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DiscoveryLoadingHeaderView invoke() {
                Context context = GuildRecommendContent.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new DiscoveryLoadingHeaderView(context, "guild.re.new.GuildRecommendContent");
            }
        });
        this.refreshHeader = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ih1.a B9() {
        return (ih1.a) this.block.getValue();
    }

    private final DiscoveryLoadingHeaderView E9() {
        return (DiscoveryLoadingHeaderView) this.refreshHeader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(GuildRecommendContent this$0, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadInfo.isRefreshState()) {
            this$0.viewModel.refresh();
        } else if (loadInfo.isLoadMoreState()) {
            GuildRecommendDetailViewModel guildRecommendDetailViewModel = this$0.viewModel;
            guildRecommendDetailViewModel.loadData(guildRecommendDetailViewModel.get_categoryId(), this$0.viewModel.get_categoryConfId(), this$0.viewModel.get_categoryName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        getBlockContainer().getBlockMerger().setCustomNoMoreDataView(LayoutInflater.from(getContext()).inflate(R.layout.ela, (ViewGroup) null, false));
    }

    @NotNull
    /* renamed from: C9, reason: from getter */
    public final String getMainSource() {
        return this.mainSource;
    }

    /* renamed from: D9, reason: from getter */
    public final int getPageFrom() {
        return this.pageFrom;
    }

    @NotNull
    /* renamed from: F9, reason: from getter */
    public final String getSubSource() {
        return this.subSource;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "SELECT_POSITION") && (args instanceof IGProRecommendCategory)) {
            getBlockContainer().getRecyclerView().setVisibility(8);
            GuildRecommendDetailViewModel guildRecommendDetailViewModel = this.viewModel;
            IGProRecommendCategory iGProRecommendCategory = (IGProRecommendCategory) args;
            int categoryId = iGProRecommendCategory.getCategoryId();
            int categoryConfId = iGProRecommendCategory.getCategoryConfId();
            String name = iGProRecommendCategory.getName();
            Intrinsics.checkNotNullExpressionValue(name, "args.name");
            guildRecommendDetailViewModel.loadData(categoryId, categoryConfId, name);
            getBlockContainer().getRecyclerView().scrollToPosition(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        getPeerBlocks().add(B9());
        B9().setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.b
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                GuildRecommendContent.G9(GuildRecommendContent.this, loadInfo, obj);
            }
        });
        super.onInitView(rootView);
        BlockContainer blockContainer = getBlockContainer();
        Intrinsics.checkNotNullExpressionValue(blockContainer, "blockContainer");
        ViewExtKt.c(blockContainer, 0);
        e12.a<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp> discoverRecommendDetailRspForNewCard = this.viewModel.getDiscoverRecommendDetailRspForNewCard();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildRecommendContent$onInitView$2 guildRecommendContent$onInitView$2 = new GuildRecommendContent$onInitView$2(this);
        discoverRecommendDetailRspForNewCard.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendContent.H9(Function1.this, obj);
            }
        });
        B9().getLoadInfo().setFinish(false);
        B9().getLoadInfo().setCurrentState(4);
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        E9().k(recyclerView);
        getBlockContainer().setRefreshHeader(E9());
        getBlockContainer().setEnableRefresh(true);
        getBlockContainer().setEnableLoadMore(true);
        I9();
        getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        getBlockContainer().getBlockMerger().registerAdapterDataObserver(new c());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new b(context, ViewUtils.dpToPx(74.0f)));
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        RecyclerView.Adapter adapter;
        super.onPartResume(activity);
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
