package com.tencent.imcore.message;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class l implements ConversationFacade.b {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ConfessProxy E(QQAppInterface qQAppInterface) {
        return qQAppInterface.getProxyManager().e();
    }

    public static int F(ConfessConvInfo confessConvInfo) {
        if (confessConvInfo == null) {
            return 0;
        }
        return confessConvInfo.unreadCount;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public long A(AppRuntime appRuntime, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return E((QQAppInterface) appRuntime).c(str, i3, i16);
        }
        return 0L;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean B(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return ServiceAccountFolderManager.l((QQAppInterface) appRuntime, str);
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public ConversationInfo C(ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) conversationInfo);
        }
        return ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).onGetUnreadCount(conversationInfo);
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public String D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return "sp_key_nearby_clean_unread_time";
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return com.tencent.mobileqq.graytip.f.e(messageRecord);
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean b(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ad.y(messageRecord);
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void c(AppRuntime appRuntime, boolean z16, boolean z17, ConversationFacade conversationFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appRuntime, Boolean.valueOf(z16), Boolean.valueOf(z17), conversationFacade);
            return;
        }
        if (appRuntime instanceof QQAppInterface) {
            if (z16) {
                for (ConfessConvInfo confessConvInfo : E((QQAppInterface) appRuntime).b()) {
                    if (F(confessConvInfo) > 0) {
                        conversationFacade.n(confessConvInfo.uin, confessConvInfo.type, confessConvInfo.topicId, z17);
                    }
                }
                return;
            }
            E((QQAppInterface) appRuntime).a();
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return "sp_key_say_hello_msg_clean_unread_time";
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean e(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public BaseApplication f(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getApp();
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void g(AppRuntime appRuntime, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appRuntime, Integer.valueOf(i3), messageRecord, list);
            return;
        }
        if (appRuntime instanceof QQAppInterface) {
            if (i3 != 1033) {
                if (i3 != 1038) {
                    if (i3 != 1044) {
                        return;
                    }
                } else {
                    AppletsHandler appletsHandler = (AppletsHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
                    if (appletsHandler != null) {
                        appletsHandler.O2(list);
                        return;
                    }
                    return;
                }
            } else {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                E(qQAppInterface).f(messageRecord.frienduin, messageRecord.istroop, messageRecord.getConfessTopicId(), 1);
                ConfessMsgUtil.t(qQAppInterface, false, true);
            }
            ((com.tencent.mobileqq.qqexpand.network.e) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).H();
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public RecentUserProxy getRecentUserProxy(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RecentUserProxy) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getProxyManager().m();
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean h(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getMsgCache().p1(messageRecord);
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public List<MessageRecord> i(AppRuntime appRuntime, MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, appRuntime, messageRecord, Integer.valueOf(i3));
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getMessageFacade().N(messageRecord.senderuin, messageRecord.istroop, i3);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean isFileAssistantAio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.filemanager.fileassistant.util.h.k(str);
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean isRedPacketMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return MessageForQQWalletMsg.isRedPacketMsg(messageRecord);
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void j(AppRuntime appRuntime, ConversationFacade conversationFacade, String str, int i3) {
        int i16;
        boolean z16;
        long j3;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, appRuntime, conversationFacade, str, Integer.valueOf(i3));
            return;
        }
        if (appRuntime instanceof QQAppInterface) {
            List<MessageRecord> o16 = v(appRuntime, i3).o(str, i3);
            if (!ConfessMsgUtil.r((QQAppInterface) appRuntime, true)) {
                if (o16 == null) {
                    o16 = new ArrayList<>();
                }
                int i26 = 0;
                for (MessageRecord messageRecord : o16) {
                    if (messageRecord.isSelfConfessor()) {
                        i19 = 1033;
                    } else {
                        i19 = 1034;
                    }
                    ao.e(messageRecord.senderuin, i19, messageRecord.getConfessTopicId());
                    i26 += conversationFacade.S(messageRecord.senderuin, i19, messageRecord.getConfessTopicId());
                }
                if (((ConfessManager) appRuntime.getManager(QQManagerFactory.CONFESS_MANAGER)).h() != null && ConfessConfig.h((QQAppInterface) appRuntime, "redpoint_box_show")) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.unread.Facade", 2, "calcConfessBoxUnreadCount box redpoint show +1");
                    }
                    i26++;
                }
                i16 = i26;
            } else {
                i16 = 0;
            }
            if (conversationFacade.W(str, i3) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (conversationFacade.R(str, i3) == i16 && conversationFacade.V(str, i3) == 0 && !z16) {
                i17 = 0;
                i18 = 0;
            } else {
                ConversationInfo i27 = k(appRuntime).i(str, i3);
                n k3 = k(appRuntime);
                if (i27 == null) {
                    j3 = 0;
                } else {
                    j3 = i27.lastread;
                }
                i17 = 0;
                i18 = 0;
                k3.s(str, i3, j3, i16, 0, 0);
                if (ao.H(i3) && z16) {
                    conversationFacade.v0(k(appRuntime).i(str, i3), "");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "calcConfessBoxUnreadCount boxUin=" + str + ", unread=" + i16 + ", giftCount=" + i18 + ", redPacketCount=" + i17);
            }
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public n k(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (n) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getProxyManager().f();
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean l(AppRuntime appRuntime, RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) appRuntime, (Object) recentUser)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return com.tencent.mobileqq.filemanager.fileassistant.util.h.l((QQAppInterface) appRuntime, recentUser);
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public Message m(AppRuntime appRuntime, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Message) iPatchRedirector.redirect((short) 6, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getMessageFacade().K(str, i3, i16);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean n(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ((MessageForNearbyLiveTip) messageRecord).isLiving;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public ConversationFacade o(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ConversationFacade) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getConversationFacade();
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public long p(AppRuntime appRuntime, String str, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).longValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            long e16 = E(qQAppInterface).e(str, i3, i16);
            E(qQAppInterface).h(str, i3, i16, j3, 0);
            return e16;
        }
        return 0L;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void q(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) appRuntime, (Object) str);
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void r(AppRuntime appRuntime, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appRuntime, Boolean.valueOf(z16), obj);
        } else if (appRuntime instanceof QQAppInterface) {
            ((QQAppInterface) appRuntime).getMsgHandler().notifyUI(MessageHandlerConstants.NOTIFY_TYPE_BOX_UNREAD_NUM_REFRESH, z16, obj);
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void refreshAppBadge(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (appRuntime.isLogin()) {
            ((IAppBadgeService) appRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void s(MessageRecord messageRecord, ConversationFacade conversationFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) messageRecord, (Object) conversationFacade);
        } else {
            conversationFacade.q0(messageRecord.senderuin, messageRecord.istroop, ((MessageForInteractAndFollow) messageRecord).unReadCount);
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public int t(AppRuntime appRuntime, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (!(appRuntime instanceof QQAppInterface)) {
            return 0;
        }
        return F(E((QQAppInterface) appRuntime).d(str, i3, i16));
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean u(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return "1".equals(messageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag"));
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public f v(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime, i3);
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getMessageProxy(i3);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean w(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return TroopBarAssistantManager.n().A((QQAppInterface) appRuntime, str);
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public boolean x(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return messageRecord instanceof MessageForFoldMsg;
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void y(AppRuntime appRuntime, ConversationInfo conversationInfo, int i3) {
        IGameMsgManagerService iGameMsgManagerService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appRuntime, conversationInfo, Integer.valueOf(i3));
            return;
        }
        if (conversationInfo != null) {
            try {
                if (("2747277822".equals(conversationInfo.uin) || 10007 == conversationInfo.type) && appRuntime != null && (iGameMsgManagerService = (IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "")) != null) {
                    iGameMsgManagerService.setUnshowedUnreadCnt(0);
                }
            } catch (Exception e16) {
                com.tencent.qqperf.monitor.crash.catchedexception.a.b(e16);
            }
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.b
    public void z(String str, int i3, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
        } else {
            OpenApiManager.getInstance().onMessageReaded(str, i3, z16, j3);
        }
    }
}
