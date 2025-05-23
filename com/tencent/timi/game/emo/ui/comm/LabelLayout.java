package com.tencent.timi.game.emo.ui.comm;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.widget.TraceUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002\u0012\u0010B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J0\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\tH\u0004J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/timi/game/emo/ui/comm/LabelLayout;", "Landroid/widget/RelativeLayout;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/widget/RelativeLayout$LayoutParams;", "generateLayoutParams", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "changed", "l", "t", "r", "b", "onLayout", "a", "Landroid/widget/BaseAdapter;", "adapter", "setAdapter", "d", "Landroid/widget/BaseAdapter;", "mAdapter", "Landroid/database/DataSetObserver;", "e", "Landroid/database/DataSetObserver;", "mDataSetObserver", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LabelLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseAdapter mAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DataSetObserver mDataSetObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/emo/ui/comm/LabelLayout$a;", "Landroid/database/DataSetObserver;", "", "onChanged", "<init>", "(Lcom/tencent/timi/game/emo/ui/comm/LabelLayout;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            LabelLayout.this.a();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected final void a() {
        BaseAdapter baseAdapter = this.mAdapter;
        if (baseAdapter == null) {
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < baseAdapter.getCount() && i3 < childCount) {
            baseAdapter.getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > baseAdapter.getCount()) {
            removeViews(i3, childCount - baseAdapter.getCount());
        }
        if (childCount < baseAdapter.getCount()) {
            int count = baseAdapter.getCount();
            while (i3 < count) {
                View view = baseAdapter.getView(i3, null, this);
                Intrinsics.checkNotNullExpressionValue(view, "adapter.getView(i, null, this)");
                addView(view, new ViewGroup.MarginLayoutParams(-2, -2));
                i3++;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        TraceUtils.traceBegin("FlowLayout.onLayout");
        int width = getWidth();
        int childCount = getChildCount();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i19 = marginLayoutParams.leftMargin;
                if (i3 + i19 + measuredWidth + marginLayoutParams.rightMargin > width) {
                    i16 += i17;
                    i3 = 0;
                }
                int i26 = marginLayoutParams.topMargin;
                int i27 = i26 + measuredHeight + marginLayoutParams.bottomMargin;
                int i28 = i19 + i3;
                int i29 = i26 + i16;
                childAt.layout(i28, i29, i28 + measuredWidth, measuredHeight + i29);
                i3 += marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
                i17 = i27;
            }
        }
        TraceUtils.traceEnd();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        int i16;
        int coerceAtLeast;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 1;
        int i28 = 0;
        while (true) {
            if (i17 < childCount) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 8) {
                    i3 = size2;
                } else {
                    measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    i3 = size2;
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i29 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int i36 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i37 = i28 + i29;
                    if (i37 <= size) {
                        i36 = RangesKt___RangesKt.coerceAtLeast(i18, i36);
                        i29 = i37;
                    } else {
                        i27++;
                        if (i27 > 2) {
                            i26 = RangesKt___RangesKt.coerceAtLeast(i28, i29);
                            i19 += i18;
                            break;
                        } else {
                            i26 = RangesKt___RangesKt.coerceAtLeast(i28, i29);
                            i19 += i36;
                        }
                    }
                    if (i17 == childCount - 1) {
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i29, i26);
                        i19 += i36;
                        i18 = i36;
                        i26 = coerceAtLeast;
                    } else {
                        i18 = i36;
                    }
                    i28 = i29;
                }
                i17++;
                size2 = i3;
            } else {
                i3 = size2;
                break;
            }
        }
        if (mode != 1073741824) {
            size = i26;
        }
        if (mode2 == 1073741824) {
            i16 = i3;
        } else {
            i16 = i19;
        }
        setMeasuredDimension(size, i16);
    }

    public final void setAdapter(@NotNull BaseAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        BaseAdapter baseAdapter = this.mAdapter;
        if (baseAdapter != null) {
            baseAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        removeAllViews();
        this.mAdapter = adapter;
        a aVar = new a();
        this.mDataSetObserver = aVar;
        adapter.registerDataSetObserver(aVar);
        adapter.notifyDataSetChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    @NotNull
    public RelativeLayout.LayoutParams generateLayoutParams(@Nullable AttributeSet attrs) {
        return (RelativeLayout.LayoutParams) new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    public /* synthetic */ LabelLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDataSetObserver = new a();
    }
}
