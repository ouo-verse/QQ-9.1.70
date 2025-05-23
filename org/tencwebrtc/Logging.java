package org.tencwebrtc;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Logging {
    private static final Logger fallbackLogger = createFallbackLogger();

    @Nullable
    private static Loggable loggable;
    private static Severity loggableSeverity;
    private static volatile boolean loggingEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.Logging$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$Logging$Severity;

        static {
            int[] iArr = new int[Severity.values().length];
            $SwitchMap$org$tencwebrtc$Logging$Severity = iArr;
            try {
                iArr[Severity.LS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Severity.LS_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Severity.LS_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Severity {
        LS_VERBOSE,
        LS_INFO,
        LS_WARNING,
        LS_ERROR,
        LS_NONE
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes29.dex */
    public enum TraceLevel {
        TRACE_NONE(0),
        TRACE_STATEINFO(1),
        TRACE_WARNING(2),
        TRACE_ERROR(4),
        TRACE_CRITICAL(8),
        TRACE_APICALL(16),
        TRACE_DEFAULT(255),
        TRACE_MODULECALL(32),
        TRACE_MEMORY(256),
        TRACE_TIMER(512),
        TRACE_STREAM(1024),
        TRACE_DEBUG(2048),
        TRACE_INFO(4096),
        TRACE_TERSEINFO(8192),
        TRACE_ALL(65535);

        public final int level;

        TraceLevel(int i3) {
            this.level = i3;
        }
    }

    private static Logger createFallbackLogger() {
        Logger logger = Logger.getLogger("org.tencwebrtc.Logging");
        logger.setLevel(Level.ALL);
        return logger;
    }

    public static void d(String str, String str2) {
        log(Severity.LS_INFO, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteInjectedLoggable() {
        loggable = null;
    }

    public static void e(String str, String str2) {
        log(Severity.LS_ERROR, str, str2);
    }

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Severity severity) {
        synchronized (Logging.class) {
            if (loggable == null) {
                nativeEnableLogToDebugOutput(severity.ordinal());
                loggingEnabled = true;
            } else {
                throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
            }
        }
    }

    private static String getStackTraceString(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void injectLoggable(Loggable loggable2, Severity severity) {
        if (loggable2 != null) {
            loggable = loggable2;
            loggableSeverity = severity;
        }
    }

    public static void log(Severity severity, String str, String str2) {
        Level level;
        if (str != null && str2 != null) {
            if (loggable != null) {
                if (severity.ordinal() < loggableSeverity.ordinal()) {
                    return;
                }
                loggable.onLogMessage(str2, severity, str);
                return;
            }
            if (loggingEnabled) {
                nativeLog(severity.ordinal(), str, str2);
                return;
            }
            int i3 = AnonymousClass1.$SwitchMap$org$tencwebrtc$Logging$Severity[severity.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        level = Level.FINE;
                    } else {
                        level = Level.INFO;
                    }
                } else {
                    level = Level.WARNING;
                }
            } else {
                level = Level.SEVERE;
            }
            fallbackLogger.log(level, str + MsgSummary.STR_COLON + str2);
            return;
        }
        throw new IllegalArgumentException("Logging tag or message may not be null.");
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int i3);

    private static native void nativeLog(int i3, String str, String str2);

    public static void v(String str, String str2) {
        log(Severity.LS_VERBOSE, str, str2);
    }

    public static void w(String str, String str2) {
        log(Severity.LS_WARNING, str, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        Severity severity = Severity.LS_ERROR;
        log(severity, str, str2);
        log(severity, str, th5.toString());
        log(severity, str, getStackTraceString(th5));
    }

    public static void w(String str, String str2, Throwable th5) {
        Severity severity = Severity.LS_WARNING;
        log(severity, str, str2);
        log(severity, str, th5.toString());
        log(severity, str, getStackTraceString(th5));
    }

    @Deprecated
    public static void enableTracing(String str, EnumSet<TraceLevel> enumSet) {
    }
}
