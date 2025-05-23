package com.tencent.mobileqq.app;

import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.BubbleReq;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.FontReq;
import QC.GetUsrKeyWordInfoReq;
import QC.Hamlet;
import QC.LoginInfo;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniLoginCheckReq;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.vipfontupdate.VipFontUpdate$TDiyFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate$TDiyFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate$TFontSsoReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate$TFontSsoRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

/* loaded from: classes11.dex */
public class SVIPHandler extends BusinessHandler implements ISVIPHandler {
    static IPatchRedirector $redirector_;
    private static int G;
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f195033d;

    /* renamed from: e, reason: collision with root package name */
    private int f195034e;

    /* renamed from: f, reason: collision with root package name */
    public BubbleManager f195035f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f195036h;

    /* renamed from: i, reason: collision with root package name */
    private int f195037i;

    /* renamed from: m, reason: collision with root package name */
    private int f195038m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
        } else {
            G = 0;
        }
    }

    SVIPHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195033d = false;
        this.f195034e = 0;
        this.f195035f = null;
        this.f195037i = -1;
        this.f195038m = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.f195036h = qQAppInterface;
        this.f195035f = (BubbleManager) qQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    }

    private LoginInfo E2() {
        return F2(this.f195036h);
    }

    public static LoginInfo F2(QQAppInterface qQAppInterface) {
        try {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            TicketManager ticketManager = (TicketManager) qQAppInterface.getManager(2);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.lUin = Long.parseLong(currentAccountUin);
            loginInfo.iKeyType = 1;
            loginInfo.sSKey = VasSkey.getSkey(ticketManager, currentAccountUin);
            loginInfo.iOpplat = 2;
            loginInfo.sClientVer = com.tencent.mobileqq.utils.ah.P();
            return loginInfo;
        } catch (Exception e16) {
            QLog.e("SVIPHandler", 1, "getLoginInfo fail", e16);
            return null;
        }
    }

    private com.tencent.mobileqq.bubble.b G2() {
        int selfBubbleId = getSelfBubbleId();
        com.tencent.mobileqq.bubble.b bVar = this.f195035f.f200582m.get(Integer.valueOf(selfBubbleId));
        if (bVar != null) {
            return bVar;
        }
        com.tencent.mobileqq.bubble.b z16 = this.f195035f.z(selfBubbleId, true);
        if (z16 != null) {
            this.f195035f.f200582m.put(Integer.valueOf(selfBubbleId), z16);
        }
        return z16;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess()) {
            if (obj instanceof MessageRemindRsp) {
                notifyUI(113, true, obj);
                return;
            } else {
                notifyUI(113, false, null);
                return;
            }
        }
        QLog.e("vip_pretty.SVIPHandler", 1, "handleGetBigTroopExpiredInfo resp failed:" + fromServiceMsg.getResultCode());
        notifyUI(113, false, null);
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj instanceof BubbleRecommendRsp) {
            notifyUI(108, true, obj);
        } else {
            notifyUI(108, false, null);
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess() && obj != null) {
            VipFontUpdate$TFontSsoRsp vipFontUpdate$TFontSsoRsp = new VipFontUpdate$TFontSsoRsp();
            try {
                vipFontUpdate$TFontSsoRsp.mergeFrom(fromServiceMsg.getWupBuffer());
                VipFontUpdate$TDiyFontRsp vipFontUpdate$TDiyFontRsp = vipFontUpdate$TFontSsoRsp.st_diyfont_rsp.get();
                ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
                IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
                IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                for (VipFontUpdate$TDiyFontRsp.TDiyFontRspInfo tDiyFontRspInfo : vipFontUpdate$TDiyFontRsp.rpt_font_rsp_info.get()) {
                    String valueOf = String.valueOf(tDiyFontRspInfo.u64_uin.get());
                    String str = tDiyFontRspInfo.str_diy_font_config.get();
                    if (str == null) {
                        str = "";
                    }
                    int i3 = tDiyFontRspInfo.i32_font_id.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(FontManagerConstants.TAG, 2, "handleGetDiyFontConfig uin = " + valueOf + " fontId = " + i3 + " config = " + str + " seq = " + fromServiceMsg.getRequestSsoSeq());
                    }
                    VasCommonReporter.getHistoryFeature().setValue1("font").setValue2("diyfontConfig").setValue3("fontId = " + i3 + " config = " + str).report();
                    String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(valueOf);
                    NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uidFromUin, "SVIPHandler");
                    if (vasSimpleInfoWithUid == null) {
                        vasSimpleInfoWithUid = new NTVasSimpleInfo();
                    }
                    if (vasSimpleInfoWithUid.diyFontConfigMap == null) {
                        vasSimpleInfoWithUid.diyFontConfigMap = new ConcurrentHashMap<>();
                    }
                    try {
                        if (vasSimpleInfoWithUid.diyFontConfigMap.containsKey(Integer.valueOf(i3)) && str.equals(vasSimpleInfoWithUid.diyFontConfigMap.get(Integer.valueOf(i3)))) {
                        }
                        ((IFontManagerService) this.f195036h.getRuntimeService(IFontManagerService.class, "")).updateDiyConfig(valueOf, i3);
                        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, valueOf);
                        nTVasSimpleInfo.c();
                        nTVasSimpleInfo.diyFontConfigMap = new ConcurrentHashMap<>(vasSimpleInfoWithUid.diyFontConfigMap);
                        arrayList.add(nTVasSimpleInfo);
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(FontManagerConstants.TAG, 1, "handleGetDiyFontConfig error: + " + e.getMessage());
                        return;
                    }
                    vasSimpleInfoWithUid.diyFontConfigMap.put(Integer.valueOf(i3), str);
                }
                if (arrayList.size() > 0) {
                    iVasInfoService.accurateUpdateVasSimpleInfo(arrayList, "SVIPHandler", (hx3.c<NTVasSimpleInfo>) null);
                } else if (QLog.isColorLevel()) {
                    QLog.d(FontManagerConstants.TAG, 2, "handleGetDiyFontConfig return empty");
                }
            } catch (Exception e17) {
                e = e17;
            }
        } else {
            QLog.e(FontManagerConstants.TAG, 1, "handleGetDiyFontConfig not success errorcode = " + fromServiceMsg.getResultCode() + " seq = " + fromServiceMsg.getRequestSsoSeq());
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj instanceof FontRecommendRsp) {
            notifyUI(107, true, obj);
        } else {
            notifyUI(107, false, null);
        }
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj instanceof GetRoamToastRsp) {
            notifyUI(111, true, obj);
        } else {
            notifyUI(111, false, obj);
        }
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleRequestColorNickPanel resp = " + fromServiceMsg.toString());
        }
        if (obj instanceof readItemInfoRsp) {
            notifyUI(105, true, (readItemInfoRsp) obj);
        } else {
            notifyUI(105, false, null);
        }
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj instanceof FaceRsp) {
            notifyUI(112, true, obj);
        } else {
            notifyUI(112, false, obj);
        }
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("setFontBubbleSeq");
        if (obj instanceof SetFontBubbleRsp) {
            notifyUI(109, true, new Object[]{obj, Integer.valueOf(i3)});
        } else {
            notifyUI(109, false, new Object[]{null, Integer.valueOf(i3)});
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void addSendingBubbleId(MessageRecord messageRecord) {
        int i3;
        int selfBubbleVoicePrintId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && messageRecord.needVipBubble()) {
            if ((!com.tencent.biz.anonymous.a.m(messageRecord) || !com.tencent.biz.anonymous.a.n(messageRecord)) && (i3 = messageRecord.istroop) != 1001 && i3 != 10002) {
                if (getSelfBubbleDiyTextId() > 0) {
                    messageRecord.vipBubbleID = SVIPHandlerConstants.mixedBubbleAndTextId(getSelfBubbleId(), getSelfBubbleDiyTextId());
                    messageRecord.vipBubbleDiyTextId = getSelfBubbleDiyTextId();
                } else {
                    messageRecord.vipBubbleID = getSelfBubbleId();
                }
                if ((messageRecord instanceof MessageForPtt) && (selfBubbleVoicePrintId = getSelfBubbleVoicePrintId()) > 0) {
                    messageRecord.vipBubbleID = selfBubbleVoicePrintId;
                }
                int subBubbleId = getSubBubbleId();
                messageRecord.vipSubBubbleId = subBubbleId;
                if (subBubbleId != 0) {
                    messageRecord.saveExtInfoToExtStr(AppConstants.BubbleConfig.BUBBLE_SUB_ID, String.valueOf(subBubbleId));
                    changeSubBubbleId();
                    if (QLog.isColorLevel()) {
                        QLog.i("SVIPHandler", 2, "addSendingBubbleId: changeSubBubbleId, messageRecord: " + messageRecord.getClass().getSimpleName());
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void changeSubBubbleId() {
        com.tencent.mobileqq.bubble.b G2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        BubbleManager bubbleManager = this.f195035f;
        if (bubbleManager != null && bubbleManager.f200582m != null && (G2 = G2()) != null && G2.d()) {
            G2.f();
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void closeToast(GetRoamToastRsp getRoamToastRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) getRoamToastRsp);
            return;
        }
        String currentAccountUin = this.f195036h.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            QLog.e("SVIPHandler", 1, "closeToast null uin");
            return;
        }
        SharedPreferences sharedPreferences = this.f195036h.getApp().getSharedPreferences(currentAccountUin, 0);
        String str = AppConstants.Preferences.ROAM_TOAST_CLOSE_COUNT + getRoamToastRsp.sToastKey;
        int i3 = sharedPreferences.getInt(str, 0) + 1;
        sharedPreferences.edit().putInt(str, i3).commit();
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "closeToast: " + str + "," + i3);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler, com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public ToServiceMsg createToServiceMsg(String str, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 34, this, str, businessObserver, Boolean.valueOf(z16));
        }
        return super.createToServiceMsg(str, businessObserver, z16);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void doFriendCloneAuth(String str, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "FriendClone.CloneAuthStatus");
        toServiceMsg.extraData.putInt(QCircleDaTongConstant.ElementParamValue.OPERATION, i3);
        toServiceMsg.extraData.putString("uUin", this.f195036h.getCurrentAccountUin());
        toServiceMsg.extraData.putBoolean("bOpenAuth", z16);
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void getBigTroopExpiredInfo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, j3);
            return;
        }
        MessageRemindReq messageRemindReq = new MessageRemindReq();
        messageRemindReq.iGroupCode = j3;
        TroopInfo k3 = ((TroopManager) this.f195036h.getManager(QQManagerFactory.TROOP_MANAGER)).k(j3 + "");
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo troopInfo == null, troopUin: " + j3);
                return;
            }
            return;
        }
        messageRemindReq.uOwnerUin = Long.parseLong(k3.troopowneruin);
        messageRemindReq.dwAppId = AppSetting.f();
        String skey = VasSkey.getSkey((TicketManager) this.f195036h.getManager(2), this.f195036h.getAccount());
        messageRemindReq.sKey = skey;
        if (skey != null) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "GroupCare.getMessageRemindInfo");
            toServiceMsg.extraData.putSerializable("req", messageRemindReq);
            this.f195036h.sendToService(toServiceMsg);
        } else if (QLog.isColorLevel()) {
            QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo skey == null, troopUin: " + j3);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public int getBubbleIdFromMessageRecord(MessageRecord messageRecord) {
        int resolveBubbleId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) messageRecord)).intValue();
        }
        if (messageRecord == null || (resolveBubbleId = SVIPHandlerConstants.resolveBubbleId(messageRecord.vipBubbleID)) == 0) {
            return 0;
        }
        int i3 = messageRecord.vipSubBubbleId;
        if (i3 == 0) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(AppConstants.BubbleConfig.BUBBLE_SUB_ID);
            if (QLog.isDevelopLevel()) {
                QLog.i("SVIPHandler", 2, String.format("try get bubbleSubId from msg id %d : %s", Long.valueOf(messageRecord.uniseq), extInfoFromExtStr));
            }
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                i3 = Integer.parseInt(extInfoFromExtStr);
            } else {
                i3 = 0;
            }
        }
        if (i3 != 0 && isBubblePackage(resolveBubbleId, i3)) {
            messageRecord.vipSubBubbleId = i3;
            return i3;
        }
        messageRecord.vipSubBubbleId = 0;
        return resolveBubbleId;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized int getBubbleMsgLimit() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        try {
            i3 = Integer.parseInt(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.MsgLengthByBubble.name(), "0"));
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SVIPHandler", 2, e16.getMessage());
            }
            i3 = 0;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void getBubbleRecommend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        BubbleRecommendReq bubbleRecommendReq = new BubbleRecommendReq();
        LoginInfo E2 = E2();
        bubbleRecommendReq.stLogin = E2;
        if (E2 == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "FontBubbleRecommend.getBubbleRecommend");
        toServiceMsg.extraData.putSerializable("req", bubbleRecommendReq);
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public int getColorScreenId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str)).intValue();
        }
        int i3 = this.f195036h.getApp().getSharedPreferences(str, 0).getInt(AppConstants.Preferences.SVIP_COLOR_SCREEN_ID, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "getColorScreenId " + str + " id " + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public int getCurrentUserVipType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int privilegeFlags = VasUtil.getSignedService(this.f195036h).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 4) != 0) {
            return 3;
        }
        if ((privilegeFlags & 2) != 0) {
            return 1;
        }
        if ((privilegeFlags & 1) != 0) {
            return 2;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void getFontRecommend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        FontRecommendReq fontRecommendReq = new FontRecommendReq();
        LoginInfo E2 = E2();
        fontRecommendReq.stLogin = E2;
        if (E2 == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "FontBubbleRecommend.getFontRecommend");
        toServiceMsg.extraData.putSerializable("req", fontRecommendReq);
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public LoginInfo getLoginInfo(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (LoginInfo) iPatchRedirector.redirect((short) 40, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return F2((QQAppInterface) appRuntime);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void getRoamToast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        try {
            String currentAccountUin = this.f195036h.getCurrentAccountUin();
            GetRoamToastReq getRoamToastReq = new GetRoamToastReq(Long.parseLong(currentAccountUin), VasSkey.getSkey((TicketManager) this.f195036h.getManager(2), currentAccountUin));
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "RoamWrap.GetRoamToast");
            toServiceMsg.extraData.putSerializable("req", getRoamToastReq);
            this.f195036h.sendToService(toServiceMsg);
        } catch (Exception e16) {
            QLog.e("SVIPHandler", 1, "getRoamToast fail", e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized int getSelfBubbleDiyTextId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (this.f195038m == -1) {
            this.f195038m = this.f195036h.getApp().getSharedPreferences(this.f195036h.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.SVIP_BUBBLE_DIY_TEXT_ID, 0);
        }
        return this.f195038m;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized int getSelfBubbleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int decodeInt = VipMMKV.getCommon(this.f195036h.getCurrentAccountUin()).decodeInt(AppConstants.Preferences.SVIP_BUBBLE_ID, 0);
        this.f195037i = decodeInt;
        return SVIPHandlerConstants.resolveBubbleId(decodeInt);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized int getSelfBubbleVoicePrintId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int decodeInt = VipMMKV.getCommon(this.f195036h.getCurrentAccountUin()).decodeInt(AppConstants.Preferences.SVIP_BUBBLE_VOICE_PRINT_ID, 0);
        this.C = decodeInt;
        return decodeInt;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized int getSelfFontId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (this.D == -1) {
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195036h.getAccount()), "SVIPHandler");
            if (vasSimpleInfoWithUid == null) {
                return 0;
            }
            this.D = (int) vasSimpleInfoWithUid.uVipFont;
            this.E = vasSimpleInfoWithUid.vipFontType;
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized NTVasSimpleInfo getSelfFontInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (NTVasSimpleInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195036h.getAccount()), "SVIPHandler");
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public int getSubBubbleId() {
        com.tencent.mobileqq.bubble.b G2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        BubbleManager bubbleManager = this.f195035f;
        if (bubbleManager != null && bubbleManager.f200582m != null && (G2 = G2()) != null && G2.d()) {
            int a16 = G2.a();
            changeSubBubbleId();
            if (QLog.isColorLevel()) {
                QLog.i("SVIPHandler", 2, "main bubbleid: " + this.f195037i + ", subBubbleId: " + a16);
            }
            return a16;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void gxhLoginCheck(ArrayList<Hamlet> arrayList, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, arrayList, businessObserver, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QCUniBusinessLogin.check", businessObserver, z16);
        createToServiceMsg.extraData.putSerializable("req", new UniLoginCheckReq(E2(), arrayList, 3L, new GetUsrKeyWordInfoReq()));
        this.f195036h.sendToService(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void gxhLoginCheckForTroopKeywork(BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, businessObserver, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QCUniBusinessLogin.check", businessObserver, z16);
        createToServiceMsg.extraData.putSerializable("req", new UniLoginCheckReq(E2(), new ArrayList(), 2L, new GetUsrKeyWordInfoReq()));
        this.f195036h.sendToService(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void handleFriendClone(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleFriendClone: resp=" + fromServiceMsg.toString());
        }
        if ((obj instanceof ArrayList) && ((Integer) ((ArrayList) obj).get(0)).intValue() == 0) {
            notifyUI(104, true, obj);
        } else {
            notifyUI(104, false, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void handleRequestDefaultCard(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleRequestDefaultCard: resp=" + fromServiceMsg.toString());
        }
        if (!(obj instanceof readUserInfoRsp) && !(obj instanceof setUserProfileRsp) && !(obj instanceof setUserFlagRsp)) {
            notifyUI(106, false, fromServiceMsg.getServiceCmd());
        } else {
            notifyUI(106, true, obj);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public boolean isBubblePackage(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        BubbleManager bubbleManager = this.f195035f;
        if (bubbleManager == null || bubbleManager.f200582m == null) {
            return false;
        }
        com.tencent.mobileqq.bubble.b G2 = G2();
        if (G2 != null && G2.d() && G2.e(i16)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return SVIPObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        BubbleManager.LruLinkedHashMap<Integer, com.tencent.mobileqq.bubble.b> lruLinkedHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        BubbleManager bubbleManager = this.f195035f;
        if (bubbleManager != null && (lruLinkedHashMap = bubbleManager.f200582m) != null) {
            lruLinkedHashMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_REQ_RES_VIP_FONT_FRESH.equals(fromServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getInt(CheckForwardServlet.KEY_CMD) == 3) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if ("FriendClone.CloneAuthStatus".equals(fromServiceMsg.getServiceCmd())) {
            handleFriendClone(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("groupnick.readitem".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().startsWith("profilelogic.")) {
            handleRequestDefaultCard(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo")) {
            H2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend")) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend")) {
            I2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble")) {
            O2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast")) {
            L2(toServiceMsg, fromServiceMsg, obj);
        } else if (fromServiceMsg.getServiceCmd().equals("Face.setFace")) {
            N2(toServiceMsg, fromServiceMsg, obj);
        } else {
            notifyUI(toServiceMsg, 0, true, obj);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void pbGetDiyFontConfig(Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-04-12", "vas_diy_font_request").isEnable(true)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(FontManagerConstants.TAG, 2, "pbGetDiyFontConfig");
        }
        VipFontUpdate$TFontSsoReq vipFontUpdate$TFontSsoReq = new VipFontUpdate$TFontSsoReq();
        vipFontUpdate$TFontSsoReq.u32_cmd.set(3);
        vipFontUpdate$TFontSsoReq.u64_seq.set(new Random().nextInt(1000));
        vipFontUpdate$TFontSsoReq.i32_implat.set(109);
        vipFontUpdate$TFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
        vipFontUpdate$TFontSsoReq.str_mqqver.set(AppSetting.f99554n);
        VipFontUpdate$TDiyFontReq vipFontUpdate$TDiyFontReq = new VipFontUpdate$TDiyFontReq();
        for (String str : map.keySet()) {
            VipFontUpdate$TDiyFontReq.TDiyFontReqInfo tDiyFontReqInfo = new VipFontUpdate$TDiyFontReq.TDiyFontReqInfo();
            tDiyFontReqInfo.u64_uin.set(Long.parseLong(str));
            tDiyFontReqInfo.i32_font_id.set(map.get(str).intValue());
            vipFontUpdate$TDiyFontReq.rpt_font_req_info.add(tDiyFontReqInfo);
        }
        vipFontUpdate$TFontSsoReq.st_diyfont_req.set(vipFontUpdate$TDiyFontReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), ProfileContants.CMD_REQ_RES_VIP_FONT_FRESH);
        toServiceMsg.putWupBuffer(vipFontUpdate$TFontSsoReq.toByteArray());
        toServiceMsg.extraData.putInt(CheckForwardServlet.KEY_CMD, 3);
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void requestColorNickPanel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "groupnick.readitem");
        toServiceMsg.extraData.putSerializable("req", new readItemInfoReq(109L, com.tencent.mobileqq.utils.ah.P(), i3));
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void requestDefaultCardInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "profilelogic.readUserInfo");
        toServiceMsg.extraData.putSerializable("req", new readUserInfoReq(com.tencent.mobileqq.utils.ah.P(), 109, i3));
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setColorScreenId(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3);
            return;
        }
        SharedPreferences sharedPreferences = this.f195036h.getApp().getSharedPreferences(str, 0);
        sharedPreferences.getInt(AppConstants.Preferences.SVIP_COLOR_SCREEN_ID, 0);
        sharedPreferences.edit().putInt(AppConstants.Preferences.SVIP_COLOR_SCREEN_ID, i3).commit();
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "setColorScreenId " + str + " id " + i3);
        }
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setColorScreenTestId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.f195034e = i3;
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setDefaultCardFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "profilelogic.setUserFlag");
        toServiceMsg.extraData.putSerializable("req", new setUserFlagReq(i3, com.tencent.mobileqq.utils.ah.P(), 109));
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setDefaultCardId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "profilelogic.setUserProfile");
        toServiceMsg.extraData.putSerializable("req", new setUserProfileReq(i3, com.tencent.mobileqq.utils.ah.P(), 109));
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setFace(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
            return;
        }
        FaceReq faceReq = new FaceReq();
        LoginInfo E2 = E2();
        faceReq.stLogin = E2;
        if (E2 == null) {
            return;
        }
        faceReq.faceID = i3;
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "Face.setFace");
        toServiceMsg.extraData.putSerializable("req", faceReq);
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void setFontBubble(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        SetFontBubbleReq setFontBubbleReq = new SetFontBubbleReq();
        LoginInfo E2 = E2();
        setFontBubbleReq.stLogin = E2;
        if (E2 == null) {
            return;
        }
        setFontBubbleReq.stFontReq = new FontReq(i3);
        setFontBubbleReq.stBubbleReq = new BubbleReq(i16);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195036h.getCurrentAccountUin(), "FontBubbleRecommend.setFontBubble");
        toServiceMsg.extraData.putInt("setFontBubbleSeq", i17);
        toServiceMsg.extraData.putSerializable("req", setFontBubbleReq);
        this.f195036h.sendToService(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setFontEffect(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "setFontEffect fontEffectId = " + i3);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195036h.getAccount()), this.f195036h.getAccount());
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.fontEffect = i3;
        nTVasSimpleInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        ((IFontManagerService) this.f195036h.getRuntimeService(IFontManagerService.class, "")).resetLastSendReportTime();
        if (i3 != 0) {
            nTVasSimpleInfo.magicFont = 0;
        }
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "SVIPHandler", (hx3.c<NTVasSimpleInfo>) null);
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setMagicFont(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "setMagicFont setup = " + i3);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195036h.getAccount()), this.f195036h.getAccount());
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.magicFont = i3;
        if (1 == i3) {
            nTVasSimpleInfo.fontEffect = 0;
        }
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "SVIPHandler", (hx3.c<NTVasSimpleInfo>) null);
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setSelfBubbleDiyTextId(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 != this.f195038m && this.f195036h != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SVIPHandler", 2, "setSelfBubbleDiyTextId->" + i3);
            }
            this.f195038m = i3;
            this.f195036h.getApp().getSharedPreferences(this.f195036h.getCurrentAccountUin(), 0).edit().putInt(AppConstants.Preferences.SVIP_BUBBLE_DIY_TEXT_ID, i3).commit();
            if (i3 > 0) {
                String str = this.f195036h.getAccount() + "_" + i3;
                if (z16) {
                    ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.app.SVIPHandler.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f195039d;

                        /* renamed from: com.tencent.mobileqq.app.SVIPHandler$1$a */
                        /* loaded from: classes11.dex */
                        class a implements BusinessObserver {
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ BubbleDiyFetcher f195040d;

                            a(BubbleDiyFetcher bubbleDiyFetcher) {
                                this.f195040d = bubbleDiyFetcher;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bubbleDiyFetcher);
                                }
                            }

                            @Override // com.tencent.mobileqq.app.BusinessObserver
                            public void onUpdate(int i3, boolean z16, Object obj) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                                    return;
                                }
                                try {
                                    String valueOf = String.valueOf(SVIPHandler.this.getSelfBubbleId());
                                    if (obj instanceof List) {
                                        List<BubbleDiyEntity> list = (List) obj;
                                        if (list.size() > 0) {
                                            for (BubbleDiyEntity bubbleDiyEntity : list) {
                                                if (!TextUtils.isEmpty(bubbleDiyEntity.topLeftId)) {
                                                    this.f195040d.f200569g.add("BubbleDiyFetcher_" + valueOf + "_TL_" + bubbleDiyEntity.topLeftId);
                                                }
                                                if (!TextUtils.isEmpty(bubbleDiyEntity.topRightId)) {
                                                    this.f195040d.f200569g.add("BubbleDiyFetcher_" + valueOf + "_TR_" + bubbleDiyEntity.topRightId);
                                                }
                                                if (!TextUtils.isEmpty(bubbleDiyEntity.bottomRightId)) {
                                                    this.f195040d.f200569g.add("BubbleDiyFetcher_" + valueOf + "_BR_" + bubbleDiyEntity.bottomRightId);
                                                }
                                                if (!TextUtils.isEmpty(bubbleDiyEntity.bottomLeftId)) {
                                                    this.f195040d.f200569g.add("BubbleDiyFetcher_" + valueOf + "_BL_" + bubbleDiyEntity.bottomLeftId);
                                                }
                                            }
                                            this.f195040d.f();
                                        }
                                    }
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("SVIPHandler", 2, e16.getMessage());
                                    }
                                }
                            }
                        }

                        {
                            this.f195039d = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SVIPHandler.this, (Object) str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                BubbleDiyFetcher m3 = BubbleDiyFetcher.m();
                                m3.h(SVIPHandler.this.f195036h, this.f195039d, new a(m3));
                            }
                        }
                    }, 5, null, false);
                } else {
                    BubbleDiyFetcher.m().h(this.f195036h, str, null);
                }
            }
        }
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setSelfBubbleId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        QLog.i("AIOFontBubble_SVIPHandler", 1, "setSelfBubbleId id = " + i3 + " mSelfBubbleId = " + this.f195037i);
        if (i3 != this.f195037i) {
            this.f195037i = i3;
            VipMMKV.getCommon(this.f195036h.getCurrentAccountUin()).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_ID, i3);
        }
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setSelfBubbleVoicePrintId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 != this.C) {
            this.C = i3;
            VipMMKV.getCommon(this.f195036h.getCurrentAccountUin()).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_VOICE_PRINT_ID, i3);
        }
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setSelfFontInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != this.D || i16 != this.E) {
            this.D = i3;
            this.E = i16;
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195036h.getAccount());
            QLog.i("SVIPHandler", 1, "setSelfFontInfo id = " + i3 + " type = " + i16 + ", uid = " + uidFromUin + "uin: " + this.f195036h.getAccount());
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, this.f195036h.getAccount());
            nTVasSimpleInfo.c();
            nTVasSimpleInfo.uVipFont = (long) i3;
            nTVasSimpleInfo.vipFontType = i16;
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "SVIPHandler", (hx3.c<NTVasSimpleInfo>) null);
        }
        if (VasShieldFont.f32672e != i3) {
            VasShieldFont.f32672e = i3;
            MqqHandler handler = this.f195036h.getHandler(ChatActivity.class);
            if (handler != null) {
                handler.removeMessages(89);
                handler.sendEmptyMessage(89);
            }
        }
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public synchronized void setSelfPendantDiyId(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 != this.F && this.f195036h != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SVIPHandler", 2, "setSelfPendantDiyId->" + i3);
            }
            this.F = i3;
            if (i3 > 0) {
                String str = this.f195036h.getAccount() + "_" + i3;
                if (z16) {
                    ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.app.SVIPHandler.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f195042d;

                        /* renamed from: com.tencent.mobileqq.app.SVIPHandler$2$a */
                        /* loaded from: classes11.dex */
                        class a implements BusinessObserver {
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ IDiyPendantFetcher f195043d;

                            a(IDiyPendantFetcher iDiyPendantFetcher) {
                                this.f195043d = iDiyPendantFetcher;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) iDiyPendantFetcher);
                                }
                            }

                            @Override // com.tencent.mobileqq.app.BusinessObserver
                            public void onUpdate(int i3, boolean z16, Object obj) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                                    return;
                                }
                                try {
                                    if (obj instanceof List) {
                                        List list = (List) obj;
                                        if (list.size() > 0) {
                                            Iterator it = list.iterator();
                                            while (it.hasNext()) {
                                                Iterator<DiyPendantSticker> it5 = ((DiyPendantEntity) it.next()).getStickerInfoList().iterator();
                                                while (it5.hasNext()) {
                                                    this.f195043d.getUnCachePasterId().add(this.f195043d.getStickerKey(it5.next()));
                                                }
                                            }
                                            this.f195043d.decodeOrDownloadPaster();
                                        }
                                    }
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("SVIPHandler", 2, e16.getMessage());
                                    }
                                }
                            }
                        }

                        {
                            this.f195042d = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SVIPHandler.this, (Object) str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                IDiyPendantFetcher diyPendantFetcher = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher();
                                diyPendantFetcher.fetchDiyPendant(SVIPHandler.this.f195036h, this.f195042d, new a(diyPendantFetcher));
                            }
                        }
                    }, 5, null, false);
                } else {
                    ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().fetchDiyPendant(this.f195036h, str, null);
                }
            }
        }
        this.f195033d = false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public boolean shouldShowToast(GetRoamToastRsp getRoamToastRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) getRoamToastRsp)).booleanValue();
        }
        String currentAccountUin = this.f195036h.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            QLog.e("SVIPHandler", 1, "shouldShowToast null uin");
            return false;
        }
        SharedPreferences sharedPreferences = this.f195036h.getApp().getSharedPreferences(currentAccountUin, 0);
        String str = AppConstants.Preferences.ROAM_TOAST_CLOSE_COUNT + getRoamToastRsp.sToastKey;
        int i3 = sharedPreferences.getInt(str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "shouldShowToast: " + str + "," + i3);
        }
        if (i3 < 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.svip.api.ISVIPHandler
    public void updateSelfMsgBubbleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_UPDATE);
        createToServiceMsg.extraData.putInt(ProfileContants.CMD_REQ_RES_UPDATE_SEQID, 0);
        send(createToServiceMsg);
    }
}
