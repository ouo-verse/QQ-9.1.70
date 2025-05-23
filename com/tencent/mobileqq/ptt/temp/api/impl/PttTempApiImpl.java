package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.utils.ff;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PttTempApiImpl implements IPttTempApi {
    static IPatchRedirector $redirector_;

    public PttTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public void doOnPttSrvAddressError(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
        } else if (z16) {
            FMTSrvAddrProvider.getInstance().getPttIpSaver().V1(0);
        } else {
            FMTSrvAddrProvider.getInstance().onFailed(16, str);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public Message getLastMessage(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Message) iPatchRedirector.redirect((short) 5, this, appRuntime, str, Integer.valueOf(i3));
        }
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) appRuntime).getMessageFacade().getLastMessage(str, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public MessageRecord getMsgItemByUniseq(AppRuntime appRuntime, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, this, appRuntime, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) appRuntime).getMessageFacade().P(str, i3, j3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public int getPttVipFlag(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime, (Object) str)).intValue();
        }
        return ff.n(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public boolean isHotChat(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime == null) {
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public void sendMessage(AppRuntime appRuntime, MessageRecord messageRecord, BaseMessageObserver baseMessageObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, messageRecord, baseMessageObserver);
        } else if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            ((QQAppInterface) appRuntime).getMessageFacade().D0(messageRecord, (bs) baseMessageObserver);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public void setJsPttLocalPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            ((IPublicAccountH5AbilityPtt) QRoute.api(IPublicAccountH5AbilityPtt.class)).setLocalPathForPtt(str);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public void setJsPttServerId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTempApi
    public void updateMsgContentByUniseq(AppRuntime appRuntime, String str, int i3, long j3, byte[] bArr) {
        QQMessageFacade qQMessageFacade;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        } else {
            if (appRuntime == null || (qQMessageFacade = (QQMessageFacade) appRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE)) == null) {
                return;
            }
            qQMessageFacade.Y0(str, i3, j3, bArr);
        }
    }
}
