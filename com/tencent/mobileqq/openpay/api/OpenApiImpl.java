package com.tencent.mobileqq.openpay.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.BaseApi;
import com.tencent.mobileqq.openpay.processor.ApiProcessorCenter;
import com.tencent.mobileqq.openpay.processor.IApiProcessor;
import com.tencent.mobileqq.openpay.utils.QQVersionUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
final class OpenApiImpl implements IOpenApi {
    static IPatchRedirector $redirector_;
    private final ApiProcessorCenter mApiProcessorCenter;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenApiImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mApiProcessorCenter = new ApiProcessorCenter();
            this.mContext = context;
        }
    }

    private String getMobileQQVersion() {
        return QQVersionUtils.getMobileQQVersion(this.mContext);
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public boolean execApi(BaseApi baseApi) {
        String apiName;
        IApiProcessor iApiProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseApi)).booleanValue();
        }
        if (baseApi == null || !baseApi.checkParams() || (iApiProcessor = this.mApiProcessorCenter.get((apiName = baseApi.getApiName()))) == null) {
            return false;
        }
        if (!isMobileQQSupportApi(iApiProcessor)) {
            Log.d(OpenConstants.QQApp.SDK_TAG, "unSupport api: " + apiName + ", QQ current(" + getMobileQQVersion() + ") < require(" + iApiProcessor.getSupportQQVersion() + ")");
            return false;
        }
        try {
            iApiProcessor.processApi(this.mContext, baseApi);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public boolean handleIntent(Intent intent, IOpenApiListener iOpenApiListener) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) iOpenApiListener)).booleanValue();
        }
        if (intent == null || iOpenApiListener == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        IApiProcessor iApiProcessor = this.mApiProcessorCenter.get(extras.getString("_mqqpay_baseapi_apiname"));
        if (iApiProcessor == null) {
            return false;
        }
        return iApiProcessor.handleIntent(intent, iOpenApiListener);
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public boolean isMobileQQInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (getMobileQQVersion() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public boolean isMobileQQSupportApi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        IApiProcessor iApiProcessor = this.mApiProcessorCenter.get(str);
        if (isMobileQQSupportApi(iApiProcessor)) {
            return true;
        }
        Log.d(OpenConstants.QQApp.SDK_TAG, "unSupport api: " + str + ", QQ current(" + getMobileQQVersion() + ") < require(" + iApiProcessor.getSupportQQVersion() + ")");
        return false;
    }

    private boolean isMobileQQSupportApi(IApiProcessor iApiProcessor) {
        String supportQQVersion;
        String mobileQQVersion;
        return (iApiProcessor == null || (supportQQVersion = iApiProcessor.getSupportQQVersion()) == null || (mobileQQVersion = getMobileQQVersion()) == null || new QQVersionUtils().compare(mobileQQVersion, supportQQVersion) < 0) ? false : true;
    }
}
