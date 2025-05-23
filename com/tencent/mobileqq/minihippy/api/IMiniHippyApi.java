package com.tencent.mobileqq.minihippy.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniHippyApi extends QRouteApi {
    public static final String KEY_MINI_HIPPY = "bundle_key_mini_hippy";

    void backToHome(Context context);

    boolean checkIfColdReloadHippy(Object obj, Object obj2);

    Map<String, String> getShareParams();

    boolean isInMiniHippyWhiteList(String str);

    boolean isLaunchByMiniApp(Context context);

    boolean isMiniHippy(Object obj);

    void launchMiniHippy(Context context, Intent intent);

    void openUrl(Context context, String str);

    void popMiniHippy(Context context);

    void setShareParams(String str, String str2, String str3);
}
