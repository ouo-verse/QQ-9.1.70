package hy1;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u00020\u0001:\u0003&'(B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bR\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006)"}, d2 = {"Lhy1/b;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "", "r", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "", "isAutoMeasureEnabled", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onLayoutChildren", "canScrollVertically", "", "d", "I", "space", "e", "maxLine", "", "Lhy1/b$c;", "f", "Ljava/util/List;", "lineRows", "Landroid/view/View;", h.F, "Landroid/view/View;", "moreView", "i", "moreViewWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isShowMoreView", "<init>", "(II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends RecyclerView.LayoutManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int space;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int maxLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> lineRows = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View moreView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int moreViewWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowMoreView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lhy1/b$b;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", "view", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", CanvasView.ACTION_RECT, "<init>", "(Landroid/view/View;Landroid/graphics/Rect;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hy1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C10480b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private View view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Rect rect;

        public C10480b(@NotNull View view, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.view = view;
            this.rect = rect;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Rect getRect() {
            return this.rect;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.view = view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lhy1/b$c;", "", "Lhy1/b$b;", "view", "", "a", "", "Ljava/util/List;", "b", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "views", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<C10480b> views = new ArrayList();

        public final void a(@NotNull C10480b view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.views.add(view);
        }

        @NotNull
        public final List<C10480b> b() {
            return this.views;
        }
    }

    public b(int i3, int i16) {
        this.space = i3;
        this.maxLine = i16;
    }

    private final void r() {
        int size = this.lineRows.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<C10480b> b16 = this.lineRows.get(i3).b();
            int size2 = b16.size();
            for (int i16 = 0; i16 < size2; i16++) {
                if (this.isShowMoreView && i3 == this.maxLine - 1 && i16 == b16.size() - 1) {
                    C10480b c10480b = b16.get(i16);
                    View view = this.moreView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("moreView");
                        view = null;
                    }
                    c10480b.c(view);
                    b16.get(i16).getRect().right = b16.get(i16).getRect().left + this.moreViewWidth;
                }
                View view2 = b16.get(i16).getView();
                measureChildWithMargins(view2, 0, 0);
                addView(view2);
                Rect rect = b16.get(i16).getRect();
                layoutDecoratedWithMargins(view2, rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        int paddingLeft;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.f235387a.d().d("Guild.rg.FlowLayoutManager", 1, "onLayoutChildren");
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        c cVar = new c();
        this.lineRows.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        View viewForPosition = recycler.getViewForPosition(0);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(0)");
        this.moreView = viewForPosition;
        View view = null;
        if (viewForPosition == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreView");
            viewForPosition = null;
        }
        measureChildWithMargins(viewForPosition, 0, 0);
        View view2 = this.moreView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreView");
        } else {
            view = view2;
        }
        this.moreViewWidth = getDecoratedMeasuredWidth(view);
        this.isShowMoreView = false;
        int itemCount = getItemCount();
        int i3 = 0;
        int i16 = 1;
        while (true) {
            if (i16 >= itemCount) {
                break;
            }
            View viewForPosition2 = recycler.getViewForPosition(i16);
            Intrinsics.checkNotNullExpressionValue(viewForPosition2, "recycler.getViewForPosition(i)");
            measureChildWithMargins(viewForPosition2, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition2);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition2);
            if (i3 == 0 && this.space + decoratedMeasuredWidth > width) {
                paddingLeft = getPaddingLeft();
            } else {
                int i17 = this.space;
                if (i3 + decoratedMeasuredWidth + i17 <= width) {
                    if (i3 == 0) {
                        paddingLeft = getPaddingLeft();
                    } else {
                        paddingLeft = i17 + i3;
                        i3 += i17;
                    }
                } else {
                    this.lineRows.add(cVar);
                    if (this.lineRows.size() == 3) {
                        this.isShowMoreView = true;
                        break;
                    }
                    cVar = new c();
                    paddingTop += this.space + decoratedMeasuredHeight;
                    paddingLeft = getPaddingLeft();
                    i3 = decoratedMeasuredWidth;
                    Rect rect = new Rect();
                    rect.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
                    cVar.a(new C10480b(viewForPosition2, rect));
                    i16++;
                }
            }
            i3 += decoratedMeasuredWidth;
            Rect rect2 = new Rect();
            rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
            cVar.a(new C10480b(viewForPosition2, rect2));
            i16++;
        }
        if (this.lineRows.size() < this.maxLine) {
            this.lineRows.add(cVar);
        }
        r();
    }
}
