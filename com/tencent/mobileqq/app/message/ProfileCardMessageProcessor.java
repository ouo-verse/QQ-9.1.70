package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.PersonInfoChange;
import IMMsgBodyPack.PersonInfoField;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ag;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class ProfileCardMessageProcessor extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    public ProfileCardMessageProcessor(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        }
    }

    private void C(MsgInfo msgInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "Recieved user info update");
        }
        JceInputStream jceInputStream = new JceInputStream(msgInfo.vMsg);
        jceInputStream.setServerEncoding("utf-8");
        PersonInfoChange personInfoChange = new PersonInfoChange();
        personInfoChange.readFrom(jceInputStream);
        byte b16 = personInfoChange.cType;
        if (b16 == 0) {
            Iterator<PersonInfoField> it = personInfoChange.vChgField.iterator();
            boolean z16 = false;
            boolean z17 = false;
            while (it.hasNext()) {
                long j3 = it.next().uField;
                if (j3 != 20015 && j3 != 10009) {
                    if (j3 == 20002 || j3 == 20009 || j3 == 20031 || j3 == 20019) {
                        z17 = true;
                    }
                } else {
                    z16 = true;
                }
            }
            AppInterface appInterface = this.f116342a;
            if (appInterface != null) {
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) appInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
                if (z16 && ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn()) {
                    iQQAvatarHandlerService.getCustomHead(this.f116342a.getAccount());
                }
                if (z17) {
                    BaseApplicationImpl.sUiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardMessageProcessor.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else if (!TextUtils.isEmpty(((BaseMessageProcessor) ProfileCardMessageProcessor.this).f116342a.getAccount())) {
                                ((FriendListHandler) ((BaseMessageProcessor) ProfileCardMessageProcessor.this).f116342a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(((BaseMessageProcessor) ProfileCardMessageProcessor.this).f116342a.getAccount());
                            }
                        }
                    }, 150L);
                    return;
                }
                return;
            }
            return;
        }
        if (b16 == 1 && QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "group data update push");
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public ag o(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ag) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), msgInfo, svcReqPushMsg);
        }
        if (i3 == 9011) {
            if (msgInfo != null && svcReqPushMsg != null) {
                C(msgInfo);
            } else {
                f(getClass().getName(), i3);
            }
        }
        return new ag(null, false);
    }
}
