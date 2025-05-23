package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetArkInfoReq extends MessageMicro<userInfo$GetArkInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{ReportDataBuilder.KEY_ACCOUNT_ID, "account_type", "self_account_id"}, new Object[]{"", 0, ""}, userInfo$GetArkInfoReq.class);
    public final PBStringField account_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBStringField self_account_id = PBField.initString("");
}
