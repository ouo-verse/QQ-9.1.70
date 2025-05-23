package com.tencent.mobileqq.service;

import android.os.Build;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bx;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import tencent.im.onlinestatus.RegisterExt$RegisterExtData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f286106e;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f286107d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286106e = new String[]{"StatSvc"};
        }
    }

    public e(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f286107d = appInterface;
        }
    }

    private Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRespRegister) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRespSetToken) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespSetToken", new SvcRespSetToken());
    }

    private boolean c(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        byte b16;
        SvcReqRegister svcReqRegister = new SvcReqRegister();
        VendorPushInfo vendorPushInfo = new VendorPushInfo();
        svcReqRegister.cConnType = (byte) 0;
        svcReqRegister.lBid = 7L;
        svcReqRegister.lUin = Long.parseLong(toServiceMsg.getUin());
        AppRuntime.Status status = (AppRuntime.Status) toServiceMsg.extraData.getSerializable("onlineStatus");
        svcReqRegister.iStatus = status.getValue();
        svcReqRegister.bKikPC = (byte) 0;
        svcReqRegister.bKikWeak = (byte) 0;
        svcReqRegister.timeStamp = this.f286107d.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
        svcReqRegister.iLargeSeq = toServiceMsg.extraData.getLong("K_SEQ", 0L);
        svcReqRegister.bRegType = (byte) 0;
        if (toServiceMsg.extraData.getBoolean("isAutoSet", false)) {
            b16 = 2;
        } else {
            b16 = 1;
        }
        svcReqRegister.bIsSetStatus = b16;
        svcReqRegister.uExtOnlineStatus = toServiceMsg.extraData.getLong("extOnlineStatus", -1L);
        int i3 = toServiceMsg.extraData.getInt(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, 1);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusService", 2, "OnlineStatusService-handleReqSetOnlineStatus.vendor_push_type:" + i3);
        }
        vendorPushInfo.uVendorType = i3;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2 && au.d(svcReqRegister.uExtOnlineStatus)) {
            svcReqRegister.iBatteryStatus = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSendBatteryStatus(toServiceMsg.extraData.getInt("batteryCapacity", 0), toServiceMsg.extraData.getInt("powerConnect", -1));
        } else {
            svcReqRegister.iBatteryStatus = 0;
        }
        if (status == status2 && svcReqRegister.uExtOnlineStatus == 2000) {
            svcReqRegister.vecCustomStatus = toServiceMsg.extraData.getByteArray("diyStatusInfo");
        }
        try {
            svcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (NetConnInfoCenter.isMobileConn()) {
            svcReqRegister.cNetType = (byte) 0;
        } else if (NetConnInfoCenter.isWifiConn()) {
            svcReqRegister.cNetType = (byte) 1;
        }
        svcReqRegister.vecGuid = NetConnInfoCenter.GUID;
        svcReqRegister.strDevName = DeviceInfoMonitor.getModel();
        svcReqRegister.strDevType = DeviceInfoMonitor.getModel();
        svcReqRegister.strOSVer = Build.VERSION.RELEASE;
        svcReqRegister.stVendorPushInfo = vendorPushInfo;
        int i16 = toServiceMsg.extraData.getInt("from_type", 0);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusService", 2, "OnlineStatusService-handleReqSetOnlineStatus.fromType: " + i16);
        }
        RegisterExt$RegisterExtData registerExt$RegisterExtData = new RegisterExt$RegisterExtData();
        registerExt$RegisterExtData.set_status_scene.set(i16);
        registerExt$RegisterExtData.first_login_after_update.set(0);
        registerExt$RegisterExtData.set_status_has_avatar.set(toServiceMsg.extraData.getInt(IOnlineStatusService.SET_AVATAR, 0));
        svcReqRegister.vecRegisterExtData = registerExt$RegisterExtData.toByteArray();
        uniPacket.put("SvcReqRegister", svcReqRegister);
        uniPacket.setServantName("PushService");
        uniPacket.setFuncName("SvcReqRegister");
        return true;
    }

    private boolean d(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3;
        byte b16;
        byte b17;
        SvcReqSetToken svcReqSetToken = new SvcReqSetToken();
        String string = toServiceMsg.extraData.getString("push_token");
        String string2 = toServiceMsg.extraData.getString("push_profileid");
        try {
            svcReqSetToken.vNewToken = string.getBytes("utf-8");
            if (!TextUtils.isEmpty(string2)) {
                svcReqSetToken.vProfileID = string2.getBytes("utf-8");
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        svcReqSetToken.bEnterVersion = (byte) 37;
        svcReqSetToken.bPushMsg = (byte) 1;
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        svcReqSetToken.uGroupProSwitch = j3;
        if (bx.a()) {
            try {
                svcReqSetToken.strDevType = DeviceInfoMonitor.getModel();
                svcReqSetToken.strOSVer = Build.VERSION.RELEASE;
                svcReqSetToken.uVendorType = toServiceMsg.extraData.getInt(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, 1);
                if (SettingCloneUtil.readValue(this.f286107d.getApplicationContext(), this.f286107d.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true)) {
                    b16 = 1;
                } else {
                    b16 = 0;
                }
                svcReqSetToken.cNotifySwitch = b16;
                if (((ISubAccountService) this.f286107d.getRuntimeService(ISubAccountService.class, "")).getNotifySwitch()) {
                    b17 = 1;
                } else {
                    b17 = 0;
                }
                svcReqSetToken.cBindUinNotifySwitch = b17;
                svcReqSetToken.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
            } catch (Exception e17) {
                QLog.e("OnlineStatusService", 1, e17, new Object[0]);
            }
        }
        uniPacket.put("SvcReqSetToken", svcReqSetToken);
        uniPacket.setServantName("PushService");
        uniPacket.setFuncName("SvcReqSetToken");
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusService", 2, "HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:" + string + ",profileid = " + string2 + " uGroupProSwitch:" + svcReqSetToken.uGroupProSwitch);
        }
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f286106e;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (IOnlineStatusService.CMD_SET_ONLINE_STATUS.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, fromServiceMsg);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(IOnlineStatusService.CMD_SET_PUSH_TOKEN)) {
            return b(toServiceMsg, fromServiceMsg);
        }
        return super.decode(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(IOnlineStatusService.CMD_SET_ONLINE_STATUS)) {
            return c(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(IOnlineStatusService.CMD_SET_PUSH_TOKEN)) {
            return d(toServiceMsg, uniPacket);
        }
        return true;
    }
}
