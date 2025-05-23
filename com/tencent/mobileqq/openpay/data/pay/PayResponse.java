package com.tencent.mobileqq.openpay.data.pay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Deprecated
/* loaded from: classes16.dex */
public class PayResponse extends BaseResponse {
    static IPatchRedirector $redirector_;
    public String callbackUrl;
    public String openId;
    public String payChannelType;
    public String payTime;
    public String serialNumber;
    public String spData;
    public String totalFee;
    public String transactionId;

    public PayResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public void fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.fromBundle(bundle);
        this.payChannelType = bundle.getString("_mqqpay_payresp_paychanneltype");
        this.transactionId = bundle.getString("_mqqpay_payresp_transactionid");
        this.payTime = bundle.getString("_mqqpay_payresp_paytime");
        this.totalFee = bundle.getString("_mqqpay_payresp_totalfee");
        this.callbackUrl = bundle.getString("_mqqpay_payresp_callbackurl");
        this.spData = bundle.getString("_mqqpay_payresp_spdata");
        this.serialNumber = bundle.getString("_mqqpay_payapi_serialnumber");
        this.openId = bundle.getString("_mqqpay_payapi_openid");
    }

    public boolean isPayByWeChat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.payChannelType)) {
            return false;
        }
        return this.payChannelType.equals("1");
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payresp_transactionid", this.transactionId);
        bundle.putString("_mqqpay_payresp_paytime", this.payTime);
        bundle.putString("_mqqpay_payresp_totalfee", this.totalFee);
        bundle.putString("_mqqpay_payresp_callbackurl", this.callbackUrl);
        bundle.putString("_mqqpay_payresp_spdata", this.spData);
        bundle.putString("_mqqpay_payapi_serialnumber", this.serialNumber);
        bundle.putString("_mqqpay_payapi_openid", this.openId);
        bundle.putString("_mqqpay_payresp_paychanneltype", this.payChannelType);
    }
}
