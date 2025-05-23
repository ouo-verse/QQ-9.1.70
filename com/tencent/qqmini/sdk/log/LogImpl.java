package com.tencent.qqmini.sdk.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.log.Log;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class LogImpl implements Log {
    private LogProxy logProxy = (LogProxy) ProxyManager.get(LogProxy.class);
    private boolean isDebug = false;

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public void d(String str, String str2, Throwable th5) {
        LogProxy logProxy = this.logProxy;
        if (logProxy != null) {
            logProxy.log(2, str, str2, th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public void e(String str, String str2, Throwable th5) {
        LogProxy logProxy = this.logProxy;
        if (logProxy != null) {
            logProxy.log(5, str, str2, th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public int getLogLevel() {
        return 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public void i(String str, String str2, Throwable th5) {
        LogProxy logProxy = this.logProxy;
        if (logProxy != null && this.isDebug) {
            logProxy.log(3, str, str2, th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public boolean isColorLevel() {
        LogProxy logProxy = this.logProxy;
        if (logProxy != null) {
            return logProxy.isColorLevel();
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.log.Log
    public void w(String str, String str2, Throwable th5) {
        LogProxy logProxy = this.logProxy;
        if (logProxy != null) {
            logProxy.log(4, str, str2, th5);
        }
    }
}
