package com.tencent.gdtad.statistics.metric;

import com.tencent.ams.monitor.metric.j;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements j {
    @Override // com.tencent.ams.monitor.metric.j
    public void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void i(String str, String str2, Throwable th5) {
        QLog.i(str, 1, str2, th5);
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void d(String str, String str2, Throwable th5) {
    }
}
