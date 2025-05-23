package com.tencent.rmonitor.base.plugin.listener;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IBatteryListener extends IBaseListener {
    @Nullable
    String getBlackClassName();

    void onPrintLog(@Nullable String str);

    void onUsageAlarm(int i3, int i16, int i17, String str, String str2);
}
