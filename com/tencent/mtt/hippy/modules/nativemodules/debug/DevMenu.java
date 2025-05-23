package com.tencent.mtt.hippy.modules.nativemodules.debug;

import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
@HippyNativeModule(name = "DevMenu")
/* loaded from: classes20.dex */
public class DevMenu extends HippyNativeModuleBase {
    public DevMenu(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = DKWebViewController.DKHippyWebviewFunction.RELOAD)
    public void reload() {
        try {
            this.mContext.getDevSupportManager().a().b();
        } catch (Throwable th5) {
            LogUtils.d("HippyDevMemo", "reload error: " + th5.getMessage());
        }
    }
}
