package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class QSecControlBitsQuery$QSecCbResp extends MessageMicro<QSecControlBitsQuery$QSecCbResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"u32_status", "u32_time_interval", "str_cbstr", "str_extra"}, new Object[]{0, 0, "", ""}, QSecControlBitsQuery$QSecCbResp.class);
    public final PBUInt32Field u32_status = PBField.initUInt32(0);
    public final PBUInt32Field u32_time_interval = PBField.initUInt32(0);
    public final PBStringField str_cbstr = PBField.initString("");
    public final PBStringField str_extra = PBField.initString("");
}
