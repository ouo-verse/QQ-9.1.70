package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterCommonApiImpl implements IGameCenterCommonApi {
    public static final String KEY_ACT_FLAG = "actFlag";
    public static final String KEY_ACT_ID = "actId";
    public static final String KEY_ACT_URL = "actUrl";
    public static final String KEY_OFFLINE_IDS = "actOfflineId";
    public static final String TAG = "GameActWeb.GameCenterCommonApiImpl";
    private static final long WANGZHE_APP_ID = 1104466820;
    private static com.tencent.biz.common.offline.a sCallback = new a();
    private com.tencent.mobileqq.gamecenter.protocols.c mActConfigHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveActUrl$0(String str, String str2, long j3) {
        try {
            com.tencent.mobileqq.gamecenter.utils.c.t(str, str2, j3);
            com.tencent.mobileqq.gamecenter.utils.c.b();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[saveActUrl], th:", th5);
        }
    }

    private void reportError(String str) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setOperId("915932").setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(2, str);
        wadlReportBuilder.report();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public void checkNewConfiguredUrl(String str, String str2, com.tencent.mobileqq.gamecenter.api.i iVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.tencent.mobileqq.gamecenter.protocols.c cVar = new com.tencent.mobileqq.gamecenter.protocols.c();
        this.mActConfigHandler = cVar;
        cVar.j(str, str2, iVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean handleGameActScheme(HashMap<String, String> hashMap, Context context) {
        if (hashMap != null && !hashMap.isEmpty()) {
            String str = hashMap.get(KEY_ACT_FLAG);
            String str2 = hashMap.get(KEY_ACT_URL);
            if (!"1".equals(str)) {
                return false;
            }
            if (!com.tencent.mobileqq.gamecenter.utils.c.l(str2)) {
                reportError("2");
                QLog.w(TAG, 1, "[handleGameActScheme], not legal url, actUrl:" + str2);
                return false;
            }
            String str3 = hashMap.get(KEY_ACT_ID);
            if (TextUtils.isEmpty(str3)) {
                reportError("1");
                QLog.w(TAG, 1, "[handleGameActScheme], No actID++++++++++");
                return true;
            }
            try {
                String h16 = com.tencent.mobileqq.gamecenter.utils.c.h(str3);
                QLog.i(TAG, 1, "[handleGameActScheme] actId:" + str3 + ",orgUrl:" + str2 + ",hitUrl:" + h16);
                if (!TextUtils.isEmpty(h16)) {
                    str2 = h16;
                }
                com.tencent.mobileqq.gamecenter.utils.c.v(str2, context, str3, str);
                com.tencent.mobileqq.gamecenter.utils.c.w(hashMap.get(KEY_OFFLINE_IDS), sCallback);
                return true;
            } catch (Throwable th5) {
                QLog.w(TAG, 1, "[handleGameActScheme], error happens! use default way. th:", th5);
                reportError("3");
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isApplyPartnerBox(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        if (gVar == null || gVar.p() == null) {
            return false;
        }
        Iterator<RecentContactExtAttr> it = gVar.p().iterator();
        while (it.hasNext()) {
            RecentContactExtAttr next = it.next();
            if (next != null && (tempChatGameSession = next.gameSession) != null) {
                if (tempChatGameSession.seekingPartner.intValue() != 10000) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isApplyPartnerContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        if (gVar != null && gVar.p() != null) {
            Iterator<RecentContactExtAttr> it = gVar.p().iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (tempChatGameSession = next.gameSession) != null) {
                    return isApplyPartnerContact(tempChatGameSession);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isGamePartnerContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        if (gVar != null && gVar.p() != null) {
            Iterator<RecentContactExtAttr> it = gVar.p().iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (tempChatGameSession = next.gameSession) != null) {
                    return isGamePartnerContact(tempChatGameSession);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isWangZheContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        TempChatGameSession tempChatGameSession;
        if (gVar == null || gVar.p() == null) {
            return false;
        }
        Iterator<RecentContactExtAttr> it = gVar.p().iterator();
        while (it.hasNext()) {
            RecentContactExtAttr next = it.next();
            if (next != null && (tempChatGameSession = next.gameSession) != null) {
                if (tempChatGameSession.gameAppId != WANGZHE_APP_ID) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public void saveActUrl(final String str, final String str2, final long j3) {
        QLog.i(TAG, 1, "[saveActUrl] actId:" + str + ",url:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterCommonApiImpl.lambda$saveActUrl$0(str, str2, j3);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isApplyPartnerContact(TempChatGameSession tempChatGameSession) {
        return tempChatGameSession != null && tempChatGameSession.seekingPartner.intValue() == 1 && tempChatGameSession.gameAppId == WANGZHE_APP_ID;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi
    public boolean isGamePartnerContact(TempChatGameSession tempChatGameSession) {
        AppRuntime peekAppRuntime;
        IGameMsgManagerService iGameMsgManagerService;
        List<com.tencent.mobileqq.gamecenter.data.n> recentPartnerList;
        if (tempChatGameSession == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iGameMsgManagerService = (IGameMsgManagerService) peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "")) == null || (recentPartnerList = iGameMsgManagerService.getRecentPartnerList()) == null) {
            return false;
        }
        for (com.tencent.mobileqq.gamecenter.data.n nVar : recentPartnerList) {
            if (nVar != null && nVar.p(tempChatGameSession)) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("GameActWeb.offlineCallback", 1, "[loaded], code:" + i3 + ",param:" + str);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
