package e22;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Le22/b;", "", "Le22/a;", "logInterface", "", "b", "a", "Le22/a;", "log", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f395373a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static a log;

    b() {
    }

    @NotNull
    public final a a() {
        a aVar = log;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("log");
            return null;
        }
        return aVar;
    }

    public final void b(@NotNull a logInterface) {
        Intrinsics.checkNotNullParameter(logInterface, "logInterface");
        log = logInterface;
    }
}
