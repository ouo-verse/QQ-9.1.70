package com.tencent.mobileqq.openpay.data.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.openpay.BuildConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseApi {
    static IPatchRedirector $redirector_;
    public String appId;
    private MidasPayExt mMidasPayExt;
    public String transaction;

    public BaseApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract boolean checkParams();

    public void fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        this.transaction = bundle.getString("_mqqpay_baseapi_transaction");
        this.appId = bundle.getString("_mqqpay_baseapi_appid");
        this.mMidasPayExt = new MidasPayExt().fromBundle(bundle);
    }

    public abstract int getApiMark();

    public abstract String getApiName();

    public void setExtraParams(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            this.mMidasPayExt = new MidasPayExt().fromBundle(bundle);
        }
    }

    public void toBundle(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (TextUtils.isEmpty(this.transaction)) {
            str = String.valueOf(hashCode());
        } else {
            str = this.transaction;
        }
        bundle.putString("_mqqpay_baseapi_transaction", str);
        bundle.putString("_mqqpay_baseapi_appid", this.appId);
        bundle.putString("_mqqpay_baseapi_apiname", getApiName());
        bundle.putInt("_mqqpay_baseapi_apimark", getApiMark());
        bundle.putString("_mqqpay_baseapi_apptype", "native");
        bundle.putString("_mqqpay_baseapi_sdkversion", BuildConfig.VERSION_NAME);
        MidasPayExt midasPayExt = this.mMidasPayExt;
        if (midasPayExt != null) {
            midasPayExt.toBundle(bundle);
        }
    }
}
