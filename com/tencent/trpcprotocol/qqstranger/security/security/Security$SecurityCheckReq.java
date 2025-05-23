package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$SecurityCheckReq extends MessageMicro<Security$SecurityCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"source", "security_item_ids", ReportDataBuilder.KEY_ACCOUNT_ID, "account_type"}, new Object[]{"", 0, "", 0}, Security$SecurityCheckReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBRepeatField<Integer> security_item_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField account_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
}
