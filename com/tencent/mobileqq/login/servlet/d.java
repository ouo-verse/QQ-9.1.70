package com.tencent.mobileqq.login.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.z;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements BusinessObserver, z {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.z
    public void a(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.login.z
    public void b(int i3, String str, DevlockInfo devlockInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, devlockInfo);
        }
    }

    public void c(int i3, String str, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, bArr, bundle);
        }
    }

    public void d(int i3, String str, DevlockInfo devlockInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, devlockInfo, bArr);
        }
    }

    public void e(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        int i16 = bundle.getInt("ret");
        ErrMsg errMsg = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
        DevlockInfo devlockInfo = (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        byte[] byteArray = bundle.getByteArray("smsExtraData");
        if (errMsg != null) {
            str = errMsg.getMessage();
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginVerifyObserver", 2, "onReceive type=" + i3 + " ret=" + i16 + " errMsg=" + str);
        }
        switch (i3) {
            case 2300:
                e(i16, z16, bundle);
                return;
            case JsonGrayBusiId.AIO_ZPLAN_EMOTICON_GUIDE /* 2301 */:
                d(i16, str, devlockInfo, byteArray);
                return;
            case JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE /* 2302 */:
                c(i16, str, byteArray, bundle);
                return;
            case 2303:
                b(i16, str, devlockInfo);
                return;
            case 2304:
                a(i16, str, bundle);
                return;
            default:
                return;
        }
    }
}
