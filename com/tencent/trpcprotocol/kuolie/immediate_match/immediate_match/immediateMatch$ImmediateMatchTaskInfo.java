package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$ImmediateMatchTaskInfo extends MessageMicro<immediateMatch$ImmediateMatchTaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"description", "max_progress", "current_progress", "reward_text", "jump_type"}, new Object[]{"", 0L, 0L, "", 0}, immediateMatch$ImmediateMatchTaskInfo.class);
    public final PBStringField description = PBField.initString("");
    public final PBUInt64Field max_progress = PBField.initUInt64(0);
    public final PBUInt64Field current_progress = PBField.initUInt64(0);
    public final PBStringField reward_text = PBField.initString("");
    public final PBEnumField jump_type = PBField.initEnum(0);
}
