package com.tencent.sqshow.zootopia.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sc4.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J0\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J'\u0010\u0016\u001a\u00020\u0003\"\u0010\b\u0000\u0010\u0014*\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R \u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/ZPlanAverageLinearLayout;", "Landroid/widget/LinearLayout;", "Ljava/util/Observer;", "", "a", "", "changed", "", "l", "t", "r", "b", "onLayout", "Ljava/util/Observable;", "o", "", "arg", "update", "Lsc4/a;", "Lsc4/a$a;", "T", "adapter", "setAdapter", "(Lsc4/a;)V", "d", "Lsc4/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAverageLinearLayout extends LinearLayout implements Observer {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a<? extends a.AbstractC11222a> adapter;

    public ZPlanAverageLinearLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a() {
        a.AbstractC11222a abstractC11222a;
        a<? extends a.AbstractC11222a> aVar = this.adapter;
        if (aVar == null) {
            return;
        }
        Integer valueOf = aVar != null ? Integer.valueOf(aVar.a()) : null;
        Intrinsics.checkNotNull(valueOf);
        int intValue = valueOf.intValue();
        for (int i3 = 0; i3 < intValue; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a.AbstractC11222a)) {
                Object tag = childAt.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.widget.ZPlanAverageLinearLayoutAdapter.ViewHolder");
                abstractC11222a = (a.AbstractC11222a) tag;
            } else {
                a<? extends a.AbstractC11222a> aVar2 = this.adapter;
                Intrinsics.checkNotNull(aVar2);
                a<? extends a.AbstractC11222a> aVar3 = this.adapter;
                Intrinsics.checkNotNull(aVar3);
                a.AbstractC11222a d16 = aVar2.d(this, aVar3.b(i3));
                d16.getItemView().setTag(d16);
                if (childAt == null) {
                    addView(d16.getItemView(), i3);
                }
                abstractC11222a = d16;
            }
            a<? extends a.AbstractC11222a> aVar4 = this.adapter;
            Intrinsics.checkNotNull(aVar4);
            aVar4.c(abstractC11222a, i3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        int childCount = getChildCount();
        int measuredWidth = childCount > 0 ? (getMeasuredWidth() - (getChildCount() * getChildAt(0).getMeasuredWidth())) / (childCount - 1) : 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int height = ((getHeight() - childAt.getMeasuredHeight()) / 2) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int measuredHeight = childAt.getMeasuredHeight() + height;
            int measuredWidth2 = (childAt.getMeasuredWidth() + measuredWidth) * i3;
            childAt.layout(measuredWidth2, height, childAt.getMeasuredWidth() + measuredWidth2, measuredHeight);
        }
    }

    public final <T extends a<? extends a.AbstractC11222a>> void setAdapter(T adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        Intrinsics.checkNotNull(adapter);
        adapter.addObserver(this);
    }

    @Override // java.util.Observer
    public void update(Observable o16, Object arg) {
        a();
        requestLayout();
    }

    public ZPlanAverageLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ZPlanAverageLinearLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ZPlanAverageLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
