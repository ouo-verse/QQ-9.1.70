package com.tencent.mobileqq.service.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.receivesuccess.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.api.IMessageHandlerService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageHandlerServiceImpl implements IMessageHandlerService {
    static IPatchRedirector $redirector_;

    public MessageHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.api.IMessageHandlerService
    public void getRoamMsgInOneDay(AppRuntime appRuntime, String str, long j3, short s16, Bundle bundle, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Long.valueOf(j3), Short.valueOf(s16), bundle, Long.valueOf(j16));
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().j3(str, j3, s16, bundle, j16);
        }
    }

    @Override // com.tencent.mobileqq.service.message.api.IMessageHandlerService
    public void handleGetBlackList(AppInterface appInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, toServiceMsg, fromServiceMsg, obj);
        } else {
            d.a((MessageHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER), toServiceMsg, fromServiceMsg, obj);
        }
    }
}
