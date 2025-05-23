package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class device_lock_query_status$ReqBody extends MessageMicro<device_lock_query_status$ReqBody> {
    public static final int U32_APP_ID_FIELD_NUMBER = 3;
    public static final int U32_SEQ_FIELD_NUMBER = 1;
    public static final int U32_SYS_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"u32_seq", "u32_sys_type", "u32_app_id"}, new Object[]{0, 0, 0}, device_lock_query_status$ReqBody.class);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_sys_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_app_id = PBField.initUInt32(0);
}
