package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetEqqDetailInfoRequest extends MessageMicro<mobileqq_mp$GetEqqDetailInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"eqq_id", "seqno", "leqq_id", "version"}, new Object[]{0, 0, 0L, 0}, mobileqq_mp$GetEqqDetailInfoRequest.class);
    public final PBUInt32Field eqq_id = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field leqq_id = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
