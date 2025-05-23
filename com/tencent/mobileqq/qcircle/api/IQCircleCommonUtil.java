package com.tencent.mobileqq.qcircle.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleCommonUtil extends QRouteApi {
    int getColorFromJSON(JSONObject jSONObject, String str);

    long getSystemTotalMemory();

    @Nullable
    Activity getTopActivity();

    boolean isFriend(String str);

    boolean isInNightMode();

    boolean isTestEnv();

    Bundle jsonToLabel(Bundle bundle, String str);

    String keyGpsInfo();

    String keyParseDataErrorMsg();

    String labelToJson(Bundle bundle);

    void setNavigationBarColor(Activity activity, int i3);

    void setStatusBarColor(Activity activity, int i3);
}
