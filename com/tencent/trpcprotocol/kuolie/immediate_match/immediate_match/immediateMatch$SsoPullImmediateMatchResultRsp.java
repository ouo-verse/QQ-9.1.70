package com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class immediateMatch$SsoPullImmediateMatchResultRsp extends MessageMicro<immediateMatch$SsoPullImmediateMatchResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret_code", "ret_msg", "to_openid", "recom_trace"}, new Object[]{0, "", "", ""}, immediateMatch$SsoPullImmediateMatchResultRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBStringField to_openid = PBField.initString("");
    public final PBStringField recom_trace = PBField.initString("");
}
