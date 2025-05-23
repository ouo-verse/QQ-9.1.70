package com.qzone.app;

import com.tencent.component.media.ILog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ImageLogger implements ILog {
    @Override // com.tencent.component.media.ILog
    public void d(String str, Object... objArr) {
        if (QZLog.isColorLevel()) {
            QZLog.d(str, 2, objArr);
        }
    }

    @Override // com.tencent.component.media.ILog
    public void i(String str, Object... objArr) {
        if (QZLog.isColorLevel()) {
            QZLog.i(str, 1, objArr);
        }
    }

    @Override // com.tencent.component.media.ILog
    public void e(String str, Object... objArr) {
        QZLog.e(str, 1, objArr);
    }

    @Override // com.tencent.component.media.ILog
    public void fatal(String str, String str2, Throwable th5) {
        w5.b.h(str, 1, th5);
    }

    @Override // com.tencent.component.media.ILog
    public void w(String str, Object... objArr) {
        QZLog.w(str, 1, objArr);
    }
}
