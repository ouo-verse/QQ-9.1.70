package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.n;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0002;<B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b8\u00109J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0017J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVB$a$a;", "f1", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "j1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVM;", "g1", "", "d", "I", "viewId", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "layoutParam", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "h1", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "k1", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;)V", "mAdapter", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "i1", "()Landroidx/recyclerview/widget/RecyclerView;", "l1", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recyclerViewLayoutManager", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "mRootLayout", "<init>", "(ILandroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishMediaPreviewVB extends BaseVB<n, GuildFeedPublishMediaPreviewUIState, com.tencent.base.api.runtime.a<zl1.a>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int viewId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout.LayoutParams layoutParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public FeedPostMediaPreviewAdapter mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RecyclerView mRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager recyclerViewLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRootLayout;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVB$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "b", "", "position", "itemCount", "a", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "d", "I", "top", "e", "bottom", "f", "begin", tl.h.F, "end", "i", "between", "<init>", "(IIIII)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int top;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int bottom;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int begin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int end;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final int between;

        public b(int i3, int i16, int i17, int i18, int i19) {
            this.top = i3;
            this.bottom = i16;
            this.begin = i17;
            this.end = i18;
            this.between = i19;
        }

        private final void a(Rect outRect, int position, int itemCount) {
            if (position == 0) {
                outRect.left = this.begin;
                outRect.right = this.between;
            } else if (position == itemCount - 1) {
                outRect.left = this.between;
                outRect.right = this.end;
            } else {
                int i3 = this.between;
                outRect.left = i3;
                outRect.right = i3;
            }
            outRect.top = this.top;
            outRect.bottom = this.bottom;
        }

        private final void b(Rect outRect) {
            outRect.top = this.top;
            outRect.bottom = this.bottom;
            outRect.left = this.begin;
            outRect.right = this.end;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int itemCount = state.getItemCount();
            if (itemCount == 1) {
                b(outRect);
            } else {
                a(outRect, parent.getChildAdapterPosition(view), itemCount);
            }
        }
    }

    public GuildFeedPublishMediaPreviewVB(int i3, @NotNull ConstraintLayout.LayoutParams layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        this.viewId = i3;
        this.layoutParam = layoutParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e1(GuildFeedPublishMediaPreviewVB this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 0) {
            this$0.sendIntent(n.b.f222204d);
            return false;
        }
        return false;
    }

    private final Companion.C7768a f1() {
        return new Companion.C7768a(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVB$createScaleHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                FrameLayout frameLayout;
                FrameLayout frameLayout2;
                frameLayout = GuildFeedPublishMediaPreviewVB.this.mRootLayout;
                FrameLayout frameLayout3 = null;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                    frameLayout = null;
                }
                int i3 = 0;
                if (frameLayout.getVisibility() == 0) {
                    frameLayout2 = GuildFeedPublishMediaPreviewVB.this.mRootLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                    } else {
                        frameLayout3 = frameLayout2;
                    }
                    i3 = frameLayout3.getMeasuredHeight();
                }
                return Integer.valueOf(i3);
            }
        }, new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVB$createScaleHandle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(30.0f));
            }
        }, new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVB$createScaleHandle$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                GuildFeedPublishMediaPreviewVB.this.h1().y0(f16);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @SuppressLint({"ClickableViewAccessibility"})
    public void bindViewAndData() {
        sendIntent(new n.a(h1()));
        i1().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean e16;
                e16 = GuildFeedPublishMediaPreviewVB.e1(GuildFeedPublishMediaPreviewVB.this, view, motionEvent);
                return e16;
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public GuildFeedPublishMediaPreviewVM createVM() {
        return new GuildFeedPublishMediaPreviewVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildFeedPublishMediaPreviewUIState>> getObserverStates() {
        List<Class<? extends GuildFeedPublishMediaPreviewUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildFeedPublishMediaContainerVisibilityChange.class);
        return listOf;
    }

    @NotNull
    public final FeedPostMediaPreviewAdapter h1() {
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        if (feedPostMediaPreviewAdapter != null) {
            return feedPostMediaPreviewAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    @NotNull
    public final RecyclerView i1() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildFeedPublishMediaPreviewUIState state) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildFeedPublishMediaContainerVisibilityChange) {
            if (((GuildFeedPublishMediaContainerVisibilityChange) state).getIsVisible()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            FrameLayout frameLayout = this.mRootLayout;
            FrameLayout frameLayout2 = null;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                frameLayout = null;
            }
            if (i3 != frameLayout.getVisibility()) {
                FrameLayout frameLayout3 = this.mRootLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                } else {
                    frameLayout2 = frameLayout3;
                }
                frameLayout2.setVisibility(i3);
            }
        }
    }

    public final void k1(@NotNull FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter) {
        Intrinsics.checkNotNullParameter(feedPostMediaPreviewAdapter, "<set-?>");
        this.mAdapter = feedPostMediaPreviewAdapter;
    }

    public final void l1(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        k1(new FeedPostMediaPreviewAdapter(createViewParams.a()));
        this.recyclerViewLayoutManager = new LinearLayoutManager(getMContext(), 0, false);
        HorizontalScrollRecyclerView horizontalScrollRecyclerView = new HorizontalScrollRecyclerView(createViewParams.a(), null, 0, 6, null);
        LinearLayoutManager linearLayoutManager = this.recyclerViewLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewLayoutManager");
            linearLayoutManager = null;
        }
        horizontalScrollRecyclerView.setLayoutManager(linearLayoutManager);
        horizontalScrollRecyclerView.setAdapter(h1());
        horizontalScrollRecyclerView.setClipChildren(false);
        horizontalScrollRecyclerView.setClipToPadding(false);
        horizontalScrollRecyclerView.setHasFixedSize(true);
        horizontalScrollRecyclerView.setNestedScrollingEnabled(false);
        horizontalScrollRecyclerView.addItemDecoration(new b(ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(0.0f)));
        VideoReport.enableAndroidXRVExposure(horizontalScrollRecyclerView);
        l1(horizontalScrollRecyclerView);
        h1().w1(i1());
        m mVar = new m(h1(), null);
        mVar.d(1.0f, 0.8f, 1.22f, 1.12f);
        mVar.c(1.0f);
        new ItemTouchHelper(mVar).attachToRecyclerView(i1());
        d1();
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setId(this.viewId);
        frameLayout.setLayoutParams(this.layoutParam);
        frameLayout.addView(i1());
        frameLayout.setTag(f1());
        frameLayout.setVisibility(8);
        this.mRootLayout = frameLayout;
        return frameLayout;
    }

    private final void d1() {
    }
}
