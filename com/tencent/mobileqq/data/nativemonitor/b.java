package com.tencent.mobileqq.data.nativemonitor;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements com.tencent.mobileqq.nlog.b {
    @Override // com.tencent.mobileqq.nlog.b
    public void e(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    @Override // com.tencent.mobileqq.nlog.b
    public void i(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.tencent.mobileqq.nlog.b
    public void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    @Override // com.tencent.mobileqq.nlog.b
    public void i(String str, String str2, Throwable th5) {
        QLog.i(str, 1, str2, th5);
    }
}
