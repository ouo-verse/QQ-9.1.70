package com.tencent.mobileqq.troop.data;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.mobileqq.troop.utils.bh;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes19.dex */
public class x extends BaseMessageManagerForTroopAndDisc {
    static IPatchRedirector $redirector_;
    public boolean I;
    public int J;
    public int K;
    public int L;
    public int M;
    public long N;
    private HashMap<String, HashSet<String>> P;

    public x(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) msgPool);
            return;
        }
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = -1L;
        this.P = new HashMap<>();
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
    protected String N0(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f116281d.getCurrentAccountUin().equals(str)) {
            str3 = HardCodeUtil.qqStr(R.string.unl);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            return str3;
        }
        return str;
    }

    @Override // com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
    protected String O0(String str, String str2) {
        String f06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f116281d.getCurrentAccountUin().equals(str)) {
            f06 = HardCodeUtil.qqStr(R.string.unm);
        } else {
            f06 = ac.f0((QQAppInterface) this.f116281d, str2, str);
        }
        if (f06 != null) {
            return f06;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0460  */
    @Override // com.tencent.imcore.message.BaseMessageManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, BaseMessageManager.a aVar) {
        c cVar;
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        int i3;
        int i16;
        long j16;
        String str5;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, messageRecord, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), aVar);
            return;
        }
        if (messageRecord == null) {
            return;
        }
        Map<String, RecentUser> map = aVar.f116296a;
        com.tencent.mobileqq.model.d dVar = (com.tencent.mobileqq.model.d) aVar.f116304i;
        RecentUserProxy recentUserProxy = aVar.f116306k;
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        String str8 = messageRecord.frienduin;
        String str9 = messageRecord.senderuin;
        int i17 = messageRecord.istroop;
        long j17 = messageRecord.time;
        RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(str8, i17);
        if (dVar != null) {
            c a16 = dVar.a(str8);
            if (a16 != null) {
                if (a16.g() == messageRecord.shmsgseq) {
                    if (messageRecord.isread) {
                        dVar.b(str8);
                    }
                }
            }
            cVar = a16;
            GroupMsgMask troopMask = this.f116283f.getTroopMask(str8);
            if (i17 == 1) {
                if (findRecentUserByUin.msgType != 25 && cVar != null && cVar.f() == 25) {
                    if (troopMask != GroupMsgMask.NOTIFY && troopMask != GroupMsgMask.RECEIVE) {
                        if (this.f116283f.getTroopMask(findRecentUserByUin.uin) == GroupMsgMask.ASSISTANT) {
                            ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, findRecentUserByUin.uin, "", "", "");
                        }
                    } else {
                        ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, findRecentUserByUin.uin, "", "", "");
                    }
                } else {
                    int i18 = findRecentUserByUin.msgType;
                    if (i18 != 18 && i18 != 23 && i18 != 25 && cVar != null && cVar.f() == 18) {
                        boolean z26 = messageRecord instanceof MessageForQQWalletMsg;
                        if (troopMask == GroupMsgMask.SHIELD || troopMask == GroupMsgMask.RECEIVE) {
                            if (z26) {
                                ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_allscreen", 0, 0, findRecentUserByUin.uin, "", "", "");
                            } else {
                                ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, findRecentUserByUin.uin, "", "", "");
                            }
                        } else if (troopMask == GroupMsgMask.ASSISTANT) {
                            if (z26) {
                                ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_grphelper", 0, 0, findRecentUserByUin.uin, "", "", "");
                            } else {
                                ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, findRecentUserByUin.uin, "", "", "");
                            }
                        } else if (troopMask == GroupMsgMask.NOTIFY) {
                            ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, findRecentUserByUin.uin, "", "", "");
                        }
                    } else {
                        int i19 = findRecentUserByUin.msgType;
                        if (i19 != 18 && i19 != 23 && i19 != 25) {
                            if (i19 != 14 && cVar != null && cVar.f() == 14) {
                                if (troopMask != GroupMsgMask.SHIELD && troopMask != GroupMsgMask.RECEIVE) {
                                    if (troopMask == GroupMsgMask.ASSISTANT) {
                                        ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, findRecentUserByUin.uin, "", "", "");
                                    } else if (troopMask == GroupMsgMask.NOTIFY) {
                                        ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, findRecentUserByUin.uin, "", "", "");
                                    }
                                } else {
                                    ReportController.o(this.f116281d, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, findRecentUserByUin.uin, "", "", "");
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord");
                                }
                            }
                            if (!messageRecord.isSend() && cVar != null) {
                                cVar.f();
                            }
                            if (MessageForQQWalletMsg.isCommandRedPacketMsg(messageRecord)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageManager", 2, "group command red packet, UI_BUSY");
                                }
                                MainService.sPwdPacketTime = System.currentTimeMillis();
                                com.tencent.qqperf.opt.threadpriority.b.k(true);
                            }
                            if (messageRecord.senderuin.equals(this.f116281d.getCurrentAccountUin())) {
                                IceBreakingUtil.o((QQAppInterface) this.f116281d, messageRecord.frienduin, i17, messageRecord);
                            }
                        }
                    }
                }
                if (!messageRecord.isSend()) {
                    cVar.f();
                }
                if (MessageForQQWalletMsg.isCommandRedPacketMsg(messageRecord)) {
                }
                if (messageRecord.senderuin.equals(this.f116281d.getCurrentAccountUin())) {
                }
            }
            if (cVar == null && cVar.h()) {
                int f16 = cVar.f();
                if (QLog.isColorLevel()) {
                    str5 = "Q.msg.BaseMessageManager.troop.special_msg";
                    QLog.d("Q.msg.BaseMessageManager.troop.special_msg.special_attention", 2, "addMessageRecord, bizType" + f16 + "|ru.msgType:" + findRecentUserByUin.msgType);
                } else {
                    str5 = "Q.msg.BaseMessageManager.troop.special_msg";
                }
                findRecentUserByUin.msgType = f16;
                str = str5;
                j3 = j17;
                str2 = "Q.msg.BaseMessageManager";
                str4 = str9;
                i3 = 18;
                i16 = i17;
                Object c16 = com.tencent.mobileqq.troop.navigatebar.g.c((QQAppInterface) this.f116281d, str8, cVar, findRecentUserByUin.f203116msg, messageRecord, true);
                findRecentUserByUin = findRecentUserByUin;
                findRecentUserByUin.f203116msg = c16;
                if (i16 != 1 && i16 != 3000) {
                    str3 = str8;
                } else if (f16 == 9) {
                    if (troopMask == GroupMsgMask.ASSISTANT) {
                        str7 = "msg_assist";
                    } else if (troopMask == GroupMsgMask.NOTIFY) {
                        str7 = "msg_public";
                    } else {
                        str6 = "";
                        str3 = str8;
                        ReportController.o(this.f116281d, "P_CliOper", "Grp_public", "", "oper", str6, 0, 0, str3, "", "", "");
                    }
                    str6 = str7;
                    str3 = str8;
                    ReportController.o(this.f116281d, "P_CliOper", "Grp_public", "", "oper", str6, 0, 0, str3, "", "", "");
                } else {
                    str3 = str8;
                    if (f16 == 23) {
                        String str10 = i16 == 3000 ? "Grp_Dis_replyMsg" : "Grp_replyMsg";
                        ReportController.o(this.f116281d, "P_CliOper", str10, "", "Msglist", "Appear_replySign", 0, 0, findRecentUserByUin.troopUin, "" + troopMask, "", "");
                        if (troopMask != GroupMsgMask.SHIELD && troopMask != GroupMsgMask.RECEIVE) {
                            if (troopMask == GroupMsgMask.ASSISTANT) {
                                ReportController.o(this.f116281d, "P_CliOper", str10, "", "Msglist", "Appear_replySign_grphelper", 0, 0, findRecentUserByUin.troopUin, "", "", "");
                            }
                        } else {
                            ReportController.o(this.f116281d, "P_CliOper", str10, "", "Msglist", "Appear_replySign_allscreen", 0, 0, findRecentUserByUin.troopUin, "", "", "");
                        }
                    }
                }
            } else {
                str = "Q.msg.BaseMessageManager.troop.special_msg";
                j3 = j17;
                str2 = "Q.msg.BaseMessageManager";
                str3 = str8;
                str4 = str9;
                i3 = 18;
                i16 = i17;
            }
            if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
                findRecentUserByUin = map.get(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()));
            }
            if (!ad.D(messageRecord.msgtype) && !TroopManager.T((QQAppInterface) this.f116281d, messageRecord)) {
                if (i16 != 1 && troopMask != GroupMsgMask.NOTIFY && troopMask != GroupMsgMask.RECEIVE) {
                    int f17 = cVar == null ? 0 : cVar.f();
                    if (f17 == i3 || f17 == 25 || f17 == 17 || f17 == 14 || f17 == 5 || f17 == 27 || f17 == 19 || f17 == 23 || f17 == 15 || f17 == 4 || f17 == 11 || f17 == 12) {
                        findRecentUserByUin.uin = str3;
                        if (i16 == 1000 || i16 == 1020 || i16 == 1004) {
                            findRecentUserByUin.troopUin = str4;
                        }
                        findRecentUserByUin.setType(i16);
                        long j18 = j3;
                        if (j18 > findRecentUserByUin.lastmsgtime) {
                            findRecentUserByUin.lastmsgtime = j18;
                        }
                        map.put(ao.f(str3, i16), findRecentUserByUin);
                        if (QLog.isColorLevel()) {
                            QLog.d(str, 2, "addMessageRecord, MsgBizType:" + f17 + "uin:" + findRecentUserByUin.uin);
                        }
                    }
                } else {
                    j16 = j3;
                    if (!messageRecord.isLongMsg() && ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).p1(messageRecord)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(str2, 2, "addMessageRecord, long msg uncompleted");
                        }
                    } else {
                        findRecentUserByUin.uin = str3;
                        findRecentUserByUin.setType(i16);
                        boolean z27 = messageRecord instanceof MessageForUniteGrayTip ? ((MessageForUniteGrayTip) messageRecord).tipParam.f213689l : true;
                        if (j16 > findRecentUserByUin.lastmsgtime && z27) {
                            findRecentUserByUin.lastmsgtime = j16;
                        }
                        findRecentUserByUin.updatedByRegisterProxy = messageRecord.fromRegisterProxy;
                        map.put(ao.f(str3, i16), findRecentUserByUin);
                    }
                }
            }
            super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
            ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) this.f116281d, messageRecord);
        }
        cVar = null;
        GroupMsgMask troopMask2 = this.f116283f.getTroopMask(str8);
        if (i17 == 1) {
        }
        if (cVar == null) {
        }
        str = "Q.msg.BaseMessageManager.troop.special_msg";
        j3 = j17;
        str2 = "Q.msg.BaseMessageManager";
        str3 = str8;
        str4 = str9;
        i3 = 18;
        i16 = i17;
        if (map.containsKey(ao.f(findRecentUserByUin.uin, findRecentUserByUin.getType()))) {
        }
        if (!ad.D(messageRecord.msgtype)) {
            if (i16 != 1) {
            }
            j16 = j3;
            if (!messageRecord.isLongMsg()) {
            }
            findRecentUserByUin.uin = str3;
            findRecentUserByUin.setType(i16);
            if (messageRecord instanceof MessageForUniteGrayTip) {
            }
            if (j16 > findRecentUserByUin.lastmsgtime) {
                findRecentUserByUin.lastmsgtime = j16;
            }
            findRecentUserByUin.updatedByRegisterProxy = messageRecord.fromRegisterProxy;
            map.put(ao.f(str3, i16), findRecentUserByUin);
        }
        super.a(messageRecord, entityManager, z16, z17, z18, z19, aVar);
        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) this.f116281d, messageRecord);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void b(String str, int i3) {
        GroupMsgMask troopMask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        super.b(str, i3);
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(str, i3);
        A0(str, i3, Long.MAX_VALUE);
        if (com.tencent.mobileqq.activity.recent.msg.b.a((QQAppInterface) this.f116281d, findRecentUserByUin) || findRecentUserByUin.msgType == 12) {
            findRecentUserByUin.cleanMsgAndMsgData(findRecentUserByUin.msgType);
            recentUserCache.saveRecentUser(findRecentUserByUin);
        }
        if (i3 == 1 && (troopMask = this.f116283f.getTroopMask(str)) != GroupMsgMask.NOTIFY && troopMask != GroupMsgMask.RECEIVE) {
            com.tencent.mobileqq.activity.recent.g.c().e(findRecentUserByUin.uin + "-" + findRecentUserByUin.getType());
            this.f116282e.removeRecentUser(findRecentUserByUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            super.c(str, i3, j3);
            A0(str, i3, j3);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void g0(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        super.g0(str, i3, j3, z16);
        bh bhVar = (bh) this.f116281d.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if (bhVar != null) {
            bhVar.e(str);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void h0(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        super.h0(str, i3, z16, z17);
        bh bhVar = (bh) this.f116281d.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if (bhVar != null) {
            bhVar.e(str);
        }
    }

    public void h1(QQAppInterface qQAppInterface, String str, String str2, ArrayList<TroopNotificationCache> arrayList, int i3, int i16, int i17, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, qQAppInterface, str, str2, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str3, Boolean.valueOf(z16));
        } else {
            aw.n(qQAppInterface, str2, arrayList, i16, i17, str3, z16);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void i0(String str, int i3, boolean z16, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        super.i0(str, i3, z16, z17, i16);
        bh bhVar = (bh) this.f116281d.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if (bhVar != null) {
            bhVar.e(str);
        }
    }

    public synchronized void i1(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.P.containsKey(str)) {
            HashSet<String> hashSet = this.P.get(str);
            hashSet.remove(j3 + "" + j16);
            if (hashSet.isEmpty()) {
                this.P.remove(str);
                setChanged();
                notifyObservers();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "\u5e76\u53d1\u62c9\u53d6\u5b8c\u6210\uff0ctroopUin:" + str);
                }
            }
        }
    }

    public synchronized void j1(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        String str2 = j3 + "" + j16;
        if (this.P.containsKey(str)) {
            this.P.get(str).add(str2);
        } else {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(str2);
            this.P.put(str, hashSet);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void m0(String str, int i3, String str2, String str3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3));
            return;
        }
        GroupMsgMask troopMask = this.f116283f.getTroopMask(str);
        if (i3 == 1 && troopMask != GroupMsgMask.NOTIFY && troopMask != GroupMsgMask.RECEIVE) {
            if (troopMask == GroupMsgMask.ASSISTANT) {
                this.f116281d.getEntityManagerFactory().createEntityManager().close();
            }
            this.f116282e.setChangeAndNotify(null);
            return;
        }
        super.m0(str, i3, str2, str3, j3);
    }
}
