package com.tencent.mtt.hippy.utils;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ExceptionUtil {
    private static final String TAG = "ExceptionUtil";

    public static void handleNativeException(HippyEngineContext hippyEngineContext, Throwable th5, String str) {
        if (hippyEngineContext != null && th5 != null) {
            Exception exc = new Exception("msg:" + str + " err:" + th5.getMessage());
            exc.setStackTrace(th5.getStackTrace());
            reportNativeException(hippyEngineContext, exc);
            printNativeException(hippyEngineContext, exc);
        }
    }

    private static void printNativeException(HippyEngineContext hippyEngineContext, Exception exc) {
        HippyGlobalConfigs globalConfigs = hippyEngineContext.getGlobalConfigs();
        if (globalConfigs != null && globalConfigs.getLogAdapter() != null) {
            globalConfigs.getLogAdapter().onReceiveLogMessage(3, TAG, exc.getMessage());
        }
    }

    private static void reportNativeException(HippyEngineContext hippyEngineContext, Exception exc) {
        HippyGlobalConfigs globalConfigs = hippyEngineContext.getGlobalConfigs();
        if (globalConfigs != null && globalConfigs.getExceptionHandler() != null) {
            globalConfigs.getExceptionHandler().handleNativeException(exc, true);
        }
    }
}
