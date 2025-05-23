package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$SsoJoinImmediateMatchQueueRsp extends MessageMicro<immediateMatch$SsoJoinImmediateMatchQueueRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"ret_code", "ret_msg", "loading_gap", "loading_max_count"}, new Object[]{0, "", 0, 0}, immediateMatch$SsoJoinImmediateMatchQueueRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt32Field loading_gap = PBField.initUInt32(0);
    public final PBUInt32Field loading_max_count = PBField.initUInt32(0);
}
