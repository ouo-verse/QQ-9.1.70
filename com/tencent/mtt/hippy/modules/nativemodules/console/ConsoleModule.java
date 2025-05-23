package com.tencent.mtt.hippy.modules.nativemodules.console;

import android.util.Log;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = "ConsoleModule")
/* loaded from: classes20.dex */
public class ConsoleModule extends HippyNativeModuleBase {
    public ConsoleModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "error")
    public void error(String str) {
        Log.e("hippy_console", str);
    }

    @HippyMethod(name = "info")
    public void info(String str) {
        Log.i("hippy_console", str);
    }

    @HippyMethod(name = "log")
    public void log(String str) {
        Log.d("hippy_console", str);
    }

    @HippyMethod(name = "warn")
    public void warn(String str) {
        Log.w("hippy_console", str);
    }
}
