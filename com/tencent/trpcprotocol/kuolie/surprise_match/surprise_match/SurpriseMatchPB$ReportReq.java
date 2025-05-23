package com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class SurpriseMatchPB$ReportReq extends MessageMicro<SurpriseMatchPB$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"cookies", "operation_type"}, new Object[]{"", 0}, SurpriseMatchPB$ReportReq.class);
    public final PBStringField cookies = PBField.initString("");
    public final PBEnumField operation_type = PBField.initEnum(0);
}
