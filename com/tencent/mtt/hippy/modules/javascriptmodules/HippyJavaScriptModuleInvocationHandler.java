package com.tencent.mtt.hippy.modules.javascriptmodules;

import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyJavaScriptModuleInvocationHandler implements InvocationHandler {
    private final HippyEngineContext mHippyContext;
    private final String mName;

    public HippyJavaScriptModuleInvocationHandler(HippyEngineContext hippyEngineContext, String str) {
        this.mHippyContext = hippyEngineContext;
        this.mName = str;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object hippyArray;
        if (obj instanceof HippyJavaScriptModule) {
            HippyEngine.BridgeTransferType bridgeTransferType = HippyEngine.BridgeTransferType.BRIDGE_TRANSFER_TYPE_NORMAL;
            if (objArr != null && objArr.length > 0) {
                if (objArr.length == 1) {
                    hippyArray = objArr[0];
                } else {
                    Object obj2 = objArr[objArr.length - 1];
                    if (obj2 instanceof HippyEngine.BridgeTransferType) {
                        Object[] objArr2 = new Object[objArr.length - 1];
                        System.arraycopy(objArr, 0, objArr2, 0, objArr.length - 1);
                        objArr = objArr2;
                        bridgeTransferType = (HippyEngine.BridgeTransferType) obj2;
                    }
                    hippyArray = ArgumentUtils.fromJavaArgs(objArr);
                }
            } else {
                hippyArray = new HippyArray();
            }
            HippyEngineContext hippyEngineContext = this.mHippyContext;
            if (hippyEngineContext != null && hippyEngineContext.getBridgeManager() != null) {
                this.mHippyContext.getBridgeManager().a(this.mName, method.getName(), hippyArray, bridgeTransferType);
                return null;
            }
            return null;
        }
        return null;
    }
}
