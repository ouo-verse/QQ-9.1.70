package com.tencent.mobileqq.openpay.processor;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.openpay.api.IOpenApiListener;
import com.tencent.mobileqq.openpay.data.base.BaseApi;

/* loaded from: classes16.dex */
public interface IApiProcessor {
    String getSupportQQVersion();

    boolean handleIntent(Intent intent, IOpenApiListener iOpenApiListener);

    void processApi(Context context, BaseApi baseApi) throws Exception;
}
