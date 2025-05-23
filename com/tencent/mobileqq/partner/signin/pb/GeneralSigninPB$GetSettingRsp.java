package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$GetSettingRsp extends MessageMicro<GeneralSigninPB$GetSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QCircleDaTongConstant.ElementParamValue.SETTINGS}, new Object[]{null}, GeneralSigninPB$GetSettingRsp.class);
    public final PBRepeatMessageField<GeneralSigninPB$Setting> settings = PBField.initRepeatMessage(GeneralSigninPB$Setting.class);
}
