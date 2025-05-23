package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$TodayReq extends MessageMicro<GeneralSigninPB$TodayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bus_id", "target", "sub_bus_id", "source", "need_settings"}, new Object[]{"", "", "", "", ""}, GeneralSigninPB$TodayReq.class);
    public final PBRepeatField<String> need_settings;
    public final PBStringField source;
    public final PBRepeatField<String> sub_bus_id;
    public final PBStringField bus_id = PBField.initString("");
    public final PBStringField target = PBField.initString("");

    public GeneralSigninPB$TodayReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.sub_bus_id = PBField.initRepeat(pBStringField);
        this.source = PBField.initString("");
        this.need_settings = PBField.initRepeat(pBStringField);
    }
}
