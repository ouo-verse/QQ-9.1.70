package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$GetImmediateMatchFrequencyInfoRsp extends MessageMicro<immediateMatch$GetImmediateMatchFrequencyInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "result"}, new Object[]{0, "", null}, immediateMatch$GetImmediateMatchFrequencyInfoRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<immediateMatch$ImmediateMatchFrequencyInfo> result = PBField.initRepeatMessage(immediateMatch$ImmediateMatchFrequencyInfo.class);
}
