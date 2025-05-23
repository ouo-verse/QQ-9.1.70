package com.tencent.mobileqq.openpay.data.pay;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.BaseApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public final class PayApiV2 extends BaseApi {
    static IPatchRedirector $redirector_ = null;
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "mqqopenpay.PayApiV2";
    public String callbackScheme;
    public String extData;
    public String nonceStr;
    public String packageName;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String qqSign;
    public String qqSignType;
    public String sign;
    public String signType;
    public String timeStamp;

    public PayApiV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.appId)) {
            Log.e(TAG, "checkArgs fail, invalid appId");
            return false;
        }
        if (TextUtils.isEmpty(this.partnerId)) {
            Log.e(TAG, "checkArgs fail, invalid partnerId");
            return false;
        }
        if (TextUtils.isEmpty(this.prepayId)) {
            Log.e(TAG, "checkArgs fail, invalid prepayId");
            return false;
        }
        if (TextUtils.isEmpty(this.nonceStr)) {
            Log.e(TAG, "checkArgs fail, invalid nonceStr");
            return false;
        }
        try {
            if (!TextUtils.isEmpty(this.timeStamp) && Long.parseLong(this.timeStamp) >= 0) {
                if (TextUtils.isEmpty(this.packageValue)) {
                    Log.e(TAG, "checkArgs fail, invalid packageValue");
                    return false;
                }
                if (TextUtils.isEmpty(this.sign)) {
                    Log.e(TAG, "checkArgs fail, invalid sign");
                    return false;
                }
                if (TextUtils.isEmpty(this.callbackScheme)) {
                    Log.e(TAG, "checkArgs fail, invalid callbackScheme");
                    return false;
                }
                String str = this.extData;
                if (str != null && str.length() > 1024) {
                    Log.e(TAG, "checkArgs fail, extData length too long");
                    return false;
                }
                return true;
            }
            Log.e(TAG, "checkArgs fail, invalid timeStamp");
            return false;
        } catch (NumberFormatException unused) {
            Log.e(TAG, "checkArgs fail, invalid timeStamp");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void fromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.fromBundle(bundle);
        this.partnerId = bundle.getString("_mqqpay_payapi_partnerid");
        this.prepayId = bundle.getString("_mqqpay_payapi_prepayid");
        this.nonceStr = bundle.getString("_mqqpay_payapi_noncestr");
        this.timeStamp = bundle.getString("_mqqpay_payapi_timestamp");
        this.packageValue = bundle.getString("_mqqpay_payapi_packagevalue");
        this.sign = bundle.getString("_mqqpay_payapi_sign");
        this.signType = bundle.getString("_mqqpay_payapi_sign_type");
        this.callbackScheme = bundle.getString("_mqqpay_payapi_callbackscheme");
        this.extData = bundle.getString("_mqqpay_payapi_ext_data");
    }

    public void fromQQSignBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        this.qqSign = bundle.getString("_mqqpay_payapi_qq_sign");
        this.qqSignType = bundle.getString("_mqqpay_payapi_qq_sign_type");
        this.packageName = bundle.getString("_mqqpay_payapi_in_package_name");
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public int getApiMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public String getApiName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return OpenConstants.ApiName.PAY_V2;
    }

    @Override // com.tencent.mobileqq.openpay.data.base.BaseApi
    public void toBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.toBundle(bundle);
        bundle.putString("_mqqpay_payapi_partnerid", this.partnerId);
        bundle.putString("_mqqpay_payapi_prepayid", this.prepayId);
        bundle.putString("_mqqpay_payapi_noncestr", this.nonceStr);
        bundle.putString("_mqqpay_payapi_timestamp", this.timeStamp);
        bundle.putString("_mqqpay_payapi_packagevalue", this.packageValue);
        bundle.putString("_mqqpay_payapi_sign", this.sign);
        bundle.putString("_mqqpay_payapi_sign_type", this.signType);
        bundle.putString("_mqqpay_payapi_callbackscheme", this.callbackScheme);
        bundle.putString("_mqqpay_payapi_ext_data", this.extData);
    }

    public void toQQSignBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        bundle.putString("_mqqpay_payapi_qq_sign", this.qqSign);
        bundle.putString("_mqqpay_payapi_qq_sign_type", this.qqSignType);
        bundle.putString("_mqqpay_payapi_in_package_name", this.packageName);
    }
}
