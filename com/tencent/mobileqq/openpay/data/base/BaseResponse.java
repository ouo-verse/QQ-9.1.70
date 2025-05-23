package com.tencent.mobileqq.openpay.data.base;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseResponse {
    static IPatchRedirector $redirector_;
    public int apiMark;
    public String apiName;
    public int retCode;
    public String retMsg;
    public String transaction;

    public BaseResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.retCode = -1;
        }
    }

    public void fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        this.retCode = bundle.getInt("_mqqpay_baseresp_retcode");
        this.retMsg = bundle.getString("_mqqpay_baseresp_retmsg");
        this.transaction = bundle.getString("_mqqpay_baseresp_transaction");
        this.apiName = bundle.getString("_mqqpay_baseapi_apiname");
        this.apiMark = bundle.getInt("_mqqpay_baseapi_apimark");
    }

    public boolean isSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.retCode == 0) {
            return true;
        }
        return false;
    }

    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        bundle.putInt("_mqqpay_baseresp_retcode", this.retCode);
        bundle.putString("_mqqpay_baseresp_retmsg", this.retMsg);
        bundle.putString("_mqqpay_baseresp_transaction", this.transaction);
        bundle.putString("_mqqpay_baseapi_apiname", this.apiName);
        bundle.putInt("_mqqpay_baseapi_apimark", this.apiMark);
    }
}
