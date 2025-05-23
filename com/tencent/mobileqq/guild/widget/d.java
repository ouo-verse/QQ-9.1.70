package com.tencent.mobileqq.guild.widget;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.guild.widget.BubbleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView$b;", "", "orientation", "c", LayoutAttrDefine.Gravity.Gravity, "b", "backgroundColor", "a", "viewRes", "e", "Landroid/view/View;", "targetView", "Lcom/tencent/mobileqq/guild/widget/BubbleView;", "d", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {
    @NotNull
    public static final BubbleView.b a(@NotNull BubbleView.b bVar, int i3) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f(i3);
        return bVar;
    }

    @NotNull
    public static final BubbleView.b b(@NotNull BubbleView.b bVar, int i3) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.g(i3);
        return bVar;
    }

    @NotNull
    public static final BubbleView.b c(@NotNull BubbleView.b bVar, int i3) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.h(i3);
        return bVar;
    }

    @NotNull
    public static final BubbleView d(@NotNull BubbleView.b bVar, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        BubbleView bubbleView = new BubbleView(bVar.getContext(), null, 2, null);
        bubbleView.h(bVar, targetView);
        return bubbleView;
    }

    @NotNull
    public static final BubbleView.b e(@NotNull BubbleView.b bVar, @LayoutRes int i3) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.i(i3);
        return bVar;
    }
}
