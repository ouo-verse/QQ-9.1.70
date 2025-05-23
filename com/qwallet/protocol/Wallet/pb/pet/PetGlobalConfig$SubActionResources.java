package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$SubActionResources extends MessageMicro<PetGlobalConfig$SubActionResources> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"sub_action_type", QCircleLpReportDc05502.KEY_BEGIN_TIME, "sub_action_resource", "next_sub_action_types", "end_time", "elapse_animation_time"}, new Object[]{"", 0, "", "", 0, 0}, PetGlobalConfig$SubActionResources.class);
    public final PBStringField sub_action_type = PBField.initString("");
    public final PBInt32Field begin_time = PBField.initInt32(0);
    public final PBStringField sub_action_resource = PBField.initString("");
    public final PBRepeatField<String> next_sub_action_types = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field end_time = PBField.initInt32(0);
    public final PBInt32Field elapse_animation_time = PBField.initInt32(0);
}
