package com.tencent.mobileqq.login.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class e implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
        }
    }

    public void b(int i3, String str, int i16, int i17, WechatInfo wechatInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), wechatInfo);
        }
    }

    public void c(int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) errMsg);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public final void onReceive(int i3, boolean z16, Bundle bundle) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        switch (i3) {
            case 2306:
                int i16 = bundle.getInt("ret");
                ErrMsg errMsg = (ErrMsg) bundle.getParcelable("errMsg");
                QLog.i("WeChatLoginObserver", 1, "onReceive login type=" + i3 + " ret=" + i16);
                c(i16, errMsg);
                return;
            case 2307:
                int i17 = bundle.getInt("ret");
                ErrMsg errMsg2 = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
                String string = bundle.getString("uin");
                if (errMsg2 != null) {
                    str = errMsg2.getMessage();
                } else {
                    str = "";
                }
                String str3 = str;
                if (errMsg2 != null && errMsg2.getType() == 1) {
                    str2 = errMsg2.getOtherinfo();
                } else {
                    str2 = null;
                }
                String str4 = str2;
                byte[] byteArray = bundle.getByteArray("LHSig");
                String string2 = bundle.getString("LHUin");
                aj ajVar = new aj(i17, i17, str3, errMsg2, str4, bundle.getByteArray("errorTlv"));
                ajVar.f241870g = byteArray;
                ajVar.f241871h = string2;
                DevlockInfo devlockInfo = (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
                QLog.i("WeChatLoginObserver", 1, "onReceive login type=" + i3 + " ret=" + i17);
                a(i17, string, ajVar, devlockInfo);
                return;
            case 2308:
                int i18 = bundle.getInt("ret");
                String string3 = bundle.getString("businessFailMsg");
                int i19 = bundle.getInt("wxBindState");
                int i26 = bundle.getInt("qqBindState");
                WechatInfo wechatInfo = (WechatInfo) bundle.getParcelable("wxBindInfo");
                QLog.i("WeChatLoginObserver", 1, "onReceive login type=" + i3 + " ret=" + i18);
                b(i18, string3, i19, i26, wechatInfo);
                return;
            default:
                return;
        }
    }
}
