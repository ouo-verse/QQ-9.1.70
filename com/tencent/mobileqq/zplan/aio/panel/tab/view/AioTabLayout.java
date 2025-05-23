package com.tencent.mobileqq.zplan.aio.panel.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Lcom/google/android/material/tabs/TabLayout$g;", "J", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AioTabLayout extends TabLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioTabLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.google.android.material.tabs.TabLayout
    public TabLayout.g J() {
        TabLayout.g J = super.J();
        Intrinsics.checkNotNullExpressionValue(J, "super.newTab()");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View aioTabIcon = new AioTabIcon(context, null, 0, 6, null);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(g.c(aioTabIcon, 32.0f), g.c(aioTabIcon, 32.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = g.c(aioTabIcon, 4.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = g.c(aioTabIcon, 4.0f);
        aioTabIcon.setLayoutParams(layoutParams);
        J.p(aioTabIcon);
        return J;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AioTabLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AioTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setSelectedTabIndicator((Drawable) null);
        setTabRippleColor(null);
    }
}
