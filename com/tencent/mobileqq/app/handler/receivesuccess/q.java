package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, Object obj, String str) {
        if ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(str)) {
            qQAppInterface.getQlinkServiceMgr().e((byte[]) obj);
        }
    }
}
