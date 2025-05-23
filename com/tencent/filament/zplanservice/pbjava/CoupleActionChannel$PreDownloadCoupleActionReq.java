package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes6.dex */
public final class CoupleActionChannel$PreDownloadCoupleActionReq extends MessageMicro<CoupleActionChannel$PreDownloadCoupleActionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"action_ids"}, new Object[]{0}, CoupleActionChannel$PreDownloadCoupleActionReq.class);
    public final PBRepeatField<Integer> action_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
