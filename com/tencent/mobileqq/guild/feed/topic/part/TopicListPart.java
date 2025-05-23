package com.tencent.mobileqq.guild.feed.topic.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedPublishEvent;
import com.tencent.mobileqq.guild.feed.topic.mvi.FeedListState;
import com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRefreshIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000201B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListPart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "T9", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "state", "O9", "", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "E", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "mPageData", "Lun1/c;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "N9", "()Lun1/c;", "mAdapterHolder", "G", "Z", "lockUpdateList", "H", "updateListWhenUnLock", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "I", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mSmartRefreshLayout", "<init>", "()V", "J", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicListPart extends TopicListBasePart implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private PageData mPageData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapterHolder;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean lockUpdateList;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean updateListWhenUnLock;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private SmartRefreshLayout mSmartRefreshLayout;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        private final Drawable a(Context context) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(context.getResources().getColor(R.color.qui_common_border_standard));
            return gradientDrawable;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDraw(c16, parent, state);
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = parent.getChildAt(i3);
                if (childAt.getId() == R.id.v3b) {
                    Context context = childAt.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "child.context");
                    Drawable a16 = a(context);
                    if (a16 == null) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
                    a16.setBounds(parent.getLeft() + ViewUtils.dip2px(16.0f), bottom, parent.getRight() - ViewUtils.dip2px(16.0f), ViewUtils.dip2px(0.7f) + bottom);
                    a16.draw(c16);
                }
            }
        }
    }

    public TopicListPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<un1.c>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListPart$mAdapterHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final un1.c invoke() {
                return TopicListPart.this.C9().getAdapterHolder();
            }
        });
        this.mAdapterHolder = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final un1.c N9() {
        return (un1.c) this.mAdapterHolder.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(final FeedListState state) {
        PageData pageData = this.mPageData;
        RecyclerView recyclerView = null;
        if (pageData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageData");
            pageData = null;
        }
        QLog.i("GTopic_TopicListPart", 1, "handleTopicListChange setItems " + pageData + " " + state);
        SmartRefreshLayout smartRefreshLayout = this.mSmartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
        if (this.lockUpdateList) {
            Logger.f235387a.d().i("GTopic_TopicListPart", 1, "handleTopicListChange is lockUpdateList return");
            this.updateListWhenUnLock = true;
            return;
        }
        if (Q9(state)) {
            Logger.f235387a.d().i("GTopic_TopicListPart", 1, "handleTopicListChange needJumpTop");
            state.j(0);
        }
        final boolean needInsertAnimator = state.getNeedInsertAnimator();
        if (needInsertAnimator) {
            this.lockUpdateList = true;
            BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.feed.part.a.d(this), null, null, new TopicListPart$handleTopicListChange$3(this, null), 3, null);
        } else {
            this.lockUpdateList = false;
            this.updateListWhenUnLock = false;
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        if (recyclerView2.canScrollVertically(-1) && state.getScrollPos() >= 0) {
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setItemAnimator(null);
            RecyclerView recyclerView4 = this.mRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.scrollToPosition(state.getScrollPos());
        }
        state.i(false);
        N9().getMFeedsAdapter().setItems(state.c().b(), new Runnable() { // from class: com.tencent.mobileqq.guild.feed.topic.part.e
            @Override // java.lang.Runnable
            public final void run() {
                TopicListPart.P9(TopicListPart.this, needInsertAnimator, state);
            }
        });
        N9().c(state.getLoadingMore(), !state.getFinish());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(final TopicListPart this$0, boolean z16, FeedListState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        final RecyclerView recyclerView = this$0.mRecyclerView;
        PageData pageData = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(recyclerView, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListPart$handleTopicListChange$lambda$6$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                un1.c N9;
                VideoReport.traversePage(this$0.getPartRootView());
                N9 = this$0.N9();
                QLog.i("GTopic_TopicListPart", 1, "[trace] onPreDraw size:" + N9.getMFeedsAdapter().getItems().size());
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        if (z16) {
            RecyclerView recyclerView2 = this$0.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            FeedDefaultItemAnimator feedDefaultItemAnimator = new FeedDefaultItemAnimator(Boolean.TRUE);
            feedDefaultItemAnimator.setAddDuration(250L);
            feedDefaultItemAnimator.setMoveDuration(250L);
            feedDefaultItemAnimator.setSupportsChangeAnimations(false);
            recyclerView2.setItemAnimator(feedDefaultItemAnimator);
        } else {
            RecyclerView recyclerView3 = this$0.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setItemAnimator(null);
        }
        if (state.getScrollPos() >= 0) {
            RecyclerView recyclerView4 = this$0.mRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView4 = null;
            }
            recyclerView4.scrollToPosition(state.getScrollPos());
            state.j(-1);
        }
        PageData pageData2 = this$0.mPageData;
        if (pageData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageData");
        } else {
            pageData = pageData2;
        }
        QLog.i("GTopic_TopicListPart", 1, "handleTopicListChange FeedList callback " + pageData + " size:" + state.c());
    }

    private final boolean Q9(FeedListState state) {
        boolean z16;
        List<vn1.a> items = N9().getMFeedsAdapter().getItems();
        if (items != null && !items.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean isEmpty = state.c().b().isEmpty();
        if (!z16 || isEmpty) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(TopicListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.T9();
    }

    private final void T9() {
        E9().Z1(new TopicFeedsRefreshIntent(null, "refresh", 1, null));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TopicFeedDeleteEvent.class, TopicFeedPublishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f100245rz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.topic_content_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b());
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setRecycledViewPool(B9().getRvPool());
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setAdapter(N9().getConcatAdapter());
        this.mPageData = D9().getF223518b();
        LiveData<FeedListState> X1 = E9().X1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<FeedListState, Unit> function1 = new Function1<FeedListState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeedListState feedListState) {
                invoke2(feedListState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeedListState it) {
                TopicListPart topicListPart = TopicListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                topicListPart.O9(it);
            }
        };
        X1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicListPart.R9(Function1.this, obj);
            }
        });
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.x2o);
        this.mSmartRefreshLayout = smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.d
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    TopicListPart.S9(TopicListPart.this, iRefreshLayout);
                }
            });
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.clearOnScrollListeners();
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.clearOnChildAttachStateChangeListeners();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        Long l3;
        com.tencent.mobileqq.guild.feed.topic.e eVar = (com.tencent.mobileqq.guild.feed.topic.e) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.e.class);
        if (eVar != null) {
            l3 = Long.valueOf(eVar.getTopicId());
        } else {
            l3 = null;
        }
        if (!(event instanceof TopicFeedDeleteEvent)) {
            if (event instanceof TopicFeedPublishEvent) {
                long topicId = ((TopicFeedPublishEvent) event).getTopicId();
                if (l3 == null || topicId != l3.longValue()) {
                    return;
                }
            } else {
                return;
            }
        }
        T9();
    }
}
