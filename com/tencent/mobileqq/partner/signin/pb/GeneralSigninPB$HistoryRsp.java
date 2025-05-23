package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$HistoryRsp extends MessageMicro<GeneralSigninPB$HistoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26}, new String[]{"bus_history"}, new Object[]{null}, GeneralSigninPB$HistoryRsp.class);
    public final PBRepeatMessageField<GeneralSigninPB$BusSigninDetailEntity> bus_history = PBField.initRepeatMessage(GeneralSigninPB$BusSigninDetailEntity.class);
}
