package com.tencent.mobileqq.guild.media.game.service.repository;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0004\u001a\u00020\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/service/repository/a;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/media/game/service/repository/a;", "KernelService", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGameKernelServiceKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f228809a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<a>() { // from class: com.tencent.mobileqq.guild.media.game.service.repository.GuildGameKernelServiceKt$KernelService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        f228809a = lazy;
    }

    @NotNull
    public static final a a() {
        return (a) f228809a.getValue();
    }
}
