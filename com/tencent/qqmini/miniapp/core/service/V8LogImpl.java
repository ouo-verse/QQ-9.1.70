package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.v8rt.engine.ILog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8LogImpl implements ILog {
    static final String TAG = "MIV8RT";
    private boolean isDebug = false;

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int d(String str, String str2) {
        QMLog.d("MIV8RT/" + str, str2, null);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int e(String str, String str2) {
        QMLog.e("MIV8RT/" + str, str2);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int i(String str, String str2) {
        if (!this.isDebug) {
            return 0;
        }
        QMLog.i("MIV8RT/" + str, str2);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public void printNativeLog(int i3, String str, String str2) {
        String str3 = "MIV8RT/" + str;
        if (i3 >= 100) {
            i3 = (i3 - 100) + 2;
        }
        if (i3 <= 2) {
            QMLog.d(str3, str2);
            return;
        }
        if (i3 == 3) {
            QMLog.i(str3, str2);
        } else if (i3 == 4) {
            QMLog.w(str3, str2);
        } else if (i3 == 5) {
            QMLog.e(str3, str2);
        }
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int w(String str, String str2) {
        QMLog.w("MIV8RT/" + str, str2);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int d(String str, String str2, Throwable th5) {
        QMLog.d("MIV8RT/" + str, str2, th5);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int e(String str, String str2, Throwable th5) {
        QMLog.e("MIV8RT/" + str, str2, th5);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int w(String str, String str2, Throwable th5) {
        QMLog.w("MIV8RT/" + str, str2, th5);
        return 0;
    }

    @Override // com.tencent.qqmini.v8rt.engine.ILog
    public int i(String str, String str2, Throwable th5) {
        QMLog.i("MIV8RT/" + str, str2, th5);
        return 0;
    }
}
