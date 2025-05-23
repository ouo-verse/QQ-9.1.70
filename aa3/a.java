package aa3;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z93.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Laa3/a;", "Lz93/f;", "Ljava/lang/Runnable;", "action", "", "delayMs", "", "b", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements f {
    private final void b(Runnable action, long delayMs) {
        if (delayMs > 0) {
            new Handler().postDelayed(action, delayMs);
        } else {
            new BaseThread(action).start();
        }
    }

    @Override // z93.f
    public void a(@NotNull Runnable action, long delayMs) {
        Intrinsics.checkNotNullParameter(action, "action");
        b(action, delayMs);
    }
}
