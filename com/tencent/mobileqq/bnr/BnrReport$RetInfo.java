package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$RetInfo extends MessageMicro<BnrReport$RetInfo> {
    public static final int ERR_INFO_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0L, ""}, BnrReport$RetInfo.class);
    public final PBUInt64Field ret_code = PBField.initUInt64(0);
    public final PBStringField err_info = PBField.initString("");
}
