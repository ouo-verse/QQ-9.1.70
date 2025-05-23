package com.tencent.ecommerce.biz.detail.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010+\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010*\u001a\u00020#\u00a2\u0006\u0004\b,\u0010-J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0019R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/ECShopDetailItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "position", "", "b", "d", "Lkotlin/Lazy;", "a", "()I", "rightMargin", "e", "I", "getTopSpace", "setTopSpace", "(I)V", "topSpace", "f", "getSideSpace", "setSideSpace", "sideSpace", h.F, "getColumn", "setColumn", "column", "Lbh0/b;", "i", "Lbh0/b;", "getAdapter", "()Lbh0/b;", "setAdapter", "(Lbh0/b;)V", "adapter", "midSpace", "<init>", "(IIIILbh0/b;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy rightMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int topSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sideSpace;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int column;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bh0.b adapter;

    public ECShopDetailItemDecoration(int i3, int i16, final int i17, int i18, bh0.b bVar) {
        Lazy lazy;
        this.topSpace = i3;
        this.sideSpace = i16;
        this.column = i18;
        this.adapter = bVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration$rightMargin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return i17 / 2;
            }
        });
        this.rightMargin = lazy;
    }

    private final int a() {
        return ((Number) this.rightMargin.getValue()).intValue();
    }

    public final boolean b(int position) {
        ECBasePtsViewData i06 = this.adapter.i0(position);
        if (i06 != null) {
            return (Intrinsics.areEqual(i06.getPageName(), "shop_home_product_card") || Intrinsics.areEqual(i06.getPageName(), "apply_sample_recommend_card") || Intrinsics.areEqual(i06.getPageName(), "product_detail_saas_card") || Intrinsics.areEqual(i06.getPageName(), "product_detail_saas_card")) ? false : true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsViewData");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        if (view.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                if (b(childLayoutPosition)) {
                    layoutParams2.setFullSpan(true);
                    return;
                }
                layoutParams2.setFullSpan(false);
                outRect.bottom = this.topSpace;
                if (layoutParams2.getSpanIndex() % this.column == 0) {
                    outRect.left = this.sideSpace;
                    outRect.right = a();
                    return;
                }
                int spanIndex = layoutParams2.getSpanIndex();
                int i3 = this.column;
                if (spanIndex % i3 == i3 - 1) {
                    outRect.left = a();
                    outRect.right = this.sideSpace;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        }
    }
}
