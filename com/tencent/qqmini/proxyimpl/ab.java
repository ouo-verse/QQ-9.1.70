package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;

/* compiled from: P */
@ProxyService(proxy = LogProxy.class)
/* loaded from: classes34.dex */
public class ab extends LogProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public int getUinReportLogLevel() {
        return QLog.getUIN_REPORTLOG_LEVEL();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public void log(int i3, String str, String str2, Throwable th5) {
        if (i3 == 2) {
            if (th5 == null) {
                QLog.d(str, 1, str2);
                return;
            } else {
                QLog.d(str, 1, str2, th5);
                return;
            }
        }
        if (i3 == 4) {
            if (th5 == null) {
                QLog.w(str, 1, str2);
                return;
            } else {
                QLog.w(str, 1, str2, th5);
                return;
            }
        }
        if (i3 != 5) {
            if (th5 == null) {
                QLog.i(str, 1, str2);
                return;
            } else {
                QLog.i(str, 1, str2, th5);
                return;
            }
        }
        if (th5 == null) {
            QLog.e(str, 1, str2);
        } else {
            QLog.e(str, 1, str2, th5);
        }
    }
}
