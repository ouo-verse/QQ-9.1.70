package com.tencent.mobileqq.transfile.proto;

import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import mqq.app.NewIntent;

/* loaded from: classes19.dex */
public interface IProtoReqStrategy {
    void updateIntent(NewIntent newIntent);

    void updateReq(ProtoReqManagerImpl.ProtoReq protoReq);
}
