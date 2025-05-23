package com.tencent.mobileqq.triton.utils;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "", "printConsoleLog", "", "level", "Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;", "tag", "", "message", "throwable", "", "printJsConsoleLog", "logStr", "printLog", "Level", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface LogDelegate {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void printConsoleLog$default(LogDelegate logDelegate, Level level, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    th5 = null;
                }
                logDelegate.printConsoleLog(level, str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: printConsoleLog");
        }

        public static /* synthetic */ void printLog$default(LogDelegate logDelegate, Level level, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    th5 = null;
                }
                logDelegate.printLog(level, str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: printLog");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", RLog.ERROR, "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    @Deprecated(message = "\u4f7f\u7528[printJsConsoleLog]")
    void printConsoleLog(@NotNull Level level, @NotNull String tag, @NotNull String message, @Nullable Throwable throwable);

    void printJsConsoleLog(@NotNull String logStr);

    void printLog(@NotNull Level level, @NotNull String tag, @NotNull String message, @Nullable Throwable throwable);
}
