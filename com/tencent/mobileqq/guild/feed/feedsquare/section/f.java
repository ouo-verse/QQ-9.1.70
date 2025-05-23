package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u0010\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u00012\u00020\u0004:\u000256B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J0\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010&R \u0010-\u001a\f\u0012\b\u0012\u00060)j\u0002`*0(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "", "imageCount", "", "k", "", "e", "Landroid/view/View;", "containerView", "i", "data", "position", "", "", "payload", "g", "f", tl.h.F, "currentPos", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "generateTransitionBean", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "depends", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroid/view/View;", "mContainerView", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLayoutManager", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter;", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter;", "mGuildSimpleFeedImageAdapter", "", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mMixedMediaDataList", "Landroid/view/GestureDetector;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/GestureDetector;", "mGestureDetector", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;)V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends a<qj1.h> implements TransitionHelper.TransitionBeanCreator {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GridLayoutManager mLayoutManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildSimpleFeedItemImageAdapter mGuildSimpleFeedImageAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<? extends qj1.l> mMixedMediaDataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0019\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "a", "", "dataSize", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "", "elementId", "c", tl.h.F, "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "position", "itemCount", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "e", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            @NotNull
            public static AbsGuildFeedMediaSizeUtils a(@NotNull b bVar) {
                return GuildFeedMediaSizeUtils.f219296d;
            }

            @Nullable
            public static Object b(@NotNull b bVar) {
                return null;
            }

            public static void c(@NotNull b bVar, @NotNull RoundCornerLayout view, int i3, int i16) {
                Intrinsics.checkNotNullParameter(view, "view");
                ui1.a.f439021a.a(view, i3, i16);
            }
        }

        @Nullable
        Object a();

        void c(@Nullable View view, @NotNull String elementId);

        int d(int dataSize);

        @NotNull
        AbsGuildFeedMediaSizeUtils e();

        void f(@NotNull RoundCornerLayout view, int position, int itemCount);

        int g();

        @Nullable
        RecyclerView.RecycledViewPool getRecycledViewPool();

        void h(@NotNull View view);

        void i(int pos, @NotNull View view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/f$c", "Lcom/tencent/mobileqq/guild/feed/adapter/o;", "Landroid/view/View;", "view", "", com.tencent.luggage.wxa.c8.c.G, "", NodeProps.ON_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.adapter.o {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.adapter.o
        public void onClick(@NotNull View view, int pos) {
            Intrinsics.checkNotNullParameter(view, "view");
            List list = f.this.mMixedMediaDataList;
            List list2 = null;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
                list = null;
            }
            if (pos >= list.size()) {
                List list3 = f.this.mMixedMediaDataList;
                if (list3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
                } else {
                    list2 = list3;
                }
                QLog.d("GuildFeedSquareMultiImageSection", 4, "pos = " + pos + ", listSize = " + list2.size());
                return;
            }
            f.this.depends.i(pos, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/f$d", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends GridLayoutManager {
        d(Context context) {
            super(context, 2);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public f(@NotNull b depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(f this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetector gestureDetector = this$0.mGestureDetector;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    private final void k(int imageCount) {
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            gridLayoutManager = null;
        }
        gridLayoutManager.setSpanCount(Math.min(imageCount, this.depends.d(imageCount)));
    }

    @NotNull
    public int[] e() {
        return new int[]{R.id.x0w};
    }

    public final void f() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        yl1.n.y(recyclerView, TransitionHelper.TransitionBeanCreator.class, this);
    }

    public void g(@Nullable qj1.h data, int position, @Nullable List<Object> payload) {
        List<qj1.l> emptyList;
        if (data == null || (emptyList = data.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.mMixedMediaDataList = emptyList;
        View view = null;
        if (emptyList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            emptyList = null;
        }
        if (emptyList.isEmpty()) {
            View view2 = this.mContainerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        List<? extends qj1.l> list = this.mMixedMediaDataList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            list = null;
        }
        k(list.size());
        GuildSimpleFeedItemImageAdapter guildSimpleFeedItemImageAdapter = this.mGuildSimpleFeedImageAdapter;
        if (guildSimpleFeedItemImageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSimpleFeedImageAdapter");
            guildSimpleFeedItemImageAdapter = null;
        }
        List<? extends qj1.l> list2 = this.mMixedMediaDataList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
            list2 = null;
        }
        guildSimpleFeedItemImageAdapter.setData(list2);
        GuildSimpleFeedItemImageAdapter guildSimpleFeedItemImageAdapter2 = this.mGuildSimpleFeedImageAdapter;
        if (guildSimpleFeedItemImageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSimpleFeedImageAdapter");
            guildSimpleFeedItemImageAdapter2 = null;
        }
        guildSimpleFeedItemImageAdapter2.y0(new c());
        View view3 = this.mContainerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
    @NotNull
    public TransitionBean generateTransitionBean(int currentPos) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            List<? extends qj1.l> list = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            if (recyclerView.getChildCount() > currentPos) {
                List<? extends qj1.l> list2 = this.mMixedMediaDataList;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
                    list2 = null;
                }
                if (list2.size() > currentPos) {
                    TransitionBean transitionBean = new TransitionBean();
                    List<? extends qj1.l> list3 = this.mMixedMediaDataList;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataList");
                    } else {
                        list = list3;
                    }
                    qj1.l lVar = list.get(currentPos);
                    transitionBean.setEnterViewRect(recyclerView.getChildAt(currentPos));
                    transitionBean.setStImage(lVar.getPicUrl(), lVar.getWidth(), lVar.getHeight());
                    return transitionBean;
                }
            }
        }
        return new TransitionBean();
    }

    public final void h() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        yl1.n.D(recyclerView, TransitionHelper.TransitionBeanCreator.class);
    }

    public void i(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.x0q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026eed_item_image_container)");
        this.mContainerView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.x0r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026feed_item_image_recycler)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        this.mGuildSimpleFeedImageAdapter = new GuildSimpleFeedItemImageAdapter(this.depends);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        GuildSimpleFeedItemImageAdapter guildSimpleFeedItemImageAdapter = this.mGuildSimpleFeedImageAdapter;
        if (guildSimpleFeedItemImageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSimpleFeedImageAdapter");
            guildSimpleFeedItemImageAdapter = null;
        }
        recyclerView.setAdapter(guildSimpleFeedItemImageAdapter);
        this.mLayoutManager = new d(containerView.getContext());
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            gridLayoutManager = null;
        }
        recyclerView3.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setNestedScrollingEnabled(false);
        GuildSimpleFeedItemImageAdapter.b bVar = new GuildSimpleFeedItemImageAdapter.b();
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView5 = null;
        }
        recyclerView5.addItemDecoration(bVar);
        RecyclerView recyclerView6 = this.mRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setRecycledViewPool(this.depends.getRecycledViewPool());
        this.mGestureDetector = new GestureDetector(containerView.getContext(), new e());
        RecyclerView recyclerView7 = this.mRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView7;
        }
        recyclerView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean j3;
                j3 = f.j(f.this, view, motionEvent);
                return j3;
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u0012\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/f$e", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "", "onShowPress", "onSingleTapUp", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements GestureDetector.OnGestureListener {
        e() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent e16) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            b bVar = f.this.depends;
            View view = f.this.mContainerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainerView");
                view = null;
            }
            bVar.h(view);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@Nullable MotionEvent e16) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@Nullable MotionEvent e16) {
        }
    }
}
