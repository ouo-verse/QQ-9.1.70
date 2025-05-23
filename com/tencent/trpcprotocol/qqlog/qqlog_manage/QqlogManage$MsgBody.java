package com.tencent.trpcprotocol.qqlog.qqlog_manage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QqlogManage$MsgBody extends MessageMicro<QqlogManage$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98}, new String[]{"cmd", "seq", "log_tag", "start_time", "end_time", "log_size", "log_field", "platform", "product", "log_level", "log_level_expire_time", "params"}, new Object[]{0, 0L, "", 0L, 0L, 0, 0, 0, 0, 0, 0L, null}, QqlogManage$MsgBody.class);
    public final PBEnumField cmd = PBField.initEnum(0);
    public final PBInt64Field seq = PBField.initInt64(0);
    public final PBStringField log_tag = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBUInt32Field log_size = PBField.initUInt32(0);
    public final PBUInt32Field log_field = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field product = PBField.initUInt32(0);
    public final PBEnumField log_level = PBField.initEnum(0);
    public final PBInt64Field log_level_expire_time = PBField.initInt64(0);
    public final PBRepeatMessageField<QqlogManage$Param> params = PBField.initRepeatMessage(QqlogManage$Param.class);
}
