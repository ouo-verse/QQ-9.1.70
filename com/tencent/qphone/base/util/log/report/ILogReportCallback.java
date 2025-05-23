package com.tencent.qphone.base.util.log.report;

import android.util.Pair;

/* compiled from: P */
/* loaded from: classes22.dex */
interface ILogReportCallback {
    int getDay(boolean z16);

    int getHour(boolean z16);

    int getMonth(boolean z16);

    Pair<Long, Long> getTimePeriod();

    int getYear(boolean z16);

    void onStateChange(int i3);
}
