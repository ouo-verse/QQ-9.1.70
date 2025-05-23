package com.tencent.mtt.hippy.modules;

import com.tencent.mtt.hippy.HippyEngine;

/* loaded from: classes20.dex */
public interface Promise {
    String getCallId();

    boolean isCallback();

    void reject(Object obj);

    void resolve(Object obj);

    void setTransferType(HippyEngine.BridgeTransferType bridgeTransferType);
}
