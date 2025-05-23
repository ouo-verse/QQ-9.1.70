package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$GetCrmQQMenuRequest extends MessageMicro<StructMsg$GetCrmQQMenuRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"seqno", "uin"}, new Object[]{0, 0L}, StructMsg$GetCrmQQMenuRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
