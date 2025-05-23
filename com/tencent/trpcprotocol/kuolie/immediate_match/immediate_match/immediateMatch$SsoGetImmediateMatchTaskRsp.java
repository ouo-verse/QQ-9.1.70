package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$SsoGetImmediateMatchTaskRsp extends MessageMicro<immediateMatch$SsoGetImmediateMatchTaskRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"ret_code", "ret_msg", "day_max_match_count", "day_lave_match_count", "task_infos"}, new Object[]{0, "", 0L, 0L, null}, immediateMatch$SsoGetImmediateMatchTaskRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt64Field day_max_match_count = PBField.initUInt64(0);
    public final PBUInt64Field day_lave_match_count = PBField.initUInt64(0);
    public final PBRepeatMessageField<immediateMatch$ImmediateMatchTaskInfo> task_infos = PBField.initRepeatMessage(immediateMatch$ImmediateMatchTaskInfo.class);
}
