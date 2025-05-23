package com.tencent.mobileqq.guild.discoveryv2.content.part;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Landroidx/lifecycle/LifecycleOwner;", "a", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleOwner;", "hostLifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "b", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleCoroutineScope;", "hostLifecycleScope", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    @NotNull
    public static final LifecycleOwner a(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        LifecycleOwner lifecycleOwner = part.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        return lifecycleOwner;
    }

    @NotNull
    public static final LifecycleCoroutineScope b(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return LifecycleOwnerKt.getLifecycleScope(a(part));
    }
}
