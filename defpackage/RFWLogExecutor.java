package defpackage;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"LRFWLogExecutor;", "", "", "isSubThread", "Ljava/lang/Runnable;", "runnable", "", "a", "Lm;", "Lkotlin/Lazy;", "b", "()Lm;", "logThreadPool", "<init>", "()V", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWLogExecutor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy logThreadPool;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final RFWLogExecutor f25095b = new RFWLogExecutor();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<m>() { // from class: RFWLogExecutor$logThreadPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final m invoke() {
                return new m(0, 0, 0L, null, null, null, 63, null);
            }
        });
        logThreadPool = lazy;
    }

    RFWLogExecutor() {
    }

    private final m b() {
        return (m) logThreadPool.getValue();
    }

    public final void a(boolean isSubThread, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (isSubThread) {
            b().execute(runnable);
        } else {
            runnable.run();
        }
    }
}
