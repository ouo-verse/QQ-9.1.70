package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SetSettingReq extends MessageMicro<GeneralSigninPB$SetSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 50}, new String[]{"bus_id", "target", "sub_bus_id", "source", QCircleDaTongConstant.ElementParamValue.SETTINGS}, new Object[]{"", "", "", "", null}, GeneralSigninPB$SetSettingReq.class);
    public final PBStringField bus_id = PBField.initString("");
    public final PBStringField target = PBField.initString("");
    public final PBStringField sub_bus_id = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBRepeatMessageField<GeneralSigninPB$SettingEntity> settings = PBField.initRepeatMessage(GeneralSigninPB$SettingEntity.class);
}
