package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$SendPreMessageStatusRequest extends MessageMicro<mobileqq_mp$SendPreMessageStatusRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"luin", "uint64_unique_id"}, new Object[]{0L, 0L}, mobileqq_mp$SendPreMessageStatusRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0);
}
