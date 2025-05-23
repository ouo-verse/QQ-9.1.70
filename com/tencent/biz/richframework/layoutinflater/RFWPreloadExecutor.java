package com.tencent.biz.richframework.layoutinflater;

import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWPreloadExecutor;", "", "()V", "asyncPreloadThreadPool", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflatePool;", "getAsyncPreloadThreadPool", "()Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflatePool;", "asyncPreloadThreadPool$delegate", "Lkotlin/Lazy;", "execute", "", "runnable", "Ljava/lang/Runnable;", "remove", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWPreloadExecutor {

    @NotNull
    public static final RFWPreloadExecutor INSTANCE = new RFWPreloadExecutor();

    /* renamed from: asyncPreloadThreadPool$delegate, reason: from kotlin metadata */
    private static final Lazy asyncPreloadThreadPool;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RFWAsyncLayoutInflatePool>() { // from class: com.tencent.biz.richframework.layoutinflater.RFWPreloadExecutor$asyncPreloadThreadPool$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWAsyncLayoutInflatePool invoke() {
                return new RFWAsyncLayoutInflatePool(0, 0, 0L, null, null, null, 63, null);
            }
        });
        asyncPreloadThreadPool = lazy;
    }

    RFWPreloadExecutor() {
    }

    private final RFWAsyncLayoutInflatePool getAsyncPreloadThreadPool() {
        return (RFWAsyncLayoutInflatePool) asyncPreloadThreadPool.getValue();
    }

    public final void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            getAsyncPreloadThreadPool().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public final void remove(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getAsyncPreloadThreadPool().remove(runnable);
    }
}
