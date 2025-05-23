package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$HistoryReq extends MessageMicro<GeneralSigninPB$HistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"bus_id", "target", "sub_bus_id", "start_date", "end_date", "need_detail", "source"}, new Object[]{"", "", "", "", "", Boolean.FALSE, ""}, GeneralSigninPB$HistoryReq.class);
    public final PBStringField bus_id = PBField.initString("");
    public final PBStringField target = PBField.initString("");
    public final PBRepeatField<String> sub_bus_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField start_date = PBField.initString("");
    public final PBStringField end_date = PBField.initString("");
    public final PBBoolField need_detail = PBField.initBool(false);
    public final PBStringField source = PBField.initString("");
}
