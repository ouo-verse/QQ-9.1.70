package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetMiniUserInfoReq extends MessageMicro<userInfo$GetMiniUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{ReportDataBuilder.KEY_ACCOUNT_ID, "account_type", "mini_info_ids", "source"}, new Object[]{"", 0, 0, 0}, userInfo$GetMiniUserInfoReq.class);
    public final PBStringField account_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBRepeatField<Integer> mini_info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBEnumField source = PBField.initEnum(0);
}
