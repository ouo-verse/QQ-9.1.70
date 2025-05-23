package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class Prompt$ReportUserReq extends MessageMicro<Prompt$ReportUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"openId", "recm_trace"}, new Object[]{"", ""}, Prompt$ReportUserReq.class);
    public final PBStringField openId = PBField.initString("");
    public final PBStringField recm_trace = PBField.initString("");
}
