package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3, byte[] bArr, byte[] bArr2) {
        if (QLog.isColorLevel()) {
            QLog.d("LinkStarDebugProcessor.", 2, "handleLinkStarNotifyPush. linkStarMsgType=" + i3 + " reservedData=" + bArr + " data=" + bArr2);
            return true;
        }
        return true;
    }
}
