package com.tencent.mobileqq.shortvideo.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.utils.Logger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements Logger {
    @Override // com.tencent.richmedia.videocompress.utils.Logger
    public void d(String str, String str2) {
        QLog.d(str, 1, str2);
    }

    @Override // com.tencent.richmedia.videocompress.utils.Logger
    public void e(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    @Override // com.tencent.richmedia.videocompress.utils.Logger
    public void i(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // com.tencent.richmedia.videocompress.utils.Logger
    public void w(String str, String str2) {
        QLog.w(str, 1, str2);
    }

    @Override // com.tencent.richmedia.videocompress.utils.Logger
    public void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, th5, new Object[0]);
    }
}
