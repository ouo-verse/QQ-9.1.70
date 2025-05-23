package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$BatchGetUserInfoReq extends MessageMicro<QqstrangerUserInfoPB$BatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{ReportDataBuilder.KEY_ACCOUNT_ID, "account_type", "info_ids", "source"}, new Object[]{"", 0, 0, 0}, QqstrangerUserInfoPB$BatchGetUserInfoReq.class);
    public final PBRepeatField<String> account_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBRepeatField<Integer> info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBEnumField source = PBField.initEnum(0);
}
