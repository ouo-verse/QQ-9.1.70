package com.tencent.mobileqq.service.push;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bx;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286380d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f286380d = new String[]{AegisLogger.PUSH, "PushService"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.getWupBuffer() == null) {
            return null;
        }
        return fromServiceMsg;
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRespSetToken) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespSetToken", new SvcRespSetToken());
    }

    private boolean c(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
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
                if (SettingCloneUtil.readValue(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true)) {
                    b16 = 1;
                } else {
                    b16 = 0;
                }
                svcReqSetToken.cNotifySwitch = b16;
                if (((ISubAccountService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountService.class, "")).getNotifySwitch()) {
                    b17 = 1;
                } else {
                    b17 = 0;
                }
                svcReqSetToken.cBindUinNotifySwitch = b17;
                svcReqSetToken.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
            } catch (Exception e17) {
                QLog.e("PushService", 1, e17, new Object[0]);
            }
        }
        uniPacket.put("SvcReqSetToken", svcReqSetToken);
        uniPacket.setServantName("PushService");
        uniPacket.setFuncName("SvcReqSetToken");
        if (QLog.isColorLevel()) {
            QLog.d("PushService", 2, "HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:" + string + ",profileid = " + string2 + " uGroupProSwitch:" + svcReqSetToken.uGroupProSwitch);
        }
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f286380d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (fromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) {
            return a(toServiceMsg, fromServiceMsg);
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void decodeRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (BaseConstants.CMD_MSF_NOTIFYRESP.equals(serviceCmd)) {
            Intent intent = new Intent("tencent.notify.album");
            intent.putExtra("resp", fromServiceMsg);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } else if (IOnlineStatusService.CMD_SET_PUSH_TOKEN.equalsIgnoreCase(serviceCmd)) {
            b(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(IOnlineStatusService.CMD_SET_PUSH_TOKEN)) {
            return c(toServiceMsg, uniPacket);
        }
        return false;
    }
}
