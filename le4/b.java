package le4;

import com.tencent.videocut.utils.thread.PriorityThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lle4/b;", "", "Ljava/lang/Runnable;", "runnable", "", "a", "Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "getBackgroundThread", "()Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "backgroundThread$annotations", "()V", "backgroundThread", "<init>", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f414432b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PriorityThreadPoolExecutor backgroundThread = new PriorityThreadPoolExecutor(1, 60, TimeUnit.SECONDS);

    b() {
    }

    public final void a(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        backgroundThread.execute(runnable);
    }
}
