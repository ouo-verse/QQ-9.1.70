package com.tencent.mtt.hippy.modules.javascriptmodules;

import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface EventDispatcher extends HippyJavaScriptModule {
    void receiveNativeEvent(String str, Object obj);

    void receiveNativeEvent(String str, Object obj, HippyEngine.BridgeTransferType bridgeTransferType);

    void receiveNativeGesture(HippyMap hippyMap);

    void receiveNativeGesture(HippyMap hippyMap, HippyEngine.BridgeTransferType bridgeTransferType);

    void receiveUIComponentEvent(int i3, String str, Object obj);

    void receiveUIComponentEvent(int i3, String str, Object obj, HippyEngine.BridgeTransferType bridgeTransferType);
}
