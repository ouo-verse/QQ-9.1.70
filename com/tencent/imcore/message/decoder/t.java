package com.tencent.imcore.message.decoder;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class t implements j {
    static IPatchRedirector $redirector_;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(Message message) {
        int i3 = message.msgtype;
        if (i3 != -3006 && i3 != -5004) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (b(message)) {
            if (message.msgtype == -3006) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                message.f203106msg = MessageForPubAccount.getMsgSummary(qQAppInterface, message, false);
                if (message.istroop == 1) {
                    message.nickName = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(qQAppInterface, BaseApplication.getContext());
                    return;
                }
                return;
            }
            message.f203106msg = appRuntime.getApp().getString(R.string.cqa);
        }
    }
}
