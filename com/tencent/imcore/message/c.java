package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements BaseMessageManagerForTroopAndDisc.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public Object a(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.data.c cVar, Object obj, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, appRuntime, str, cVar, obj, messageRecord, Boolean.valueOf(z16));
        }
        return com.tencent.mobileqq.troop.navigatebar.g.c((QQAppInterface) appRuntime, str, cVar, obj, messageRecord, z16);
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public void b(AppRuntime appRuntime, ArrayList<MessageRecord> arrayList) {
        com.tencent.mobileqq.troop.utils.x troopBatchAddFriendMgr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime, (Object) arrayList);
            return;
        }
        ITroopBatchAddFriendService iTroopBatchAddFriendService = (ITroopBatchAddFriendService) appRuntime.getRuntimeService(ITroopBatchAddFriendService.class, "");
        if (iTroopBatchAddFriendService != null && (troopBatchAddFriendMgr = iTroopBatchAddFriendService.getTroopBatchAddFriendMgr()) != null) {
            troopBatchAddFriendMgr.D(arrayList);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public List<MessageRecord> c(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageRecord);
        }
        if (messageRecord instanceof MessageForLongMsg) {
            return ((MessageForLongMsg) messageRecord).longMsgFragmentList;
        }
        return null;
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public boolean d(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        if (!com.tencent.biz.anonymous.a.m(messageRecord) && TroopUtils.g((QQAppInterface) appRuntime, "atMeOrReplyMe")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public boolean e(AppRuntime appRuntime, long j3, long j16, long j17, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z16), bundle)).booleanValue();
        }
        return ((QQAppInterface) appRuntime).getMsgHandler().e3(j3, j16, j17, z16, bundle);
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public void f(AppRuntime appRuntime, IConversationFacade iConversationFacade, IMessageFacade iMessageFacade, String str, int i3, long j3, RecentUserProxy recentUserProxy, RecentUser recentUser) {
        GroupMsgMask troopMask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, iConversationFacade, iMessageFacade, str, Integer.valueOf(i3), Long.valueOf(j3), recentUserProxy, recentUser);
            return;
        }
        if (recentUser != null && com.tencent.mobileqq.activity.recent.msg.b.a((QQAppInterface) appRuntime, recentUser)) {
            Object obj = recentUser.f203116msg;
            if ((obj instanceof com.tencent.mobileqq.activity.recent.msg.a) && ((com.tencent.mobileqq.activity.recent.msg.a) obj).f185679d.f294896b <= j3) {
                recentUser.cleanMsgAndMsgData(recentUser.msgType);
                recentUserProxy.saveRecentUser(recentUser);
                if (!com.tencent.mobileqq.troop.navigatebar.expriment.a.c()) {
                    ((TroopAioNavigateBarManager) appRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).f(str, i3, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "cleanBizTypeMark TYPE_ALL_MSG type = " + i3 + ", seqFrom = " + j3);
                    }
                }
                if (i3 == 1 && (troopMask = iConversationFacade.getTroopMask(str)) != GroupMsgMask.NOTIFY && troopMask != GroupMsgMask.RECEIVE) {
                    com.tencent.mobileqq.activity.recent.g.c().e(recentUser.uin + "-" + recentUser.getType());
                    iMessageFacade.removeRecentUser(recentUser);
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public boolean g(AppRuntime appRuntime, String str, long j3, long j16, boolean z16, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), bundle, Integer.valueOf(i3))).booleanValue();
        }
        return ((QQAppInterface) appRuntime).getMsgHandler().g3(str, j3, j16, z16, bundle, i3);
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.a
    public byte[] h(MessageRecord messageRecord, MessageRecord messageRecord2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageRecord, (Object) messageRecord2);
        }
        return com.tencent.mobileqq.troop.data.z.c(messageRecord, messageRecord2);
    }
}
