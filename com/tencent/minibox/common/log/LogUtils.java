package com.tencent.minibox.common.log;

import androidx.annotation.Keep;
import com.tencent.minibox.proxy.LogProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J'\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013H\u0007\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/minibox/common/log/LogUtils;", "", "()V", "mImpl", "Lcom/tencent/minibox/proxy/LogProxy;", "tagPrefix", "", "d", "", "tag", "msg", "throwable", "", "e", "i", "injectImpl", "impl", "printArray", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)V", "v", "w", "MiniBoxCommon_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class LogUtils {
    private static LogProxy mImpl;
    public static final LogUtils INSTANCE = new LogUtils();
    private static String tagPrefix = "[MiniBoxSDK]";

    LogUtils() {
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        d(tag, msg2, null);
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        d(str, str2, th5);
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        e(tag, msg2, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        e(str, str2, th5);
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        i(tag, msg2, null);
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        i(str, str2, th5);
    }

    @JvmStatic
    public static final void injectImpl(@Nullable LogProxy impl) {
        mImpl = impl;
    }

    @JvmStatic
    public static final void printArray(@NotNull Object tag, @Nullable Object[] args) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
    }

    @JvmStatic
    public static final void v(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        v(tag, msg2, null);
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        v(str, str2, th5);
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        w(tag, msg2, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        w(str, str2, th5);
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        LogProxy logProxy = mImpl;
        if (logProxy != null) {
            logProxy.d(tagPrefix + tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        LogProxy logProxy = mImpl;
        if (logProxy != null) {
            logProxy.e(tagPrefix + tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        LogProxy logProxy = mImpl;
        if (logProxy != null) {
            logProxy.i(tagPrefix + tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        LogProxy logProxy = mImpl;
        if (logProxy != null) {
            logProxy.v(tagPrefix + tag, msg2, throwable);
        }
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        LogProxy logProxy = mImpl;
        if (logProxy != null) {
            logProxy.w(tagPrefix + tag, msg2, throwable);
        }
    }
}
