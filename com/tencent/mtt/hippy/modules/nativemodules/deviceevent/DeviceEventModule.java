package com.tencent.mtt.hippy.modules.nativemodules.deviceevent;

import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

/* compiled from: P */
@HippyNativeModule(init = true, name = "DeviceEventModule")
/* loaded from: classes20.dex */
public class DeviceEventModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    HippyEngine.BackPressHandler f337509a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f337510b;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes20.dex */
    public interface InvokeDefaultBackPress {
        void callSuperOnBackPress();
    }

    public DeviceEventModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337509a = null;
        this.f337510b = false;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        this.f337509a = null;
    }

    @HippyMethod(name = "invokeDefaultBackPressHandler")
    public void invokeDefaultBackPressHandler() {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.1
            @Override // java.lang.Runnable
            public void run() {
                HippyEngine.BackPressHandler backPressHandler = DeviceEventModule.this.f337509a;
                if (backPressHandler != null) {
                    backPressHandler.handleBackPress();
                }
            }
        });
    }

    public boolean onBackPressed(HippyEngine.BackPressHandler backPressHandler) {
        if (this.f337510b) {
            this.f337509a = backPressHandler;
            HippyEngineContext hippyEngineContext = this.mContext;
            if (hippyEngineContext != null && hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class) != null) {
                ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("hardwareBackPress", null);
                return true;
            }
        }
        return false;
    }

    @HippyMethod(name = "setListenBackPress")
    public void setListenBackPress(boolean z16) {
        this.f337510b = z16;
    }
}
