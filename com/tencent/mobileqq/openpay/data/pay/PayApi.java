package com.tencent.mobileqq.openpay.data.pay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.BaseApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Deprecated
/* loaded from: classes16.dex */
public final class PayApi extends BaseApi {
    static IPatchRedirector $redirector_;
    public String bargainorId;
    public String callbackScheme;
    public String nonce;
    public String pubAcc;
    public String pubAccHint;
    public String serialNumber;
    public String sig;
    public String sigType;
    public long timeStamp;
    public String tokenId;

    public PayApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.callbackScheme) || TextUtils.isEmpty(this.tokenId) || TextUtils.isEmpty(this.bargainorId) || TextUtils.isEmpty(this.nonce) || TextUtils.isEmpty(this.sig) || TextUtils.isEmpty(this.sigType) || this.timeStamp <= 0 || TextUtils.isEmpty(this.serialNumber)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.fromBundle(bundle);
        this.serialNumber = bundle.getString("_mqqpay_payapi_serialnumber");
        this.callbackScheme = bundle.getString("_mqqpay_payapi_callbackscheme");
        this.pubAcc = bundle.getString("_mqqpay_payapi_pubacc");
        this.pubAccHint = bundle.getString("_mqqpay_payapi_pubacchint");
        this.tokenId = bundle.getString("_mqqpay_payapi_tokenid");
        this.nonce = bundle.getString("_mqqpay_payapi_nonce");
        this.timeStamp = bundle.getLong("_mqqpay_payapi_timeStamp");
        this.bargainorId = bundle.getString("_mqqpay_payapi_bargainorId");
        this.sigType = bundle.getString("_mqqpay_payapi_sigType");
        this.sig = bundle.getString("_mqqpay_payapi_sig");
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public int getApiMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public String getApiName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return OpenConstants.ApiName.PAY;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payapi_serialnumber", this.serialNumber);
        bundle.putString("_mqqpay_payapi_callbackscheme", this.callbackScheme);
        bundle.putString("_mqqpay_payapi_pubacc", this.pubAcc);
        bundle.putString("_mqqpay_payapi_pubacchint", this.pubAccHint);
        bundle.putString("_mqqpay_payapi_tokenid", this.tokenId);
        bundle.putString("_mqqpay_payapi_nonce", this.nonce);
        bundle.putLong("_mqqpay_payapi_timeStamp", this.timeStamp);
        bundle.putString("_mqqpay_payapi_bargainorId", this.bargainorId);
        bundle.putString("_mqqpay_payapi_sigType", this.sigType);
        bundle.putString("_mqqpay_payapi_sig", this.sig);
    }
}
