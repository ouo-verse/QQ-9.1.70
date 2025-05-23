package com.tencent.mobileqq.guild.media.widget.audiofaceview;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006*$\b\u0002\u0010\t\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a8\u0006\n"}, d2 = {"Landroid/view/ViewGroup;", "", "Landroid/view/View;", "views", "", "a", "(Landroid/view/ViewGroup;[Landroid/view/View;)V", "Lkotlin/Function1;", "", "StatusHandler", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {
    public static final void a(@NotNull ViewGroup viewGroup, @NotNull View... views) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(views, "views");
        for (View view : views) {
            viewGroup.addView(view);
        }
    }
}
