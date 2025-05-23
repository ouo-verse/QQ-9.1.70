package mn3;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\bJ+\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\n\u0010\bJ+\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\u000b\u0010\bJ+\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rR\u001c\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lmn3/a;", "", "", "msg", "", "args", "", "a", "(Ljava/lang/String;[Ljava/lang/Object;)V", "b", "d", "c", "f", "", "exception", "e", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "Lorg/slf4j/Logger;", "logger", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f417045a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Logger logger = LoggerFactory.getLogger("CoreAVStage.Synchronizer");

    a() {
    }

    public final void a(@Nullable String msg2, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        logger2.info("begin fetching seq info -> " + msg2, Arrays.copyOf(copyOf, copyOf.length));
    }

    public final void b(@Nullable String msg2, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        logger2.info("end fetching seq info -> " + msg2, Arrays.copyOf(copyOf, copyOf.length));
    }

    public final void c(@Nullable String msg2, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        logger2.info("end fetching seq info -> " + msg2, Arrays.copyOf(copyOf, copyOf.length));
    }

    public final void d(@Nullable String msg2, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        logger2.error("error fetching seq info -> " + msg2, Arrays.copyOf(copyOf, copyOf.length));
    }

    public final void e(@Nullable String msg2, @NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        logger2.error("error fetching seq info -> " + msg2, exception);
    }

    public final void f(@Nullable String msg2, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Logger logger2 = logger;
        Intrinsics.checkNotNullExpressionValue(logger2, "logger");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        logger2.error("error fetching seq info -> " + msg2, Arrays.copyOf(copyOf, copyOf.length));
    }
}
