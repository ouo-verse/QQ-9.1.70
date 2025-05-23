package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ExceptionsKt")
/* loaded from: classes28.dex */
public class ExceptionsKt__ExceptionsKt {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void addSuppressed(@NotNull Throwable th5, @NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (th5 != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th5, exception);
        }
    }

    @NotNull
    public static final StackTraceElement[] getStackTrace(@NotNull Throwable th5) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        StackTraceElement[] stackTrace = th5.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    @NotNull
    public static final List<Throwable> getSuppressedExceptions(@NotNull Throwable th5) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th5);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th5) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        th5.printStackTrace();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static String stackTraceToString(@NotNull Throwable th5) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th5, PrintWriter writer) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        th5.printStackTrace(writer);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable th5, PrintStream stream) {
        Intrinsics.checkNotNullParameter(th5, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        th5.printStackTrace(stream);
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable th5) {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th5) {
    }
}
