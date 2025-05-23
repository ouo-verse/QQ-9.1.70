package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetUserEqqListRequest extends MessageMicro<mobileqq_mp$GetUserEqqListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"begin", "limit", "seqno", "version"}, new Object[]{0, 0, 0, 0}, mobileqq_mp$GetUserEqqListRequest.class);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
