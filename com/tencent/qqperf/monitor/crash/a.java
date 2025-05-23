package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.l;
import java.lang.Thread;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends d {
    private void k(StringBuilder sb5, String str, String str2) {
        if (1 == MobileQQ.sProcessId && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains("ANR_EXCEPTION")) {
            com.tencent.imcore.message.core.g.b().a(sb5);
            l.c(sb5);
        }
    }

    private void l(StringBuilder sb5) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            sb5.append("\nThread.DefaultUncaughtExceptionHandler info:" + defaultUncaughtExceptionHandler.getClass().getName());
        }
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public boolean a(boolean z16, String str, String str2, String str3, int i3) {
        if (z16 || TextUtils.isEmpty(str) || !str.contains("ANR_EXCEPTION")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public void b(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        super.b(context, z16, str, str2, str3, i3, j3, str4);
        StringBuilder sb5 = new StringBuilder();
        k(sb5, str, str2);
        QLog.d("QQCrashReportManager_ANRProcessor", 1, sb5.toString());
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public String c(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.c(context, z16, str, str2, str3, i3, j3, str4));
        l(sb5);
        return sb5.toString();
    }
}
