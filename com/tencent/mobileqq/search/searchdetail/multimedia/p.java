package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\b\u0005\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Landroid/view/ViewGroup$LayoutParams;", "LP", "Landroid/view/View;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "", NodeProps.VISIBLE, "b", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class p {
    public static final <LP extends ViewGroup.LayoutParams> void a(@NotNull View view, @NotNull Function1<? super LP, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type LP of com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaDisplayUtilKt.updateLayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void b(@NotNull View view, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }
}
