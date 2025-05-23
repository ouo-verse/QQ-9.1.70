package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import org.json.JSONObject;

@ProxyService(proxy = NavigationProxy.class)
/* loaded from: classes34.dex */
public class NavigationProxyImpl extends NavigationProxy {
    private void a(final MiniAppInfo miniAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.NavigationProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo.saveMiniAppShowInfoEntity(miniAppInfo);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public boolean launchByAppType(int i3, Activity activity, String str, int i16, JSONObject jSONObject, ResultReceiver resultReceiver) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public void onAfterLaunchByAppInfo(JSONObject jSONObject) {
        a(MiniAppInfo.createMiniAppInfo(jSONObject));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
    public void onBeforeNavigateToMiniProgram() {
    }
}
