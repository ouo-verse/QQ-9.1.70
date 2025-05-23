package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$GetImmediateMatchFrequencyInfoReq extends MessageMicro<immediateMatch$GetImmediateMatchFrequencyInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"openid_list"}, new Object[]{""}, immediateMatch$GetImmediateMatchFrequencyInfoReq.class);
    public final PBRepeatField<String> openid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
