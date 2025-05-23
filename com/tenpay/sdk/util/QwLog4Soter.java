package com.tenpay.sdk.util;

import com.tencent.soter.core.model.ISoterLogger;
import com.tenpay.QwLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QwLog4Soter implements ISoterLogger {
    private static QwLog4Soter mImp = new QwLog4Soter();

    QwLog4Soter() {
    }

    public static QwLog4Soter getInstance() {
        return mImp;
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void d(String str, String str2, Object... objArr) {
        QwLog.d(str + "," + String.format(str2, objArr));
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void e(String str, String str2, Object... objArr) {
        QwLog.e(str + "," + String.format(str2, objArr));
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void i(String str, String str2, Object... objArr) {
        QwLog.i(str + "," + String.format(str2, objArr));
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void printErrStackTrace(String str, Throwable th5, String str2) {
        QwLog.e(th5.getMessage());
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void v(String str, String str2, Object... objArr) {
        QwLog.i(str + "," + String.format(str2, objArr));
    }

    @Override // com.tencent.soter.core.model.ISoterLogger
    public void w(String str, String str2, Object... objArr) {
        QwLog.e(str + "," + String.format(str2, objArr));
    }
}
