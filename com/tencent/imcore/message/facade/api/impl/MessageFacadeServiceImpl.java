package com.tencent.imcore.message.facade.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.MsgManagerProvider;
import com.tencent.imcore.message.facade.a;
import com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverProvider;
import com.tencent.imcore.message.facade.add.inner.AddMultiMsgProcessorProvider;
import com.tencent.imcore.message.facade.add.inner.end.AddMultiMessagesInnerFinishProcessorProvider;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.imcore.message.facade.b;
import com.tencent.imcore.message.facade.c;
import com.tencent.imcore.message.facade.d;
import com.tencent.imcore.message.facade.e;
import com.tencent.imcore.message.facade.f;
import com.tencent.imcore.message.facade.g;
import com.tencent.imcore.message.facade.msg.LastMsgGetterProvider;
import com.tencent.imcore.message.facade.notify.MessageNotifyProcessorProvider;
import com.tencent.imcore.message.facade.send.MessageRealSendProcessorProvider;
import com.tencent.imcore.message.facade.send.sender.MsgSenderProvider;
import com.tencent.imcore.message.n;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.dating.h;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.data.x;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bt;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import msf.msgsvc.msg_svc$PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageFacadeServiceImpl implements IMessageFacadeService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MessageFacadeServiceImpl";
    private final Provider<Map<Integer, c<QQMessageFacade, QQAppInterface>>> lastMsgGetterProvider;
    private final Provider<Map<Integer, g<QQMessageFacade>>> msgAddCompleteObserverProvider;
    private final Provider<List<a<QQMessageFacade, QQAppInterface>>> msgAddEndProcessorProvider;
    private final Provider<List<d<QQAppInterface>>> msgNotifyProcessProvider;
    private final Provider<List<f<QQAppInterface>>> msgSenderProvider;
    private final Provider<List<b>> processorProvider;
    private final Provider<List<e<QQAppInterface>>> realSendProcessorProvider;

    public MessageFacadeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.processorProvider = new AddMultiMsgProcessorProvider();
        this.msgSenderProvider = new MsgSenderProvider();
        this.msgNotifyProcessProvider = new MessageNotifyProcessorProvider();
        this.msgAddCompleteObserverProvider = new OnMessageAddCompleteObserverProvider();
        this.msgAddEndProcessorProvider = new AddMultiMessagesInnerFinishProcessorProvider();
        this.lastMsgGetterProvider = new LastMsgGetterProvider();
        this.realSendProcessorProvider = new MessageRealSendProcessorProvider();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<List<b>> getAddMultiMsgInnerProcessorProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Provider) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.processorProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public ConversationFacade getConversationFacade(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConversationFacade) iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface);
        }
        return ((QQAppInterface) baseQQAppInterface).getConversationFacade();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public n getConversationProxy(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (n) iPatchRedirector.redirect((short) 18, (Object) this, (Object) baseQQAppInterface);
        }
        return ((QQAppInterface) baseQQAppInterface).getProxyManager().f();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<Map<Integer, c<QQMessageFacade, QQAppInterface>>> getLastMsgGetterProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Provider) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.lastMsgGetterProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public BaseQQMessageFacade getMessageFacade(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseQQMessageFacade) iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface);
        }
        return ((QQAppInterface) baseQQAppInterface).getMessageFacade();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public com.tencent.imcore.message.f getMessageProxy(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.imcore.message.f) iPatchRedirector.redirect((short) 21, (Object) this, (Object) baseQQAppInterface, i3);
        }
        return ((QQAppInterface) baseQQAppInterface).getMessageProxy(i3);
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<Map<Integer, g<QQMessageFacade>>> getMsgAddCompleteObserverProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Provider) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.msgAddCompleteObserverProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<List<a<QQMessageFacade, QQAppInterface>>> getMsgAddEndProcessorProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Provider) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.msgAddEndProcessorProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public com.tencent.mobileqq.service.message.e getMsgHandlerMsgCache(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.service.message.e) iPatchRedirector.redirect((short) 16, (Object) this, (Object) baseQQAppInterface);
        }
        return ((QQAppInterface) baseQQAppInterface).getMsgHandler().Y2();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<Map<Integer, BaseMessageManager>> getMsgManagerProvider(AppRuntime appRuntime, MsgPool msgPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Provider) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime, (Object) msgPool);
        }
        return new MsgManagerProvider(appRuntime, msgPool);
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<List<d<QQAppInterface>>> getMsgNotifyProcessProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Provider) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgNotifyProcessProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<List<f<QQAppInterface>>> getMsgSenderProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Provider) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msgSenderProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> MsgSummary getMsgSummaryForTroop(AT at5, FT ft5, Context context, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MsgSummary) iPatchRedirector.redirect((short) 13, this, at5, ft5, context, messageRecord, Boolean.valueOf(z16));
        }
        Message message = new Message();
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        try {
            if (ft5.F(message.istroop) instanceof x) {
                if (TextUtils.isEmpty(ac.f0(at5, message.frienduin, message.senderuin))) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getMsgSummaryStrForTroop nickname is null");
                    }
                    message.isFromLS = true;
                    ft5.w(message);
                    message.isFromLS = false;
                    ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(at5, ((QQLSActivity) context).f176799y1, message.senderuin, message.frienduin));
                } else {
                    ft5.w(message);
                }
            } else {
                ft5.w(message);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        MsgSummary msgSummary = new MsgSummary();
        bt.b(context, at5, message, message.istroop, msgSummary, message.nickName, false, z16);
        return msgSummary;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public Provider<List<e<QQAppInterface>>> getRealSendProcessorProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Provider) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.realSendProcessorProvider;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public String getUinByPhoneNum(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface, (Object) str);
        }
        return ac.m0(appInterface, str);
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public int getUnReadMsg(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) baseQQAppInterface)).intValue();
        }
        return com.tencent.mobileqq.qcall.f.w((QQAppInterface) baseQQAppInterface) + com.tencent.imcore.message.facade.unread.count.g.a();
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public boolean isBelongServiceAccountFolder(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseQQAppInterface, (Object) str)).booleanValue();
        }
        return ServiceAccountFolderManager.l((QQAppInterface) baseQQAppInterface, str);
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public boolean isTroopMark(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, appRuntime, str, Integer.valueOf(i3))).booleanValue();
        }
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopMark(appRuntime, str, i3);
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public void reportMsgBoxRead(AppInterface appInterface, int i3, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, appInterface, Integer.valueOf(i3), businessObserver);
        } else {
            h.b(appInterface, i3, null);
        }
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public void setReadedForHCTopic(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseQQAppInterface, (Object) str);
        }
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public void setSubaccountAssistantReaded(BaseQQAppInterface baseQQAppInterface, StringBuilder sb5, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, ConversationInfo conversationInfo) {
        ISubAccountService iSubAccountService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, baseQQAppInterface, sb5, msg_svc_pbmsgreadedreportreq, conversationInfo);
            return;
        }
        if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(conversationInfo.uin) && (iSubAccountService = (ISubAccountService) baseQQAppInterface.getRuntimeService(ISubAccountService.class, "")) != null) {
            iSubAccountService.setAllMessageReaded(conversationInfo.uin);
            byte[] cookie = iSubAccountService.getCookie(conversationInfo.uin);
            if (cookie != null) {
                msg_svc$PbBindUinMsgReadedConfirmReq msg_svc_pbbinduinmsgreadedconfirmreq = new msg_svc$PbBindUinMsgReadedConfirmReq();
                msg_svc_pbbinduinmsgreadedconfirmreq.sync_cookie.set(ByteStringMicro.copyFrom(cookie));
                msg_svc_pbmsgreadedreportreq.bind_uin_read_report.set(msg_svc_pbbinduinmsgreadedconfirmreq);
                sb5.append("{SUBUIN}");
            }
        }
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public msg_svc$PbC2CReadedReportReq setTempGameMsgReaded(BaseQQAppInterface baseQQAppInterface, BaseQQMessageFacade baseQQMessageFacade, boolean z16, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (msg_svc$PbC2CReadedReportReq) iPatchRedirector.redirect((short) 22, this, baseQQAppInterface, baseQQMessageFacade, Boolean.valueOf(z16), msg_svc_pbc2creadedreportreq, conversationInfo);
        }
        if (z16 || ((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) {
            baseQQMessageFacade.R0(conversationInfo.uin, conversationInfo.type, true, z16);
            long X = baseQQMessageFacade.X(conversationInfo.uin, conversationInfo.type);
            if (msg_svc_pbc2creadedreportreq == null) {
                msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
            }
            ed1.d.c(baseQQAppInterface, msg_svc_pbc2creadedreportreq, X, conversationInfo);
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) baseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
            if (iGameMsgManagerService.isInited()) {
                iGameMsgManagerService.setUnshowedUnreadCnt(0);
            }
        }
        return msg_svc_pbc2creadedreportreq;
    }

    @Override // com.tencent.imcore.message.facade.api.IMessageFacadeService
    public String trimName(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, this, str, Float.valueOf(f16));
        }
        return bt.s(str, f16);
    }
}
