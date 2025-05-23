package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$ReportUserReq extends MessageMicro<Security$ReportUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{ReportDataBuilder.KEY_ACCOUNT_ID, "account_type"}, new Object[]{"", 0}, Security$ReportUserReq.class);
    public final PBStringField account_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
}
