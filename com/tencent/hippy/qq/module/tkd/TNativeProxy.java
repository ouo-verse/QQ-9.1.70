package com.tencent.hippy.qq.module.tkd;

import com.tencent.hippy.qq.api.INativeProxy;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes7.dex */
public class TNativeProxy implements INativeProxy {
    private final Map<String, TJsCallBack> mjsCallbacks = new HashMap();

    @NotNull
    private String getMethodKey(String str, String str2) {
        return str + str2;
    }

    @Override // com.tencent.hippy.qq.api.INativeProxy
    public void callNativeMethod(String str, String str2, Object obj, Object obj2) {
        if ((obj instanceof HippyMap) && (obj2 instanceof Promise)) {
            callNativeMethodInternal(str, str2, (HippyMap) obj, (Promise) obj2);
        }
    }

    void callNativeMethodInternal(String str, String str2, HippyMap hippyMap, Promise promise) {
        TJsCallBack tJsCallBack = this.mjsCallbacks.get(getMethodKey(str, str2));
        if (tJsCallBack != null) {
            tJsCallBack.onCallBack(hippyMap, promise);
            return;
        }
        if (promise != null) {
            promise.reject("there is no " + str + " native function " + str2);
        }
    }

    @Override // com.tencent.hippy.qq.api.INativeProxy
    public void registerNativeMethod(String str, String str2, Object obj) {
        if (obj instanceof TJsCallBack) {
            registerNativeMethodInternal(str, str2, (TJsCallBack) obj);
        }
    }

    public void registerNativeMethodInternal(String str, String str2, TJsCallBack tJsCallBack) {
        this.mjsCallbacks.put(getMethodKey(str, str2), tJsCallBack);
    }

    @Override // com.tencent.hippy.qq.api.INativeProxy
    public void unRegisterNativeMethod(String str, String str2) {
        this.mjsCallbacks.remove(getMethodKey(str, str2));
    }
}
