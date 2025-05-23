package com.tencent.map.geolocation.internal;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface TencentLog {
    public static final String LOGNAME = "txwatchdog";
    public static final String PREFIX = "txwatchdog_";

    String getDirString();

    void println(String str, int i3, @NonNull String str2);
}
