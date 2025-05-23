package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$SendPublicAccountMessageReceiptRequest extends MessageMicro<mobileqq_mp$SendPublicAccountMessageReceiptRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_unique_id", "uint32_op", "pcuin", "cuin", "receipt_type", "unique_ids"}, new Object[]{0L, 0L, 0L, 0L, 0, 0L}, mobileqq_mp$SendPublicAccountMessageReceiptRequest.class);
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0);
    public final PBUInt64Field uint32_op = PBField.initUInt64(0);
    public final PBUInt64Field pcuin = PBField.initUInt64(0);
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBUInt32Field receipt_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> unique_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
