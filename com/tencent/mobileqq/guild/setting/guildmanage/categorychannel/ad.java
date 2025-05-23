package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010-\u001a\u00020,\u0012\b\b\u0001\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020\u0002\u0012\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R0\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/ad;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "color", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "Lkotlin/Function3;", "", "d", "Lkotlin/jvm/functions/Function3;", "isCurrentItemNeedDividerCallback", "", "e", "[I", Node.ATTRS_ATTR, "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "backgroundPaint", tl.h.F, "paint", "i", "I", "dividerHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.MARGIN_LEFT, BdhLogUtil.LogTag.Tag_Conn, NodeProps.MARGIN_RIGHT, "Landroid/graphics/drawable/Drawable;", "D", "Landroid/graphics/drawable/Drawable;", "divider", "Landroid/content/Context;", "context", "dividerColor", "dividerHeightPx", "marginLeftPx", "marginRightPx", "<init>", "(Landroid/content/Context;IIIILkotlin/jvm/functions/Function3;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends RecyclerView.ItemDecoration {

    /* renamed from: C, reason: from kotlin metadata */
    private final int marginRight;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final Drawable divider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function3<? super Integer, ? super RecyclerView, ? super RecyclerView.State, Boolean> isCurrentItemNeedDividerCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] attrs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint backgroundPaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int dividerHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int marginLeft;

    public ad(@NotNull Context context, @ColorInt int i3, int i16, int i17, int i18, @Nullable Function3<? super Integer, ? super RecyclerView, ? super RecyclerView.State, Boolean> function3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCurrentItemNeedDividerCallback = function3;
        int[] iArr = {R.attr.listDivider};
        this.attrs = iArr;
        Paint paint = new Paint(1);
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        this.dividerHeight = i16;
        this.marginLeft = i17;
        this.marginRight = i18;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttributes(attrs)");
        this.divider = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public final void a(int color) {
        Paint paint = new Paint(1);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        this.backgroundPaint = paint;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, this.dividerHeight);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int paddingLeft = parent.getPaddingLeft() + this.marginLeft;
        int width = (parent.getWidth() - parent.getPaddingRight()) - this.marginRight;
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Function3<? super Integer, ? super RecyclerView, ? super RecyclerView.State, Boolean> function3 = this.isCurrentItemNeedDividerCallback;
            if (function3 != null) {
                z16 = function3.invoke(Integer.valueOf(i3), parent, state).booleanValue();
            } else {
                z16 = true;
            }
            if (z16) {
                View childAt = parent.getChildAt(i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
                int i16 = this.dividerHeight + bottom;
                Drawable drawable = this.divider;
                if (drawable != null) {
                    drawable.setBounds(paddingLeft, bottom, width, i16);
                    drawable.draw(canvas);
                }
                float f16 = paddingLeft;
                float f17 = bottom;
                float f18 = width;
                float f19 = i16;
                canvas.drawRect(f16, f17, f18, f19, this.paint);
                Paint paint = this.backgroundPaint;
                if (paint != null) {
                    canvas.drawRect(parent.getPaddingLeft(), f17, f16, f19, paint);
                    canvas.drawRect(f18, f17, f18 + this.marginRight, f19, paint);
                }
            }
        }
    }
}
