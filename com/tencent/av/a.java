package com.tencent.av;

import com.tencent.avcore.util.IAVLog;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IAVLog {
    @Override // com.tencent.avcore.util.IAVLog
    public void d(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.d(str, 4, str2);
        }
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void e(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.tencent.avcore.util.IAVLog
    public long genDebugSeq() {
        return com.tencent.av.utils.e.d();
    }

    @Override // com.tencent.avcore.util.IAVLog
    public String getVersion() {
        return AppSetting.f99551k;
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void i(String str, String str2) {
        QLog.d(str, 1, str2);
    }

    @Override // com.tencent.avcore.util.IAVLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.avcore.util.IAVLog
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.tencent.avcore.util.IAVLog
    public boolean isDevelopLevel() {
        return QLog.isDevelopLevel();
    }

    @Override // com.tencent.avcore.util.IAVLog
    public boolean isGrayVersion() {
        return false;
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void printAllUserLog(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void printColorLog(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2);
        }
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void printDebugLog(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.d(str, 4, str2);
        }
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void printErrorLog(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void printInfoLog(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.d(str, 4, str2);
        }
    }

    @Override // com.tencent.avcore.util.IAVLog
    public void e(String str, String str2, Throwable th5) {
        QLog.i(str, 1, str2, th5);
    }
}
