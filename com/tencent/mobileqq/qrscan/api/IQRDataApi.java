package com.tencent.mobileqq.qrscan.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.o;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IQRDataApi extends QRouteApi {
    public static final String PARAM_BQQ = "bqq";
    public static final String PARAM_CMD = "cmd";
    public static final String PARAM_D = "d";
    public static final String PARAM_EXTRA = "extra";
    public static final String PARAM_NO_VERIFY_TOKEN = "no_verify_token";
    public static final String PARAM_SKEY = "skey";

    void requestUrlDecode(AppRuntime appRuntime, String str, JSONObject jSONObject, Bundle bundle, o oVar);

    void requestUrlEncode(AppRuntime appRuntime, String str, Bundle bundle, o oVar);
}
