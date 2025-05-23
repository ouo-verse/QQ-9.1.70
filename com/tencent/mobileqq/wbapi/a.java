package com.tencent.mobileqq.wbapi;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wbapi.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8962a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f313231d;

        C8962a(Runnable runnable) {
            this.f313231d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else {
                QLog.d("OpenSdkQIPCClient", 1, "WBQIPCClient installWBSdk onCallback");
                this.f313231d.run();
            }
        }
    }

    public static void a(Runnable runnable) {
        QLog.d("OpenSdkQIPCClient", 1, "installWBSdk process=" + Common.m());
        QIPCClientHelper.getInstance().callServer("weibo_qipc_module", "action_install_weibo_sdk", new Bundle(), new C8962a(runnable));
    }
}
