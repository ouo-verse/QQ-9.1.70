package com.tencent.hippy.qq.module.vas;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = VasJSIModule.TAG)
/* loaded from: classes7.dex */
public class VasJSIModule extends HippyNativeModuleBase {
    private static final String TAG = "VasJSIModule";

    public VasJSIModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(isSync = true)
    public String getAuth(String str) {
        String authWithDomain = VasModule.getAuthWithDomain(str, null);
        if (authWithDomain == null) {
            return "";
        }
        return authWithDomain;
    }

    @HippyMethod(isSync = true)
    public String getDefaultUserAgent() {
        return i.n(i.i(""), "", false);
    }

    @HippyMethod(isSync = true)
    public String getPageUrl() {
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        if (engineInstance == null || engineInstance.getPageUrl() == null) {
            return "";
        }
        return engineInstance.getPageUrl();
    }
}
