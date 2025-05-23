package com.tencent.mobileqq.qqgift.sso;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nh2.c f265000a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Z(String str, String str2, byte[] bArr, int i3, int i16, boolean z16, c cVar, Bundle bundle) {
        if (this.f265000a == null) {
            QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq giftSDK is null");
            return;
        }
        AppInterface a16 = com.tencent.mobileqq.qqgift.utils.a.a();
        if (a16 == null) {
            QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq getAppInterface is null");
        } else {
            ((QQGiftBusinessHandler) a16.getBusinessHandler(QQGiftBusinessHandler.QQ_GIFT_HANDLER)).sendQQGiftReq(this.f265000a.getSDKConfig().f264972a, str, str2, bArr, i3, i16, z16, cVar, bundle);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.sso.a
    public void G(String str, String str2, byte[] bArr, int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, bArr, Integer.valueOf(i3), cVar);
        } else {
            Z(str, str2, bArr, 15000, i3, true, cVar, null);
        }
    }

    @Override // nh2.a
    public void N(nh2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        } else {
            this.f265000a = cVar;
        }
    }

    @Override // com.tencent.mobileqq.qqgift.sso.a
    public void T(String str, String str2, byte[] bArr, int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, bArr, Integer.valueOf(i3), cVar);
        } else {
            Y(str, str2, bArr, 15000, i3, cVar, null);
        }
    }

    public void Y(String str, String str2, byte[] bArr, int i3, int i16, c cVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, bArr, Integer.valueOf(i3), Integer.valueOf(i16), cVar, bundle);
        } else {
            Z(str, str2, bArr, i3, i16, false, cVar, bundle);
        }
    }

    @Override // nh2.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
