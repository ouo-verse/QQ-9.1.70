package com.tencent.qqmini.sdk.core.proxy.service;

import android.util.Log;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;

@ProxyService(proxy = LogProxy.class)
/* loaded from: classes23.dex */
public class LogProxyDefault extends LogProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public int getUinReportLogLevel() {
        return 3;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public boolean isColorLevel() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy
    public void log(int i3, String str, String str2, Throwable th5) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (th5 == null) {
                            Log.v(str, str2);
                            return;
                        } else {
                            Log.v(str, str2, th5);
                            return;
                        }
                    }
                    if (th5 == null) {
                        Log.e(str, str2);
                        return;
                    } else {
                        Log.e(str, str2, th5);
                        return;
                    }
                }
                if (th5 == null) {
                    Log.w(str, str2);
                    return;
                } else {
                    Log.w(str, str2, th5);
                    return;
                }
            }
            if (th5 == null) {
                Log.i(str, str2);
                return;
            } else {
                Log.i(str, str2, th5);
                return;
            }
        }
        if (th5 == null) {
            Log.d(str, str2);
        } else {
            Log.d(str, str2, th5);
        }
    }
}
