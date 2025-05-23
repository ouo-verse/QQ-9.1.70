package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$NearbyMiniCardReq extends MessageMicro<NowSummaryCard$NearbyMiniCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"target_id", "id_type"}, new Object[]{0L, 0}, NowSummaryCard$NearbyMiniCardReq.class);
    public final PBRepeatField<Long> target_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
}
