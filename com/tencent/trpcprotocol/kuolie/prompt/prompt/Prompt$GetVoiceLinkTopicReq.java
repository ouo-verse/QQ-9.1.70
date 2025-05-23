package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class Prompt$GetVoiceLinkTopicReq extends MessageMicro<Prompt$GetVoiceLinkTopicReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{ReportDataBuilder.KEY_ACCOUNT_ID, "account_type", "self_account_id"}, new Object[]{"", 0, ""}, Prompt$GetVoiceLinkTopicReq.class);
    public final PBStringField account_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBStringField self_account_id = PBField.initString("");
}
