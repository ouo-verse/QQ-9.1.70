package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.utils.LogDelegate;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000bH\u0007J$\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/utils/Logger;", "", "()V", "<set-?>", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "delegate", "getDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "cd", "", "tag", "", "message", "throwable", "", "ce", "ci", "cv", "cw", "d", "e", "i", "init", "printConsoleLog", "logMsg", "v", "w", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class Logger {
    public static final Logger INSTANCE = new Logger();

    @NotNull
    private static LogDelegate delegate;

    Logger() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void cd(@NotNull String str, @NotNull String str2) {
        cd$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void cd$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        cd(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void ce(@NotNull String str, @NotNull String str2) {
        ce$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void ce$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        ce(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void ci(@NotNull String str, @NotNull String str2) {
        ci$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void ci$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        ci(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void cv(@NotNull String str, @NotNull String str2) {
        cv$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void cv$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        cv(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void cw(@NotNull String str, @NotNull String str2) {
        cw$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void cw$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        cw(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String str, @NotNull String str2) {
        d$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        d(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String str, @NotNull String str2) {
        e$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        e(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void i(@NotNull String str, @NotNull String str2) {
        i$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        i(str, str2, th5);
    }

    @JvmStatic
    public static final void init(@NotNull LogDelegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        delegate = delegate2;
    }

    @JvmStatic
    public static final void printConsoleLog(@NotNull String logMsg) {
        Intrinsics.checkParameterIsNotNull(logMsg, "logMsg");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printJsConsoleLog(logMsg);
    }

    @JvmStatic
    @JvmOverloads
    public static final void v(@NotNull String str, @NotNull String str2) {
        v$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        v(str, str2, th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String str, @NotNull String str2) {
        w$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        w(str, str2, th5);
    }

    @NotNull
    public final LogDelegate getDelegate() {
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return logDelegate;
    }

    @JvmStatic
    @JvmOverloads
    public static final void cd(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printConsoleLog(LogDelegate.Level.DEBUG, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void ce(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printConsoleLog(LogDelegate.Level.ERROR, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void ci(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printConsoleLog(LogDelegate.Level.INFO, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void cv(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printConsoleLog(LogDelegate.Level.VERBOSE, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void cw(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printConsoleLog(LogDelegate.Level.WARN, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printLog(LogDelegate.Level.DEBUG, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printLog(LogDelegate.Level.ERROR, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void i(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printLog(LogDelegate.Level.INFO, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void v(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printLog(LogDelegate.Level.VERBOSE, tag, message, throwable);
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        LogDelegate logDelegate = delegate;
        if (logDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        logDelegate.printLog(LogDelegate.Level.WARN, tag, message, throwable);
    }
}
