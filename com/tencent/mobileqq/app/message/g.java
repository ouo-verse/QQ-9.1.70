package com.tencent.mobileqq.app.message;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends BaseMessageManagerForTroopAndDisc {
    static IPatchRedirector $redirector_;

    public g(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
    public String N0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f116281d.getCurrentAccountUin().equals(str)) {
            return this.f116281d.getApp().getResources().getString(R.string.c7y);
        }
        return ac.n((QQAppInterface) this.f116281d, str2, str);
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
    protected String O0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        return N0(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01bd  */
    @Override // com.tencent.imcore.message.BaseMessageManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, BaseMessageManager.a aVar) {
        com.tencent.mobileqq.troop.data.c cVar;
        long j3;
        boolean z26;
        boolean z27;
        int d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, messageRecord, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), aVar);
            return;
        }
        if (messageRecord == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + messageRecord);
        }
        Map<String, RecentUser> map = aVar.f116296a;
        RecentUserProxy recentUserProxy = aVar.f116306k;
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        String str = messageRecord.frienduin;
        int i3 = messageRecord.istroop;
        long j16 = messageRecord.time;
        RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, i3);
        com.tencent.mobileqq.model.d dVar = (com.tencent.mobileqq.model.d) aVar.f116304i;
        if (dVar != null) {
            String str2 = str + ContainerUtils.FIELD_DELIMITER + 3000;
            com.tencent.mobileqq.troop.data.c a16 = dVar.a(str2);
            if (a16 != null) {
                if (a16.e() != messageRecord.shmsgseq) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
                    }
                } else if (messageRecord.isread) {
                    dVar.b(str2);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
            }
            cVar = a16;
            if (cVar != null && cVar.h()) {
                d16 = cVar.d();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + d16 + "|ru.msgType:" + findRecentUserByUin.msgType);
                }
                if (com.tencent.mobileqq.troop.data.c.a(d16, findRecentUserByUin.msgType)) {
                    findRecentUserByUin.msgType = d16;
                    j3 = j16;
                    findRecentUserByUin.f203116msg = com.tencent.mobileqq.troop.navigatebar.g.c((QQAppInterface) this.f116281d, str, cVar, findRecentUserByUin.f203116msg, messageRecord, false);
                    map.put(ao.f(str, i3), findRecentUserByUin);
                    if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
                        findRecentUserByUin = map.get(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()));
                    }
                    boolean z28 = !ad.D(messageRecord.msgtype);
                    if (!messageRecord.isLongMsg() && ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).p1(messageRecord)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
                        }
                        z26 = false;
                    } else {
                        z26 = z28;
                    }
                    if (z26) {
                        findRecentUserByUin.uin = str;
                        findRecentUserByUin.setType(i3);
                        if (messageRecord instanceof MessageForUniteGrayTip) {
                            z27 = ((MessageForUniteGrayTip) messageRecord).tipParam.f213689l;
                        } else {
                            z27 = true;
                        }
                        long j17 = j3;
                        if (j17 > findRecentUserByUin.lastmsgtime && z27) {
                            findRecentUserByUin.lastmsgtime = j17;
                            map.put(ao.f(str, i3), findRecentUserByUin);
                        }
                    }
                    super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
                    ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) this.f116281d, messageRecord);
                }
            }
            j3 = j16;
            if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
            }
            boolean z282 = !ad.D(messageRecord.msgtype);
            if (!messageRecord.isLongMsg()) {
            }
            z26 = z282;
            if (z26) {
            }
            super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
            ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) this.f116281d, messageRecord);
        }
        cVar = null;
        if (cVar != null) {
            d16 = cVar.d();
            if (QLog.isColorLevel()) {
            }
            if (com.tencent.mobileqq.troop.data.c.a(d16, findRecentUserByUin.msgType)) {
            }
        }
        j3 = j16;
        if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
        }
        boolean z2822 = !ad.D(messageRecord.msgtype);
        if (!messageRecord.isLongMsg()) {
        }
        z26 = z2822;
        if (z26) {
        }
        super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) this.f116281d, messageRecord);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + str + "-" + i3);
        }
        super.b(str, i3);
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(str, i3);
        if (com.tencent.mobileqq.activity.recent.msg.b.a((QQAppInterface) this.f116281d, findRecentUserByUin)) {
            findRecentUserByUin.cleanMsgAndMsgData(findRecentUserByUin.msgType);
            recentUserCache.saveRecentUser(findRecentUserByUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + str + "-" + i3 + "-" + j3);
        }
        super.c(str, i3, j3);
        A0(str, i3, j3);
    }
}
