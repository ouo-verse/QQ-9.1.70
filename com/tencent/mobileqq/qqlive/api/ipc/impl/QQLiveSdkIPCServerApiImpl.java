package com.tencent.mobileqq.qqlive.api.ipc.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.qqlive.ipc.QQLiveSdkIPCServerModule;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes17.dex */
public class QQLiveSdkIPCServerApiImpl implements IQQLiveSdkIPCServerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLive_IPC_API";

    public QQLiveSdkIPCServerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi
    public QIPCModule getServerIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "init");
        }
        return QQLiveSdkIPCServerModule.INSTANCE;
    }
}
