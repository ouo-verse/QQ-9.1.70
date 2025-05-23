package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class immediateMatch$SsoCancelImmediateMatchRsp extends MessageMicro<immediateMatch$SsoCancelImmediateMatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, immediateMatch$SsoCancelImmediateMatchRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
}
