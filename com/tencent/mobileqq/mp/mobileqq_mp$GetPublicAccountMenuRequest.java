package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetPublicAccountMenuRequest extends MessageMicro<mobileqq_mp$GetPublicAccountMenuRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"seqno", "uin", "luin"}, new Object[]{0, 0, 0L}, mobileqq_mp$GetPublicAccountMenuRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
}
