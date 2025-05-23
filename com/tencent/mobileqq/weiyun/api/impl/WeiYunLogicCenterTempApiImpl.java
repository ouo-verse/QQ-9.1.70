package com.tencent.mobileqq.weiyun.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weiyun.api.IWeiYunLogicCenterTempApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeiYunLogicCenterTempApiImpl implements IWeiYunLogicCenterTempApi {
    static IPatchRedirector $redirector_;
    private AppRuntime mAppRuntime;

    public WeiYunLogicCenterTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQAppInterface getQQAppInterface() {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime instanceof QQAppInterface) {
            return (QQAppInterface) appRuntime;
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiYunLogicCenterTempApi
    public void saveAioMedia2Weiyun(ChatMessage chatMessage, com.tencent.mobileqq.weiyun.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatMessage, (Object) aVar);
            return;
        }
        QQAppInterface qQAppInterface = getQQAppInterface();
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.getFileManagerEngine().Y().A(chatMessage, aVar);
    }
}
