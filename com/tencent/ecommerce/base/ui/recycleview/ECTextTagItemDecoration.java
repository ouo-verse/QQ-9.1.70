package com.tencent.ecommerce.base.ui.recycleview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001'B!\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010$\u001a\u00020\n\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "b", "", "text", "", "left", "top", "right", "bottom", "a", "c", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration$TextTagRecycleViewAdapter;", "e", "Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration$TextTagRecycleViewAdapter;", "adapter", "", "f", UserInfo.SEX_FEMALE, "fontSize", h.F, "I", "getTextColor", "()I", "textColor", "<init>", "(Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration$TextTagRecycleViewAdapter;FI)V", "TextTagRecycleViewAdapter", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECTextTagItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextTagRecycleViewAdapter adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float fontSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int textColor;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration$TextTagRecycleViewAdapter;", "", "getTextTag", "", "position", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface TextTagRecycleViewAdapter {
        String getTextTag(int position);
    }

    public ECTextTagItemDecoration(TextTagRecycleViewAdapter textTagRecycleViewAdapter, float f16, int i3) {
        this.adapter = textTagRecycleViewAdapter;
        this.fontSize = f16;
        this.textColor = i3;
        Paint paint = new Paint(1);
        paint.setTextSize(f16);
        paint.setColor(i3);
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
    }

    private final void a(Canvas canvas, String text, int left, int top, int right, int bottom) {
        float measureText = this.paint.measureText(text);
        float f16 = left;
        float f17 = (right - left) - measureText;
        float f18 = 2;
        canvas.drawText(text, f16 + (f17 / f18), top + (((bottom - top) - (this.paint.getFontMetrics().descent - this.paint.getFontMetrics().ascent)) / f18) + (this.paint.getFontMetrics().leading - this.paint.getFontMetrics().ascent), this.paint);
    }

    private final void b(Canvas canvas, RecyclerView parent) {
        View next;
        int childAdapterPosition;
        Iterator<View> it = ViewGroupKt.getChildren(parent).iterator();
        while (it.hasNext() && (childAdapterPosition = parent.getChildAdapterPosition((next = it.next()))) >= 0) {
            ViewGroup.LayoutParams layoutParams = next.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                int paddingLeft = next.getPaddingLeft() + (next.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                int top = next.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                int bottom = next.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                String textTag = this.adapter.getTextTag(childAdapterPosition);
                if (childAdapterPosition == 0) {
                    a(canvas, textTag, 0, top, paddingLeft, bottom);
                } else if (!Intrinsics.areEqual(textTag, this.adapter.getTextTag(childAdapterPosition - 1))) {
                    a(canvas, textTag, 0, top, paddingLeft, bottom);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c16, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c16, parent, state);
        b(c16, parent);
    }
}
