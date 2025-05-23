package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$GetImmediateMatchInfoRsp extends MessageMicro<immediateMatch$GetImmediateMatchInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"max_loading_time", "min_loading_time", "day_max", "day_used"}, new Object[]{0L, 0L, 0L, 0L}, immediateMatch$GetImmediateMatchInfoRsp.class);
    public final PBUInt64Field max_loading_time = PBField.initUInt64(0);
    public final PBUInt64Field min_loading_time = PBField.initUInt64(0);
    public final PBUInt64Field day_max = PBField.initUInt64(0);
    public final PBUInt64Field day_used = PBField.initUInt64(0);
}
