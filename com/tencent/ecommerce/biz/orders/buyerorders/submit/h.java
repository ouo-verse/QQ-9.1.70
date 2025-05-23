package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/h;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "Landroid/graphics/Canvas;", "c", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "e", "Landroid/graphics/Rect;", "bounds", "Landroid/content/Context;", "f", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Rect bounds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public h(Context context) {
        this.context = context;
        Paint paint = new Paint(1);
        paint.setColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
        this.bounds = new Rect();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if (r6 < (r0 - 1)) goto L14;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        boolean z16;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        RecyclerView.ViewHolder findContainingViewHolder = parent.findContainingViewHolder(view);
        if (!(findContainingViewHolder instanceof com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.b) && !(findContainingViewHolder instanceof com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.a)) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            outRect.set(0, 0, 0, this.context.getResources().getDimensionPixelSize(R.dimen.f9940q));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c16, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            parent.getDecoratedBoundsWithMargins(parent.getChildAt(i3), this.bounds);
            c16.drawRect(this.bounds, this.paint);
        }
    }
}
