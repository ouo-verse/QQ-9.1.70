package com.tencent.mobileqq.gamecenter.qa.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import sd1.c;
import sd1.d;
import vd1.MetaDreamUnreadMsgInfo;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public class MetaDreamServiceImpl extends fe1.a implements IMetaDreamService {
    private static final String TAG = "MetaDreamServiceImpl";
    private sd1.a mGetOAIDCallback;
    private boolean mIsMetaDreamAio;
    private sd1.b mMetaDreamAddFriendCallback;
    private c mMetaDreamGetGameTeamingLinkCallback;
    private d mMetaDreamIsFriendCallback;
    private fe1.c mStrategyHandler = null;

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void addMetaDreamGameFriend(String str, String str2, sd1.b bVar) {
        this.mMetaDreamAddFriendCallback = bVar;
        this.mStrategyHandler.G(str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void getIsMetaDreamFriendFromServer(String str, d dVar) {
        this.mMetaDreamIsFriendCallback = dVar;
        this.mStrategyHandler.K0(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void getMetaDreamGameTeamingLink(String str, String str2, String str3, c cVar) {
        this.mMetaDreamGetGameTeamingLinkCallback = cVar;
        this.mStrategyHandler.R(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public MetaDreamUnreadMsgInfo getMetaDreamUnreadMsgInfo() {
        int i3;
        List<RecentContactInfo> gameRecentContactList = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameRecentContactList();
        long j3 = 0;
        if (gameRecentContactList != null && gameRecentContactList.size() > 0) {
            i3 = 0;
            long j16 = 0;
            for (RecentContactInfo recentContactInfo : gameRecentContactList) {
                TempChatGameSession gameSessionFromContact = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromContact(recentContactInfo);
                if (gameSessionFromContact != null && "1112198072".equals(String.valueOf(gameSessionFromContact.getGameAppId()))) {
                    long unreadCnt = recentContactInfo.getUnreadCnt();
                    if (unreadCnt > 0) {
                        i3 = (int) (i3 + unreadCnt);
                        if (recentContactInfo.getMsgTime() > j16) {
                            j16 = recentContactInfo.getMsgTime();
                        }
                    }
                }
            }
            j3 = j16;
        } else {
            i3 = 0;
        }
        MetaDreamUnreadMsgInfo metaDreamUnreadMsgInfo = new MetaDreamUnreadMsgInfo(i3, j3);
        QLog.d(TAG, 1, "getMetaDreamUnreadSessionInfo result=", metaDreamUnreadMsgInfo);
        return metaDreamUnreadMsgInfo;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public Bundle getMetaDreamUnreadMsgInfoBundle() {
        Bundle bundle = new Bundle();
        MetaDreamUnreadMsgInfo metaDreamUnreadMsgInfo = getMetaDreamUnreadMsgInfo();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgCount", metaDreamUnreadMsgInfo.getUnreadCount());
            jSONObject.put("latestMsgTime", metaDreamUnreadMsgInfo.getLastestMsgTime());
            bundle.putInt("result", 0);
            bundle.putString("data", jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getMetaDreamUnreadSessionInfoBundle exception=", th5);
            bundle.putInt("result", -1);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void getOAIDFromServer(String str, sd1.a aVar) {
        QLog.d(TAG, 1, "getOAIDFromServer");
        this.mGetOAIDCallback = aVar;
        this.mStrategyHandler.V(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public String getSavedOAID() {
        return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).decodeString("key_gc_ad_oaid", "");
    }

    @Override // fe1.a, fe1.d
    public void onAddMetaDreamGameFriend(boolean z16, long j3) {
        sd1.b bVar = this.mMetaDreamAddFriendCallback;
        if (bVar != null) {
            bVar.onAddMetaDreamGameFriend(z16, j3);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        fe1.c cVar = new fe1.c();
        this.mStrategyHandler = cVar;
        cVar.Z0(this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mStrategyHandler.N0();
    }

    @Override // fe1.a, fe1.d
    public void onGetMetaDreamGameTeamingLink(boolean z16, long j3, String str) {
        c cVar = this.mMetaDreamGetGameTeamingLinkCallback;
        if (cVar != null) {
            cVar.a(z16, j3, str);
        }
    }

    @Override // fe1.a, fe1.d
    public void onGetMetaDreamIsFriend(boolean z16, long j3, boolean z17) {
        d dVar = this.mMetaDreamIsFriendCallback;
        if (dVar != null) {
            dVar.a(z16, j3, z17);
        }
    }

    @Override // fe1.a, fe1.d
    public void onGetOAID(boolean z16, String str) {
        sd1.a aVar = this.mGetOAIDCallback;
        if (aVar != null) {
            aVar.onGetOAID(z16, str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void removeGetOAIDCallback() {
        this.mGetOAIDCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void removeMetaDreamAddFriendCallback() {
        this.mMetaDreamAddFriendCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void removeMetaDreamGetGameTeamingLinkCallback() {
        this.mMetaDreamGetGameTeamingLinkCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService
    public void removeMetaDreamIsGameFriendCallback() {
        this.mMetaDreamIsFriendCallback = null;
    }
}
