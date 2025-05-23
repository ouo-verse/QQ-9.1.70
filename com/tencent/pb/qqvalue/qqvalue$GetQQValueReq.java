package com.tencent.pb.qqvalue;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqvalue$GetQQValueReq extends MessageMicro<qqvalue$GetQQValueReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "ext_info"}, new Object[]{0L, null}, qqvalue$GetQQValueReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBRepeatMessageField<ExtInfo> ext_info = PBField.initRepeatMessage(ExtInfo.class);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class ExtInfo extends MessageMicro<ExtInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ExtInfo.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }
}
