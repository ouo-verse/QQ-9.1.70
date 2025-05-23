package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class mobileqq_bmqq$RetInfo extends MessageMicro<mobileqq_bmqq$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_ret_code", "err_info"}, new Object[]{0, ""}, mobileqq_bmqq$RetInfo.class);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBStringField err_info = PBField.initString("");
}
