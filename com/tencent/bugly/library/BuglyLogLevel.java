package com.tencent.bugly.library;

import com.tencent.rmonitor.common.logger.LogState;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface BuglyLogLevel {
    public static final int LEVEL_OFF = LogState.OFF.getValue();
    public static final int LEVEL_ERROR = LogState.ERROR.getValue();
    public static final int LEVEL_WARN = LogState.WARN.getValue();
    public static final int LEVEL_INFO = LogState.INFO.getValue();
    public static final int LEVEL_DEBUG = LogState.DEBUG.getValue();
    public static final int LEVEL_VERBOS = LogState.VERBOS.getValue();
}
