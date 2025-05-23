package com.tencent.cmsdk.hippy.api;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ITKDAdModule {
    void MMAOnExpose(String str, int i3);

    void getAccountInfo(Promise promise);

    void getAppPkgInfo(String str, Promise promise);

    void getDeviceInfo(Promise promise);

    void getEnv(Promise promise);

    void goBack(String str, Promise promise);

    void init(HippyEngineContext hippyEngineContext);

    void isSupportQQMiniGame(Promise promise);

    void loadUrl(String str, HippyMap hippyMap);

    void openQQMiniGameByLink(HippyMap hippyMap, Promise promise);

    void runApp(String str);

    void sendWupRequest(HippyMap hippyMap, Promise promise);

    void setTitle(HippyMap hippyMap, Promise promise);

    void showToast(String str, String str2, int i3, String str3, Promise promise);
}
