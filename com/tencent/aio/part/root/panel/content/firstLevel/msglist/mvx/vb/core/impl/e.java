package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "Lkotlin/Function0;", "invoke", "a", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class e {
    @Nullable
    public static final <T> T a(@NotNull RefreshType valid, @NotNull Function0<? extends T> invoke) {
        Intrinsics.checkNotNullParameter(valid, "$this$valid");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        if (valid != RefreshType.RefreshInit) {
            return invoke.invoke();
        }
        return null;
    }
}
