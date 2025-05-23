package e32;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Ljava/lang/Exception;", "exception", "", "d", "e", "isThrow", "b", "ic-game-base-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    public static final boolean b(@NotNull final Exception exception, boolean z16) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (z16) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: e32.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.c(exception);
                }
            });
        } else {
            p32.a.a(exception);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "$exception");
        throw exception;
    }

    public static final boolean d(@NotNull Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return b(exception, false);
    }

    public static final boolean e(@NotNull Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return b(exception, false);
    }
}
