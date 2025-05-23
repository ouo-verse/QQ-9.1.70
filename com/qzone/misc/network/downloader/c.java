package com.qzone.misc.network.downloader;

import com.tencent.component.network.module.base.inter.Log;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements Log {
    @Override // com.tencent.component.network.module.base.inter.Log
    public void d(String str, String str2) {
        QZLog.d(str, 4, str2);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void e(String str, String str2) {
        QZLog.e(str, str2);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public int getLogLevel() {
        if (QLog.isDevelopLevel()) {
            return 2;
        }
        return QLog.isColorLevel() ? 3 : 4;
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void i(String str, String str2) {
        QZLog.i(str, 2, str2);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void w(String str, String str2) {
        QZLog.w(str, str2);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void d(String str, String str2, Throwable th5) {
        QZLog.d(str, 4, str2, th5);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void e(String str, String str2, Throwable th5) {
        QZLog.e(str, str2, th5);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void i(String str, String str2, Throwable th5) {
        QZLog.i(str, 1, str2, th5);
    }

    @Override // com.tencent.component.network.module.base.inter.Log
    public void w(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
    }
}
