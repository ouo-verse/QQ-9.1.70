package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$SendMenuEventResponse extends MessageMicro<StructMsg$SendMenuEventResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret_info", "seqno"}, new Object[]{null, 0}, StructMsg$SendMenuEventResponse.class);
    public StructMsg$RetInfo ret_info = new StructMsg$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
}
