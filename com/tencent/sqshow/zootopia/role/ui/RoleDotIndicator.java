package com.tencent.sqshow.zootopia.role.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/RoleDotIndicator;", "Landroid/widget/LinearLayout;", "", "count", "", "a", "dotRes", "setDotRes", "nowSelect", "b", "d", "I", "dotSize", "e", "dotSpace", "f", tl.h.F, "currentSelectedIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RoleDotIndicator extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int dotSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int dotSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int dotRes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentSelectedIndex;

    /* renamed from: m, reason: collision with root package name */
    private static int f372794m = R.drawable.il_;
    private static int C = R.drawable.il9;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleDotIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dotRes = f372794m;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m74.a.f416391d);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026R.styleable.DotIndicator)");
        int i3 = m74.a.f416392e;
        this.dotSize = obtainStyledAttributes.getDimensionPixelSize(i3, ViewUtils.dpToPx(6.0f));
        this.dotSpace = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416393f, ViewUtils.dpToPx(6.0f));
        this.dotRes = obtainStyledAttributes.getResourceId(i3, f372794m);
        obtainStyledAttributes.recycle();
    }

    public final void b(int nowSelect) {
        if (this.currentSelectedIndex == nowSelect || nowSelect >= getChildCount()) {
            return;
        }
        getChildAt(this.currentSelectedIndex).setSelected(false);
        getChildAt(this.currentSelectedIndex).setBackgroundResource(f372794m);
        getChildAt(nowSelect).setSelected(true);
        getChildAt(nowSelect).setBackgroundResource(C);
        this.currentSelectedIndex = nowSelect;
    }

    public final void setDotRes(int dotRes) {
        this.dotRes = dotRes;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setBackgroundResource(dotRes);
        }
    }

    public final void a(int count) {
        if (count <= 1) {
            setVisibility(8);
            return;
        }
        this.currentSelectedIndex = 0;
        setVisibility(0);
        removeAllViews();
        for (int i3 = 0; i3 < count; i3++) {
            View view = new View(getContext());
            view.setBackgroundResource(this.dotRes);
            view.setSelected(false);
            int i16 = this.dotSize;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
            int i17 = this.dotSpace;
            layoutParams.leftMargin = i17;
            layoutParams.rightMargin = i17;
            addView(view, layoutParams);
        }
        getChildAt(this.currentSelectedIndex).setSelected(true);
        getChildAt(this.currentSelectedIndex).setBackgroundResource(C);
    }
}
