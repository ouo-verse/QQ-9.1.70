package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes6.dex */
public final class CoupleActionChannel$PlayCoupleActionReq extends MessageMicro<CoupleActionChannel$PlayCoupleActionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"action_id"}, new Object[]{0}, CoupleActionChannel$PlayCoupleActionReq.class);
    public final PBUInt32Field action_id = PBField.initUInt32(0);
}
