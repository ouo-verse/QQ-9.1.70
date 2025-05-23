package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$TodayRsp extends MessageMicro<GeneralSigninPB$TodayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26}, new String[]{"bus_detail"}, new Object[]{null}, GeneralSigninPB$TodayRsp.class);
    public final PBRepeatMessageField<GeneralSigninPB$BusSigninDetailEntity> bus_detail = PBField.initRepeatMessage(GeneralSigninPB$BusSigninDetailEntity.class);
}
