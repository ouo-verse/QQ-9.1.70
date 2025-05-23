package com.tencent.mtt.hippy.adapter;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyLogAdapter {
    public static final int LOG_SEVERITY_DEBUG = -1;
    public static final int LOG_SEVERITY_ERROR = 2;
    public static final int LOG_SEVERITY_FATAL = 3;
    public static final int LOG_SEVERITY_INFO = 0;
    public static final int LOG_SEVERITY_WARNING = 1;

    void onReceiveLogMessage(int i3, @NonNull String str, @NonNull String str2);
}
