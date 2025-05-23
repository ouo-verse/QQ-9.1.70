package com.tencent.mobileqq.app;

import MQQ.DataReturnFlag;
import MQQ.GuanjiaReportRsp;
import MQQ.ItemCfgInfo;
import MQQ.ItemCfgList;
import MQQ.PayRuleCfg;
import MQQ.PrivExtV2Rsp;
import MQQ.QidInfoItem;
import MQQ.ShowRangeTime;
import MQQ.ShowRule;
import MQQ.TrafficResultInfo;
import MQQ.VAResourcesRsp;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import QC.LoginInfo;
import QC.MessageShow;
import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniSetReq;
import QQService.EVIPSPEC;
import VIP.GetCustomOnlineStatusRsp;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb$CustomOnlineStatusMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.ilive.manager.ILiveDbManagerApi;
import cooperation.qzone.QUA;
import cooperation.qzone.util.JceUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class VipInfoHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static String P;
    private static final Object Q;
    private static HashMap<String, PayRuleCfg> R;

    /* renamed from: f, reason: collision with root package name */
    private static String f195214f;

    /* renamed from: h, reason: collision with root package name */
    public static String f195215h;

    /* renamed from: i, reason: collision with root package name */
    public static String f195216i;

    /* renamed from: m, reason: collision with root package name */
    public static String f195217m;

    /* renamed from: d, reason: collision with root package name */
    private String f195218d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f195219e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f195214f = "VipInfoHandler";
        f195215h = com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN;
        f195216i = "k_type";
        f195217m = "k_skey";
        C = "k_from";
        D = "k_phone_num";
        E = "k_is_king_card";
        F = "k_card_type";
        G = "k_card_status";
        H = "k_hasImsi";
        I = "key_has_double_imsi";
        J = "key_imsi_one";
        K = "key_imsi_two";
        L = "k_sequence";
        M = "uin";
        N = "login_info";
        P = "state";
        Q = new Object();
        R = new HashMap<>();
    }

    VipInfoHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195218d = null;
            this.f195219e = qQAppInterface;
        }
    }

    private LoginInfo F2() {
        try {
            String currentAccountUin = this.f195219e.getCurrentAccountUin();
            String skey = VasSkey.getSkey((TicketManager) this.f195219e.getManager(2), currentAccountUin);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.lUin = Long.parseLong(currentAccountUin);
            loginInfo.iKeyType = 1;
            loginInfo.sSKey = skey;
            loginInfo.iOpplat = 2;
            loginInfo.sClientVer = com.tencent.mobileqq.utils.ah.P();
            return loginInfo;
        } catch (Exception e16) {
            QLog.e(f195214f, 1, e16, new Object[0]);
            return null;
        }
    }

    public static PayRuleCfg H2(String str) {
        PayRuleCfg payRuleCfg;
        if (TextUtils.isEmpty(str)) {
            QLog.e(f195214f, 1, "getPayRule: empty uin");
            return null;
        }
        synchronized (R) {
            payRuleCfg = R.get(str);
        }
        if (payRuleCfg != null) {
            return payRuleCfg;
        }
        PayRuleCfg T2 = T2(str, "payRule.cfg");
        if (T2 == null) {
            T2 = new PayRuleCfg();
            T2.enable = 0;
        }
        synchronized (R) {
            PayRuleCfg payRuleCfg2 = R.get(str);
            if (payRuleCfg2 == null) {
                R.put(str, T2);
            } else {
                T2 = payRuleCfg2;
            }
        }
        return T2;
    }

    public static int I2(PayRuleCfg payRuleCfg) {
        return ((payRuleCfg.clubType - 1) * 3) + payRuleCfg.userType;
    }

    public static int J2(QQAppInterface qQAppInterface, String str, boolean z16) {
        boolean z17;
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), f195214f);
        if (vasSimpleInfoWithUid != null) {
            EVIPSPEC evipspec = EVIPSPEC.E_SP_QQVIP;
            boolean c16 = com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec);
            EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
            boolean c17 = com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec2);
            int a16 = com.tencent.mobileqq.vip.r.a(vasSimpleInfoWithUid, evipspec2) + com.tencent.mobileqq.vip.r.a(vasSimpleInfoWithUid, evipspec);
            int i3 = 1;
            if (a16 <= 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (c17) {
                i3 = 3;
            } else if (c16) {
                i3 = 4;
            } else if (z17) {
                i3 = 2;
            }
            if (z16) {
                return i3 + 4;
            }
            return i3;
        }
        if (z16) {
            return 99;
        }
        return 98;
    }

    private boolean K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, PrivExtV2Rsp privExtV2Rsp, boolean z16) {
        long j3;
        TrafficResultInfo trafficResultInfo;
        VipMedalList vipMedalList;
        boolean z17 = true;
        if (z16) {
            String string = toServiceMsg.extraData.getString(f195215h);
            if (P2(privExtV2Rsp)) {
                return true;
            }
            VipUserInfo vipUserInfo = privExtV2Rsp.vipInfo;
            M2(privExtV2Rsp.medalInfoList, string);
            L2(vipUserInfo, string);
            if (vipUserInfo != null) {
                if (vipUserInfo.bUpdate == 0) {
                    QLog.e("QVipSettingMe." + f195214f, 1, "bUpdate=" + vipUserInfo.bUpdate + " it do not need to update vip info");
                } else {
                    com.tencent.mobileqq.vip.api.d.a().setQQSettingVipHomeType(string, vipUserInfo.iHomeType);
                    if (vipUserInfo.iOpenVip >= 0 && vipUserInfo.iOpenSVip >= 0) {
                        O2(privExtV2Rsp, string);
                    } else {
                        z16 = false;
                    }
                }
            } else {
                QLog.e("QVipSettingMe." + f195214f, 1, "request vip user info rsp null!");
            }
            com.tencent.mobileqq.vip.d.g(privExtV2Rsp.trafficResult, toServiceMsg.extraData);
            if (vipUserInfo != null && vipUserInfo.bUpdate == 1 && (trafficResultInfo = privExtV2Rsp.trafficResult) != null && trafficResultInfo.bUpdate == 1 && (vipMedalList = privExtV2Rsp.medalInfoList) != null && vipMedalList.bUpdate == 1) {
                QVipConfigManager.setLong(this.f195219e, QVipConfigManager.KEY_LONG_SETTING_ME_GET_VIP_INFO_SEQUENCE, NetConnInfoCenter.getServerTime());
            }
            QVipConfigManager.setLong(this.f195219e, QVipConfigManager.KEY_LONG_SETTING_ME_LAST_REQUEST_SUCCESS_TIME, NetConnInfoCenter.getServerTime());
            VipMedalList vipMedalList2 = privExtV2Rsp.medalInfoList;
            if (vipMedalList2 != null && vipMedalList2.bUpdate == 1) {
                if (cooperation.vip.manager.i.r().z() > 0) {
                    j3 = 1;
                } else {
                    j3 = 0;
                }
                QVipConfigManager.setLong(this.f195219e, QVipConfigManager.KEY_LONG_SETTING_ME_VIP_MEDAL_LIST_RECORD, j3);
            }
            ItemCfgList itemCfgList = privExtV2Rsp.itemCfgList;
            if (itemCfgList != null) {
                long j16 = QVipConfigManager.getLong(this.f195219e, QVipConfigManager.KEY_LONG_NAME_PLATE_CONFIG_VERSION, 0L);
                String vipNamePlateCfgInfo = NamePlateCfgInfo.getVipNamePlateCfgInfo(this.f195219e, string);
                if (QLog.isColorLevel()) {
                    QLog.i("QVipSettingMe." + f195214f, 2, "vipinfo NamePlate response localVersion = " + j16 + " netVersion = " + itemCfgList.iItemCfgVer + " \nlocalCfgInfo = " + vipNamePlateCfgInfo);
                }
                if (j16 != itemCfgList.iItemCfgVer || TextUtils.isEmpty(vipNamePlateCfgInfo)) {
                    QVipConfigManager.setLong(this.f195219e, QVipConfigManager.KEY_LONG_NAME_PLATE_CONFIG_VERSION, itemCfgList.iItemCfgVer);
                    N2(privExtV2Rsp.itemCfgList.itemCfgInfo, string);
                }
            }
            PayRuleCfg payRuleCfg = privExtV2Rsp.payRule;
            if (payRuleCfg != null) {
                QLog.e(f195214f, 1, "privExtRsp.payRule ", payRuleCfg.iconText, " url=", payRuleCfg.iconUrl, " update=", Integer.valueOf(payRuleCfg.update), " new:\n", S2(privExtV2Rsp.payRule));
                if (privExtV2Rsp.payRule.update == 1) {
                    QVipConfigManager.setLong(this.f195219e, QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, NetConnInfoCenter.getServerTime());
                    PayRuleCfg T2 = T2(string, "payRuleOrigin.cfg");
                    boolean R2 = R2(T2, privExtV2Rsp.payRule);
                    QLog.e(f195214f, 1, "privExtRsp.payRule equals=" + R2, " old:\n", S2(T2));
                    if (!R2) {
                        d3(string, "payRuleOrigin.cfg", privExtV2Rsp.payRule);
                        U2(string, privExtV2Rsp.payRule);
                        notifyUI(4, true, null);
                    }
                }
            } else {
                QLog.e(f195214f, 1, "privExtRsp.payRule is null");
            }
            QidInfoItem qidInfoItem = privExtV2Rsp.qid_info;
            if (qidInfoItem != null) {
                QQAppInterface qQAppInterface = this.f195219e;
                if (qidInfoItem.has_qid != 1) {
                    z17 = false;
                }
                VipQidHelper.setQidOpen(qQAppInterface, z17);
                QVipConfigManager.setString(this.f195219e, QVipConfigManager.KEY_STRING_LOGIN_QID_INFO, privExtV2Rsp.qid_info.qid);
            }
            if (privExtV2Rsp.map_menum != null) {
                com.tencent.mobileqq.vip.o.a().g(this.f195219e, privExtV2Rsp.map_menum);
            }
            if (privExtV2Rsp.qq_value != null) {
                m23.b.b().e(string, privExtV2Rsp.qq_value);
            }
        } else {
            QLog.e(f195214f, 1, "ClubInfoSvc.queryPrivExt failed:" + fromServiceMsg.getBusinessFailCode());
            ReportCenter.f().r("ClubInfoSvc.queryPrivExt", 100, fromServiceMsg.getBusinessFailCode(), this.f195219e.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
        }
        return z16;
    }

    private void L2(VipUserInfo vipUserInfo, String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && str.equals(this.f195219e.getCurrentAccountUin())) {
            if (vipUserInfo != null && vipUserInfo.bUpdate != 0) {
                if (vipUserInfo.iOpenVip > 0 && vipUserInfo.iOpenSVip > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ThemeVipBehavior.setCurrentUserVip(z16);
                return;
            }
            ThemeVipBehavior.setCurrentUserVip(VasUtil.getSignedService(this.f195219e).getVipStatus().isSVip());
        }
    }

    private void M2(VipMedalList vipMedalList, String str) {
        this.f195218d = null;
        if (vipMedalList == null) {
            QLog.e("QVipSettingMe." + f195214f, 1, "medal info is null!");
            return;
        }
        if (vipMedalList.bUpdate == 0) {
            QLog.e("QVipSettingMe." + f195214f, 1, "bUpdate=" + vipMedalList.bUpdate + " it do not need to update medal info");
            return;
        }
        MedalList parse = MedalList.parse(vipMedalList);
        if (parse != null) {
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
            nTVasSimpleInfo.c();
            try {
                String convert = parse.convert();
                if (TextUtils.isEmpty(convert)) {
                    convert = "";
                }
                nTVasSimpleInfo.medalsInfo = convert;
                this.f195218d = convert;
                if (QLog.isColorLevel()) {
                    QLog.d("QVipSettingMe." + f195214f, 1, "medalList receiver form service :" + this.f195218d);
                }
                ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, f195214f, (hx3.c<NTVasSimpleInfo>) null);
            } catch (JSONException e16) {
                QLog.e("QVipSettingMe." + f195214f, 1, "medalList convert faile :" + e16);
            }
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, f195214f, (hx3.c<NTVasSimpleInfo>) null);
        }
    }

    private void N2(ArrayList<ItemCfgInfo> arrayList, String str) {
        if (arrayList == null) {
            QLog.e("QVipSettingMe." + f195214f, 1, "NamePlateCfgInfo is null!");
            return;
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
        nTVasSimpleInfo.c();
        String convert2Json = NamePlateCfgInfo.convert2Json(arrayList);
        if (TextUtils.isEmpty(convert2Json)) {
            convert2Json = "";
        }
        nTVasSimpleInfo.nameplateCfgInfo = convert2Json;
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, f195214f, (hx3.c<NTVasSimpleInfo>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O2(@NonNull PrivExtV2Rsp privExtV2Rsp, String str) {
        NTVasSimpleInfo vasSimpleInfoWithUid;
        NTVasSimpleInfo nTVasSimpleInfo;
        String str2;
        VipUserInfo vipUserInfo = privExtV2Rsp.vipInfo;
        VipMedalList vipMedalList = privExtV2Rsp.medalInfoList;
        if (vipUserInfo == null) {
            return;
        }
        QLog.d(f195214f, 1, "handleVipInfoRsp[" + str + "] iOpenVip=" + vipUserInfo.iOpenVip + " iOpenSVip=" + vipUserInfo.iOpenSVip + " iVipType=" + vipUserInfo.iVipType + " iVipLevel=" + vipUserInfo.iVipLevel);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        if (((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("handleResultOfVasInfo_get_origin_data_from_old", Boolean.TRUE).booleanValue()) {
            ArrayList<NTVasSimpleInfo> vasSimpleInfoWithUid2 = ((IQQVasInfoApi) QRoute.api(IQQVasInfoApi.class)).getVasSimpleInfoWithUid(new ArrayList<>(Collections.singleton(uidFromUin)), f195214f);
            if (vasSimpleInfoWithUid2 != null && !vasSimpleInfoWithUid2.isEmpty()) {
                nTVasSimpleInfo = vasSimpleInfoWithUid2.get(0);
                NTVasSimpleInfo nTVasSimpleInfo2 = new NTVasSimpleInfo(nTVasSimpleInfo.getUid(), nTVasSimpleInfo.getUin());
                nTVasSimpleInfo2.c();
                nTVasSimpleInfo2.qqVipInfo = c3(vipUserInfo, 1, nTVasSimpleInfo.qqVipInfo);
                nTVasSimpleInfo2.superVipInfo = c3(vipUserInfo, 2, nTVasSimpleInfo.superVipInfo);
                SharedPreferences sharedPreferences = this.f195219e.getApplication().getApplicationContext().getSharedPreferences(this.f195219e.getCurrentAccountUin(), 0);
                if (vipUserInfo.iUpdateTime > 0) {
                    sharedPreferences.edit().putLong(AppConstants.Preferences.VIP_INFO_REQ_TIME, vipUserInfo.iUpdateTime);
                }
                if (vipUserInfo.iUpdateFreq > 0) {
                    sharedPreferences.edit().putInt(AppConstants.Preferences.VIP_INFO_UPDATE_FREQ, vipUserInfo.iUpdateFreq);
                }
                if (vipUserInfo.iCanUseRed >= 0) {
                    sharedPreferences.edit().putInt(AppConstants.Preferences.VIP_INFO_CAN_USE_PACKET, vipUserInfo.iCanUseRed);
                }
                if (vipUserInfo.iRedDisable >= 0) {
                    sharedPreferences.edit().putInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_DISABLE, vipUserInfo.iRedDisable);
                }
                sharedPreferences.edit().putString(AppConstants.Preferences.VIP_INFO_CURRENT_VERSION, QUA.getQUA3());
                sharedPreferences.edit().putInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_ID, vipUserInfo.iRedPackId);
                sharedPreferences.edit().putString(AppConstants.Preferences.VIP_INFO_RED_PACKET_TEXT, vipUserInfo.sRedPackRemard);
                sharedPreferences.edit().putString(AppConstants.Preferences.VIP_MEDAL_LVL_JUMP_URL, vipMedalList.lvlJumpUrl);
                sharedPreferences.edit().commit();
                if (QLog.isColorLevel()) {
                    QLog.d(f195214f, 2, "redpacketinfo : icanusedred = " + vipUserInfo.iCanUseRed + ";iRedDisable = " + vipUserInfo.iRedDisable + "iRedPacketId = " + vipUserInfo.iRedPackId + ";sRedPackRemard = " + vipUserInfo.sRedPackRemard);
                }
                iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo2, f195214f, (hx3.c<NTVasSimpleInfo>) null);
                if (!TextUtils.isEmpty(str) && str.equals(this.f195219e.getAccount()) && (vipUserInfo.iCanUseRed >= 0 || vipUserInfo.iRedDisable >= 0)) {
                    VasCommonReporter.getHistoryFeature("individualRed").setValue2("handleVipInfoRsp").report();
                    IndividualRedPacketManager individualRedPacketManager = (IndividualRedPacketManager) this.f195219e.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
                    individualRedPacketManager.Q(vipUserInfo.iCanUseRed, vipUserInfo.iRedDisable, true);
                    individualRedPacketManager.R(vipUserInfo.iRedPackId, vipUserInfo.sRedPackRemard);
                }
                str2 = vipUserInfo.sUri;
                if (!TextUtils.isEmpty(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f195214f, 2, "vip url = " + str2);
                    }
                    if (VasToggle.BUG_102518313.isEnable(true)) {
                        VasMMKV.getCommon(this.f195219e.getCurrentAccountUin()).encodeString("VIPCenter_url_key", str2);
                    } else {
                        this.f195219e.getApplication().getSharedPreferences(this.f195219e.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", str2).apply();
                    }
                }
                com.tencent.mobileqq.vip.a.a().d(this.f195219e, vipUserInfo);
            }
            vasSimpleInfoWithUid = new NTVasSimpleInfo();
            vasSimpleInfoWithUid.e(uidFromUin);
            vasSimpleInfoWithUid.f(String.valueOf(str));
        } else {
            vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uidFromUin, f195214f);
            if (vasSimpleInfoWithUid == null) {
                vasSimpleInfoWithUid = new NTVasSimpleInfo();
                vasSimpleInfoWithUid.e(uidFromUin);
                vasSimpleInfoWithUid.f(String.valueOf(str));
            }
        }
        nTVasSimpleInfo = vasSimpleInfoWithUid;
        NTVasSimpleInfo nTVasSimpleInfo22 = new NTVasSimpleInfo(nTVasSimpleInfo.getUid(), nTVasSimpleInfo.getUin());
        nTVasSimpleInfo22.c();
        nTVasSimpleInfo22.qqVipInfo = c3(vipUserInfo, 1, nTVasSimpleInfo.qqVipInfo);
        nTVasSimpleInfo22.superVipInfo = c3(vipUserInfo, 2, nTVasSimpleInfo.superVipInfo);
        SharedPreferences sharedPreferences2 = this.f195219e.getApplication().getApplicationContext().getSharedPreferences(this.f195219e.getCurrentAccountUin(), 0);
        if (vipUserInfo.iUpdateTime > 0) {
        }
        if (vipUserInfo.iUpdateFreq > 0) {
        }
        if (vipUserInfo.iCanUseRed >= 0) {
        }
        if (vipUserInfo.iRedDisable >= 0) {
        }
        sharedPreferences2.edit().putString(AppConstants.Preferences.VIP_INFO_CURRENT_VERSION, QUA.getQUA3());
        sharedPreferences2.edit().putInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_ID, vipUserInfo.iRedPackId);
        sharedPreferences2.edit().putString(AppConstants.Preferences.VIP_INFO_RED_PACKET_TEXT, vipUserInfo.sRedPackRemard);
        sharedPreferences2.edit().putString(AppConstants.Preferences.VIP_MEDAL_LVL_JUMP_URL, vipMedalList.lvlJumpUrl);
        sharedPreferences2.edit().commit();
        if (QLog.isColorLevel()) {
        }
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo22, f195214f, (hx3.c<NTVasSimpleInfo>) null);
        if (!TextUtils.isEmpty(str)) {
            VasCommonReporter.getHistoryFeature("individualRed").setValue2("handleVipInfoRsp").report();
            IndividualRedPacketManager individualRedPacketManager2 = (IndividualRedPacketManager) this.f195219e.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
            individualRedPacketManager2.Q(vipUserInfo.iCanUseRed, vipUserInfo.iRedDisable, true);
            individualRedPacketManager2.R(vipUserInfo.iRedPackId, vipUserInfo.sRedPackRemard);
        }
        str2 = vipUserInfo.sUri;
        if (!TextUtils.isEmpty(str2)) {
        }
        com.tencent.mobileqq.vip.a.a().d(this.f195219e, vipUserInfo);
    }

    private boolean P2(PrivExtV2Rsp privExtV2Rsp) {
        if (privExtV2Rsp.data_flag != null) {
            ((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).saveIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_TRACE_INFO, privExtV2Rsp.data_flag.trace_info);
        }
        ((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).saveIliveData(privExtV2Rsp.isQQLivePgc, privExtV2Rsp.qqLiveMsg);
        QVipConfigManager.setInteger(this.f195219e, QVipConfigManager.KEY_INTEGER_SETTING_ME_VIP_SYNC_FREQ, privExtV2Rsp.iSyncFreq);
        DataReturnFlag dataReturnFlag = privExtV2Rsp.data_flag;
        if (dataReturnFlag != null && dataReturnFlag.has_priv_base == 0) {
            QLog.e(f195214f, 1, "getVipInfo PrivExtV2Rsp has_priv_base = 0");
            return true;
        }
        QLog.e(f195214f, 1, "getVipInfo PrivExtV2Rsp has_priv_base = 1 , return vip data");
        return false;
    }

    public static boolean Q2(QQAppInterface qQAppInterface, PayRuleCfg payRuleCfg, boolean z16) {
        Object valueOf;
        ShowRule showRule;
        if (payRuleCfg != null && payRuleCfg.enable == 1 && (showRule = payRuleCfg.rule) != null) {
            int i3 = showRule.showType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        long j3 = QVipConfigManager.getLong(qQAppInterface, QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, 0L);
                        long serverTime = NetConnInfoCenter.getServerTime();
                        if (QLog.isColorLevel()) {
                            QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_DATE " + payRuleCfg.rule.showCount + " offset " + (serverTime - j3));
                        }
                        if (serverTime - j3 >= payRuleCfg.rule.showCount * 24 * 3600) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    long serverTime2 = NetConnInfoCenter.getServerTime();
                    ArrayList<ShowRangeTime> arrayList = payRuleCfg.rule.rangTimes;
                    if (arrayList != null) {
                        Iterator<ShowRangeTime> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ShowRangeTime next = it.next();
                            if (next.beginTime <= serverTime2 && serverTime2 <= next.endTime) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME needShowPayButton");
                                }
                                return true;
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME dontShow");
                    }
                    return false;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_LIMIT_DAY count remain: " + payRuleCfg.rule.showCount);
                }
                ShowRule showRule2 = payRuleCfg.rule;
                int i16 = showRule2.showCount;
                if (i16 <= 0) {
                    return false;
                }
                if (!z16) {
                    showRule2.showCount = i16 - 1;
                    U2(qQAppInterface.getCurrentUin(), payRuleCfg);
                }
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("needShowPayButton: cfg=");
            sb5.append(payRuleCfg);
            sb5.append(" enable=");
            if (payRuleCfg == null) {
                valueOf = Boolean.FALSE;
            } else {
                valueOf = Integer.valueOf(payRuleCfg.enable);
            }
            sb5.append(valueOf);
            QLog.d("VipInfoHandler", 2, sb5.toString());
        }
        return false;
    }

    private static boolean R2(PayRuleCfg payRuleCfg, PayRuleCfg payRuleCfg2) {
        if (payRuleCfg == payRuleCfg2) {
            return true;
        }
        if (payRuleCfg != null && payRuleCfg2 != null) {
            return Arrays.equals(JceUtils.encodeWup(payRuleCfg), JceUtils.encodeWup(payRuleCfg2));
        }
        return false;
    }

    public static String S2(PayRuleCfg payRuleCfg) {
        if (payRuleCfg == null) {
            return "null";
        }
        return Base64.encodeToString(JceUtils.encodeWup(payRuleCfg), 2) + "\n" + payRuleCfg;
    }

    private static PayRuleCfg T2(String str, String str2) {
        byte[] fileToBytes;
        File file = new File(BaseApplication.getContext().getFilesDir(), str + File.separator + str2);
        synchronized (Q) {
            fileToBytes = FileUtils.fileToBytes(file);
        }
        if (fileToBytes != null) {
            return (PayRuleCfg) JceUtils.decodeWup(PayRuleCfg.class, fileToBytes);
        }
        return null;
    }

    public static void U2(String str, PayRuleCfg payRuleCfg) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(f195214f, 1, "writePayRule: empty uin");
            return;
        }
        synchronized (R) {
            R.put(str, payRuleCfg);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(str, payRuleCfg) { // from class: com.tencent.mobileqq.app.VipInfoHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f195220d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ PayRuleCfg f195221e;

            {
                this.f195220d = str;
                this.f195221e = payRuleCfg;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) payRuleCfg);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (VipInfoHandler.R) {
                        Object obj = VipInfoHandler.R.get(this.f195220d);
                        PayRuleCfg payRuleCfg2 = this.f195221e;
                        if (obj == payRuleCfg2) {
                            VipInfoHandler.d3(this.f195220d, "payRule.cfg", payRuleCfg2);
                            return;
                        }
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    public static void b3(int i3, String str) {
        String str2;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            str2 = "";
        } else {
            str2 = runtime.getAccount();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str2 + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.47";
        tianShuReportData.mPageId = "tianshu.47";
        tianShuReportData.mItemId = str;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    private int c3(VipUserInfo vipUserInfo, int i3, int i16) {
        int i17;
        if (vipUserInfo != null && i3 <= 2 && i3 >= 1) {
            if (1 == i3) {
                i17 = vipUserInfo.iOpenVip;
            } else {
                i17 = vipUserInfo.iOpenSVip;
            }
            return ((short) vipUserInfo.iVipLevel) | (((i17 << 8) | ((byte) vipUserInfo.iVipType)) << 16);
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d3(String str, String str2, PayRuleCfg payRuleCfg) {
        File file = new File(BaseApplication.getContext().getFilesDir(), str + File.separator + str2);
        byte[] encodeWup = JceUtils.encodeWup(payRuleCfg);
        synchronized (Q) {
            FileUtils.writeFile(encodeWup, file.getAbsolutePath());
        }
    }

    public String G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f195218d;
    }

    public void V2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195219e.getCurrentAccountUin(), "VipCustom.GetCustomOnlineStatus");
        toServiceMsg.extraData.putLong(M, j3);
        send(toServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.d("CustomOnlineStatusManager", 4, "send to server");
        }
    }

    public void W2(String str, String str2, long j3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Long.valueOf(j3), str3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195219e.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
        toServiceMsg.extraData.putString(f195215h, str2);
        toServiceMsg.extraData.putInt(f195216i, 1);
        toServiceMsg.extraData.putString(f195217m, str);
        toServiceMsg.extraData.putString(C, str3);
        if (j3 > 0) {
            toServiceMsg.extraData.putLong(L, j3);
        }
        send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe." + f195214f, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt seq=" + j3);
        }
        if (!VasNormalToggle.BUG_LIANG_REQUEST.isEnable(true)) {
            X2(str2);
        }
    }

    public void X2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195219e.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
        toServiceMsg.extraData.putString(f195215h, str);
        toServiceMsg.extraData.putInt(f195216i, 6);
        send(toServiceMsg);
    }

    public void Y2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        UniSetReq uniSetReq = new UniSetReq();
        UniBusinessItem uniBusinessItem = new UniBusinessItem();
        uniSetReq.stUniBusinessItem = uniBusinessItem;
        uniBusinessItem.appid = 36;
        uniBusinessItem.itemid = 0;
        MessageShow messageShow = new MessageShow();
        uniSetReq.stMessageShow = messageShow;
        messageShow.bOpen = z16;
        a3(uniSetReq, null, false);
    }

    public void Z2(UniGetReq uniGetReq, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uniGetReq, businessObserver, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QCUniBusinessLogic.uniGet", businessObserver, z16);
        uniGetReq.stLogin = F2();
        createToServiceMsg.extraData.putSerializable("req", uniGetReq);
        send(createToServiceMsg);
    }

    public void a3(UniSetReq uniSetReq, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uniSetReq, businessObserver, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QCUniBusinessLogic.uniSet", businessObserver, z16);
        uniSetReq.stLogin = F2();
        createToServiceMsg.extraData.putSerializable("req", uniSetReq);
        send(createToServiceMsg);
    }

    public void guanjiaReport(String str, String str2, boolean z16, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), str3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195219e.getCurrentAccountUin(), "ClubInfoSvc.guanjiaReport");
        toServiceMsg.extraData.putString(f195215h, str);
        toServiceMsg.extraData.putString(D, str2);
        toServiceMsg.extraData.putBoolean(E, z16);
        toServiceMsg.extraData.putInt(F, i3);
        toServiceMsg.extraData.putInt(G, 0);
        send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d(f195214f, 2, "guanjiaReport: isKingCard=" + z16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Class) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return dt.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        int intValue = Integer.valueOf(toServiceMsg.extraData.getInt(f195216i)).intValue();
        Long.valueOf(toServiceMsg.extraData.getLong(L)).longValue();
        boolean isSuccess = fromServiceMsg.isSuccess();
        if ("ClubInfoSvc.queryPrivExt".equals(serviceCmd)) {
            if (intValue == 6 && (obj instanceof VAResourcesRsp)) {
                PrettyAccountUtil.lastSynTime = System.currentTimeMillis() / 1000;
                PrettyAccountUtil.updateLhLogoInfo((VAResourcesRsp) obj);
                VasLogNtReporter.getVipIcon().reportDebug("receive lianghao rsp and notify");
                notifyUI(6, isSuccess, obj);
                return;
            }
            if (intValue == 1) {
                VasLogNtReporter.getVipIcon().reportDebug("receive vipinfo rsp and notify");
                isSuccess = K2(toServiceMsg, fromServiceMsg, (PrivExtV2Rsp) obj, isSuccess);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f195214f, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + isSuccess);
            }
            notifyUI(1, isSuccess, obj);
            return;
        }
        if ("ClubInfoSvc.guanjiaReport".equals(serviceCmd)) {
            if (isSuccess) {
                GuanjiaReportRsp guanjiaReportRsp = (GuanjiaReportRsp) obj;
                if (QLog.isColorLevel()) {
                    QLog.d(f195214f, 1, "onReceive: " + guanjiaReportRsp.ret);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f195214f, 2, "onReceive: guanjiaReport,isSuccess=" + isSuccess);
                return;
            }
            return;
        }
        if ("VipCustom.GetCustomOnlineStatus".equals(serviceCmd)) {
            if (isSuccess) {
                GetCustomOnlineStatusRsp getCustomOnlineStatusRsp = (GetCustomOnlineStatusRsp) obj;
                if (QLog.isColorLevel()) {
                    QLog.d("CustomOnlineStatusManager", 2, "onReceive: CUSTOM_ONLINE_STATUS " + getCustomOnlineStatusRsp.sMsg + " " + getCustomOnlineStatusRsp.sMsg);
                }
                if (!TextUtils.isEmpty(getCustomOnlineStatusRsp.sBuffer)) {
                    try {
                        CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg = new CustomOnlineStatusPb$CustomOnlineStatusMsg();
                        customOnlineStatusPb$CustomOnlineStatusMsg.mergeFrom(getCustomOnlineStatusRsp.sBuffer.getBytes());
                        CustomOnlineStatusManager.d().k(customOnlineStatusPb$CustomOnlineStatusMsg);
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.d(f195214f, 1, e16, new Object[0]);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if ("QCUniBusinessLogic.uniSet".equals(serviceCmd)) {
            notifyUI(toServiceMsg, 2, isSuccess, obj);
        } else if ("QCUniBusinessLogic.uniGet".equals(serviceCmd)) {
            notifyUI(toServiceMsg, 3, isSuccess, obj);
        }
    }

    public void sendGetBaseVipInfoReq(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            W2(str, str2, 1562146740L, "vip_other");
        }
    }
}
