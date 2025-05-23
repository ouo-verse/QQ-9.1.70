package com.tencent.hippy.qq.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyUpdate extends QRouteApi {
    public static final String EXTRA_KEY_IS_CHECK_PRELOAD = "isCheckPreload";
    public static final String EXTRA_KEY_IS_CONTROL_FLOW = "isFlowControl";
    public static final String EXTRA_KEY_IS_SKIP_INTERVAL = "isSkipInterval";
    public static final String EXTRA_KEY_PRELOAD_SCENE_TYPE = "preloadSceneType";
    public static final String EXTRA_KEY_REPORT_FROM = "reportFrom";

    boolean checkUpdateJsBundleInterval(String str);

    void commonUpdateJsBundle(String str, String str2, IUpdateListener iUpdateListener);

    HippyConfig getHippyConfig();

    File getTabConfigFile(String str, String str2);

    boolean isGameCenterPreloadByTab();

    void removeJsBundleUpdateListener(String str, IUpdateListener iUpdateListener);

    void reportHippy(JSONObject jSONObject);

    void requestHippyConfig(int i3);

    void updateJsBundle(String str, boolean z16, int i3, Bundle bundle, IUpdateListener iUpdateListener);
}
