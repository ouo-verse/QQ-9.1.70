package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameReportApiImpl implements IGameReportApi {
    private static final String OPERATE_MODULE = "1006";
    private static final String TAG = "GameReportApiImpl";
    private static String lastReportApplyPartnerBoxUid;
    private static ArrayList<String> lastReportApplyPartnerMsgUidList = new ArrayList<>();
    private static ArrayList<String> lastReportGamePartnerMsgUidList = new ArrayList<>();

    private String getGameAppId(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        if (gVar != null && gVar.p() != null) {
            Iterator<RecentContactExtAttr> it = gVar.p().iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (tempChatGameSession = next.gameSession) != null) {
                    return String.valueOf(tempChatGameSession.gameAppId);
                }
            }
            return "";
        }
        return "";
    }

    private String getPeerOpenId(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        String str;
        if (gVar != null && gVar.p() != null) {
            Iterator<RecentContactExtAttr> it = gVar.p().iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (tempChatGameSession = next.gameSession) != null && (str = tempChatGameSession.peerOpenId) != null) {
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void clearLastReportApplyPartnerBoxData() {
        lastReportApplyPartnerBoxUid = "";
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void clearLastReportApplyPartnerData() {
        synchronized (lastReportApplyPartnerMsgUidList) {
            lastReportApplyPartnerMsgUidList.clear();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void clearLastReportGamePartnerData() {
        synchronized (lastReportGamePartnerMsgUidList) {
            lastReportGamePartnerMsgUidList.clear();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportApplyPartnerBoxExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        String str;
        String str2 = lastReportApplyPartnerBoxUid;
        if (str2 != null && str2.equals(gVar.k())) {
            return;
        }
        lastReportApplyPartnerBoxUid = gVar.k();
        if (gVar.x().b() > 0) {
            str = "0";
        } else {
            str = "1";
        }
        com.tencent.mobileqq.gamecenter.utils.f.j0(QZoneShareManager.GLORY_OF_KINGS, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92050", "928866", null, null, "8", str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportApplyPartnerMsgExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        String str;
        synchronized (lastReportApplyPartnerMsgUidList) {
            if (lastReportApplyPartnerMsgUidList.contains(gVar.k())) {
                return;
            }
            lastReportApplyPartnerMsgUidList.add(gVar.k());
            if (gVar.x().b() > 0) {
                str = "0";
            } else {
                str = "1";
            }
            com.tencent.mobileqq.gamecenter.utils.f.j0(QZoneShareManager.GLORY_OF_KINGS, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92050", "928909", null, null, "8", str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportGameAchievement(String str, String str2, int i3) {
        GameCenterUnissoHandler.N2().reportGameAchievement(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportGamePartnerMsgExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        synchronized (lastReportGamePartnerMsgUidList) {
            if (lastReportGamePartnerMsgUidList.contains(gVar.k())) {
                return;
            }
            lastReportGamePartnerMsgUidList.add(gVar.k());
            com.tencent.mobileqq.gamecenter.utils.f.j0(getGameAppId(gVar), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92053", "989347", getPeerOpenId(gVar), null, "8", "");
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportRobot(String str, String str2, GameReportExtraData gameReportExtraData) {
        GameCenterUnissoHandler.N2().p3("1006", str, str2, gameReportExtraData);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameReportApi
    public void reportSendHonorRankArkMsg(String str) {
        GameCenterUnissoHandler.N2().reportSendHonorRankArkMsg(str);
    }
}
