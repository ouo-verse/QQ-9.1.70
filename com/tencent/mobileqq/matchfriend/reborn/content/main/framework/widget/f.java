package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Landroid/view/View;", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f {
    public static final View a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecycleViewChildResidualFillGroup recycleViewChildResidualFillGroup = new RecycleViewChildResidualFillGroup(context);
        recycleViewChildResidualFillGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        recycleViewChildResidualFillGroup.addView(view, layoutParams);
        return recycleViewChildResidualFillGroup;
    }
}
