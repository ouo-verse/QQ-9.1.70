package com.tencent.mobileqq.qwallet.hb;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IH5HbUtil extends QRouteApi {
    JSONObject getExtraDataForGrapH5CommonHbResult(JSONObject jSONObject) throws Exception;

    void getGrapH5CommonHbResult(String str, ResultReceiver resultReceiver) throws Throwable;

    JSONObject getGrapHbResult(int i3, Bundle bundle, Activity activity);

    void getHbDetailInfo(JSONObject jSONObject, String str, ResultReceiver resultReceiver) throws JSONException;
}
