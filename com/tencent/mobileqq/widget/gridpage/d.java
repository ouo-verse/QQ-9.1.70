package com.tencent.mobileqq.widget.gridpage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.gridpage.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u0000 **\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001+B\u0015\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/d;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "T", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "pageIndex", "Landroid/view/View;", "e", "f", "Landroid/content/Context;", "context", "columnCount", "Landroidx/recyclerview/widget/GridLayoutManager;", "g", "getCount", "view", "", "obj", "", "isViewFromObject", ParseCommon.CONTAINER, "position", "instantiateItem", "", "destroyItem", "Lcom/tencent/mobileqq/widget/gridpage/b;", "d", "Lcom/tencent/mobileqq/widget/gridpage/b;", "getItemAdapter", "()Lcom/tencent/mobileqq/widget/gridpage/b;", "itemAdapter", "I", "mItemCount", "mColumnCount", h.F, "mRowCount", "i", "pageItemCount", "<init>", "(Lcom/tencent/mobileqq/widget/gridpage/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
final class d<T extends com.tencent.mobileqq.widget.gridpage.c> extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.gridpage.b<T> itemAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mItemCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mColumnCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mRowCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int pageItemCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/widget/gridpage/d$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f316891d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d<T> f316892e;

        b(int i3, d<T> dVar) {
            this.f316891d = i3;
            this.f316892e = dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            GridLayoutManager.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof GridLayoutManager.LayoutParams) {
                layoutParams = (GridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                return;
            }
            int width = (parent.getWidth() - (this.f316891d * ((d) this.f316892e).mColumnCount)) / (((d) this.f316892e).mColumnCount - 1);
            int i3 = ((((d) this.f316892e).mColumnCount - 1) * width) / ((d) this.f316892e).mColumnCount;
            int spanIndex = (width - i3) * layoutParams.getSpanIndex();
            outRect.left = spanIndex;
            outRect.right = i3 - spanIndex;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/widget/gridpage/d$c", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollVertically", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends GridLayoutManager {
        c(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public d(@NotNull com.tencent.mobileqq.widget.gridpage.b<T> itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
        this.itemAdapter = itemAdapter;
        int b16 = itemAdapter.b();
        this.mItemCount = b16;
        int a16 = itemAdapter.a();
        this.mColumnCount = a16;
        int e16 = itemAdapter.e();
        this.mRowCount = e16;
        this.pageItemCount = a16 * e16;
        QLog.i("QQViewPagerGridPage", 1, "set adapter, [item:" + b16 + " column:" + a16 + " row:" + e16 + " page:" + getF373114d() + "]");
    }

    private final View e(ViewGroup parent, int pageIndex) {
        RecyclerView recyclerView = new RecyclerView(parent.getContext());
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        recyclerView.setLayoutManager(g(context, this.mColumnCount));
        recyclerView.setAdapter(new a(this.pageItemCount, pageIndex, f(pageIndex), this.itemAdapter));
        if (this.mColumnCount > 1) {
            recyclerView.addItemDecoration(new b(x.c(parent.getContext(), this.itemAdapter.d()), this));
        }
        return recyclerView;
    }

    private final int f(int pageIndex) {
        if (this.pageItemCount <= 0) {
            return 0;
        }
        if (pageIndex == getF373114d() - 1) {
            return ((this.mItemCount - 1) % this.pageItemCount) + 1;
        }
        return this.pageItemCount;
    }

    private final GridLayoutManager g(Context context, int columnCount) {
        return new c(context, columnCount);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj instanceof View) {
            container.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        int i3 = this.pageItemCount;
        if (i3 > 0) {
            return ((this.mItemCount - 1) / i3) + 1;
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View e16 = e(container, position);
        container.addView(e16);
        return e16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }
}
