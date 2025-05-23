package com.tencent.filament.zplanservice.util.log;

import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.filament.zplanservice.util.log.ILogDelegate;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplanservice/util/log/FLog;", "", "()V", "logDelegate", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate;", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "init", "delegate", "v", "w", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FLog {

    @NotNull
    public static final FLog INSTANCE = new FLog();
    private static ILogDelegate logDelegate;

    FLog() {
    }

    public static /* synthetic */ void d$default(FLog fLog, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        fLog.d(str, str2, th5);
    }

    public static /* synthetic */ void e$default(FLog fLog, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        fLog.e(str, str2, th5);
    }

    public static /* synthetic */ void i$default(FLog fLog, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        fLog.i(str, str2, th5);
    }

    public static /* synthetic */ void v$default(FLog fLog, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        fLog.v(str, str2, th5);
    }

    public static /* synthetic */ void w$default(FLog fLog, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        fLog.w(str, str2, th5);
    }

    public final void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        d(tag, msg2, null);
    }

    public final void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        e(tag, msg2, null);
    }

    public final void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        i(tag, msg2, null);
    }

    public final void init(@NotNull ILogDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        logDelegate = delegate;
    }

    public final void v(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        v(tag, msg2, null);
    }

    public final void w(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        w(tag, msg2, null);
    }

    public final void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (logDelegate == null) {
            Log.d(tag, msg2, throwable);
        }
        ILogDelegate iLogDelegate = logDelegate;
        if (iLogDelegate != null) {
            iLogDelegate.a(ILogDelegate.Level.DEBUG, tag, msg2, throwable);
        }
    }

    public final void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (logDelegate == null) {
            Log.e(tag, msg2, throwable);
        }
        ILogDelegate iLogDelegate = logDelegate;
        if (iLogDelegate != null) {
            iLogDelegate.a(ILogDelegate.Level.ERROR, tag, msg2, throwable);
        }
    }

    public final void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (logDelegate == null) {
            Log.i(tag, msg2, throwable);
        }
        ILogDelegate iLogDelegate = logDelegate;
        if (iLogDelegate != null) {
            iLogDelegate.a(ILogDelegate.Level.INFO, tag, msg2, throwable);
        }
    }

    public final void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (logDelegate == null) {
            Log.v(tag, msg2, throwable);
        }
        ILogDelegate iLogDelegate = logDelegate;
        if (iLogDelegate != null) {
            iLogDelegate.a(ILogDelegate.Level.VERBOSE, tag, msg2, throwable);
        }
    }

    public final void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (logDelegate == null) {
            Log.w(tag, msg2, throwable);
        }
        ILogDelegate iLogDelegate = logDelegate;
        if (iLogDelegate != null) {
            iLogDelegate.a(ILogDelegate.Level.WARN, tag, msg2, throwable);
        }
    }
}
