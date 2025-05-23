package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$RetInfo extends MessageMicro<StructMsg$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0, ""}, StructMsg$RetInfo.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_info = PBField.initString("");
}
