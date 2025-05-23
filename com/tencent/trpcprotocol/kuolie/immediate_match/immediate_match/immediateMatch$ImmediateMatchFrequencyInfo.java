package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$ImmediateMatchFrequencyInfo extends MessageMicro<immediateMatch$ImmediateMatchFrequencyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"openid", "day_max", "day_used"}, new Object[]{"", 0L, 0L}, immediateMatch$ImmediateMatchFrequencyInfo.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field day_max = PBField.initUInt64(0);
    public final PBUInt64Field day_used = PBField.initUInt64(0);
}
