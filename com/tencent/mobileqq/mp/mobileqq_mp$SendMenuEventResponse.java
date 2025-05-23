package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SendMenuEventResponse extends MessageMicro<mobileqq_mp$SendMenuEventResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret_info", "seqno"}, new Object[]{null, 0}, mobileqq_mp$SendMenuEventResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
}
