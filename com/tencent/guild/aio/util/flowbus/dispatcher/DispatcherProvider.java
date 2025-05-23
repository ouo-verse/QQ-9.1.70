package com.tencent.guild.aio.util.flowbus.dispatcher;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/util/flowbus/dispatcher/DispatcherProvider;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lcom/tencent/guild/aio/util/flowbus/dispatcher/a;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/guild/aio/util/flowbus/dispatcher/a;", "provider", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class DispatcherProvider {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DispatcherProvider f112398a = new DispatcherProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy provider;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.util.flowbus.dispatcher.DispatcherProvider$provider$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        provider = lazy;
    }

    DispatcherProvider() {
    }

    private final a b() {
        return (a) provider.getValue();
    }

    @NotNull
    public final CoroutineDispatcher a() {
        return b().a();
    }
}
