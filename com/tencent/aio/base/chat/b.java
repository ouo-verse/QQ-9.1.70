package com.tencent.aio.base.chat;

import com.tencent.aio.main.fragment.ChatFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a2\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\b\u0007H\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a2\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\b\u0007H\u0000\u00a2\u0006\u0004\b\u000b\u0010\n\u001a2\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\b\u0007H\u0000\u00a2\u0006\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPie;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "fragment", "Lts/a;", "b", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "invoke", "c", "(Lcom/tencent/aio/base/chat/ChatPie;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "a", "d", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    public static final <T> T a(@NotNull ChatPie coldLoad, @NotNull Function1<? super ChatPie, ? extends T> invoke) {
        Intrinsics.checkNotNullParameter(coldLoad, "$this$coldLoad");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        T invoke2 = invoke.invoke(coldLoad);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.e("ChatPie", "coldLoad complete");
        } else {
            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "coldLoad complete");
        }
        return invoke2;
    }

    @NotNull
    public static final ts.a b(@NotNull ChatPie fetchLauncher, @NotNull ChatFragment fragment) {
        Intrinsics.checkNotNullParameter(fetchLauncher, "$this$fetchLauncher");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new com.tencent.aio.runtime.launcher.b(fetchLauncher.o().buildActivityJumpService(), fragment);
    }

    public static final <T> T c(@NotNull ChatPie preLoad, @NotNull Function1<? super ChatPie, ? extends T> invoke) {
        Intrinsics.checkNotNullParameter(preLoad, "$this$preLoad");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        T invoke2 = invoke.invoke(preLoad);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.e("ChatPie", "preLoad complete");
        } else {
            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "preLoad complete");
        }
        return invoke2;
    }

    public static final <T> T d(@NotNull ChatPie warmLoad, @NotNull Function1<? super ChatPie, ? extends T> invoke) {
        Intrinsics.checkNotNullParameter(warmLoad, "$this$warmLoad");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        T invoke2 = invoke.invoke(warmLoad);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.e("ChatPie", "warmLoad complete");
        } else {
            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "warmLoad complete");
        }
        return invoke2;
    }
}
