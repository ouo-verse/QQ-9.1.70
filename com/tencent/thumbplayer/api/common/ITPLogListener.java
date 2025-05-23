package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPLogListener {
    public static final int TP_LOG_LEVEL_DEBUG = 1;
    public static final int TP_LOG_LEVEL_ERROR = 4;
    public static final int TP_LOG_LEVEL_INFO = 2;
    public static final int TP_LOG_LEVEL_VERBOSE = 0;
    public static final int TP_LOG_LEVEL_WARN = 3;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface LogLevel {
    }

    void d(String str, String str2);

    void e(String str, String str2);

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);
}
