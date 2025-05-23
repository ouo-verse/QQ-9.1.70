package com.qq.e.comm.plugin.g.a;

import android.util.Log;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ams.monitor.metric.j;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b implements j {
    private static String a(String str, String str2, Throwable th5) {
        if (th5 == null) {
            return "[MetricReporter][" + str + "]" + StringUtil.safeString(str2);
        }
        return "[MetricReporter][" + str + "]" + StringUtil.safeString(str2) + '\n' + Log.getStackTraceString(th5);
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void d(String str, String str2, Throwable th5) {
        GDTLogger.d(a(str, str2, th5));
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void e(String str, String str2, Throwable th5) {
        GDTLogger.e(a(str, str2, null), th5);
    }

    @Override // com.tencent.ams.monitor.metric.j
    public void i(String str, String str2, Throwable th5) {
        GDTLogger.i(a(str, str2, th5));
    }

    public void w(String str, String str2, Throwable th5) {
        GDTLogger.w(a(str, str2, null), th5);
    }
}
