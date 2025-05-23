package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetSharePublicAccountListRequest extends MessageMicro<mobileqq_mp$GetSharePublicAccountListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"seqno"}, new Object[]{0}, mobileqq_mp$GetSharePublicAccountListRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
}
