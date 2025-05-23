package com.tencent.ecommerce.biz.logistics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/l;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "view", "", "a", "c", "b", "Landroid/graphics/Rect;", "outRect", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    public l() {
        Paint paint = new Paint();
        paint.setColor(ECSkin.INSTANCE.getColor(R.color.f6762f));
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        View findViewById = view.findViewById(R.id.f163105ob4);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 0) {
                outRect.set(0, com.tencent.ecommerce.biz.util.e.c(4.0f), 0, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c16, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c16, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = parent.getChildAt(i3);
                int childAdapterPosition = parent.getChildAdapterPosition(childAt);
                if (childAdapterPosition == 1) {
                    a(c16, childAt);
                } else if (childAdapterPosition == adapter.getItemCount() - 1) {
                    c(c16, childAt);
                } else if (childAdapterPosition != 0) {
                    b(c16, childAt);
                }
            }
        }
    }

    private final void a(Canvas canvas, View view) {
        View findViewById = view.findViewById(R.id.ob5);
        int top = view.getTop();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int top2 = top + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0) + findViewById.getTop() + (findViewById.getHeight() / 2);
        int left = view.getLeft();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams2 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        int left2 = left + (marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0) + findViewById.getLeft() + ((findViewById.getWidth() - com.tencent.ecommerce.biz.util.e.c(1.0f)) / 2);
        int bottom = view.getBottom();
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? layoutParams3 : null);
        canvas.drawRect(new Rect(left2, top2, com.tencent.ecommerce.biz.util.e.c(1.0f) + left2, bottom + (marginLayoutParams3 != null ? marginLayoutParams3.bottomMargin : 0)), this.paint);
    }

    private final void b(Canvas canvas, View view) {
        View findViewById = view.findViewById(R.id.ob5);
        int c16 = view.findViewById(R.id.f163105ob4).getVisibility() == 0 ? com.tencent.ecommerce.biz.util.e.c(4.0f) : 0;
        int top = view.getTop();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i3 = (top + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0)) - c16;
        int left = view.getLeft();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams2 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        int left2 = left + (marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0) + findViewById.getLeft() + ((findViewById.getWidth() - com.tencent.ecommerce.biz.util.e.c(1.0f)) / 2);
        int bottom = view.getBottom();
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? layoutParams3 : null);
        canvas.drawRect(new Rect(left2, i3, com.tencent.ecommerce.biz.util.e.c(1.0f) + left2, bottom + (marginLayoutParams3 != null ? marginLayoutParams3.bottomMargin : 0)), this.paint);
    }

    private final void c(Canvas canvas, View view) {
        View findViewById = view.findViewById(R.id.ob5);
        int c16 = view.findViewById(R.id.f163105ob4).getVisibility() == 0 ? com.tencent.ecommerce.biz.util.e.c(4.0f) : 0;
        int top = view.getTop();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i3 = (top + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0)) - c16;
        int left = view.getLeft();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams2 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        int left2 = left + (marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0) + findViewById.getLeft() + ((findViewById.getWidth() - com.tencent.ecommerce.biz.util.e.c(1.0f)) / 2);
        int top2 = view.getTop();
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? layoutParams3 : null);
        canvas.drawRect(new Rect(left2, i3, com.tencent.ecommerce.biz.util.e.c(1.0f) + left2, top2 + (marginLayoutParams3 != null ? marginLayoutParams3.topMargin : 0) + findViewById.getTop() + (findViewById.getHeight() / 2)), this.paint);
    }
}
