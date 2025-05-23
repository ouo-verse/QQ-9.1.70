package com.tencent.mobileqq.profilecommon.api;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCommonService extends IRuntimeService {
    <T extends AbsProfileCommonProcessor> T getProcessor(Class<? extends AbsProfileCommonProcessor> cls);

    void getProfileDetailForLogin();

    void notifyProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro);

    void notifyProfileModifyPushBegin(long j3);

    void notifyProfileModifyPushEnd();
}
