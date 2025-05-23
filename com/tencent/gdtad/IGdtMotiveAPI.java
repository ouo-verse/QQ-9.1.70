package com.tencent.gdtad;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gdtad.jsbridge.GdtOpenMotiveAdHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtMotiveAPI extends QRouteApi {
    String getJSBundleVersion();

    String getJsBundleInfo();

    void preDownload();

    void registerIPCForHippy(Context context);

    void scheduleH5ReportRewardAdNew(GdtOpenMotiveAdHandler gdtOpenMotiveAdHandler, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2);
}
