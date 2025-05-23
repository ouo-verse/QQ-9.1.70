package com.tencent.guild.aio.util.ex;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "Lcom/tencent/guild/aio/util/ex/c;", "l", "", "b", "a", "", "padding", "d", "e", "f", "c", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ViewExtKt {
    public static final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getParent() instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static final void b(@NotNull final View view, @NotNull final c l3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(l3, "l");
        final long j3 = 200;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.util.ex.ViewExtKt$setLongClickAndClickListener$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                view.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                l3.onClick(it);
                final View view2 = view;
                view2.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.util.ex.ViewExtKt$setLongClickAndClickListener$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view2.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        view.setOnLongClickListener(l3);
    }

    public static final void c(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    public static final void d(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i3, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void e(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i3, view.getPaddingBottom());
    }

    public static final void f(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), view.getPaddingBottom());
    }
}
