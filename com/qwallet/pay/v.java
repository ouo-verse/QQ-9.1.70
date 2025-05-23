package com.qwallet.pay;

import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v implements IMidasLogCallback {
    @Override // com.tencent.midas.api.IMidasLogCallback
    public void onLogging(int i3, String str, String str2) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    QLog.d(str, 4, str2);
                    return;
                } else {
                    QLog.e(str, 1, str2);
                    return;
                }
            }
            QLog.w(str, 1, str2);
            return;
        }
        QLog.i(str, 4, str2);
    }
}
