package org.apache.commons.logging;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface Log {
    void debug(Object obj);

    void debug(Object obj, Throwable th5);

    void error(Object obj);

    void error(Object obj, Throwable th5);

    void fatal(Object obj);

    void fatal(Object obj, Throwable th5);

    void info(Object obj);

    void info(Object obj, Throwable th5);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isFatalEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(Object obj);

    void trace(Object obj, Throwable th5);

    void warn(Object obj);

    void warn(Object obj, Throwable th5);
}
