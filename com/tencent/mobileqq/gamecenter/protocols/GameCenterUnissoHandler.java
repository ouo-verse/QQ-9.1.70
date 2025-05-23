package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.MtpConstants;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gamecenter.api.IGameCenterSgameApi;
import com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.gamecenter.api.impl.GameMsgHelperApiImpl;
import com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl;
import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.gamecenter.data.n;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterHonorRank$PreloadRankReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterRobotReport$ReportReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting$QueryAIOGreetInfoReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting$QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GetAllGameListReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GetAllGameListRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.MobileDialog;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetPartnerDialogReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$OpenAIOReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$ReportGameMsgInfoReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$SendMsgReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$SendMsgRsp;
import com.tencent.mobileqq.gamecenter.utils.j;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import com.tencent.trpcprotocol.gamecenter.sgame_team.sgame_team.SgameTeamPB$GetTeamLinkReq;
import com.tencent.trpcprotocol.gamecenter.sgame_team.sgame_team.SgameTeamPB$GetTeamLinkRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadReq;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterUnissoHandler extends BusinessHandler {

    /* renamed from: i, reason: collision with root package name */
    public static final String f212290i = "com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler";

    /* renamed from: m, reason: collision with root package name */
    private static String f212291m = "GameCenterMsg.GameCenterUnissoHandler";

    /* renamed from: d, reason: collision with root package name */
    private long f212292d;

    /* renamed from: e, reason: collision with root package name */
    private long f212293e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f212294f;

    /* renamed from: h, reason: collision with root package name */
    private WadlTrpcListener f212295h;

    public GameCenterUnissoHandler(AppInterface appInterface) {
        super(appInterface);
        this.f212292d = 0L;
        this.f212293e = 1200L;
        this.f212295h = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler.1
            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            public HashSet<String> getFilterCmds() {
                return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler.1.1
                    {
                        add(HippyUnissoHandler.CMD_TRPC_GAME_CENTER_HIPPY_CONFIG);
                        add("/v1/216");
                        add("/v1/221");
                        add("/v1/279");
                        add("/v1/347");
                        add("/v1/739");
                        add("/v1/1232");
                        add("/v1/1553");
                        add("/v1/1545");
                        add("/v1/1693");
                        add("/v1/1967");
                        add("/v1/1968");
                    }
                };
            }

            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
                if (QLog.isColorLevel()) {
                    QLog.i(GameCenterUnissoHandler.f212291m, 1, "WadlTrpcListener onTrpcRsp cmd:" + str + " ret:" + j3);
                }
                if (HippyUnissoHandler.CMD_TRPC_GAME_CENTER_HIPPY_CONFIG.equals(str)) {
                    GameCenterUnissoHandler.this.Z2(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/216".equals(str)) {
                    GameCenterUnissoHandler.this.f3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/221".equals(str)) {
                    GameCenterUnissoHandler.this.Y2(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/279".equals(str)) {
                    GameCenterUnissoHandler.this.i3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/347".equals(str)) {
                    GameCenterUnissoHandler.this.h3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/739".equals(str)) {
                    GameCenterUnissoHandler.this.X2(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/1232".equals(str)) {
                    GameCenterUnissoHandler.this.d3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/1553".equals(str)) {
                    GameCenterUnissoHandler.this.m3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/1545".equals(str)) {
                    GameCenterUnissoHandler.this.k3(intent, j3, trpcInovkeRsp);
                    return;
                }
                if ("/v1/1693".equals(str)) {
                    GameCenterUnissoHandler.this.e3(intent, j3, trpcInovkeRsp);
                } else if ("/v1/1967".equals(str)) {
                    GameCenterUnissoHandler.this.W2(intent, j3, trpcInovkeRsp);
                } else if ("/v1/1968".equals(str)) {
                    GameCenterUnissoHandler.this.g3(intent, j3, trpcInovkeRsp);
                }
            }
        };
        this.f212294f = appInterface;
    }

    private boolean K2() {
        boolean z16;
        this.f212293e = S2();
        this.f212292d = P2();
        if (NetConnInfoCenter.getServerTime() - (this.f212292d / 1000) < this.f212293e) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[checkTabConfigInterval] ret=" + z16 + ",lasttime = " + (this.f212292d / 1000) + ", interval = " + this.f212293e);
        }
        return z16;
    }

    private CommonReq L2(long j3, long j16) {
        CommonReq commonReq = new CommonReq();
        try {
            commonReq.cpuCoreCount.set(ah.n());
            commonReq.manufacturer.set(Build.BRAND);
            commonReq.model.set(DeviceInfoMonitor.getModel());
            commonReq.osVersionCode.set(Build.VERSION.SDK_INT);
            commonReq.qqVersion.set(ah.Q(BaseApplication.getContext()));
            commonReq.totalMemory.set((int) (m.c() / 1048576));
            commonReq.lastPreDownloadTime.set(j3);
            commonReq.lastUpdateTime.set(j16);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, "createCommonHippyReq e:" + th5);
        }
        return commonReq;
    }

    public static GameCenterUnissoHandler N2() {
        return (GameCenterUnissoHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(f212290i);
    }

    private String O2(byte[] bArr) {
        try {
            WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
            webSSOAgent$UniSsoServerRsp.mergeFrom(bArr);
            return webSSOAgent$UniSsoServerRsp.rspdata.get();
        } catch (Throwable th5) {
            QLog.i(f212291m, 2, th5.getMessage());
            return "";
        }
    }

    private gd1.a Q2(GameUserInfo gameUserInfo) {
        if (gameUserInfo == null) {
            return null;
        }
        GameMsgManagerServiceImpl gameMsgManagerServiceImpl = (GameMsgManagerServiceImpl) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
        if (!GameUserInfo.isUsrInfoUpdate(gameMsgManagerServiceImpl.findGameUserInfo(gameUserInfo.mRoleId), gameUserInfo)) {
            return null;
        }
        QLog.i(f212291m, 1, "[notifyGameUsrInfoChanged], roleId:" + gameUserInfo.mRoleId);
        return gd1.a.b(gameMsgManagerServiceImpl.findGameConfig(gameUserInfo.mAppId), gameUserInfo);
    }

    private ie1.a T2(Intent intent, Object obj) {
        ie1.a aVar = new ie1.a();
        aVar.f407561b = obj;
        if (intent != null) {
            aVar.f407560a = intent.getIntExtra("req_intent_param_hashcode", -1);
        }
        return aVar;
    }

    private void U2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleAddOrShieldFriend]");
        }
        try {
            com.tencent.mobileqq.gamecenter.utils.c.c();
            if (bArr != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                JSONObject jSONObject = new JSONObject(O2(bArr)).getJSONObject("Aio.DealGameFriend").getJSONObject("rsp");
                int optInt = jSONObject.optInt("ret_code");
                int optInt2 = jSONObject.optInt("op_type");
                String optString = jSONObject.optString("err_msg");
                QLog.i(f212291m, 1, "[handleAddOrShieldFriend], retCode:" + optInt + ",errMsg:" + optString + ",type:" + optInt2);
                notifyUI(8263, true, T2(intent, jSONObject));
            }
        } catch (Throwable th5) {
            notifyUI(8263, false, T2(intent, null));
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    private void V2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleAioPopInfo]");
        }
        if (bArr != null && fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess() && (optJSONObject = new JSONObject(O2(bArr)).optJSONObject("Aio.GetAioPop")) != null && (optJSONObject2 = optJSONObject.optJSONObject("rsp")) != null) {
                    int optInt = optJSONObject2.optInt("ret_code");
                    String optString = optJSONObject2.optString("err_msg");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("popinfo");
                    if (optInt != 0) {
                        QLog.w(f212291m, 1, "errMsg:" + optString);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        String str = f212291m;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[handleAioPopInfo] popInfo: ");
                        if (optJSONObject3 == null) {
                            jSONObject = "null";
                        } else {
                            jSONObject = optJSONObject3.toString();
                        }
                        sb5.append(jSONObject);
                        QLog.d(str, 2, sb5.toString());
                    }
                    notifyUI(8279, true, T2(intent, Integer.valueOf(optJSONObject2.optInt("game_type"))));
                    Object optJSONObject4 = optJSONObject2.optJSONObject("friend_info");
                    Object optJSONArray = optJSONObject2.optJSONArray("gray_tips_list");
                    if (optJSONObject4 != null) {
                        notifyUI(8226, true, T2(intent, optJSONObject4));
                    }
                    if (optJSONObject3 != null) {
                        notifyUI(8225, true, T2(intent, optJSONObject3));
                    }
                    if (optJSONArray != null) {
                        notifyUI(8228, true, T2(intent, optJSONArray));
                    }
                    notifyUI(8273, true, T2(intent, optJSONObject2.optString("desc")));
                    notifyUI(8278, true, T2(intent, optJSONObject2.optString("zone_url")));
                    Object optJSONObject5 = optJSONObject2.optJSONObject("stranger_recomd");
                    if (optJSONObject5 != null) {
                        notifyUI(8262, true, T2(intent, optJSONObject5));
                    }
                    notifyUI(8261, true, T2(intent, optJSONObject2.optString("top_gray_tips")));
                    notifyUI(8264, true, T2(intent, optJSONObject2.optJSONArray("head_icon_list")));
                    notifyUI(8274, true, T2(intent, optJSONObject2));
                    if (optJSONObject2.has("sgamebattle")) {
                        notifyUI(8275, true, T2(intent, optJSONObject2));
                    }
                    if (optJSONObject2.has("new_page_info")) {
                        notifyUI(8276, true, T2(intent, optJSONObject2));
                    }
                    if (optJSONObject2.has("session_sig")) {
                        notifyUI(8277, true, T2(intent, optJSONObject2.optString("session_sig")));
                    }
                }
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, th5.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isColorLevel()) {
            QLog.i(f212291m, 1, "handleGameCardInfo retCode:" + j3);
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                SgamePartnerSvr$GetGameMsgPartnersRsp sgamePartnerSvr$GetGameMsgPartnersRsp = new SgamePartnerSvr$GetGameMsgPartnersRsp();
                sgamePartnerSvr$GetGameMsgPartnersRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).onGetGameCardInfo(sgamePartnerSvr$GetGameMsgPartnersRsp);
                return;
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, "[handleRecentPartnerSessionList] e:", th5);
                return;
            }
        }
        ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).onGetGameCardInfo(null);
    }

    private void a3(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        JSONObject optJSONObject;
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleGameStartPriority]");
        }
        if (bArr != null && fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    JSONObject jSONObject = new JSONObject(O2(bArr));
                    if (QLog.isColorLevel()) {
                        QLog.d(f212291m, 2, "[handleGameStartPriority] root: " + jSONObject.toString());
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("GameInfo.GetGameStartPriority");
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("rsp")) != null && optJSONObject.optInt("ret_code") == 0) {
                        notifyUI(8227, true, T2(intent, optJSONObject));
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.e(f212291m, 1, "", e16);
                return;
            }
        }
        notifyUI(8227, false, T2(intent, null));
    }

    private void b3(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        String jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleGetGameSwitch]");
        }
        if (bArr != null && fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    JSONObject jSONObject2 = new JSONObject(O2(bArr)).getJSONObject("UserInfo.GetSwitch").getJSONObject("rsp");
                    int optInt = jSONObject2.optInt("ret_code");
                    String optString = jSONObject2.optString("err_msg");
                    JSONObject optJSONObject = jSONObject2.optJSONObject("result_map").optJSONObject(this.f212294f.getCurrentAccountUin());
                    if (optInt != 0) {
                        QLog.w(f212291m, 1, "errMsg:" + optString);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        String str = f212291m;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[handleGetGameSwitch] result: ");
                        if (optJSONObject == null) {
                            jSONObject = "null";
                        } else {
                            jSONObject = optJSONObject.toString();
                        }
                        sb5.append(jSONObject);
                        QLog.d(str, 2, sb5.toString());
                    }
                    ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
                    if (optJSONObject != null) {
                        Iterator keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            if (!TextUtils.isEmpty(str2)) {
                                GameSwitchConfig gameSwitchConfig = new GameSwitchConfig();
                                JSONObject jSONObject3 = optJSONObject.getJSONObject(str2);
                                gameSwitchConfig.mAppId = str2;
                                gameSwitchConfig.mSyncSwitch = jSONObject3.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                                gameSwitchConfig.mBlockSwitch = jSONObject3.optInt("qq_block_switch");
                                gameSwitchConfig.mBoxSwitch = jSONObject3.optInt("box_switch");
                                gameSwitchConfig.mMuteSwitch = jSONObject3.optInt("mutex_switch");
                                gameSwitchConfig.print();
                                arrayList.add(gameSwitchConfig);
                            }
                        }
                        ((GameMsgManagerServiceImpl) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateGameSwitchConfigs(arrayList);
                    }
                    notifyUI(8272, true, T2(intent, ""));
                }
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, th5.getMessage());
            }
        }
    }

    private void c3(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        ArrayList<GameUserInfo> arrayList;
        GameMsgManagerServiceImpl gameMsgManagerServiceImpl;
        long j3;
        String str;
        ArrayList arrayList2;
        GameCenterUnissoHandler gameCenterUnissoHandler = this;
        String str2 = "game_profile";
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleGetUserInfoRsp]");
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            GameMsgManagerServiceImpl gameMsgManagerServiceImpl2 = (GameMsgManagerServiceImpl) gameCenterUnissoHandler.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
            if (bArr != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                JSONObject jSONObject = new JSONObject(gameCenterUnissoHandler.O2(bArr));
                if (QLog.isColorLevel()) {
                    QLog.d(f212291m, 2, jSONObject.toString());
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("UserInfo.GetUserInfo").getJSONObject("rsp");
                int optInt = jSONObject2.optInt("ret_code");
                String optString = jSONObject2.optString("err_msg");
                if (optInt != 0) {
                    QLog.w(f212291m, 1, "errMsg:" + optString);
                    return;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("game_config");
                ArrayList<GameBasicInfo> arrayList3 = new ArrayList<>();
                String str3 = "data_update_ts";
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str4 = (String) keys.next();
                        if (!TextUtils.isEmpty(str4)) {
                            GameBasicInfo gameBasicInfo = new GameBasicInfo();
                            gameBasicInfo.mAppId = str4;
                            JSONObject jSONObject3 = optJSONObject.getJSONObject(str4);
                            gameBasicInfo.mName = jSONObject3.optString("name");
                            gameBasicInfo.mIconUrl = jSONObject3.optString("icon");
                            gameBasicInfo.mMsgMaxLen = jSONObject3.optInt("msg_max_len");
                            gameBasicInfo.mUpdateTs = jSONObject3.optLong("data_update_ts");
                            gameBasicInfo.mStartGameUrl = jSONObject3.optString("zone_url");
                            arrayList3.add(gameBasicInfo);
                            if (QLog.isDevelopLevel()) {
                                QLog.d(f212291m, 1, "[handleGetUserInfoRsp], item:" + jSONObject3);
                            }
                        }
                    }
                    gameMsgManagerServiceImpl2.saveOrUpdateGameBasicConfigs(arrayList3);
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("result_list");
                ArrayList<GameUserInfo> arrayList4 = new ArrayList<>();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    ArrayList arrayList5 = new ArrayList();
                    int i3 = 0;
                    while (i3 < length) {
                        GameUserInfo gameUserInfo = new GameUserInfo();
                        JSONObject jSONObject4 = optJSONArray.getJSONObject(i3);
                        String optString2 = jSONObject4.optString("uin");
                        int optInt2 = jSONObject4.optInt("online_type");
                        int optInt3 = jSONObject4.optInt("sex");
                        GameMsgManagerServiceImpl gameMsgManagerServiceImpl3 = gameMsgManagerServiceImpl2;
                        int i16 = length;
                        long optLong = jSONObject4.optLong(str3);
                        JSONArray jSONArray = optJSONArray;
                        int optInt4 = jSONObject4.optInt("msgsync_switch");
                        String str5 = str3;
                        String optString3 = jSONObject4.optString("appid");
                        int i17 = i3;
                        String optString4 = jSONObject4.optString("nick");
                        ArrayList<GameUserInfo> arrayList6 = arrayList4;
                        String optString5 = jSONObject4.optString("face_url");
                        ArrayList arrayList7 = arrayList5;
                        String optString6 = jSONObject4.optString("role_id");
                        try {
                            String optString7 = jSONObject4.optString("partition_name");
                            j3 = currentTimeMillis;
                            String optString8 = jSONObject4.optJSONObject(str2).optString("level_pic");
                            String string = jSONObject4.optJSONObject(str2).getString("level_text");
                            String optString9 = jSONObject4.optString("online_desc");
                            str = str2;
                            String optString10 = jSONObject4.optString("viprank_url");
                            String optString11 = jSONObject4.optString("growth_rank_url");
                            String optString12 = jSONObject4.optString("growth_rank_jump");
                            String optString13 = jSONObject4.optString("medal_url");
                            String optString14 = jSONObject4.optString("medal_jump");
                            gameUserInfo.mUin = optString2;
                            gameUserInfo.mRoleId = optString6;
                            gameUserInfo.mAppId = optString3;
                            gameUserInfo.mUpdateTs = optLong;
                            gameUserInfo.mFaceUrl = optString5;
                            gameUserInfo.mSex = optInt3;
                            gameUserInfo.mNickInGame = optString4;
                            gameUserInfo.mOnlineType = optInt2;
                            gameUserInfo.mPartitioName = optString7;
                            gameUserInfo.mLevelPic = optString8;
                            gameUserInfo.mLevelText = string;
                            gameUserInfo.mSaveTs = j3;
                            gameUserInfo.mSwitchInGame = optInt4;
                            gameUserInfo.mOnLineDesc = optString9;
                            gameUserInfo.mVipRankUrl = optString10;
                            gameUserInfo.growthRankUrl = optString11;
                            gameUserInfo.growthRankUrlJump = optString12;
                            gameUserInfo.medalUrl = optString13;
                            gameUserInfo.medalUrlJump = optString14;
                            gameUserInfo.print();
                        } catch (Throwable th5) {
                            th = th5;
                            QLog.e(f212291m, 1, th.getMessage());
                            return;
                        }
                        try {
                            gd1.a Q2 = Q2(gameUserInfo);
                            if (Q2 != null) {
                                arrayList2 = arrayList7;
                                arrayList2.add(Q2);
                            } else {
                                arrayList2 = arrayList7;
                            }
                            arrayList6.add(gameUserInfo);
                            if (QLog.isDevelopLevel()) {
                                QLog.d(f212291m, 1, "[handleGetUserInfoRsp], usrInfo item:" + jSONObject4);
                            }
                            i3 = i17 + 1;
                            length = i16;
                            currentTimeMillis = j3;
                            gameCenterUnissoHandler = this;
                            arrayList5 = arrayList2;
                            gameMsgManagerServiceImpl2 = gameMsgManagerServiceImpl3;
                            str3 = str5;
                            str2 = str;
                            optJSONArray = jSONArray;
                            arrayList4 = arrayList6;
                        } catch (Throwable th6) {
                            th = th6;
                            QLog.e(f212291m, 1, th.getMessage());
                            return;
                        }
                    }
                    GameCenterUnissoHandler gameCenterUnissoHandler2 = gameCenterUnissoHandler;
                    arrayList = arrayList4;
                    gameMsgManagerServiceImpl = gameMsgManagerServiceImpl2;
                    ArrayList arrayList8 = arrayList5;
                    if (arrayList8.size() > 0) {
                        gameCenterUnissoHandler2.notifyUI(MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, true, gameCenterUnissoHandler2.T2(intent, arrayList8));
                    }
                } else {
                    arrayList = arrayList4;
                    gameMsgManagerServiceImpl = gameMsgManagerServiceImpl2;
                }
                if (gameMsgManagerServiceImpl != null) {
                    gameMsgManagerServiceImpl.saveOrUpdateGameUsrInfoArrays(arrayList);
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i(f212291m, 1, "[handleRemoteUserList], retCode:" + j3);
        try {
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
                List<MobileDialog> n3 = n3(trpcInovkeRsp);
                if (n3 == null) {
                    iGameMsgManagerService.notifyRemoteUserReady((int) j3, null);
                    return;
                }
                ArrayList<com.tencent.mobileqq.gamecenter.data.f> arrayList = new ArrayList<>();
                for (MobileDialog mobileDialog : n3) {
                    com.tencent.mobileqq.gamecenter.data.f fVar = new com.tencent.mobileqq.gamecenter.data.f();
                    fVar.f212017f = mobileDialog.fromOpenID.get();
                    fVar.f212013b = mobileDialog.fromRoleID.get();
                    fVar.f212015d = mobileDialog.fromTinyID.get();
                    fVar.f212018g = mobileDialog.toOpenID.get();
                    fVar.f212014c = mobileDialog.toRoleID.get();
                    fVar.f212016e = mobileDialog.toTinyID.get();
                    fVar.f212012a = mobileDialog.appid.get();
                    fVar.f212019h = mobileDialog.sig.get();
                    fVar.f212020i = mobileDialog.time.get();
                    fVar.f212021j = mobileDialog.partner_status.get();
                    arrayList.add(fVar);
                }
                iGameMsgManagerService.notifyRemoteUserReady(0, arrayList);
                QLog.i(f212291m, 1, ",dialog size:" + arrayList.size());
                return;
            }
            QLog.w(f212291m, 1, "rsp errors!");
            iGameMsgManagerService.notifyRemoteUserReady((int) j3, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
            ((IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "")).notifyRemoteUserReady(-2001, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isDevelopLevel()) {
            QLog.d(f212291m, 4, "handleReportGameCardEvent retCode:", Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent == null) {
            QLog.e(f212291m, 1, "handleReportSendHonorRankArkMsg request is null.");
        } else if (j3 != 0 || trpcInovkeRsp == null) {
            QLog.e(f212291m, 1, "handleReportSendHonorRankArkMsg request error retCode:", Long.valueOf(j3));
        }
    }

    private void j3(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        QLog.d(f212291m, 2, "handleSearchPopPreloadConfig");
        if (intent != null && bArr != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d(f212291m, 2, "handleSearchPopPreloadConfig appruntime is null");
                return;
            }
            ISearchPopService iSearchPopService = (ISearchPopService) peekAppRuntime.getRuntimeService(ISearchPopService.class, "all");
            if (iSearchPopService == null) {
                QLog.d(f212291m, 2, "handleSearchPopPreloadConfig service is null");
                return;
            }
            try {
                Preload$SsoNYGetPreloadRsp preload$SsoNYGetPreloadRsp = new Preload$SsoNYGetPreloadRsp();
                preload$SsoNYGetPreloadRsp.mergeFrom(bArr);
                iSearchPopService.handlePreloadConfig(intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0), preload$SsoNYGetPreloadRsp);
                return;
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, "handleSearchPopPreloadConfig e:", th5);
                return;
            }
        }
        QLog.d(f212291m, 2, "handleSearchPopPreloadConfig failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i(f212291m, 1, "handleSendApplyPartnerMessage retCode:" + j3);
        if (intent == null) {
            QLog.e(f212291m, 1, "handleSendApplyPartnerMessage request is null.");
            return;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            QLog.e(f212291m, 1, "handleSendApplyPartnerMessage gameMsgManager is null.");
            return;
        }
        int intExtra = intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0);
        int intExtra2 = intent.getIntExtra("requestType", -1);
        if (j3 == 0 && intExtra2 >= 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                new SgamePartnerSvr$SendMsgRsp().mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                iGameMsgManagerService.onSendApplyPartnerMessage(intExtra, intExtra2, r11.ret.get(), "");
                return;
            } catch (Throwable th5) {
                iGameMsgManagerService.onSendApplyPartnerMessage(intExtra, intExtra2, -1L, "parse rsp error:" + th5);
                QLog.e(f212291m, 1, "handleSendApplyPartnerMessage error:" + th5);
                return;
            }
        }
        iGameMsgManagerService.onSendApplyPartnerMessage(intExtra, intExtra2, j3, "error.");
    }

    private void l3(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[handleSetSwitch]");
        }
        if (bArr != null && fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess() && new JSONObject(O2(bArr)).getJSONObject("UserInfo.SetSwitch").getJSONObject("rsp").optInt("ret_code") == 0) {
                    notifyUI(8265, true, T2(intent, ""));
                }
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, th5.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isColorLevel()) {
            QLog.i(f212291m, 1, "handleUrlForCreatingSgameTeam retCode:" + j3);
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                byte[] byteArray = trpcInovkeRsp.data.get().toByteArray();
                SgameTeamPB$GetTeamLinkRsp sgameTeamPB$GetTeamLinkRsp = new SgameTeamPB$GetTeamLinkRsp();
                sgameTeamPB$GetTeamLinkRsp.mergeFrom(byteArray);
                ((IGameCenterSgameApi) QRoute.api(IGameCenterSgameApi.class)).handleUrlForCreatingSgameTeam(sgameTeamPB$GetTeamLinkRsp.team_url.get());
                return;
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, "handleMsgBoxGameList e:", th5);
                ((IGameCenterSgameApi) QRoute.api(IGameCenterSgameApi.class)).handleUrlForCreatingSgameTeam(null);
                return;
            }
        }
        ((IGameCenterSgameApi) QRoute.api(IGameCenterSgameApi.class)).handleUrlForCreatingSgameTeam(null);
    }

    private void x3(long j3) {
        String currentAccountUin = this.f212294f.getCurrentAccountUin();
        SharedPreferences sharedPreferences = this.f212294f.getApplication().getSharedPreferences("game_center_sp", 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(currentAccountUin + "sp_key_last_get_tab_config_timestamp", j3).commit();
    }

    private void y3(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[saveTabConfigInterval] interval : " + j3);
        }
        String currentAccountUin = this.f212294f.getCurrentAccountUin();
        SharedPreferences sharedPreferences = this.f212294f.getApplication().getSharedPreferences("game_center_sp", 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(currentAccountUin + "sp_key_get_tab_config_interval", j3);
        this.f212293e = j3;
    }

    public void A3() {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "sendProfileGuideShowed");
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set("");
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterMsg.SetQQCardPopSwitch");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    public void M2(int i3, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
                webSSOAgent$UniSsoServerReqComm.platform.set(109L);
                webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
                WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("role_id", next);
                    jSONArray.mo162put(jSONObject2);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_need_game_config", true);
                jSONObject3.put("query_list", jSONArray);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("req", jSONObject3);
                jSONObject.put("UserInfo.GetUserInfo", jSONObject4);
                webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
                NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
                newIntent.putExtra("cmd", "GameCenterMsg.GetUserInfo");
                newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.putExtra("req_intent_param_hashcode", i3);
                this.f212294f.startServlet(newIntent);
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, th5.getMessage());
            }
        }
    }

    public long P2() {
        String currentAccountUin = this.f212294f.getCurrentAccountUin();
        SharedPreferences sharedPreferences = this.f212294f.getApplication().getSharedPreferences("game_center_sp", 0);
        if (sharedPreferences == null) {
            return 0L;
        }
        long j3 = sharedPreferences.getLong(currentAccountUin + "sp_key_last_get_tab_config_timestamp", 0L);
        this.f212292d = j3;
        return j3;
    }

    public void R2() {
        QLog.i(f212291m, 1, "[getRemoteUserList]");
        try {
            GetMobileDialogReq getMobileDialogReq = new GetMobileDialogReq();
            getMobileDialogReq.offset.set(0);
            getMobileDialogReq.pageSize.set(-1);
            getMobileDialogReq.uin.set(Long.parseLong(this.f212294f.getCurrentAccountUin()));
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/216", false, getMobileDialogReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public long S2() {
        String currentAccountUin = this.f212294f.getCurrentAccountUin();
        SharedPreferences sharedPreferences = this.f212294f.getApplication().getSharedPreferences("game_center_sp", 0);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(currentAccountUin + "sp_key_get_tab_config_interval", 1200L);
    }

    protected void X2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isColorLevel()) {
            QLog.i(f212291m, 1, "handleGameMallAIOArkInfo retCode:" + j3);
        }
        if (intent == null) {
            QLog.e(f212291m, 1, "handleGameMallAIOArkInfo request is null.");
            return;
        }
        int intExtra = intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0);
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp = new GameMallAIORecommend$GetShopArkRsp();
                gameMallAIORecommend$GetShopArkRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ((IGameMallAIOApi) QRoute.api(IGameMallAIOApi.class)).notifyGameMallAIOArkInfo(intExtra, 0L, "", gameMallAIORecommend$GetShopArkRsp);
                return;
            } catch (Throwable th5) {
                ((IGameMallAIOApi) QRoute.api(IGameMallAIOApi.class)).notifyGameMallAIOArkInfo(intExtra, -1L, "parse rsp error.", null);
                QLog.e(f212291m, 1, "handleGameMallAIOArkInfo error:", th5);
                return;
            }
        }
        ((IGameMallAIOApi) QRoute.api(IGameMallAIOApi.class)).notifyGameMallAIOArkInfo(intExtra, j3, "error.", null);
    }

    protected void Y2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i(f212291m, 1, "handleGameMsgSayHiInfo retCode:" + j3);
        if (intent == null) {
            QLog.i(f212291m, 1, "handleGameMsgSayHiInfo request is null.");
            return;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
        int intExtra = intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, 0);
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                GameMsgGreeting$QueryAIOGreetInfoRsp gameMsgGreeting$QueryAIOGreetInfoRsp = new GameMsgGreeting$QueryAIOGreetInfoRsp();
                gameMsgGreeting$QueryAIOGreetInfoRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                iGameMsgManagerService.notifyGameMsgSayHiInfo(intExtra, 0L, "", gameMsgGreeting$QueryAIOGreetInfoRsp);
                return;
            } catch (Throwable th5) {
                iGameMsgManagerService.notifyGameMsgSayHiInfo(intExtra, -1L, "parse rsp error:" + th5, null);
                QLog.i(f212291m, 1, "handleGameMsgSayHiInfo error:" + th5);
                return;
            }
        }
        iGameMsgManagerService.notifyGameMsgSayHiInfo(intExtra, j3, "error.", null);
    }

    public void Z2(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        long j16;
        QLog.i(f212291m, 1, "handleGameMsgTabConfig retCode:" + j3);
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                CommonMobileConfQueryRsp commonMobileConfQueryRsp = new CommonMobileConfQueryRsp();
                commonMobileConfQueryRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                if (commonMobileConfQueryRsp.updatePreDownloadGap.has()) {
                    j16 = commonMobileConfQueryRsp.updatePreDownloadGap.get();
                } else {
                    j16 = 1200;
                }
                y3(j16);
                if (!commonMobileConfQueryRsp.confList.has()) {
                    QLog.e(f212291m, 1, "handleGameMsgTabConfig configRsp is empty.");
                    return;
                }
                for (MobileConfRsp mobileConfRsp : commonMobileConfQueryRsp.confList.get()) {
                    if (mobileConfRsp.configType.get() == 8) {
                        ((GameMsgManagerServiceImpl) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateTabConfigs(mobileConfRsp.conf.get());
                        return;
                    }
                }
            } catch (Throwable th5) {
                QLog.i(f212291m, 1, "handleGameMsgTabConfig error:" + th5);
            }
        }
    }

    public void addOrShieldFriend(int i3, int i16, String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[addOrShieldFriend], type:" + i16 + ",friRoleId:" + str + ",myRoleId:" + str2 + ",message:" + str3);
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("op_type", i16);
            jSONObject2.put("to_roleid", str);
            jSONObject2.put("roleid", str2);
            jSONObject2.put("text", str3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("req", jSONObject2);
            jSONObject.put("Aio.DealGameFriend", jSONObject3);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f212291m, 2, jSONObject.toString());
            }
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterMsg.DealGameFriend");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("req_intent_param_hashcode", i3);
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    protected void d3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isColorLevel()) {
            QLog.i(f212291m, 1, "handleMsgBoxGameList retCode:" + j3);
        }
        if (intent == null) {
            QLog.e(f212291m, 1, "handleMsgBoxGameList request is null.");
            return;
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                byte[] byteArray = trpcInovkeRsp.data.get().toByteArray();
                GameMsgMgrSvr$GetAllGameListRsp gameMsgMgrSvr$GetAllGameListRsp = new GameMsgMgrSvr$GetAllGameListRsp();
                gameMsgMgrSvr$GetAllGameListRsp.mergeFrom(byteArray);
                GameMsgHelperApiImpl.updateGameListOfMsgBox(gameMsgMgrSvr$GetAllGameListRsp.games.get());
                QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeBytes(GameMsgHelperApiImpl.MMKV_KEY_MSG_BOX_GAME_LIST, byteArray);
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, "handleMsgBoxGameList e:", th5);
            }
        }
    }

    protected void e3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (QLog.isColorLevel()) {
            QLog.i(f212291m, 1, "[handleRecentPartnerSessionList] retCode:" + j3);
        }
        if (intent == null) {
            QLog.e(f212291m, 1, "[handleRecentPartnerSessionList] request is null.");
            return;
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            if (this.f212294f == null) {
                QLog.e(f212291m, 1, "[handleRecentPartnerSessionList] app is null.");
                return;
            }
            try {
                List<n> W = com.tencent.mobileqq.gamecenter.utils.f.W(trpcInovkeRsp.data.get().toByteArray());
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
                QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putBytes(GameMsgManagerServiceImpl.MMKV_KEY_MSG_PARTNER_LIST + this.f212294f.getCurrentAccountUin(), trpcInovkeRsp.data.get().toByteArray());
                if (iGameMsgManagerService != null) {
                    iGameMsgManagerService.updateRecentPartnerList(W);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, "[handleRecentPartnerSessionList] e:", th5);
                return;
            }
        }
        QLog.e(f212291m, 1, "[handleRecentPartnerSessionList] data err.");
    }

    public void getAioPopInfo(int i3, int i16, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[getAioPopInfo] from svr mid: " + str + ",fid:" + str2 + ",from:" + i16);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
                webSSOAgent$UniSsoServerReqComm.platform.set(109L);
                webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
                WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("me_roleid", str);
                jSONObject2.put("friend_roleid", str2);
                jSONObject2.put("source", i16);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("req", jSONObject2);
                jSONObject.put("Aio.GetAioPop", jSONObject3);
                webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(f212291m, 2, jSONObject.toString());
                }
                NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
                newIntent.putExtra("cmd", "GameCenterMsg.GetAioPop");
                newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.putExtra("req_intent_param_hashcode", i3);
                this.f212294f.startServlet(newIntent);
            } catch (Throwable th5) {
                QLog.e(f212291m, 1, th5.getMessage());
            }
        }
    }

    public void getGameMsgTabConfig() {
        if (!K2()) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        this.f212292d = serverTimeMillis;
        x3(serverTimeMillis);
        QLog.i(f212291m, 1, "getGameMsgTabConfig start");
        try {
            CommonMobileConfQueryReq commonMobileConfQueryReq = new CommonMobileConfQueryReq();
            commonMobileConfQueryReq.commonReq.set(L2(0L, 0L));
            MobileConfReq mobileConfReq = new MobileConfReq();
            mobileConfReq.configType.set(8);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "qgame_msgassistant_aio_redpoint");
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "qgame_msgassistant_box");
            jSONArray.mo162put(jSONObject3);
            jSONObject.put("testList", jSONArray);
            mobileConfReq.busiReq.set(jSONObject.toString());
            commonMobileConfQueryReq.reqConfList.add(mobileConfReq);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(HippyUnissoHandler.CMD_TRPC_GAME_CENTER_HIPPY_CONFIG, false, commonMobileConfQueryReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Exception e16) {
            QLog.e(f212291m, 1, "getGameMsgTabConfig err: ", e16);
        }
    }

    public void getGameStartPriority(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[getGameStartPriority] appid: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("req", jSONObject2);
            jSONObject.put("GameInfo.GetGameStartPriority", jSONObject3);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f212291m, 2, jSONObject.toString());
            }
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterMsg.GetGameStartPriority");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("req_intent_param_hashcode", i3);
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    public void getGameSwitch(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[getGameSwitch]");
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("req", new JSONObject());
            jSONObject.put("UserInfo.GetSwitch", jSONObject2);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f212291m, 2, jSONObject.toString());
            }
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterMsg.GetSwitch");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("req_intent_param_hashcode", i3);
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    protected void i3(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent == null) {
            QLog.i(f212291m, 1, "handleRobotReport request is null.");
        } else if (j3 != 0 || trpcInovkeRsp == null) {
            QLog.e(f212291m, 1, "handleRobotReport request error retCode:", Long.valueOf(j3));
        }
    }

    public List<MobileDialog> n3(TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        try {
            GetMobileDialogRsp getMobileDialogRsp = new GetMobileDialogRsp();
            getMobileDialogRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
            return getMobileDialogRsp.dialogList.get();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void o3(int i3, ArrayList<String> arrayList) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(f212291m, 2, "reportGameCardEvent type:", Integer.valueOf(i3), " userIds:", arrayList);
            }
            SgamePartnerSvr$ReportGameMsgInfoReq sgamePartnerSvr$ReportGameMsgInfoReq = new SgamePartnerSvr$ReportGameMsgInfoReq();
            sgamePartnerSvr$ReportGameMsgInfoReq.type.set(i3);
            if (arrayList != null) {
                sgamePartnerSvr$ReportGameMsgInfoReq.uids.addAll(arrayList);
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1968", false, sgamePartnerSvr$ReportGameMsgInfoReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ie1.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f212295h);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    public void p3(String str, String str2, String str3, GameReportExtraData gameReportExtraData) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "reportGameRobot operId:", str2, ",operModule:", str);
        }
        if (QLog.isDebugVersion()) {
            QLog.d(f212291m, 4, "reportGameRobot:operId=" + str2 + "; src=" + str3 + "; extra=" + gameReportExtraData);
        }
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        GameCenterRobotReport$ReportReq gameCenterRobotReport$ReportReq = new GameCenterRobotReport$ReportReq();
        gameCenterRobotReport$ReportReq.oper_module.set(str);
        gameCenterRobotReport$ReportReq.oper_id.set(str2);
        gameCenterRobotReport$ReportReq.domain.set("1");
        gameCenterRobotReport$ReportReq.sq_ver.set(AppSetting.f99551k);
        if (gameReportExtraData != null) {
            gameCenterRobotReport$ReportReq.exts.set(j.a(gameReportExtraData));
        }
        gameCenterRobotReport$ReportReq.gamecenter_src.set(str3);
        trpcListReq.list.add(((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/279", false, gameCenterRobotReport$ReportReq.toByteArray()));
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void q3(int i3) {
        try {
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/739", false, new MessageMicro<GameMallAIORecommend$GetShopArkReq>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameMallAIORecommend$GetShopArkReq.class);
            }.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, i3);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            ((IGameMallAIOApi) QRoute.api(IGameMallAIOApi.class)).notifyGameMallAIOArkInfo(i3, -1L, "request error.", null);
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void r3(int i3, String str, String str2) {
        QLog.i(f212291m, 1, "[reqGameMsgSayHiInfo]");
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                GameMsgGreeting$QueryAIOGreetInfoReq gameMsgGreeting$QueryAIOGreetInfoReq = new GameMsgGreeting$QueryAIOGreetInfoReq();
                gameMsgGreeting$QueryAIOGreetInfoReq.fromRoleID.set(str);
                gameMsgGreeting$QueryAIOGreetInfoReq.toRoleID.set(str2);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/221", false, gameMsgGreeting$QueryAIOGreetInfoReq.toByteArray());
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
                Bundle bundle = new Bundle();
                bundle.putInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, i3);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
                return;
            } catch (Throwable th5) {
                iGameMsgManagerService.notifyGameMsgSayHiInfo(i3, -1L, "request error." + th5, null);
                QLog.e(f212291m, 1, th5, new Object[0]);
                return;
            }
        }
        iGameMsgManagerService.notifyGameMsgSayHiInfo(i3, -1L, "roleId is empty.", null);
        QLog.i(f212291m, 1, "[reqGameMsgSayHiInfo] roleId is empty.");
    }

    public void reportGameAchievement(String str, String str2, int i3) {
        QLog.d(f212291m, 1, "[reportGameAchievement]");
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99554n);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appid", str);
            jSONObject3.put(TtmlNode.TAG_TT, 1);
            jSONObject3.put("type", i3);
            jSONObject3.put("uin", str2);
            jSONObject3.put("skey", "");
            jSONObject2.put("req", jSONObject3);
            jSONObject.put("13077", jSONObject2);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterWebSvc.13077");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            this.f212294f.startServlet(newIntent);
        } catch (Exception e16) {
            QLog.e(f212291m, 1, "[reportGameAchievement] exception=", e16);
        }
    }

    public void reportSendHonorRankArkMsg(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "reportSendHonorRankArkMsg");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(f212291m, 1, "reportSendHonorRankArkMsg, groupUin null");
            return;
        }
        try {
            GameCenterHonorRank$PreloadRankReq gameCenterHonorRank$PreloadRankReq = new GameCenterHonorRank$PreloadRankReq();
            gameCenterHonorRank$PreloadRankReq.group_code.set(Long.parseLong(str));
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/347", false, gameCenterHonorRank$PreloadRankReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, "reportSendHonorRankArkMsg, exception=", th5);
        }
    }

    public void reqGameCardInfo() {
        try {
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1967", false, new MessageMicro<SgamePartnerSvr$GetGameMsgPartnersReq>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SgamePartnerSvr$GetGameMsgPartnersReq.class);
            }.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void s3() {
        try {
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1232", false, new MessageMicro<GameMsgMgrSvr$GetAllGameListReq>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GetAllGameListReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameMsgMgrSvr$GetAllGameListReq.class);
            }.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void setGameSwitch(int i3, String str, int i16, int i17, com.tencent.mobileqq.gamecenter.data.c cVar) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d(f212291m, 2, "[setGameSwitch] synSwitch: " + i16 + ",blockSwitch:" + i17);
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject2 = new JSONObject();
            if (cVar != null) {
                jSONObject = cVar.b();
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("appid", str);
            jSONObject.put("switch_type", i16);
            jSONObject.put("qq_block_switch_type", i17);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("req", jSONObject);
            jSONObject2.put("UserInfo.SetSwitch", jSONObject3);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject2.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f212291m, 2, jSONObject2.toString());
            }
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "GameCenterMsg.SetSwitch");
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("req_intent_param_hashcode", i3);
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5.getMessage());
        }
    }

    public void t3(String str, String str2, WadlTrpcListener wadlTrpcListener) {
        try {
            SgamePartnerSvr$OpenAIOReq sgamePartnerSvr$OpenAIOReq = new SgamePartnerSvr$OpenAIOReq();
            sgamePartnerSvr$OpenAIOReq.from_openaio_id.set(str);
            sgamePartnerSvr$OpenAIOReq.to_openaio_id.set(str2);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1694", false, sgamePartnerSvr$OpenAIOReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putLong(WadlProxyConsts.PARAM_TIME_OUT, 3000L);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(wadlTrpcListener);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void u3() {
        try {
            SgamePartnerSvr$GetPartnerDialogReq sgamePartnerSvr$GetPartnerDialogReq = new SgamePartnerSvr$GetPartnerDialogReq();
            sgamePartnerSvr$GetPartnerDialogReq.page_size.set(200);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1693", false, sgamePartnerSvr$GetPartnerDialogReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void v3(Preload$SsoNYGetPreloadReq preload$SsoNYGetPreloadReq, int i3) {
        if (preload$SsoNYGetPreloadReq == null) {
            return;
        }
        QLog.d(f212291m, 2, "reqSearchPopPreloadConfig");
        try {
            NewIntent newIntent = new NewIntent(this.f212294f.getApp(), e.class);
            newIntent.putExtra("cmd", "trpc.gamecenter.sys_predownload_svr.SysPredownloadSvr.SsoSearchEggGetPreload");
            newIntent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, i3);
            newIntent.putExtra("data", preload$SsoNYGetPreloadReq.toByteArray());
            this.f212294f.startServlet(newIntent);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, "reqSearchPopPreloadConfig e:", th5);
        }
    }

    public void w3(TempChatGameSession tempChatGameSession) {
        QLog.i(f212291m, 1, "[reqUrlForCreatingSgameTeam]");
        try {
            SgameTeamPB$GetTeamLinkReq sgameTeamPB$GetTeamLinkReq = new SgameTeamPB$GetTeamLinkReq();
            sgameTeamPB$GetTeamLinkReq.appid.set(tempChatGameSession.gameAppId);
            sgameTeamPB$GetTeamLinkReq.peer_openid.set(tempChatGameSession.peerOpenId);
            sgameTeamPB$GetTeamLinkReq.peer_roleid.set(tempChatGameSession.peerRoleId);
            sgameTeamPB$GetTeamLinkReq.self_openid.set(tempChatGameSession.selfOpenId);
            sgameTeamPB$GetTeamLinkReq.self_roleid.set(tempChatGameSession.selfRoleId);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1553", false, sgameTeamPB$GetTeamLinkReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e(f212291m, 1, th5, new Object[0]);
        }
    }

    public void z3(int i3, String str, String str2, String str3, int i16) {
        TrpcProxy.TrpcListReq trpcListReq;
        Bundle bundle;
        QLog.i(f212291m, 1, "[sendApplyPartnerMessage]");
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f212294f.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            QLog.e(f212291m, 1, "sendApplyPartnerMessage gameMsgManager is null.");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((!TextUtils.isEmpty(str3) || i16 != 0) && (i16 == 0 || i16 == 1))) {
            try {
                SgamePartnerSvr$SendMsgReq sgamePartnerSvr$SendMsgReq = new SgamePartnerSvr$SendMsgReq();
                sgamePartnerSvr$SendMsgReq.from_gamemsg_role_id.set(str);
                sgamePartnerSvr$SendMsgReq.to_gamemsg_role_id.set(str2);
                sgamePartnerSvr$SendMsgReq.text.set(str3);
                sgamePartnerSvr$SendMsgReq.msg_type.set(i16);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1545", false, sgamePartnerSvr$SendMsgReq.toByteArray());
                trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212295h);
                bundle = new Bundle();
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                bundle.putInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, i3);
                bundle.putInt("requestType", i16);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
                return;
            } catch (Throwable th6) {
                th = th6;
                String str4 = "exception:" + th;
                iGameMsgManagerService.onSendApplyPartnerMessage(i3, i16, -1L, str4);
                QLog.e(f212291m, 1, "sendApplyPartnerMessage ", str4);
                return;
            }
        }
        iGameMsgManagerService.onSendApplyPartnerMessage(i3, i16, -1L, "params error.");
        QLog.e(f212291m, 1, "sendApplyPartnerMessage ", "params error.");
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        String stringExtra = intent.getStringExtra("cmd");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if ("GameCenterMsg.GetUserInfo".equals(stringExtra)) {
            c3(intent, fromServiceMsg, bArr);
            return;
        }
        if ("GameCenterMsg.GetSwitch".equals(stringExtra)) {
            b3(intent, fromServiceMsg, bArr);
            return;
        }
        if ("GameCenterMsg.GetAioPop".equals(stringExtra)) {
            V2(intent, fromServiceMsg, bArr);
            return;
        }
        if ("GameCenterMsg.GetGameStartPriority".equals(stringExtra)) {
            a3(intent, fromServiceMsg, bArr);
            return;
        }
        if ("GameCenterMsg.DealGameFriend".equals(stringExtra)) {
            U2(intent, fromServiceMsg, bArr);
        } else if ("GameCenterMsg.SetSwitch".equals(stringExtra)) {
            l3(intent, fromServiceMsg, bArr);
        } else if ("trpc.gamecenter.sys_predownload_svr.SysPredownloadSvr.SsoSearchEggGetPreload".equals(stringExtra)) {
            j3(intent, fromServiceMsg, bArr);
        }
    }
}
