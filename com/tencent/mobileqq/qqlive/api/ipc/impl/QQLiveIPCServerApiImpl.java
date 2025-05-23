package com.tencent.mobileqq.qqlive.api.ipc.impl;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveIPCServerApi;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule;
import eipc.EIPCResult;

/* loaded from: classes17.dex */
public class QQLiveIPCServerApiImpl implements IQQLiveIPCServerApi {
    static IPatchRedirector $redirector_;

    public QQLiveIPCServerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ipc.IQQLiveIPCServerApi
    @Nullable
    public EIPCResult callSync(@Nullable String str, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bundle);
        }
        return QQLiveServerQIPCModule.INSTANCE.b(str, bundle);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ipc.IQQLiveIPCServerApi
    public QIPCModule getQQLiveServerIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QQLiveServerQIPCModule.INSTANCE.c();
    }
}
