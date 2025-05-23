package org.light.aigc.net;

import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;

/* loaded from: classes29.dex */
public interface ISSOPBTransformer<REQ, RESP> {
    REQ transToRequestPb(AIGCRequest aIGCRequest);

    AIGCContentOutput transToResponsePb(RESP resp);
}
