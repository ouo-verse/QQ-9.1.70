package com.tencent.libra.download;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlin/Lazy;", "b", "()Lkotlinx/coroutines/CoroutineDispatcher;", "subDispatcher", "libra-core_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class RFWQuicDownloaderKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f118666a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.libra.download.RFWQuicDownloaderKt$subDispatcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                return new e();
            }
        });
        f118666a = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineDispatcher b() {
        return (CoroutineDispatcher) f118666a.getValue();
    }
}
