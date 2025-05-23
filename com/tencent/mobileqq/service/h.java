package com.tencent.mobileqq.service;

import MQQ.GuanjiaReportReq;
import MQQ.GuanjiaReportRsp;
import MQQ.PrivExtV2Req;
import MQQ.PrivExtV2Rsp;
import MQQ.VAResourcesReq;
import MQQ.VAResourcesRsp;
import QC.UniGetRsp;
import QC.UniSetRsp;
import VIP.GetCustomOnlineStatusReq;
import VIP.GetCustomOnlineStatusRsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.ilive.manager.ILiveDbManagerApi;
import cooperation.ilive.manager.ILiveRedManagerApi;
import cooperation.qzone.QUA;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286137d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286137d = new String[]{"ClubInfoSvc", "VipCustom", "QCUniBusinessLogic"};
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private <T> T a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, T t16) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (T) uniPacket.getByClass("rsp", t16);
        } catch (Exception e16) {
            QLog.e("VIPService", 1, "decodeWUP: ", e16);
            return null;
        }
    }

    private long b(String str) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || !(runtime instanceof QQAppInterface)) {
            return 0L;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        long j3 = QVipConfigManager.getLong(qQAppInterface, QVipConfigManager.KEY_LONG_NAME_PLATE_CONFIG_VERSION, 0L);
        if (TextUtils.isEmpty(NamePlateCfgInfo.getVipNamePlateCfgInfo(qQAppInterface, str))) {
            return 0L;
        }
        return j3;
    }

    private boolean c(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
        uniPacket.setFuncName("queryLhResources");
        String string = toServiceMsg.extraData.getString(VipInfoHandler.f195215h);
        VAResourcesReq vAResourcesReq = new VAResourcesReq();
        vAResourcesReq.sUin = string;
        vAResourcesReq.resourcesFlag = 1;
        vAResourcesReq.lastVisitTime = PrettyAccountUtil.lastSynTime;
        uniPacket.put("req", vAResourcesReq);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String str;
        int decodeInt;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        uniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
        uniPacket.setFuncName("queryPrivInfoExtV2");
        String string = toServiceMsg.extraData.getString(VipInfoHandler.f195215h);
        String string2 = toServiceMsg.extraData.getString(VipInfoHandler.f195217m);
        long j3 = toServiceMsg.extraData.getLong(VipInfoHandler.L);
        PrivExtV2Req privExtV2Req = new PrivExtV2Req();
        privExtV2Req.sUin = string;
        privExtV2Req.sKey = string2;
        privExtV2Req.iGetType = 0;
        privExtV2Req.qua = QUA.getQUA3();
        QLog.e("VIPService", 1, "Ilive handleGetVipInfoReq qua = " + QUA.getQUA3());
        VasMMKVProxy kingCard = VasMMKV.getKingCard(string);
        String decodeString = kingCard.decodeString("imsiOne", "");
        String decodeString2 = kingCard.decodeString("imsiTwo", "");
        long decodeLong = kingCard.decodeLong("kingCardLastRequest", 0L);
        long decodeInt2 = kingCard.decodeInt("kingCardRequestInterval", 0);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        privExtV2Req.lastVisitTime = j3;
        privExtV2Req.iItemCfgVer = b(string);
        if (!TextUtils.isEmpty("")) {
            privExtV2Req.sImsi1 = "";
        } else if (!TextUtils.isEmpty("")) {
            privExtV2Req.sImsi1 = "";
            str = null;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            privExtV2Req.sImsi2 = str;
            e(privExtV2Req, toServiceMsg.extraData.getString(VipInfoHandler.C));
            decodeInt = kingCard.decodeInt("kingCardSdk", -1);
            if (decodeInt < 0) {
                privExtV2Req.sImsi2 = "";
                privExtV2Req.sImsi1 = "";
                privExtV2Req.iWkOrderState1 = decodeInt;
                i3 = 0;
                z17 = false;
                z18 = false;
            } else {
                if (TextUtils.isEmpty(privExtV2Req.sImsi1) && TextUtils.isEmpty(privExtV2Req.sImsi2)) {
                    privExtV2Req.iGetType = 1;
                }
                if ((!TextUtils.isEmpty(privExtV2Req.sImsi1) && !privExtV2Req.sImsi1.equals(decodeString)) || TextUtils.isEmpty(privExtV2Req.sImsi1)) {
                    kingCard.encodeString("imsiOne", "");
                    kingCard.encodeInt(KingCardJsPlugin.BUSINESS_NAME, -1);
                    z16 = true;
                } else {
                    if (currentTimeMillis - decodeLong < decodeInt2) {
                        privExtV2Req.sImsi1 = "";
                    }
                    z16 = false;
                }
                if ((!TextUtils.isEmpty(privExtV2Req.sImsi2) && !privExtV2Req.sImsi2.equals(decodeString2)) || TextUtils.isEmpty(privExtV2Req.sImsi2)) {
                    kingCard.encodeString("imsiTwo", "");
                    kingCard.encodeInt("kingCard2", -1);
                    z16 = true;
                } else if (currentTimeMillis - decodeLong < decodeInt2) {
                    privExtV2Req.sImsi2 = "";
                }
                z17 = !TextUtils.isEmpty(privExtV2Req.sImsi1);
                z18 = !TextUtils.isEmpty(privExtV2Req.sImsi2);
                if (z17) {
                    toServiceMsg.extraData.putString(VipInfoHandler.J, privExtV2Req.sImsi1);
                }
                if (z18) {
                    toServiceMsg.extraData.putString(VipInfoHandler.K, privExtV2Req.sImsi2);
                }
                privExtV2Req.iWkOrderState1 = kingCard.decodeInt(KingCardJsPlugin.BUSINESS_NAME, -1);
                privExtV2Req.iWkOrderState2 = kingCard.decodeInt("kingCard2", -1);
                i3 = 0;
                if (z16) {
                    kingCard.encodeInt("toast_version", 0);
                    kingCard.encodeInt("popup_version_v2", 0);
                }
            }
            privExtV2Req.iToastVer = kingCard.decodeInt("toast_version", i3);
            privExtV2Req.iPopupVer = kingCard.decodeInt("popup_version_v2", i3);
            privExtV2Req.pullPayRuleCfgTime = QVipConfigManager.getLong((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, 0L);
            privExtV2Req.clientLangugeId = i3;
            f(privExtV2Req);
            QLog.e("VIPService", 1, "handleGetVipInfoReq, pullPayRuleCfgTime=" + privExtV2Req.pullPayRuleCfgTime);
            if (QLog.isColorLevel()) {
                QLog.i("VIPService", 2, "handleGetVipInfoReq, iPopupVer: " + privExtV2Req.iPopupVer + " iToastVer:" + privExtV2Req.iToastVer + " canUseTMS:true sdkCardStatus:" + decodeInt + ", send sim1: " + z17 + ", send sim2:" + z18);
            }
            toServiceMsg.extraData.putBoolean(VipInfoHandler.H, z17);
            toServiceMsg.extraData.putBoolean(VipInfoHandler.I, z18);
            uniPacket.put("req", privExtV2Req);
            return true;
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
        }
        privExtV2Req.sImsi2 = str;
        e(privExtV2Req, toServiceMsg.extraData.getString(VipInfoHandler.C));
        decodeInt = kingCard.decodeInt("kingCardSdk", -1);
        if (decodeInt < 0) {
        }
        privExtV2Req.iToastVer = kingCard.decodeInt("toast_version", i3);
        privExtV2Req.iPopupVer = kingCard.decodeInt("popup_version_v2", i3);
        privExtV2Req.pullPayRuleCfgTime = QVipConfigManager.getLong((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, 0L);
        privExtV2Req.clientLangugeId = i3;
        f(privExtV2Req);
        QLog.e("VIPService", 1, "handleGetVipInfoReq, pullPayRuleCfgTime=" + privExtV2Req.pullPayRuleCfgTime);
        if (QLog.isColorLevel()) {
        }
        toServiceMsg.extraData.putBoolean(VipInfoHandler.H, z17);
        toServiceMsg.extraData.putBoolean(VipInfoHandler.I, z18);
        uniPacket.put("req", privExtV2Req);
        return true;
    }

    private void e(PrivExtV2Req privExtV2Req, String str) {
        if (!TextUtils.isEmpty(str) && str.equals("vip_drawer")) {
            privExtV2Req.trace_info = ((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).getIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_TRACE_INFO);
            Pair<String, String> iliveRecomRedInfo = ((ILiveRedManagerApi) QRoute.api(ILiveRedManagerApi.class)).getIliveRecomRedInfo();
            if (iliveRecomRedInfo != null) {
                privExtV2Req.recom_ext_info = iliveRecomRedInfo.first;
                if (privExtV2Req.extendInfo == null) {
                    privExtV2Req.extendInfo = new HashMap();
                }
                privExtV2Req.extendInfo.put("room_schema", iliveRecomRedInfo.second);
                QLog.e("VIPService", 1, "handleGetVipInfoReq getVipInfo set trace_info " + privExtV2Req.trace_info);
            }
        }
    }

    private void f(PrivExtV2Req privExtV2Req) {
        HashMap hashMap = new HashMap();
        int a16 = com.tencent.mobileqq.vip.e.a();
        int treasureCardState = VasUtil.getService().getVasFtManager().treasureCardState("");
        if (a16 == -1) {
            a16 = 0;
        }
        hashMap.put(1, Integer.valueOf(a16));
        if (treasureCardState == -1) {
            treasureCardState = 0;
        }
        hashMap.put(2, Integer.valueOf(treasureCardState));
        privExtV2Req.mobile_info = hashMap;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286137d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ("ClubInfoSvc.queryPrivExt".equals(toServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getInt(VipInfoHandler.f195216i) == 6) {
                return a(toServiceMsg, fromServiceMsg, new VAResourcesRsp());
            }
            return a(toServiceMsg, fromServiceMsg, new PrivExtV2Rsp());
        }
        if ("ClubInfoSvc.guanjiaReport".equals(toServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, fromServiceMsg, new GuanjiaReportRsp());
        }
        if ("VipCustom.GetCustomOnlineStatus".equals(toServiceMsg.getServiceCmd())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("CustomOnlineStatusManager", 4, "decode");
            }
            return a(toServiceMsg, fromServiceMsg, new GetCustomOnlineStatusRsp());
        }
        if ("QCUniBusinessLogic.uniSet".equals(toServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, fromServiceMsg, new UniSetRsp());
        }
        if ("QCUniBusinessLogic.uniGet".equals(toServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, fromServiceMsg, new UniGetRsp());
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if ("ClubInfoSvc.queryPrivExt".equals(toServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getInt(VipInfoHandler.f195216i) == 6) {
                return c(toServiceMsg, uniPacket);
            }
            return d(toServiceMsg, uniPacket);
        }
        if ("ClubInfoSvc.guanjiaReport".equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
            uniPacket.setFuncName("guanjiaDoReport");
            String string = toServiceMsg.extraData.getString(VipInfoHandler.f195215h);
            GuanjiaReportReq guanjiaReportReq = new GuanjiaReportReq();
            guanjiaReportReq.sPkgName = "mobileQQ";
            guanjiaReportReq.uin = Long.parseLong(string);
            guanjiaReportReq.iImplat = 109;
            guanjiaReportReq.sPhoneNum = toServiceMsg.extraData.getString(VipInfoHandler.D);
            guanjiaReportReq.bKingCard = toServiceMsg.extraData.getBoolean(VipInfoHandler.E);
            guanjiaReportReq.iCardType = toServiceMsg.extraData.getInt(VipInfoHandler.F);
            guanjiaReportReq.iCardStatus = toServiceMsg.extraData.getInt(VipInfoHandler.G);
            guanjiaReportReq.bReportFlag = false;
            uniPacket.put("req", guanjiaReportReq);
            return true;
        }
        if ("VipCustom.GetCustomOnlineStatus".equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setServantName("VIP.CustomOnlineStatusServer.CustomOnlineStatusObj");
            uniPacket.setFuncName("GetCustomOnlineStatus");
            GetCustomOnlineStatusReq getCustomOnlineStatusReq = new GetCustomOnlineStatusReq();
            getCustomOnlineStatusReq.lUin = toServiceMsg.extraData.getLong(VipInfoHandler.M);
            getCustomOnlineStatusReq.sIMei = MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS);
            uniPacket.put("req", getCustomOnlineStatusReq);
            if (QLog.isDevelopLevel()) {
                QLog.d("CustomOnlineStatusManager", 4, "encodeReqMsg");
            }
            return true;
        }
        if ("QCUniBusinessLogic.uniSet".equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
            uniPacket.setFuncName("uniSet");
            uniPacket.put("stReq", toServiceMsg.extraData.getSerializable("req"));
            return true;
        }
        if (!"QCUniBusinessLogic.uniGet".equals(toServiceMsg.getServiceCmd())) {
            return false;
        }
        uniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
        uniPacket.setFuncName("uniGet");
        uniPacket.put("stReq", toServiceMsg.extraData.getSerializable("req"));
        return true;
    }
}
