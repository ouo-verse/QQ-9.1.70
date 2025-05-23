package com.tencent.mobileqq.msf.core.e0;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements e, d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247968a = "AttributesFilter";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String a(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "none" : "v4v6" : "IPv6" : "IPv4";
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY, a(MsfService.getCore().getConnectedIPFamily()));
        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_SSO_IP, MsfService.getCore().getNowUsedSsoAddress());
        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_IS_WIFI, Boolean.valueOf(NetConnInfoCenter.isWifiConn()));
        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_ISP, AppNetConnInfo.getCurrentAPN());
        if (QLog.isDebugVersion()) {
            QLog.d(f247968a, 1, "[onMessageSent] hash: ", Integer.valueOf(toServiceMsg.hashCode()), " isMain: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN, Boolean.TRUE), ", ipFamily: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY), ", isWeakNet: ", toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, Boolean.FALSE), ", sendChannel: ", toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249868z), ", isXg: ", toServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG), ", ssoIP: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SSO_IP), ", isWifi: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI), ", apn: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_ISP), ", msg: ", toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            if (toServiceMsg == null || TextUtils.isEmpty(toServiceMsg.getServiceCmd()) || !QLog.isDebugVersion()) {
                return;
            }
            QLog.d(f247968a, 1, "[onMessageReceive] hash: ", Integer.valueOf(toServiceMsg.hashCode()), " isMain: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN, Boolean.TRUE), ", ipFamily: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY), ", isWeakNet: ", toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, Boolean.FALSE), ", sendChannel: ", toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249868z), ", isXg: ", toServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG), ", ssoIP: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SSO_IP), ", isWifi: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI), ", apn: ", toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_ISP), ", msg: ", toServiceMsg);
        }
    }
}
