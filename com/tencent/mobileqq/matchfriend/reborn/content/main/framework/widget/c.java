package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/c;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/view/View;", "child", "", "widthUsed", "heightUsed", "", "measureChildWithMargins", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        int b16;
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof RecycleViewChildResidualFillGroup) {
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int position = getPosition(child);
            while (position > 0) {
                position--;
                b16 = d.b(this, position);
                height -= b16;
            }
            ViewGroup.LayoutParams layoutParams = ((RecycleViewChildResidualFillGroup) child).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).height = height;
        }
        super.measureChildWithMargins(child, widthUsed, heightUsed);
    }
}
