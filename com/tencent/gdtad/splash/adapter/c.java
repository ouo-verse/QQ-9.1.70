package com.tencent.gdtad.splash.adapter;

import com.qq.e.comm.pi.TangramAdLogger;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements TangramAdLogger {
    @Override // com.qq.e.comm.pi.TangramAdLogger
    public void logD(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.qq.e.comm.pi.TangramAdLogger
    public void logE(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }
}
