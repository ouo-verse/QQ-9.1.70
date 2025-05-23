package com.tencent.mobileqq.richmediabrowser;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.IBrowserLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k implements IBrowserLog {
    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void d(String str, int i3, String str2) {
        if (isColorLevel()) {
            QLog.d(str, i3, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void e(String str, int i3, String str2) {
        if (isColorLevel()) {
            QLog.e(str, i3, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void i(String str, int i3, String str2) {
        if (isColorLevel()) {
            QLog.i(str, i3, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void w(String str, int i3, String str2) {
        if (isColorLevel()) {
            QLog.w(str, i3, str2);
        }
    }
}
