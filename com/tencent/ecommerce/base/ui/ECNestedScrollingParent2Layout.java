package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\u0006\u00a2\u0006\u0004\bB\u0010CJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J0\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0006H\u0016J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0014J\b\u0010 \u001a\u00020\u000bH\u0014J(\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0014J\b\u0010&\u001a\u00020\u000bH\u0014J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0016R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010;\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECNestedScrollingParent2Layout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroid/view/View;", "child", "target", "", "axes", "type", "", "onStartNestedScroll", "", "onNestedScrollAccepted", "onStopNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "", "velocityX", "velocityY", "onNestedPreFling", "onNestedFling", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onFinishInflate", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, NodeProps.ON_DETACHED_FROM_WINDOW, HippyTKDListViewAdapter.X, "y", "scrollTo", "d", "I", "topViewHeight", "e", "Landroid/view/View;", "topView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Landroidx/core/view/NestedScrollingParentHelper;", "Landroidx/core/view/NestedScrollingParentHelper;", "nestedScrollingParentHelper", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "i", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "topViewGlobalLayoutListener", "()I", "minScrollTopY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECNestedScrollingParent2Layout extends LinearLayout implements NestedScrollingParent2 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int topViewHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View topView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final NestedScrollingParentHelper nestedScrollingParentHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnGlobalLayoutListener topViewGlobalLayoutListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onGlobalLayout"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int i3;
            ECNestedScrollingParent2Layout eCNestedScrollingParent2Layout = ECNestedScrollingParent2Layout.this;
            View view = eCNestedScrollingParent2Layout.topView;
            if (view == null) {
                i3 = ECNestedScrollingParent2Layout.this.topViewHeight;
            } else {
                i3 = view.getHeight();
            }
            eCNestedScrollingParent2Layout.topViewHeight = i3;
        }
    }

    public ECNestedScrollingParent2Layout(Context context) {
        this(context, null, 0, 6, null);
    }

    private final int d() {
        List list;
        int coerceAtMost;
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        list = SequencesKt___SequencesKt.toList(ViewGroupKt.getChildren(recyclerView));
        if (list.isEmpty()) {
            return 0;
        }
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        Iterator<View> it = ViewGroupKt.getChildren(recyclerView2).iterator();
        if (it.hasNext()) {
            int bottom = it.next().getBottom();
            while (it.hasNext()) {
                int bottom2 = it.next().getBottom();
                if (bottom < bottom2) {
                    bottom = bottom2;
                }
            }
            int i3 = bottom + this.topViewHeight;
            RecyclerView recyclerView3 = this.recycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            }
            ViewGroup.LayoutParams layoutParams = recyclerView3.getLayoutParams();
            if (layoutParams != null) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost((i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin) - getHeight(), this.topViewHeight);
                return coerceAtMost;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        throw new NoSuchElementException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        View view = this.topView;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.topViewGlobalLayoutListener);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        ViewTreeObserver viewTreeObserver;
        super.onFinishInflate();
        this.topView = findViewById(R.id.oco);
        this.recycleView = (RecyclerView) findViewById(R.id.o8n);
        View view = this.topView;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.topViewGlobalLayoutListener);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        RecyclerView recyclerView = this.recycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = getMeasuredHeight();
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        recyclerView2.setLayoutParams(layoutParams);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        View view = this.topView;
        if (view != null) {
            this.topViewHeight = view.getMeasuredHeight();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.topViewGlobalLayoutListener = new a();
        setOrientation(1);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (dyUnconsumed < 0) {
            scrollBy(0, dyUnconsumed);
        }
    }

    @Override // android.view.View
    public void scrollTo(int x16, int y16) {
        if (y16 < 0) {
            y16 = 0;
        }
        int i3 = this.topViewHeight;
        if (y16 > i3) {
            y16 = i3;
        }
        super.scrollTo(x16, y16);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed, int type) {
        boolean z16 = dy5 > 0 && getScrollY() < d();
        boolean z17 = dy5 < 0 && getScrollY() >= 0 && !target.canScrollVertically(-1);
        if (z16 || z17) {
            scrollBy(0, dy5);
            consumed[1] = dy5;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        if ((axes & 2) != 0) {
            RecyclerView recyclerView = this.recycleView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            }
            if (recyclerView.canScrollVertically(1) || d() > 0) {
                return true;
            }
        }
        return false;
    }
}
