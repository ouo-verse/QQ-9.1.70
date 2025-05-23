package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

/* compiled from: P */
/* loaded from: classes15.dex */
class j {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    static final String f247486a = "MSF.C.WTLoginCenter";

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static void a(MsfCommand msfCommand, ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void a(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z16, ToServiceMsg toServiceMsg, MsfCore msfCore, long j3, long j16, byte[] bArr, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z16, ToServiceMsg toServiceMsg, MsfCore msfCore, byte[] bArr, long j3, long j16, byte[] bArr2, int i3) {
    }

    private static WUserSigInfo a(ToServiceMsg toServiceMsg, o oVar) {
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = oVar.f247508f;
        return b16;
    }

    private static void a(ToServiceMsg toServiceMsg, WUserSigInfo wUserSigInfo) {
        WtloginHelper.setExtraRegTlvValueWatchQQLicense(wUserSigInfo, (byte[]) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_LICENSE));
    }

    private static void a(ToServiceMsg toServiceMsg, o oVar, int i3, String str) {
        if (i3 != -1001) {
            if (QLog.isColorLevel()) {
                QLog.d(f247486a, 2, "call " + str + " ret  " + i3);
            }
            oVar.a(str, 0, m.b(toServiceMsg.getRequestSsoSeq()));
        }
    }

    private static void b(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void c(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void d(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void e(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void f(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void g(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void h(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }

    private static void i(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper, MsfCore msfCore) {
    }
}
