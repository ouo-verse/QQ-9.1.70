package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "", "width", "height", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "LayoutParamsEx")
/* loaded from: classes13.dex */
public final class o {
    public static final void a(@NotNull View view, int i3, int i16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (i3 != view.getMeasuredWidth() || (i16 != view.getMeasuredHeight() && view.getLayoutParams() != null)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i3;
                layoutParams.height = i16;
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }
}
