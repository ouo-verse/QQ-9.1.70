package kotlin;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lkotlin/Function0;", "", "action", "d", "", "delayMS", "Ljava/lang/Runnable;", "runnable", "b", "c", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "sMainHandler", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* renamed from: fq1.d, reason: from Kotlin metadata */
/* loaded from: classes13.dex */
public final class Function0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Handler f400320a = new Handler(Looper.getMainLooper());

    public static final void b(int i3, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        f400320a.postDelayed(runnable, i3);
    }

    public static final void c(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        f400320a.removeCallbacks(runnable);
    }

    public static final void d(@NotNull final kotlin.jvm.functions.Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            action.invoke();
        } else {
            f400320a.post(new Runnable() { // from class: fq1.c
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.e(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(kotlin.jvm.functions.Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
