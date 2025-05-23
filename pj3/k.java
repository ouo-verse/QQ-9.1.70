package pj3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lpj3/k;", "Ldl0/j;", "Ljava/lang/Runnable;", "job", "", "delayMillis", "", "threadType", "e", "", "f", "c", "a", "b", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements dl0.j {
    private final void f(Runnable job, int threadType) {
        ThreadManagerV2.removeJob(job, threadType);
    }

    @Override // dl0.j
    public Runnable a(Runnable job, long delayMillis) {
        Intrinsics.checkNotNullParameter(job, "job");
        return e(job, delayMillis, 64);
    }

    @Override // dl0.j
    public Runnable b(Runnable job, long delayMillis) {
        Intrinsics.checkNotNullParameter(job, "job");
        return e(job, delayMillis, 128);
    }

    @Override // dl0.j
    public Runnable c(Runnable job, long delayMillis) {
        Intrinsics.checkNotNullParameter(job, "job");
        return e(job, delayMillis, 16);
    }

    @Override // dl0.j
    public void d(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        f(job, 16);
    }

    private final Runnable e(Runnable job, long delayMillis, int threadType) {
        if (delayMillis > 0) {
            Runnable executeDelay = ThreadManagerV2.executeDelay(job, threadType, null, false, delayMillis);
            Intrinsics.checkNotNullExpressionValue(executeDelay, "{\n            ThreadMana\u2026e, delayMillis)\n        }");
            return executeDelay;
        }
        ThreadManagerV2.excute(job, threadType, null, false);
        return job;
    }
}
