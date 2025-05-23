package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import org.json.JSONObject;

@ProxyService(proxy = NavigationProxy.class)
/* loaded from: classes23.dex */
public class NavigationProxyDefault extends NavigationProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public boolean launchByAppType(int i3, Activity activity, String str, int i16, JSONObject jSONObject, ResultReceiver resultReceiver) {
        if (i3 == 1) {
            LaunchParam launchParam = new LaunchParam();
            launchParam.scene = i16;
            MiniAppLauncher.launchMiniApp(activity, str, launchParam, resultReceiver);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public void onBeforeNavigateToMiniProgram() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public void onAfterLaunchByAppInfo(JSONObject jSONObject) {
    }
}
