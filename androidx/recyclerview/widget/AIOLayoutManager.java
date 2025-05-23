package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AIOLayoutManager$scrollListener$2;
import androidx.recyclerview.widget.AIOLinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.anchor.AsynchronousAnchor;
import androidx.recyclerview.widget.anchor.PositionAnchor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u000b*\u0001i\u0018\u0000 r2\u00020\u0001:\u0001rB\u0011\u0012\b\u0010o\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\bp\u0010qJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010\u0019\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J\u000f\u0010\u001c\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J \u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0019\u0010&\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0010\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0014J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0014J0\u0010-\u001a\u00020\u00022\f\u0010+\u001a\b\u0018\u00010*R\u00020!2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u001dH\u0014J \u0010.\u001a\u00020\u00022\f\u0010+\u001a\b\u0018\u00010*R\u00020!2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010/\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J \u00103\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0018H\u0016J1\u00103\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u000104H\u0000\u00a2\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0000\u00a2\u0006\u0004\b8\u00109J\u001a\u0010;\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u000f\u0010=\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b<\u0010\u001bJ\u0014\u0010@\u001a\u00020\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020>J\u0014\u0010A\u001a\u00020\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020>J\u0014\u0010C\u001a\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020>J\u0014\u0010D\u001a\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020>R\"\u0010E\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010+\u001a\b\u0018\u00010*R\u00020!8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010H\"\u0004\bR\u0010JR$\u0010T\u001a\u0004\u0018\u00010S8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\"\u0010b\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010F\u001a\u0004\bc\u0010H\"\u0004\bd\u0010JR\"\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020>0e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\"\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020>0e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010gR\u001b\u0010n\u001a\u00020i8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Landroidx/recyclerview/widget/AIOLayoutManager;", "Landroidx/recyclerview/widget/AIOLinearLayoutManager;", "", "dispatchOnLayoutComplete", "dispatchOnLayoutStart", "handleListener", "output", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "lp", "generateLayoutParams", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/view/View;", "referenceChild", "Landroidx/recyclerview/widget/AIOLinearLayoutManager$AnchorInfo;", "anchorInfo", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Landroidx/recyclerview/widget/AIOLinearLayoutManager$LayoutState;", "mLayoutState", "", "check", "clearAsnyAnchor$sdk_debug", "()V", "clearAsnyAnchor", "", "position", "scrollToPosition", "canScrollVertically", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "smoothScrollToPosition", "setRecyclerView$sdk_debug", "(Landroidx/recyclerview/widget/RecyclerView;)V", "setRecyclerView", "startOffset", "fixStackFromEndStartOffsetV1", "fixStackFromEndStartOffset", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "recycler", "firstLayoutItemDirection", "onAnchorReady", "onLayoutChildren", "onLayoutCompleted", "findViewByPosition", "offset", "bottom", "scrollToPositionWithOffset", "Lxs/a$b;", "listener", "scrollToPositionWithOffset$sdk_debug", "(IIZLxs/a$b;)Z", "scrollToBottomMsgWithOffset$sdk_debug", "(I)V", "scrollToBottomMsgWithOffset", "updateAnchorFromAsnyFocus", "release$sdk_debug", "release", "Lkotlin/Function0;", "layoutCompleteListener", "addLayoutCompleteListener", "removeLayoutCompleteListener", "layoutStartListener", "addLayoutStartListener", "removeLayoutStartListener", "canScrollVertical", "Z", "getCanScrollVertical", "()Z", "setCanScrollVertical", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "getRecycler$sdk_debug", "()Landroidx/recyclerview/widget/RecyclerView$Recycler;", "setRecycler$sdk_debug", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "needTopToBottom", "getNeedTopToBottom$sdk_debug", "setNeedTopToBottom$sdk_debug", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;", "ladingVisible", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;", "getLadingVisible$sdk_debug", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;", "setLadingVisible$sdk_debug", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;)V", "Landroidx/recyclerview/widget/anchor/AsynchronousAnchor;", "asynchronousAnchor", "Landroidx/recyclerview/widget/anchor/AsynchronousAnchor;", "Landroidx/recyclerview/widget/anchor/PositionAnchor;", "positionAnchor", "Landroidx/recyclerview/widget/anchor/PositionAnchor;", "scrollCompleteListener", "Lxs/a$b;", "needAnsyAnchor", "getNeedAnsyAnchor", "setNeedAnsyAnchor", "", "layoutCompleteListeners", "Ljava/util/List;", "layoutStartListeners", "androidx/recyclerview/widget/AIOLayoutManager$scrollListener$2$1", "scrollListener$delegate", "Lkotlin/Lazy;", "getScrollListener", "()Landroidx/recyclerview/widget/AIOLayoutManager$scrollListener$2$1;", "scrollListener", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AIOLayoutManager extends AIOLinearLayoutManager {
    private static final String TAG = "AIOLayoutManager";
    private AsynchronousAnchor asynchronousAnchor;
    private boolean canScrollVertical;

    @Nullable
    private com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c ladingVisible;
    private List<Function0<Unit>> layoutCompleteListeners;
    private List<Function0<Unit>> layoutStartListeners;
    private boolean needAnsyAnchor;
    private boolean needTopToBottom;
    private PositionAnchor positionAnchor;

    @Nullable
    private RecyclerView.Recycler recycler;
    private a.b scrollCompleteListener;

    /* renamed from: scrollListener$delegate, reason: from kotlin metadata */
    private final Lazy scrollListener;

    public AIOLayoutManager(@Nullable Context context) {
        super(context);
        Lazy lazy;
        this.canScrollVertical = true;
        this.layoutCompleteListeners = new ArrayList();
        this.layoutStartListeners = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOLayoutManager$scrollListener$2.AnonymousClass1>() { // from class: androidx.recyclerview.widget.AIOLayoutManager$scrollListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.AIOLayoutManager$scrollListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                return new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.AIOLayoutManager$scrollListener$2.1
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        super.onScrolled(recyclerView, dx5, dy5);
                        if (dy5 != 0) {
                            AIOLayoutManager.this.asynchronousAnchor = null;
                            AIOLayoutManager.this.positionAnchor = null;
                        }
                    }
                };
            }
        });
        this.scrollListener = lazy;
    }

    private final void dispatchOnLayoutComplete() {
        Iterator<T> it = this.layoutCompleteListeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final void dispatchOnLayoutStart() {
        Iterator<T> it = this.layoutStartListeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final AIOLayoutManager$scrollListener$2.AnonymousClass1 getScrollListener() {
        return (AIOLayoutManager$scrollListener$2.AnonymousClass1) this.scrollListener.getValue();
    }

    private final void handleListener() {
        if (com.tencent.aio.base.a.f69150c.a() && this.positionAnchor != null && this.scrollCompleteListener != null) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "handleListener " + this.positionAnchor);
        }
        PositionAnchor positionAnchor = this.positionAnchor;
        if (positionAnchor != null && this.mPendingScrollPosition == positionAnchor.getPosition() && this.mPendingScrollPositionOffset == positionAnchor.getOffset() && this.mPendingScrollPositionBottom == positionAnchor.getBaseBottom()) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            a.b bVar = this.scrollCompleteListener;
            if (bVar != null) {
                bVar.b(findViewByPosition);
            }
            this.scrollCompleteListener = null;
        }
    }

    private final void output() {
        new Handler().postDelayed(new Runnable() { // from class: androidx.recyclerview.widget.AIOLayoutManager$output$1
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView.Recycler recycler = AIOLayoutManager.this.getRecycler();
                if (recycler != null) {
                    RecyclerView.RecycledViewPool recycledViewPool = recycler.mRecyclerPool;
                    if (recycledViewPool != null) {
                        SparseArray<RecyclerView.RecycledViewPool.ScrapData> mScrap = recycledViewPool.mScrap;
                        Intrinsics.checkNotNullExpressionValue(mScrap, "mScrap");
                        int size = mScrap.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            int keyAt = mScrap.keyAt(i3);
                            RecyclerView.RecycledViewPool.ScrapData valueAt = mScrap.valueAt(i3);
                            com.tencent.aio.base.log.a.f69187b.e("AIOLayoutManager", "--------------" + keyAt + " scrap " + valueAt.mScrapHeap.size() + "----------------");
                            ArrayList<RecyclerView.ViewHolder> arrayList = valueAt.mScrapHeap;
                            Intrinsics.checkNotNullExpressionValue(arrayList, "value.mScrapHeap");
                            for (RecyclerView.ViewHolder viewHolder : arrayList) {
                                com.tencent.aio.base.log.a.f69187b.d("AIOLayoutManager", keyAt + " : value " + viewHolder.itemView);
                            }
                        }
                    }
                    com.tencent.aio.base.log.a.f69187b.e("AIOLayoutManager", "--------------cacheView " + recycler.mCachedViews.size() + "----------------");
                    ArrayList<RecyclerView.ViewHolder> arrayList2 = recycler.mCachedViews;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "it.mCachedViews");
                    for (RecyclerView.ViewHolder viewHolder2 : arrayList2) {
                        com.tencent.aio.base.log.a.f69187b.d("AIOLayoutManager", "cacheView " + viewHolder2.itemView);
                    }
                    com.tencent.aio.base.log.a.f69187b.e("AIOLayoutManager", "--------------attachedScrap " + recycler.mAttachedScrap.size() + "----------------");
                    ArrayList<RecyclerView.ViewHolder> arrayList3 = recycler.mAttachedScrap;
                    Intrinsics.checkNotNullExpressionValue(arrayList3, "it.mAttachedScrap");
                    for (RecyclerView.ViewHolder viewHolder3 : arrayList3) {
                        com.tencent.aio.base.log.a.f69187b.d("AIOLayoutManager", " attach " + viewHolder3.itemView);
                    }
                    ArrayList<RecyclerView.ViewHolder> arrayList4 = recycler.mChangedScrap;
                    if (arrayList4 != null) {
                        com.tencent.aio.base.log.a.f69187b.e("AIOLayoutManager", "--------------mChangedScrap " + arrayList4.size() + "----------------");
                        for (RecyclerView.ViewHolder viewHolder4 : arrayList4) {
                            com.tencent.aio.base.log.a.f69187b.d("AIOLayoutManager", " change " + viewHolder4.itemView);
                        }
                    }
                }
            }
        }, 50L);
    }

    public final void addLayoutCompleteListener(@NotNull Function0<Unit> layoutCompleteListener) {
        Intrinsics.checkNotNullParameter(layoutCompleteListener, "layoutCompleteListener");
        this.layoutCompleteListeners.add(layoutCompleteListener);
    }

    public final void addLayoutStartListener(@NotNull Function0<Unit> layoutStartListener) {
        Intrinsics.checkNotNullParameter(layoutStartListener, "layoutStartListener");
        this.layoutStartListeners.add(layoutStartListener);
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (!this.canScrollVertical) {
            return false;
        }
        return super.canScrollVertically();
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    public /* bridge */ /* synthetic */ Boolean check(View view, AIOLinearLayoutManager.AnchorInfo anchorInfo, RecyclerView.State state, AIOLinearLayoutManager.LayoutState layoutState) {
        return Boolean.valueOf(m39check(view, anchorInfo, state, layoutState));
    }

    public final void clearAsnyAnchor$sdk_debug() {
        if (this.asynchronousAnchor == null) {
            return;
        }
        com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d(TAG, "clearAsnyAnchor");
        this.asynchronousAnchor = null;
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View findViewByPosition(int position) {
        try {
            return super.findViewByPosition(position);
        } catch (NullPointerException e16) {
            com.tencent.aio.base.log.a.f69187b.e(TAG, "findViewByPosition " + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    public int fixStackFromEndStartOffset(int startOffset) {
        if (!this.needTopToBottom) {
            return super.fixStackFromEndStartOffset(startOffset);
        }
        if (startOffset > 0) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d(TAG, "fixStackFromEndStartOffset ");
            }
            ChildHelper childHelper = this.mRecyclerView.mChildHelper;
            Intrinsics.checkNotNullExpressionValue(childHelper, "mRecyclerView.mChildHelper");
            int childCount = childHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childView = this.mChildHelper.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                ViewGroup.LayoutParams layoutParams = childView.getLayoutParams();
                RecyclerView.ViewHolder viewHolder = null;
                if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
                    layoutParams = null;
                }
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    viewHolder = layoutParams2.mViewHolder;
                }
                if (viewHolder instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.b) {
                    return 0;
                }
                childView.offsetTopAndBottom(-startOffset);
            }
        }
        return startOffset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    public int fixStackFromEndStartOffsetV1(int startOffset) {
        View findViewByPosition;
        View findViewByPosition2;
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c cVar = this.ladingVisible;
        if (cVar != null && cVar.a() && (findViewByPosition2 = findViewByPosition(findFirstVisibleItemPosition())) != null) {
            int top = findViewByPosition2.getTop();
            OrientationHelper mOrientationHelper = this.mOrientationHelper;
            Intrinsics.checkNotNullExpressionValue(mOrientationHelper, "mOrientationHelper");
            if (top < mOrientationHelper.getStartAfterPadding()) {
                OrientationHelper mOrientationHelper2 = this.mOrientationHelper;
                Intrinsics.checkNotNullExpressionValue(mOrientationHelper2, "mOrientationHelper");
                int startAfterPadding = mOrientationHelper2.getStartAfterPadding() - findViewByPosition2.getTop();
                com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("FirstVisible Top ");
                sb5.append(findViewByPosition2.getTop());
                sb5.append(",  ");
                OrientationHelper mOrientationHelper3 = this.mOrientationHelper;
                Intrinsics.checkNotNullExpressionValue(mOrientationHelper3, "mOrientationHelper");
                sb5.append(mOrientationHelper3.getStartAfterPadding());
                sb5.append(" detail ");
                sb5.append(startAfterPadding);
                aVar.d(TAG, sb5.toString());
                if (startAfterPadding != 0) {
                    offsetChildrenVertical(startAfterPadding);
                }
            }
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c cVar2 = this.ladingVisible;
        if (cVar2 != null && cVar2.e() && (findViewByPosition = findViewByPosition(findLastVisibleItemPosition())) != null) {
            int bottom = findViewByPosition.getBottom();
            OrientationHelper mOrientationHelper4 = this.mOrientationHelper;
            Intrinsics.checkNotNullExpressionValue(mOrientationHelper4, "mOrientationHelper");
            if (bottom > mOrientationHelper4.getEndAfterPadding()) {
                OrientationHelper mOrientationHelper5 = this.mOrientationHelper;
                Intrinsics.checkNotNullExpressionValue(mOrientationHelper5, "mOrientationHelper");
                int endAfterPadding = mOrientationHelper5.getEndAfterPadding() - findViewByPosition.getBottom();
                com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("LastVisible Bottom ");
                sb6.append(findViewByPosition.getBottom());
                sb6.append("  ");
                OrientationHelper mOrientationHelper6 = this.mOrientationHelper;
                Intrinsics.checkNotNullExpressionValue(mOrientationHelper6, "mOrientationHelper");
                sb6.append(mOrientationHelper6.getEndAfterPadding());
                sb6.append("  detail ");
                sb6.append(endAfterPadding);
                aVar2.d(TAG, sb6.toString());
                if (endAfterPadding != 0) {
                    offsetChildrenVertical(endAfterPadding);
                }
            }
        }
        return super.fixStackFromEndStartOffsetV1(startOffset);
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new AIOCoreLayoutParam(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable ViewGroup.LayoutParams lp5) {
        if (lp5 instanceof RecyclerView.LayoutParams) {
            return new AIOCoreLayoutParam((RecyclerView.LayoutParams) lp5);
        }
        if (lp5 instanceof ViewGroup.MarginLayoutParams) {
            return new AIOCoreLayoutParam((ViewGroup.MarginLayoutParams) lp5);
        }
        return new AIOCoreLayoutParam(lp5);
    }

    public final boolean getCanScrollVertical() {
        return this.canScrollVertical;
    }

    @Nullable
    /* renamed from: getLadingVisible$sdk_debug, reason: from getter */
    public final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c getLadingVisible() {
        return this.ladingVisible;
    }

    public final boolean getNeedAnsyAnchor() {
        return this.needAnsyAnchor;
    }

    /* renamed from: getNeedTopToBottom$sdk_debug, reason: from getter */
    public final boolean getNeedTopToBottom() {
        return this.needTopToBottom;
    }

    @Nullable
    /* renamed from: getRecycler$sdk_debug, reason: from getter */
    public final RecyclerView.Recycler getRecycler() {
        return this.recycler;
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    protected void onAnchorReady(@Nullable RecyclerView.Recycler recycler, @Nullable RecyclerView.State state, @NotNull AIOLinearLayoutManager.AnchorInfo anchorInfo, int firstLayoutItemDirection) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@Nullable RecyclerView.Recycler recycler, @Nullable RecyclerView.State state) {
        dispatchOnLayoutStart();
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(@Nullable RecyclerView.State state) {
        handleListener();
        super.onLayoutCompleted(state);
        this.positionAnchor = null;
        dispatchOnLayoutComplete();
    }

    public final void release$sdk_debug() {
        com.tencent.aio.base.log.a.f69187b.d(TAG, "release");
        this.scrollCompleteListener = null;
        this.asynchronousAnchor = null;
        this.positionAnchor = null;
        if (com.tencent.aio.base.a.f69150c.b()) {
            output();
        }
    }

    public final void removeLayoutCompleteListener(@NotNull Function0<Unit> layoutCompleteListener) {
        Intrinsics.checkNotNullParameter(layoutCompleteListener, "layoutCompleteListener");
        this.layoutCompleteListeners.remove(layoutCompleteListener);
    }

    public final void removeLayoutStartListener(@NotNull Function0<Unit> layoutStartListener) {
        Intrinsics.checkNotNullParameter(layoutStartListener, "layoutStartListener");
        this.layoutStartListeners.remove(layoutStartListener);
    }

    public final void scrollToBottomMsgWithOffset$sdk_debug(int position) {
        com.tencent.aio.base.log.a.f69187b.d(TAG, "scrollToBottomMsgWithOffset " + position);
        super.scrollToPositionWithOffset(position, 0, true);
        this.asynchronousAnchor = null;
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        com.tencent.aio.base.log.a.f69187b.d(TAG, "scrollToPosition " + position + "hashcode " + hashCode());
        super.scrollToPositionWithOffset(position, 0);
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    public /* bridge */ /* synthetic */ Boolean scrollToPositionWithOffset(int i3, int i16, boolean z16) {
        return Boolean.valueOf(m40scrollToPositionWithOffset(i3, i16, z16));
    }

    public final boolean scrollToPositionWithOffset$sdk_debug(int position, int offset, boolean bottom, @Nullable a.b listener) {
        this.positionAnchor = new PositionAnchor(position, offset, bottom);
        this.scrollCompleteListener = listener;
        this.asynchronousAnchor = null;
        Boolean valid = super.scrollToPositionWithOffset(position, offset, bottom);
        Intrinsics.checkNotNullExpressionValue(valid, "valid");
        if (valid.booleanValue() && !bottom && this.needAnsyAnchor) {
            this.asynchronousAnchor = new AsynchronousAnchor(position, offset, bottom);
        }
        return valid.booleanValue();
    }

    public final void setCanScrollVertical(boolean z16) {
        this.canScrollVertical = z16;
    }

    public final void setLadingVisible$sdk_debug(@Nullable com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c cVar) {
        this.ladingVisible = cVar;
    }

    public final void setNeedAnsyAnchor(boolean z16) {
        this.needAnsyAnchor = z16;
    }

    public final void setNeedTopToBottom$sdk_debug(boolean z16) {
        this.needTopToBottom = z16;
    }

    public final void setRecycler$sdk_debug(@Nullable RecyclerView.Recycler recycler) {
        this.recycler = recycler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* renamed from: setRecyclerView$sdk_debug, reason: merged with bridge method [inline-methods] */
    public void setRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView.Recycler recycler;
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(getScrollListener());
        }
        super.setRecyclerView(recyclerView);
        if (recyclerView != null) {
            recycler = recyclerView.mRecycler;
        } else {
            recycler = null;
        }
        this.recycler = recycler;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(getScrollListener());
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "setRecyclerView");
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state, int position) {
        a.c cVar;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        com.tencent.aio.base.log.a.f69187b.d(TAG, "smoothScrollToPosition " + position);
        Object tag = recyclerView.getTag(R.id.f793049e);
        if (tag instanceof a.c) {
            cVar = (a.c) tag;
        } else {
            cVar = null;
        }
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.layoutMangar.a aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.layoutMangar.a(context, cVar);
        aVar.setTargetPosition(position);
        startSmoothScroll(aVar);
    }

    @Override // androidx.recyclerview.widget.AIOLinearLayoutManager
    protected boolean updateAnchorFromAsnyFocus(@Nullable RecyclerView.State state, @NotNull AIOLinearLayoutManager.AnchorInfo anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        if (!this.needAnsyAnchor) {
            return false;
        }
        OrientationHelper mOrientationHelper = this.mOrientationHelper;
        Intrinsics.checkNotNullExpressionValue(mOrientationHelper, "mOrientationHelper");
        if (mOrientationHelper.getTotalSpaceChange() != 0) {
            this.asynchronousAnchor = null;
            return false;
        }
        if (this.asynchronousAnchor == null) {
            return false;
        }
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "updateAnchorFromAsnyFocus " + this.asynchronousAnchor);
        }
        View findReferenceChildClosestToStart = findReferenceChildClosestToStart(this.recycler, state);
        if (findReferenceChildClosestToStart == null) {
            return false;
        }
        anchorInfo.mLayoutFromEnd = false;
        anchorInfo.mPosition = getPosition(findReferenceChildClosestToStart);
        anchorInfo.mCoordinate = this.mOrientationHelper.getDecoratedStart(findReferenceChildClosestToStart);
        if (aVar.a()) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "findReferenceChildClosestToStart " + anchorInfo);
            return true;
        }
        return true;
    }

    /* renamed from: check, reason: collision with other method in class */
    protected boolean m39check(@Nullable View referenceChild, @Nullable AIOLinearLayoutManager.AnchorInfo anchorInfo, @Nullable RecyclerView.State state, @Nullable AIOLinearLayoutManager.LayoutState mLayoutState) {
        if (anchorInfo == null || referenceChild == null) {
            return false;
        }
        if (isSmoothScrolling()) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.e(TAG, "check  isSmoothScrolling");
            }
            return false;
        }
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.a.f69187b.e(TAG, "check  param " + referenceChild.getLayoutParams());
        }
        ViewGroup.LayoutParams layoutParams = referenceChild.getLayoutParams();
        if (!(layoutParams instanceof AIOCoreLayoutParam)) {
            layoutParams = null;
        }
        AIOCoreLayoutParam aIOCoreLayoutParam = (AIOCoreLayoutParam) layoutParams;
        if (aIOCoreLayoutParam != null) {
            boolean z16 = aIOCoreLayoutParam.whenOutScreenLocation;
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(referenceChild);
            if (aVar.a()) {
                com.tencent.aio.base.log.a.f69187b.d(TAG, "check  wenOutScreenLocation " + z16 + " mLayoutState " + mLayoutState);
            }
            if (z16) {
                OrientationHelper mOrientationHelper = this.mOrientationHelper;
                Intrinsics.checkNotNullExpressionValue(mOrientationHelper, "mOrientationHelper");
                if (decoratedEnd > mOrientationHelper.getEndAfterPadding()) {
                    int position = getPosition(referenceChild);
                    if (aVar.a()) {
                        com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("check  wenOutScreenLocation  wenOutScreenLocation ");
                        sb5.append(z16);
                        sb5.append(" original    ");
                        sb5.append(position);
                        sb5.append(TokenParser.SP);
                        sb5.append(" decoratedEnd ");
                        sb5.append(decoratedEnd);
                        sb5.append(" afterPadding ");
                        OrientationHelper mOrientationHelper2 = this.mOrientationHelper;
                        Intrinsics.checkNotNullExpressionValue(mOrientationHelper2, "mOrientationHelper");
                        sb5.append(mOrientationHelper2.getEndAfterPadding());
                        sb5.append("  childStart ");
                        sb5.append(this.mOrientationHelper.getDecoratedStart(referenceChild));
                        sb5.append("totalChange ");
                        sb5.append(this.mOrientationHelper.getTotalSpaceChange());
                        sb5.append(TokenParser.SP);
                        aVar2.d(TAG, sb5.toString());
                    }
                    anchorInfo.mLayoutFromEnd = false;
                    anchorInfo.mPosition = getPosition(referenceChild);
                    anchorInfo.mCoordinate = this.mOrientationHelper.getDecoratedStart(referenceChild) + this.mOrientationHelper.getTotalSpaceChange();
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: scrollToPositionWithOffset, reason: collision with other method in class */
    public boolean m40scrollToPositionWithOffset(int position, int offset, boolean bottom) {
        return scrollToPositionWithOffset$sdk_debug(position, offset, bottom, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable Context c16, @Nullable AttributeSet attrs) {
        return new AIOCoreLayoutParam(c16, attrs);
    }
}
