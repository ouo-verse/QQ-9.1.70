package org.light.aigc.net;

import org.light.aigc.bean.AIGCRequest;

/* loaded from: classes29.dex */
public interface ISSOProvider {
    void sendRequest(AIGCRequest aIGCRequest, IGenerateCallback iGenerateCallback);
}
