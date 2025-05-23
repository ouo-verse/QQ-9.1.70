package com.tencent.mobileqq.openpay.data.pay;

import android.os.Bundle;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PayResponseV2 extends BaseResponse {
    static IPatchRedirector $redirector_;
    public String extData;
    public String prepayId;

    public PayResponseV2() {
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
        this.prepayId = bundle.getString("_mqqpay_payresp_prepayId");
        this.extData = bundle.getString("_mqqpay_payresp_extData");
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseResponse
    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payresp_prepayId", this.prepayId);
        bundle.putString("_mqqpay_payresp_extData", this.extData);
    }
}
