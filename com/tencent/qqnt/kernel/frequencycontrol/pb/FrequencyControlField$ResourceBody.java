package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$ResourceBody extends MessageMicro<FrequencyControlField$ResourceBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1773608, 1773618, 1773624, 1773634, 1773640, 1773648}, new String[]{"business_id", "sender_uid", "sender_uin", "item_id", "msg_id", "update_scope_type"}, new Object[]{0, "", 0L, "", 0L, 0}, FrequencyControlField$ResourceBody.class);
    public final PBUInt32Field business_id = PBField.initUInt32(0);
    public final PBStringField sender_uid = PBField.initString("");
    public final PBUInt64Field sender_uin = PBField.initUInt64(0);
    public final PBStringField item_id = PBField.initString("");
    public final PBInt64Field msg_id = PBField.initInt64(0);
    public final PBUInt32Field update_scope_type = PBField.initUInt32(0);
}
