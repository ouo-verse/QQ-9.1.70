package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.RequestAck;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface RequestOps {
    void SubmitAckRequest(RequestAck requestAck);

    void cancelAckRequest(RequestAck requestAck);
}
