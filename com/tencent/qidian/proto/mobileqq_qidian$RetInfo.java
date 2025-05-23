package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$RetInfo extends MessageMicro<mobileqq_qidian$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_ret_code", "str_error_msg"}, new Object[]{0, ""}, mobileqq_qidian$RetInfo.class);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBStringField str_error_msg = PBField.initString("");
}
