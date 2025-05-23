package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements BaseMessageManager.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void A(AppRuntime appRuntime, List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appRuntime, list, Boolean.valueOf(z16));
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().n3().O(list, z16);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void B(AppRuntime appRuntime, ArrayMap<String, List<Long>> arrayMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appRuntime, arrayMap, Boolean.valueOf(z16));
            return;
        }
        ITroopAioMsgNavigateService iTroopAioMsgNavigateService = (ITroopAioMsgNavigateService) appRuntime.getRuntimeService(ITroopAioMsgNavigateService.class, "");
        iTroopAioMsgNavigateService.updateTroopRevokeMsg(arrayMap);
        TroopAioNavigateBarManager troopAioNavigateBarManager = (TroopAioNavigateBarManager) appRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
        if (troopAioNavigateBarManager != null) {
            for (String str : arrayMap.keySet()) {
                int o16 = troopAioNavigateBarManager.o(str, arrayMap.get(str));
                if (o16 > 0) {
                    iTroopAioMsgNavigateService.notifyTroopRevokeNavMsg(str, arrayMap.get(str));
                }
                i3 += o16;
            }
            if (i3 > 0) {
                new com.tencent.mobileqq.troop.navigatebar.i().a();
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void C(AppRuntime appRuntime, IMessageFacade iMessageFacade, IConversationFacade iConversationFacade, String str, int i3, String str2, String str3, long j3) {
        RecentUser findRecentUserByUin;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, appRuntime, iMessageFacade, iConversationFacade, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3));
            return;
        }
        if (i3 == 1008 && TroopBarAssistantManager.n().x((QQAppInterface) appRuntime, str, i3)) {
            return;
        }
        if (i3 == 1008 && ServiceAccountFolderManager.j((QQAppInterface) appRuntime, str)) {
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) appRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (ecShopAssistantManager != null) {
                ecShopAssistantManager.u(str, j3);
                return;
            }
            return;
        }
        if (ao.c(i3) != 1032 && i3 != 10014) {
            if (!iConversationFacade.isUinInRecentList(str, i3) && ao.q(i3)) {
                obj = null;
            } else {
                RecentUserProxy recentUserCache = ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
                if (0 == j3) {
                    findRecentUserByUin = recentUserCache.findRecentUser(str, i3);
                } else {
                    findRecentUserByUin = recentUserCache.findRecentUserByUin(str, i3);
                    findRecentUserByUin.troopUin = str2;
                }
                if (findRecentUserByUin != null) {
                    findRecentUserByUin.lastmsgdrafttime = j3;
                    if (0 == j3 && findRecentUserByUin.lastmsgtime == 0) {
                        recentUserCache.delRecentUser(findRecentUserByUin);
                    } else {
                        a(appRuntime, findRecentUserByUin);
                        recentUserCache.saveRecentUser(findRecentUserByUin);
                    }
                }
                obj = findRecentUserByUin;
            }
            iMessageFacade.setChangeAndNotify(obj);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void D(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            ((ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "")).removeProcessorByPeerUin(str, 0);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean E(MessageRecord messageRecord, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) messageRecord, (Object) message)).booleanValue();
        }
        if (messageRecord == null && message != null) {
            DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
            DataLineMsgRecord.unpackMsgData(dataLineMsgRecord, message.msgData, message.versionCode);
            message.f203106msg = dataLineMsgRecord.f203106msg;
            return false;
        }
        if (messageRecord instanceof MessageForFoldMsg) {
            return true;
        }
        if ((messageRecord instanceof MessageForNearbyLiveTip) && message != null) {
            message.nickName = ((MessageForNearbyLiveTip) messageRecord).nickName;
            return false;
        }
        if ((messageRecord instanceof MessageForText) && message == null) {
            ((MessageForText) messageRecord).parse();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0067, code lost:
    
        if (r4 == null) goto L30;
     */
    @Override // com.tencent.imcore.message.BaseMessageManager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(AppRuntime appRuntime, List<ChatMessage> list, List<ChatMessage> list2) {
        MessageForPoke messageForPoke;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, appRuntime, list, list2);
            return;
        }
        int size = list.size();
        MessageForPokeEmo messageForPokeEmo = null;
        int i3 = 0;
        if (size > 1) {
            int i16 = size - 1;
            messageForPoke = (MessageForPoke) list.get(i16);
            for (int i17 = 0; i17 < i16; i17++) {
                MessageForPoke messageForPoke2 = (MessageForPoke) list.get(i17);
                if (messageForPoke2 != null && !messageForPoke2.isPlayed && !messageForPoke2.isSend()) {
                    messageForPoke2.setPlayed((QQAppInterface) appRuntime);
                }
            }
        } else {
            messageForPoke = null;
        }
        int size2 = list2.size();
        if (size2 >= 1) {
            messageForPokeEmo = (MessageForPokeEmo) list2.get(size2 - 1);
        }
        if (messageForPoke != null && messageForPokeEmo != null) {
            if (messageForPoke.time < messageForPokeEmo.time) {
                messageForPoke.setPlayed((QQAppInterface) appRuntime);
                z16 = true;
            }
            z16 = false;
        }
        if (messageForPoke != null && messageForPoke.isread && !messageForPoke.isPlayed) {
            messageForPoke.setPlayed((QQAppInterface) appRuntime);
        }
        if (messageForPokeEmo != null && z16) {
            int i18 = size2 - 3;
            if (i18 >= 0) {
                i3 = i18;
            }
            if (size2 > 0) {
                for (int i19 = size2 - 1; i19 >= i3; i19--) {
                    MessageForPokeEmo messageForPokeEmo2 = (MessageForPokeEmo) list2.get(i19);
                    if (!messageForPokeEmo2.isread) {
                        messageForPokeEmo2.setIsNeedPlayed(true);
                    }
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public Manager G(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Manager) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getManager(QQManagerFactory.GUILDINFO_MANAGER);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public Manager H(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Manager) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getManager(QQManagerFactory.TROOPINFO_MANAGER);
    }

    public void I(AppRuntime appRuntime, IMessageFacade iMessageFacade, BaseMessageManager baseMessageManager, MessageRecord messageRecord, EcShopAssistantManager ecShopAssistantManager) {
        RecentUser findRecentUserByUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, appRuntime, iMessageFacade, baseMessageManager, messageRecord, ecShopAssistantManager);
            return;
        }
        String str = messageRecord.frienduin;
        int i3 = messageRecord.istroop;
        if (iMessageFacade.getCachedMsg().containsKey(ao.f(str, i3))) {
            EcShopData k3 = ecShopAssistantManager.k();
            MessageRecord lastMsgForMsgTab = iMessageFacade.getLastMsgForMsgTab(str, i3);
            if (lastMsgForMsgTab != null) {
                baseMessageManager.o0(lastMsgForMsgTab, true, 4);
            } else {
                ecShopAssistantManager.p(str);
                k3 = ecShopAssistantManager.k();
                if (k3 != null) {
                    lastMsgForMsgTab = iMessageFacade.getLastMessage(k3.mUin, 1008);
                    z16 = true;
                }
            }
            if (((k3 != null && str.equals(k3.mUin)) || z16) && (findRecentUserByUin = ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().findRecentUserByUin(String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN_LONGVALUE), AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST)) != null) {
                if (lastMsgForMsgTab != null) {
                    findRecentUserByUin.lastmsgtime = lastMsgForMsgTab.time;
                    ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().saveRecentUser(findRecentUserByUin);
                }
                iMessageFacade.setChangeAndNotify(findRecentUserByUin);
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean a(AppRuntime appRuntime, RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) appRuntime, (Object) recentUser)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void b(AppRuntime appRuntime, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appRuntime, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            ConfessMsgUtil.t((QQAppInterface) appRuntime, z16, z17);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public f c(int i3, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getMessageProxy(i3);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void d(AppRuntime appRuntime, String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().n3().P(str, i3, i16, i17);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void e(AppRuntime appRuntime, BaseMessageManager baseMessageManager, IMessageFacade iMessageFacade, String str, int i3, String str2, String str3, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, baseMessageManager, iMessageFacade, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
        } else if (ao.F(str)) {
            v.b((QQAppInterface) appRuntime, baseMessageManager, iMessageFacade, str, i3, str2, str3, z16);
        } else {
            v.a((QQAppInterface) appRuntime, baseMessageManager, iMessageFacade, str, i3, str2, str3, i16, i17, z16);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean f(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        return QidianManager.H((QQAppInterface) appRuntime, messageRecord);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public String g(AppRuntime appRuntime, int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, this, appRuntime, Integer.valueOf(i3), str, str2, messageForUniteGrayTip);
        }
        if (i3 == 1) {
            String troopCodeByTroopUin = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(str);
            Bundle bundle = new Bundle();
            o(messageForUniteGrayTip, bundle);
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            String j06 = com.tencent.mobileqq.utils.ac.j0(qQAppInterface, str2, str, troopCodeByTroopUin, true, bundle);
            if (TextUtils.isEmpty(j06)) {
                return com.tencent.mobileqq.utils.ac.s(qQAppInterface, str2, str, 1, 0);
            }
            return j06;
        }
        if (i3 == 3000) {
            return com.tencent.mobileqq.utils.ac.s((QQAppInterface) appRuntime, str2, str, 2, 0);
        }
        return HardCodeUtil.qqStr(R.string.jyn);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void h(MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) messageForUniteGrayTip);
        } else {
            com.tencent.biz.anonymous.a.p(messageForUniteGrayTip);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void i(BaseMessageManager baseMessageManager, AppRuntime appRuntime, int i3, String str, List<MessageRecord> list, List<MessageRecord> list2, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, baseMessageManager, appRuntime, Integer.valueOf(i3), str, list, list2, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (com.tencent.mobileqq.managers.g.g(qQAppInterface, i3, str)) {
            r.a(baseMessageManager, qQAppInterface, list, list2, z16, z17);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean isRobotUin(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        return ((ITroopRobotService) appRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean j(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, appRuntime, str, Integer.valueOf(i3))).booleanValue();
        }
        return com.tencent.mobileqq.qcall.f.N((QQAppInterface) appRuntime, str, i3);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean k(AppRuntime appRuntime, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) appRuntime, (Object) message)).booleanValue();
        }
        return com.tencent.mobileqq.mutualmark.oldlogic.c.c((QQAppInterface) appRuntime, message);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public String l(AppRuntime appRuntime, int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, this, appRuntime, Integer.valueOf(i3), str, str2, messageForUniteGrayTip, str3);
        }
        if (i3 == 1) {
            String troopCodeByTroopUin = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(str2);
            Bundle bundle = new Bundle();
            o(messageForUniteGrayTip, bundle);
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            String j06 = com.tencent.mobileqq.utils.ac.j0(qQAppInterface, str, str2, troopCodeByTroopUin, true, bundle);
            if (TextUtils.isEmpty(j06)) {
                return com.tencent.mobileqq.utils.ac.s(qQAppInterface, str, str2, 1, 0);
            }
            return j06;
        }
        if (i3 == 3000) {
            return com.tencent.mobileqq.utils.ac.s((QQAppInterface) appRuntime, str, str2, 2, 0);
        }
        return str3;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void m(AppRuntime appRuntime, IMessageFacade iMessageFacade, BaseMessageManager baseMessageManager, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appRuntime, iMessageFacade, baseMessageManager, messageRecord);
            return;
        }
        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) appRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (ao.q(messageRecord.istroop)) {
            baseMessageManager.n0(messageRecord);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (ServiceAccountFolderManager.j(qQAppInterface, messageRecord.frienduin)) {
            I(appRuntime, iMessageFacade, baseMessageManager, messageRecord, ecShopAssistantManager);
            return;
        }
        if (messageRecord.istroop == 1008 && ServiceAccountFolderManager.l(qQAppInterface, messageRecord.frienduin)) {
            baseMessageManager.r0(messageRecord);
        } else if (messageRecord.istroop != 1008 || !ServiceAccountFolderManager.n((AppInterface) appRuntime, messageRecord.frienduin)) {
            baseMessageManager.r0(messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void n(AppRuntime appRuntime, List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appRuntime, list, Boolean.valueOf(z16));
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().n3().Q(list, z16);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void o(MessageForUniteGrayTip messageForUniteGrayTip, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) messageForUniteGrayTip, (Object) bundle);
        } else {
            bundle.putInt(com.tencent.mobileqq.utils.ac.f307393c, com.tencent.mobileqq.utils.ac.f307395e);
            bundle.putLong(com.tencent.mobileqq.utils.ac.f307397g, messageForUniteGrayTip.uniseq);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean p(BaseMessageManager baseMessageManager, MessageRecord messageRecord) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) baseMessageManager, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord instanceof MessageForShortVideo) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            if (messageForShortVideo.busiType == 0) {
                int i3 = messageForShortVideo.videoFileStatus;
                if (i3 != 1007 && (i3 != 1003 || messageForShortVideo.extraflag != 32772)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, holdFlag: " + z16);
                }
                baseMessageManager.C(messageRecord);
                return true;
            }
        } else if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            if (messageForPic.extraflag == 32772) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, msgForPic");
                }
                baseMessageManager.C(messageForPic);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void pretreatmentAIOMsg(int i3, List<MessageRecord> list, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, appRuntime);
        } else {
            com.tencent.imcore.message.ext.getaiolist.a.a(i3, list, (QQAppInterface) appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void q(List<? extends MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) list);
        } else {
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgDeleted(list);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void r(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        if (com.tencent.mobileqq.app.message.k.a((QQAppInterface) appRuntime, str, i3)) {
            QLog.e("MsgInvalidTypeErr", 1, "find invalid refreshSingleLastMsg" + str);
            com.tencent.mobileqq.app.message.k.d(str);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void refreshAppBadge(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) appRuntime);
        } else if (appRuntime.isLogin()) {
            ((IAppBadgeService) appRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public boolean s(MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) messageRecord, (Object) list)).booleanValue();
        }
        if (messageRecord instanceof MessageForLongMsg) {
            if (list != null) {
                list.addAll(((MessageForLongMsg) messageRecord).longMsgFragmentList);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void t(AppRuntime appRuntime, List<MessageRecord> list, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appRuntime, list, messageRecord);
        } else if (list != null) {
            ((QQAppInterface) appRuntime).getMsgHandler().n3().F(list);
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().n3().D(messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public String u(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, (Object) appRuntime, (Object) str);
        }
        return com.tencent.mobileqq.utils.ac.f((QQAppInterface) appRuntime, str);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void v(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        ((MiniMsgHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).F2(str, i3, -1);
        ((IZPlanMiniAIOHelper) QRoute.api(IZPlanMiniAIOHelper.class)).notifyUnreadCount();
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).notifyUnreadCount();
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public String w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) str2);
        }
        if (str2.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
            str = DataLineMsgRecord.tableName();
        }
        if (str2.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) {
            str = DataLineMsgRecord.tableName(1);
        }
        if (str2.equals(String.valueOf(AppConstants.DATALINE_PHONE_UIN))) {
            return DataLineMsgRecord.tableName(2);
        }
        return str;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void x(AppRuntime appRuntime, MessageRecord messageRecord, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appRuntime, messageRecord, Long.valueOf(j3));
        } else {
            ((QQAppInterface) appRuntime).getMsgHandler().h5(messageRecord, j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    @Override // com.tencent.imcore.message.BaseMessageManager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(AppRuntime appRuntime, IMessageFacade iMessageFacade, boolean z16, int i3, boolean z17, List<MessageRecord> list, MessageRecord messageRecord) {
        boolean z18;
        int i16;
        UUID uuid;
        TroopFileTransferManager.Item J;
        Pair<Long, Long> l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, appRuntime, iMessageFacade, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), list, messageRecord);
            return;
        }
        int i17 = 3000;
        if (messageRecord != null) {
            for (MessageRecord messageRecord2 : list) {
                iMessageFacade.removeMsgByUniseq(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq, false);
                if (messageRecord2.msgtype == -2005) {
                    QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                    FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                    FileManagerEntity E = fileManagerDataCenter.E(messageRecord2.uniseq, messageRecord2.frienduin, messageRecord2.istroop);
                    if (E != null) {
                        fileManagerDataCenter.X(E);
                        qQAppInterface.getFileManagerEngine().i(E.nSessionId);
                    }
                    if (messageRecord.istroop == 3000) {
                        FileManagerReporter.addData("0X8005E50");
                    } else {
                        FileManagerReporter.addData("0X8005E4D");
                    }
                    FileManagerReporter.addData("0X8005E4C");
                }
            }
            return;
        }
        for (MessageRecord messageRecord3 : list) {
            if (z16 && !messageRecord3.isread && messageRecord3 != list.get(0)) {
                messageRecord3.isread = true;
                if (i3 == 1 || i3 == i17) {
                    z18 = true;
                    if (!z18) {
                        c(i3, appRuntime).u(messageRecord3, false);
                    } else {
                        iMessageFacade.removeMsgByUniseq(messageRecord3.frienduin, messageRecord3.istroop, messageRecord3.uniseq, !z17);
                    }
                    i16 = messageRecord3.msgtype;
                    if (i16 != -2005 || (messageRecord3 instanceof MessageForTroopFile)) {
                        if (i16 != -2005) {
                            QQAppInterface qQAppInterface2 = (QQAppInterface) appRuntime;
                            FileManagerDataCenter fileManagerDataCenter2 = qQAppInterface2.getFileManagerDataCenter();
                            FileManagerEntity E2 = fileManagerDataCenter2.E(messageRecord3.uniseq, messageRecord3.frienduin, messageRecord3.istroop);
                            if (E2 != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
                                }
                                fileManagerDataCenter2.X(E2);
                                qQAppInterface2.getFileManagerEngine().i(E2.nSessionId);
                            } else if (QLog.isColorLevel()) {
                                QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + messageRecord3.uniseq + "],");
                            }
                        } else if (messageRecord3 instanceof MessageForTroopFile) {
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord3;
                            QQAppInterface qQAppInterface3 = (QQAppInterface) appRuntime;
                            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface3, Long.parseLong(messageForTroopFile.frienduin));
                            com.tencent.mobileqq.troop.data.t m3 = TroopFileUtils.m(qQAppInterface3, messageForTroopFile);
                            if (m3 != null && (uuid = m3.f294967a) != null && O != null && (J = O.J(uuid)) != null) {
                                O.n0(J, 12);
                            }
                        }
                        ((AIOMessageSpreadManager) appRuntime.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).q(messageRecord3);
                    }
                    l3 = EmojiStickerManager.l(messageRecord3);
                    if (l3 == null) {
                        EmojiStickerManager.k().f204599j.put(l3, Boolean.TRUE);
                    }
                    i17 = 3000;
                }
            }
            z18 = false;
            if (!z18) {
            }
            i16 = messageRecord3.msgtype;
            if (i16 != -2005) {
            }
            if (i16 != -2005) {
            }
            ((AIOMessageSpreadManager) appRuntime.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).q(messageRecord3);
            l3 = EmojiStickerManager.l(messageRecord3);
            if (l3 == null) {
            }
            i17 = 3000;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager.b
    public void z(IMessageFacade iMessageFacade, String str, int i3, List<MessageRecord> list, BaseMessageManager baseMessageManager) {
        MessageForLongMsg messageForLongMsg;
        List<MessageRecord> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, iMessageFacade, str, Integer.valueOf(i3), list, baseMessageManager);
            return;
        }
        if (!list.isEmpty() && (list.get(list.size() - 1) instanceof MessageForLongMsg) && ao.D(list.get(list.size() - 1), iMessageFacade.getLastMessage(str, i3)) && (list2 = (messageForLongMsg = (MessageForLongMsg) list.get(list.size() - 1)).longMsgFragmentList) != null && !list2.isEmpty() && messageForLongMsg.longMsgFragmentList.get(0).longMsgIndex < iMessageFacade.getLastMessage(str, i3).longMsgIndex) {
            baseMessageManager.o0(messageForLongMsg.longMsgFragmentList.get(0), true, 2);
            baseMessageManager.k0(str, i3, messageForLongMsg.longMsgFragmentList.get(0), 2);
            baseMessageManager.o0(messageForLongMsg, true, 3);
            baseMessageManager.k0(str, i3, messageForLongMsg, 3);
        }
    }
}
