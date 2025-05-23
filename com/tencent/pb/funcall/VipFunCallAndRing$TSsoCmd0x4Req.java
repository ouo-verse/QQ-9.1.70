package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TSsoCmd0x4Req extends MessageMicro<VipFunCallAndRing$TSsoCmd0x4Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"i32_funcall_id", "i32_ring_id", "rpt_uins"}, new Object[]{0, 0, 0L}, VipFunCallAndRing$TSsoCmd0x4Req.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public final PBRepeatField<Long> rpt_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
