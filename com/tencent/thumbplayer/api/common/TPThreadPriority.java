package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPThreadPriority {
    public static final int TP_THREAD_PRIORITY_AUDIO = 35;
    public static final int TP_THREAD_PRIORITY_BACKGROUND = 9;
    public static final int TP_THREAD_PRIORITY_DEFAULT = -1;
    public static final int TP_THREAD_PRIORITY_DISPLAY = 23;
    public static final int TP_THREAD_PRIORITY_FOREGROUND = 21;
    public static final int TP_THREAD_PRIORITY_LOWEST = 0;
    public static final int TP_THREAD_PRIORITY_NORMAL = 19;
    public static final int TP_THREAD_PRIORITY_URGENT_AUDIO = 38;
    public static final int TP_THREAD_PRIORITY_URGENT_DISPLAY = 27;
    public static final int TP_THREAD_PRIORITY_VIDEO = 29;
}
