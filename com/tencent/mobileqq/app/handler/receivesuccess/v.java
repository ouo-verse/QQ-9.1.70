package com.tencent.mobileqq.app.handler.receivesuccess;

import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class v {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (!"MessageSvc.PushReaded".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return;
        }
        SvcRequestPushReadedNotify svcRequestPushReadedNotify = (SvcRequestPushReadedNotify) obj;
        ArrayList arrayList = new ArrayList();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify() vC2CReadedNotify=" + svcRequestPushReadedNotify.vC2CReadedNotify + ", vGroupReadedNotify=" + svcRequestPushReadedNotify.vGroupReadedNotify + ", vDisMsgReadedNotify=" + svcRequestPushReadedNotify.vDisReadedNotify);
        }
        b(messageHandler, svcRequestPushReadedNotify, arrayList, e(svcRequestPushReadedNotify));
        d(messageHandler, svcRequestPushReadedNotify, arrayList);
        c(messageHandler, svcRequestPushReadedNotify, arrayList);
        if (arrayList.size() > 0) {
            messageHandler.notifyUI(6004, true, arrayList.toArray());
        }
    }

    private static void b(MessageHandler messageHandler, SvcRequestPushReadedNotify svcRequestPushReadedNotify, List<Object> list, boolean z16) {
        String str;
        String str2;
        ArrayList<C2CMsgReadedNotify> arrayList = svcRequestPushReadedNotify.vC2CReadedNotify;
        if (arrayList != null && arrayList.size() > 0) {
            if (z16) {
                String str3 = "";
                ISubAccountService iSubAccountService = (ISubAccountService) messageHandler.Q.getRuntimeService(ISubAccountService.class, "");
                Iterator<C2CMsgReadedNotify> it = svcRequestPushReadedNotify.vC2CReadedNotify.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    C2CMsgReadedNotify next = it.next();
                    String l3 = Long.toString(next.lPeerUin);
                    String l16 = Long.toString(next.lBindedUin);
                    int removeMessage = iSubAccountService.removeMessage(l16, l3);
                    i3 += removeMessage;
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("handlePushReadedNotify C2CMsgReadedNotify curFriendUin is ");
                        str = str3;
                        sb5.append(next.lPeerUin);
                        sb5.append(", lLastReadTime  is ");
                        sb5.append(next.lLastReadTime);
                        sb5.append(" isSubAccount=");
                        sb5.append(z16);
                        sb5.append(" changed=");
                        sb5.append(removeMessage);
                        QLog.d("SUB_ACCOUNT", 2, sb5.toString());
                    } else {
                        str = str3;
                    }
                    if (i3 != 0) {
                        if (messageHandler.Q.isLogin()) {
                            str2 = str;
                            ((IAppBadgeService) messageHandler.Q.getRuntimeService(IAppBadgeService.class, str2)).refreshAppBadge();
                        } else {
                            str2 = str;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify subUin=" + l16 + "increaseUnread=" + i3);
                        }
                    } else {
                        str2 = str;
                    }
                    messageHandler.Q.getMessageFacade().K0(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, l16});
                    str3 = str2;
                }
                return;
            }
            list.addAll(svcRequestPushReadedNotify.vC2CReadedNotify);
            Iterator<C2CMsgReadedNotify> it5 = svcRequestPushReadedNotify.vC2CReadedNotify.iterator();
            while (it5.hasNext()) {
                C2CMsgReadedNotify next2 = it5.next();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "C2CMsgReadedNotify curFriendUin is " + next2.lPeerUin + ", lLastReadTime  is " + next2.lLastReadTime + " isSubAccount=" + z16);
                }
                ((com.tencent.imcore.message.i) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C)).E0(next2);
            }
        }
    }

    private static void c(MessageHandler messageHandler, SvcRequestPushReadedNotify svcRequestPushReadedNotify, List<Object> list) {
        ArrayList<DisMsgReadedNotify> arrayList = svcRequestPushReadedNotify.vDisReadedNotify;
        if (arrayList != null && arrayList.size() > 0) {
            list.addAll(svcRequestPushReadedNotify.vDisReadedNotify);
            Iterator<DisMsgReadedNotify> it = svcRequestPushReadedNotify.vDisReadedNotify.iterator();
            while (it.hasNext()) {
                DisMsgReadedNotify next = it.next();
                String valueOf = String.valueOf(next.lDisUin);
                if (messageHandler.Q.getMsgCache().t0(valueOf) == 1) {
                    messageHandler.Q.getMsgCache().p(valueOf, next);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "DisMsgReadedNotify unfinished discussionUin=" + valueOf);
                    }
                } else {
                    ((DiscMessageProcessor) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC)).d0(next);
                }
            }
        }
    }

    private static void d(MessageHandler messageHandler, SvcRequestPushReadedNotify svcRequestPushReadedNotify, List<Object> list) {
        ArrayList<GroupMsgReadedNotify> arrayList = svcRequestPushReadedNotify.vGroupReadedNotify;
        if (arrayList != null && arrayList.size() > 0) {
            list.addAll(svcRequestPushReadedNotify.vGroupReadedNotify);
            Iterator<GroupMsgReadedNotify> it = svcRequestPushReadedNotify.vGroupReadedNotify.iterator();
            while (it.hasNext()) {
                GroupMsgReadedNotify next = it.next();
                String valueOf = String.valueOf(next.lGroupCode);
                if (messageHandler.Q.getMsgCache().d1(valueOf) == 1) {
                    messageHandler.Q.getMsgCache().u(valueOf, next);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "GroupMsgReadedNotify unfinished groupUin=" + valueOf);
                    }
                } else {
                    ((com.tencent.mobileqq.troop.data.y) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP)).A(next);
                }
            }
        }
    }

    private static boolean e(SvcRequestPushReadedNotify svcRequestPushReadedNotify) {
        if ((svcRequestPushReadedNotify.cNotifyType & 8) == 8) {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify() isSubAccount=true");
            }
            return true;
        }
        return false;
    }
}
