package com.tencent.mtt.hippy.modules.nativemodules.exception;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = ExceptionModule.HIPPY_CLASS)
/* loaded from: classes20.dex */
public class ExceptionModule extends HippyNativeModuleBase {
    public static final String HIPPY_CLASS = "ExceptionModule";

    public ExceptionModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "handleBackgroundTracing")
    public void handleBackgroundTracing(String str) {
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext != null && hippyEngineContext.getGlobalConfigs() != null) {
            this.mContext.getGlobalConfigs().getExceptionHandler().handleBackgroundTracing(str);
        }
    }

    @HippyMethod(name = "handleException")
    public void handleException(String str, String str2) {
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext != null) {
            hippyEngineContext.handleException(new HippyJsException(str, str2));
        }
    }
}
