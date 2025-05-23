package com.tencent.mobileqq.wbapi;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f313232d;

    b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        if (f313232d == null) {
            synchronized (b.class) {
                if (f313232d == null) {
                    f313232d = new b("weibo_qipc_module");
                }
            }
        }
        return f313232d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        QLog.d("WeiBoQIPCModule", 1, "onCall main proc action : " + str);
        if ("action_install_weibo_sdk".equals(str)) {
            WBShareHelper.h(3);
            callbackResult(i3, EIPCResult.createSuccessResult(new Bundle()));
            return null;
        }
        return null;
    }
}
