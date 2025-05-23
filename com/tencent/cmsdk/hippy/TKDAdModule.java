package com.tencent.cmsdk.hippy;

import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;

/* compiled from: P */
@HippyNativeModule(name = "TKDAdModule")
/* loaded from: classes5.dex */
public class TKDAdModule extends HippyNativeModuleBase {
    public static String TAG = "TKDAdModule";

    public TKDAdModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        TKDAdHippy.getInstance().getTKDAdModule().init(hippyEngineContext);
    }

    @HippyMethod(name = "mmaOnExpose")
    public void MMAOnExpose(String str, int i3) {
        TKDAdHippy.getInstance().getTKDAdModule().MMAOnExpose(str, i3);
    }

    @HippyMethod(name = "getAccountInfo")
    public void getAccountInfo(Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().getAccountInfo(promise);
    }

    @HippyMethod(name = "getAppPkgInfo")
    public void getAppPkgInfo(String str, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().getAppPkgInfo(str, promise);
    }

    @HippyMethod(name = "getDeviceInfo")
    public void getDeviceInfo(Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().getDeviceInfo(promise);
    }

    @HippyMethod(name = "getEnv")
    public void getEnv(Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().getEnv(promise);
    }

    @HippyMethod(name = DKWebViewController.DKHippyWebviewFunction.GO_BAC)
    public void goBack(String str, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().goBack(str, promise);
    }

    @HippyMethod(name = "isSupportQQMiniGame")
    public void isSupportQQMiniGame(Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().isSupportQQMiniGame(promise);
    }

    @HippyMethod(name = DKWebViewController.DKHippyWebviewFunction.LOAD_URL)
    public void loadUrl(String str, HippyMap hippyMap) {
        TKDAdHippy.getInstance().getTKDAdModule().loadUrl(str, hippyMap);
    }

    @HippyMethod(name = "openQQMiniGameByLink")
    public void openQQMiniGameByLink(HippyMap hippyMap, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().openQQMiniGameByLink(hippyMap, promise);
    }

    @HippyMethod(name = "runApp")
    public void runApp(String str) {
        TKDAdHippy.getInstance().getTKDAdModule().runApp(str);
    }

    @HippyMethod(name = "sendWupRequest")
    public void sendWupRequest(HippyMap hippyMap, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().sendWupRequest(hippyMap, promise);
    }

    @HippyMethod(name = "setTitle")
    public void setTitle(HippyMap hippyMap, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().setTitle(hippyMap, promise);
    }

    @HippyMethod(name = UIJsPlugin.EVENT_SHOW_TOAST)
    public void showToast(String str, String str2, int i3, String str3, Promise promise) {
        TKDAdHippy.getInstance().getTKDAdModule().showToast(str, str2, i3, str3, promise);
    }
}
