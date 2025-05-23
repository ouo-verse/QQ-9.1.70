package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class j implements AdLogAdapter {
    @Override // com.tencent.ad.tangram.log.AdLogAdapter
    public void d(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 4, str2, th5);
        }
    }

    @Override // com.tencent.ad.tangram.log.AdLogAdapter
    public void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    @Override // com.tencent.ad.tangram.log.AdLogAdapter
    public void i(String str, String str2, Throwable th5) {
        QLog.i(str, 1, str2, th5);
    }

    @Override // com.tencent.ad.tangram.log.AdLogAdapter
    public void w(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2, th5);
    }
}
