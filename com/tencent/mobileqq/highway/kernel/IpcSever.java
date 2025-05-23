package com.tencent.mobileqq.highway.kernel;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IpcSever extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String MODULE_NAME = "BDHKernelEngine";
    private IInject inject;

    public IpcSever(IInject iInject) {
        super("BDHKernelEngine");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iInject);
        } else {
            this.inject = iInject;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppInterface appInterface = (AppInterface) this.inject.getRuntime();
        if (appInterface == null) {
            return EIPCResult.createResult(-2003, null);
        }
        return appInterface.getHwEngine().kernelEngine.onCall(str, bundle, i3);
    }
}
