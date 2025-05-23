package com.tencent.sqshow.zootopia.taskcenter.header.progress;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import fc4.e;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001\u0004B)\b\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J0\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/header/progress/ProgressIconLayout;", "Landroid/widget/RelativeLayout;", "Ljava/util/Observer;", "", "a", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "b", "l", "i1", "i2", "i3", "onLayout", "Ljava/util/Observable;", "o", "", "arg", "update", "Lfc4/e;", "adapter", "setAdapter", "d", "I", "getProgressWidth", "()I", "setProgressWidth", "(I)V", "progressWidth", "e", "Lfc4/e;", "f", "getProgressBarIndex", "setProgressBarIndex", "progressBarIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ProgressIconLayout extends RelativeLayout implements Observer {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int progressWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int progressBarIndex;

    public ProgressIconLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a() {
        e.a aVar;
        e eVar = this.adapter;
        if (eVar == null) {
            return;
        }
        Integer valueOf = eVar != null ? Integer.valueOf(eVar.a()) : null;
        Intrinsics.checkNotNull(valueOf);
        int intValue = valueOf.intValue();
        for (int i3 = 0; i3 < intValue; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof e.a)) {
                Object tag = childAt.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.taskcenter.header.progress.ProgressIconAdapter.ViewHolder");
                aVar = (e.a) tag;
            } else {
                e eVar2 = this.adapter;
                Intrinsics.checkNotNull(eVar2);
                e eVar3 = this.adapter;
                Intrinsics.checkNotNull(eVar3);
                e.a d16 = eVar2.d(this, eVar3.b(i3));
                d16.getItemView().setTag(d16);
                if (childAt == null) {
                    addView(d16.getItemView(), i3);
                }
                aVar = d16;
            }
            e eVar4 = this.adapter;
            Intrinsics.checkNotNull(eVar4);
            eVar4.c(aVar, i3);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean b16, int l3, int i16, int i26, int i3) {
        int i17;
        int i18;
        int childCount = getChildCount();
        int i19 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i27 = this.progressBarIndex;
            if (i19 == i27) {
                i18 = marginLayoutParams.leftMargin;
                i17 = this.progressWidth + i18 + marginLayoutParams.rightMargin;
            } else {
                int i28 = ((this.progressWidth * (((i27 == -1 || i27 > i19) ? i19 : i19 - 1) + 1)) / (childCount - 1)) - (measuredWidth / 2);
                i17 = measuredWidth + i28;
                i18 = i28;
            }
            int height = ((getHeight() - measuredHeight) / 2) - marginLayoutParams.topMargin;
            int i29 = measuredHeight + height;
            QLog.d("ProgressIconLayout", 4, "cl=" + i18 + ", ct" + height + ", cr" + i17 + ", cb" + i29);
            childAt.layout(i18, height, i17, i29);
            i19++;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            int measuredWidth = childAt2.getMeasuredWidth();
            int measuredHeight = childAt2.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i18 = marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
            if (i18 > i3) {
                this.progressBarIndex = i17;
                this.progressWidth = measuredWidth;
                i3 = i18;
            }
            int i19 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            if (i19 > i16) {
                i16 = i19;
            }
        }
        int i26 = this.progressBarIndex;
        if (i26 >= 0 && i26 == childCount - 1) {
            childAt = getChildAt(childCount - 2);
        } else {
            int i27 = childCount - 1;
            childAt = i26 != i27 ? getChildAt(i27) : null;
        }
        if (childAt != null) {
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            i3 += (childAt.getMeasuredWidth() / 2) + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
        }
        if (mode != 1073741824) {
            size = i3;
        }
        if (mode2 != 1073741824) {
            size2 = i16;
        }
        setMeasuredDimension(size, size2);
    }

    public final void setAdapter(e adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        Intrinsics.checkNotNull(adapter);
        adapter.addObserver(this);
    }

    public final void setProgressBarIndex(int i3) {
        this.progressBarIndex = i3;
    }

    public final void setProgressWidth(int i3) {
        this.progressWidth = i3;
    }

    @Override // java.util.Observer
    public void update(Observable o16, Object arg) {
        a();
        requestLayout();
    }

    public ProgressIconLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public ProgressIconLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public /* synthetic */ ProgressIconLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
