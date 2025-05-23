package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class device_lock_query_status$RspBody extends MessageMicro<device_lock_query_status$RspBody> {
    public static final int STR_WORDING_FIELD_NUMBER = 3;
    public static final int U32_RET_FIELD_NUMBER = 4;
    public static final int U32_SEQ_FIELD_NUMBER = 1;
    public static final int U32_STATUS_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"u32_seq", "u32_status", "str_wording", "u32_ret"}, new Object[]{0, 0, "", 0}, device_lock_query_status$RspBody.class);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_status = PBField.initUInt32(0);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field u32_ret = PBField.initUInt32(0);
}
