package le4;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lle4/c;", "", "", "a", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "b", "J", "delayMs", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "delayTask", "<init>", "(JLjava/lang/Runnable;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long delayMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Runnable delayTask;

    public c(long j3, @NotNull Runnable delayTask) {
        Intrinsics.checkParameterIsNotNull(delayTask, "delayTask");
        this.delayMs = j3;
        this.delayTask = delayTask;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public final synchronized void a() {
        this.handler.removeCallbacks(this.delayTask);
        this.handler.postDelayed(this.delayTask, this.delayMs);
    }
}
