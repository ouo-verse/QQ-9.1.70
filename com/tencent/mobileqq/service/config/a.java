package com.tencent.mobileqq.service.config;

import MAAccessClient.AccessReq;
import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigReq;
import MAAccessClient.GetSinglePkgSigReq;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReq;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.SDKUpgradeReq;
import protocol.KQQConfig.SDKUpgradeRes;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286088d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286088d = new String[]{"ConfigServantObj", "ConfigService", "MAAControl", "ResourceConfig"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private AccessReq a(byte[] bArr) {
        AccessReq accessReq = new AccessReq();
        accessReq.gray = 0;
        String z16 = ah.z();
        String str = "";
        if (z16 == null) {
            z16 = "";
        }
        accessReq.imei = z16;
        String D = ah.D();
        if (D == null) {
            D = "";
        }
        accessReq.manufacture = D;
        String F = ah.F();
        if (F == null) {
            F = "";
        }
        accessReq.mode = F;
        String S = ah.S();
        if (S != null) {
            str = S;
        }
        accessReq.rom = str;
        accessReq.body = bArr;
        accessReq.platform = 1;
        if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "createAccessReq:\nimei:" + accessReq.imei + "\ngray:" + accessReq.gray);
        }
        return accessReq;
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str) {
        return (AccessRsp) decodePacket(fromServiceMsg.getWupBuffer(), str, new AccessRsp());
    }

    private Object c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        SDKUpgradeRes sDKUpgradeRes = (SDKUpgradeRes) decodePacket(fromServiceMsg.getWupBuffer(), "SDKUpgradeRes", new SDKUpgradeRes());
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "Get Upgrade Config Resp: " + sDKUpgradeRes);
            if (sDKUpgradeRes != null) {
                ArrayList<UpgradeInfo> arrayList = sDKUpgradeRes.vUpgradeInfo;
                if (arrayList != null && arrayList.size() > 0) {
                    UpgradeInfo upgradeInfo = sDKUpgradeRes.vUpgradeInfo.get(0);
                    QLog.d("UpgradeController", 2, "Get UpgradeInfo: " + upgradeInfo);
                    QLog.d("UpgradeController", 2, "iAppid: " + upgradeInfo.iAppid);
                    QLog.d("UpgradeController", 2, "bAppType: " + ((int) upgradeInfo.bAppType));
                    QLog.d("UpgradeController", 2, "iUpgradeType: " + upgradeInfo.iUpgradeType);
                    QLog.d("UpgradeController", 2, "iUpgradeSdkId: " + upgradeInfo.iUpgradeSdkId);
                    QLog.d("UpgradeController", 2, "strTitle: " + upgradeInfo.strTitle);
                    QLog.d("UpgradeController", 2, "strNewTitle: " + upgradeInfo.strNewTitle);
                    QLog.d("UpgradeController", 2, "strUpgradeDesc: " + upgradeInfo.strUpgradeDesc);
                    QLog.d("UpgradeController", 2, "strUrl: " + upgradeInfo.strUrl);
                    QLog.d("UpgradeController", 2, "iActionType=0: " + upgradeInfo.iActionType);
                    QLog.d("UpgradeController", 2, "bNewSwitch: " + ((int) upgradeInfo.bNewSwitch));
                    QLog.d("UpgradeController", 2, "iNewTimeStamp: " + upgradeInfo.iNewTimeStamp);
                    QLog.d("UpgradeController", 2, "strUpgradePageUrl: " + upgradeInfo.strUpgradePageUrl);
                    QLog.d("UpgradeController", 2, "iIncrementUpgrade: " + upgradeInfo.iIncrementUpgrade);
                    QLog.d("UpgradeController", 2, "iTipsType: " + upgradeInfo.iTipsType);
                    QLog.d("UpgradeController", 2, "strBannerPicUrl: " + upgradeInfo.strBannerPicUrl);
                    QLog.d("UpgradeController", 2, "strNewUpgradeDescURL: " + upgradeInfo.strNewUpgradeDescURL);
                    QLog.d("UpgradeController", 2, "iDisplayDay: " + upgradeInfo.iDisplayDay);
                    QLog.d("UpgradeController", 2, "iTipsWaitDay: " + upgradeInfo.iTipsWaitDay);
                    QLog.d("UpgradeController", 2, "strProgressName: " + upgradeInfo.strProgressName);
                    QLog.d("UpgradeController", 2, "strNewTipsDescURL: " + upgradeInfo.strNewTipsDescURL);
                    QLog.d("UpgradeController", 2, "strNewSoftwareURL: " + upgradeInfo.strNewSoftwareURL);
                    QLog.d("UpgradeController", 2, "bGray: " + ((int) upgradeInfo.bGray));
                } else {
                    QLog.d("UpgradeController", 2, "Not vUpgradeInfo");
                }
            }
        }
        return sDKUpgradeRes;
    }

    private Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (GetResourceResp) decodePacket(fromServiceMsg.getWupBuffer(), "res", new GetResourceResp());
    }

    private boolean e(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("ConfigServantObj");
        uniPacket.setFuncName("GetResourceReq");
        CheckSinglePkgSigReq checkSinglePkgSigReq = new CheckSinglePkgSigReq();
        checkSinglePkgSigReq.pkgName = BaseApplicationImpl.sApplication.getPackageName();
        String string = toServiceMsg.extraData.getString(ac.f283467k0);
        if (string == null) {
            string = "";
        }
        checkSinglePkgSigReq.pkgSig = string;
        checkSinglePkgSigReq.versionCode = com.tencent.mobileqq.cooperation.a.a(BaseApplicationImpl.sApplication);
        checkSinglePkgSigReq.marketVer = toServiceMsg.extraData.getInt(QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE);
        checkSinglePkgSigReq.sysVer = ah.K();
        byte[] byteArray = checkSinglePkgSigReq.toByteArray();
        if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "CheckSinglePkgSigReq:\nversionCode:" + checkSinglePkgSigReq.versionCode);
        }
        uniPacket.put("MAAControl.CheckSinglePkgSig", a(byteArray));
        return true;
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("ConfigServantObj");
        uniPacket.setFuncName("GetResourceReq");
        GetSinglePkgSigReq getSinglePkgSigReq = new GetSinglePkgSigReq();
        getSinglePkgSigReq.pkgName = toServiceMsg.extraData.getString("pn");
        getSinglePkgSigReq.versionCode = toServiceMsg.extraData.getInt("vc");
        getSinglePkgSigReq.marketVer = toServiceMsg.extraData.getInt(QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE);
        getSinglePkgSigReq.sysVer = toServiceMsg.extraData.getInt(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV);
        uniPacket.put("MAAControl.GetSinglePkgSig", a(getSinglePkgSigReq.toByteArray()));
        return true;
    }

    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("ConfigServantObj");
        uniPacket.setFuncName("ClientReq");
        uniPacket.put("iCmdType", 1);
        SDKUpgradeReq sDKUpgradeReq = new SDKUpgradeReq();
        sDKUpgradeReq.cProtocolVer = (byte) 1;
        sDKUpgradeReq.iActionType = toServiceMsg.extraData.getInt("iActionType");
        sDKUpgradeReq.iWidth = toServiceMsg.extraData.getInt("iWidth");
        sDKUpgradeReq.iHeight = toServiceMsg.extraData.getInt("iHeight");
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "Get Config: " + sDKUpgradeReq.iActionType + sDKUpgradeReq.iActionType + ", " + sDKUpgradeReq.iWidth + ", " + sDKUpgradeReq.iHeight);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(toServiceMsg.getUin());
        sDKUpgradeReq.vUin = arrayList;
        sDKUpgradeReq.bSdkUpdateFlag = false;
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(AppSetting.f()));
        sDKUpgradeReq.vAppid = arrayList2;
        uniPacket.put("SDKUpgradeReq", sDKUpgradeReq);
        toServiceMsg.setTimeout(20000L);
        return true;
    }

    private boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("ConfigServantObj");
        uniPacket.setFuncName("GetResourceReq");
        ArrayList<GetResourceReqInfo> arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("getResourceReqInfos");
        GetResourceReq getResourceReq = new GetResourceReq();
        if (arrayList != null && arrayList.size() > 0) {
            getResourceReq.vecResReqInfo = arrayList;
            getResourceReq.sLanCodeType = (short) 1;
        }
        uniPacket.put("req", getResourceReq);
        if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "encode request,servantName is:ConfigServantObj,funcName is:GetResourceReq,AppSeq is:" + toServiceMsg.getAppSeq());
        }
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286088d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("ResourceConfig.GetResourceReq".equals(serviceCmd)) {
            return d(toServiceMsg, fromServiceMsg);
        }
        if ("ConfigService.ClientReq".equals(serviceCmd)) {
            return c(toServiceMsg, fromServiceMsg);
        }
        if ("MAAControl.CheckSinglePkgSig".equals(serviceCmd)) {
            return b(toServiceMsg, fromServiceMsg, serviceCmd);
        }
        if ("MAAControl.GetSinglePkgSig".equals(serviceCmd)) {
            return b(toServiceMsg, fromServiceMsg, serviceCmd);
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if ("ConfigService.ClientReq".equals(serviceCmd)) {
            return g(toServiceMsg, uniPacket);
        }
        if ("ResourceConfig.GetResourceReq".equals(serviceCmd)) {
            return h(toServiceMsg, uniPacket);
        }
        if ("MAAControl.CheckSinglePkgSig".equals(serviceCmd)) {
            return e(toServiceMsg, uniPacket);
        }
        if ("MAAControl.GetSinglePkgSig".equals(serviceCmd)) {
            return f(toServiceMsg, uniPacket);
        }
        return false;
    }
}
