package lx4;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Llx4/f;", "", "Ljava/lang/Runnable;", "job", "", "delayMillis", "c", "", "d", "a", "b", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface f {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static /* synthetic */ Runnable a(f fVar, Runnable runnable, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                return fVar.c(runnable, j3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeComputeJob");
        }

        public static /* synthetic */ Runnable b(f fVar, Runnable runnable, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                return fVar.a(runnable, j3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeIOJob");
        }

        public static /* synthetic */ Runnable c(f fVar, Runnable runnable, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                return fVar.b(runnable, j3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeNetJob");
        }
    }

    @NotNull
    Runnable a(@NotNull Runnable job, long delayMillis);

    @NotNull
    Runnable b(@NotNull Runnable job, long delayMillis);

    @NotNull
    Runnable c(@NotNull Runnable job, long delayMillis);

    void d(@NotNull Runnable job);
}
