package com.tencent.mobileqq.openpay.data.base;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class MidasPayExt {
    static IPatchRedirector $redirector_;
    private String openId;
    private String openKey;
    private String sessionId;
    private String sessionType;
    private String skey;
    private String skeyType;
    private String uin;

    public MidasPayExt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.skey == null && this.skeyType == null && this.uin == null && this.sessionId == null && this.sessionType == null && this.openId == null && this.openKey == null) {
            return false;
        }
        return true;
    }

    public MidasPayExt fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MidasPayExt) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        }
        this.skey = bundle.getString("_mqqpay_payapi_skey");
        this.skeyType = bundle.getString("_mqqpay_payapi_skey_type");
        this.uin = bundle.getString("_mqqpay_payapi_uin");
        this.sessionId = bundle.getString("_mqqpay_payapi_sessionId");
        this.sessionType = bundle.getString("_mqqpay_payapi_sessionType");
        this.openId = bundle.getString("_mqqpay_payapi_openId");
        this.openKey = bundle.getString("_mqqpay_payapi_openKey");
        return this;
    }

    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        bundle.putString("_mqqpay_payapi_skey", this.skey);
        bundle.putString("_mqqpay_payapi_skey_type", this.skeyType);
        bundle.putString("_mqqpay_payapi_uin", this.uin);
        bundle.putString("_mqqpay_payapi_sessionId", this.sessionId);
        bundle.putString("_mqqpay_payapi_sessionType", this.sessionType);
        bundle.putString("_mqqpay_payapi_openId", this.openId);
        bundle.putString("_mqqpay_payapi_openKey", this.openKey);
    }
}
