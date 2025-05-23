package com.tencent.mobileqq.openpay.processor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.openpay.api.IOpenApiListener;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.BaseApi;
import com.tencent.mobileqq.openpay.data.pay.PayApiV2;
import com.tencent.mobileqq.openpay.data.pay.PayResponseV2;
import com.tencent.mobileqq.openpay.utils.QQVersionUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public final class PayApiV2Processor implements IApiProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String SUPPORT_QQ_SIGN_VERSION = "8.9.58";
    private static final String SUPPORT_QQ_VERSION = "8.9.35";

    /* JADX INFO: Access modifiers changed from: package-private */
    public PayApiV2Processor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void processQQSign(Context context, BaseApi baseApi, Bundle bundle) {
        String mobileQQVersion;
        if (!(baseApi instanceof PayApiV2) || (mobileQQVersion = QQVersionUtils.getMobileQQVersion(context)) == null || new QQVersionUtils().compare(mobileQQVersion, SUPPORT_QQ_SIGN_VERSION) < 0) {
            return;
        }
        ((PayApiV2) baseApi).toQQSignBundle(bundle);
    }

    @Override // com.tencent.mobileqq.openpay.processor.IApiProcessor
    public String getSupportQQVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return SUPPORT_QQ_VERSION;
    }

    @Override // com.tencent.mobileqq.openpay.processor.IApiProcessor
    public boolean handleIntent(Intent intent, IOpenApiListener iOpenApiListener) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) iOpenApiListener)).booleanValue();
        }
        String stringExtra = intent.getStringExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY);
        if (TextUtils.isEmpty(stringExtra) || stringExtra.compareTo(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG) != 0 || (extras = intent.getExtras()) == null) {
            return false;
        }
        PayResponseV2 payResponseV2 = new PayResponseV2();
        payResponseV2.fromBundle(extras);
        iOpenApiListener.onOpenResponse(payResponseV2);
        return true;
    }

    @Override // com.tencent.mobileqq.openpay.processor.IApiProcessor
    public void processApi(Context context, BaseApi baseApi) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) baseApi);
            return;
        }
        Bundle bundle = new Bundle();
        baseApi.toBundle(bundle);
        processQQSign(context, baseApi, bundle);
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            bundle.putString("_mqqpay_payapi_packageName", packageName);
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(OpenConstants.PayApi.OPEN_QQ_PAY_SCHEMA));
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            if (packageName == null || !packageName.equals("com.tencent.mobileqq")) {
                intent.addFlags(134217728);
            }
            context.startActivity(intent);
            return;
        }
        throw new Exception("context.getPackageName fail");
    }
}
