package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetPublicAccountDetailInfoRequest extends MessageMicro<mobileqq_mp$GetPublicAccountDetailInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"seqno", "uin", "luin", "version", "versionInfo"}, new Object[]{0, 0, 0L, 0, ""}, mobileqq_mp$GetPublicAccountDetailInfoRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
}
