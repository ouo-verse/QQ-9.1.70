package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"RESUMED", "", "RESUME_TOKEN", "Lkotlinx/coroutines/internal/Symbol;", "getRESUME_TOKEN$annotations", "()V", DebugCoroutineInfoImplKt.SUSPENDED, "UNDECIDED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CancellableContinuationImplKt {
    private static final int RESUMED = 2;

    @JvmField
    @NotNull
    public static final Symbol RESUME_TOKEN = new Symbol("RESUME_TOKEN");
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    public static /* synthetic */ void getRESUME_TOKEN$annotations() {
    }
}
