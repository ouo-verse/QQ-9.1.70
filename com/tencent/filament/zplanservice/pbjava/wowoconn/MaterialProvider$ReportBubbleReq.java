package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class MaterialProvider$ReportBubbleReq extends MessageMicro<MaterialProvider$ReportBubbleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 40}, new String[]{"friend_uin", "bubble_token", "relationship_type", "relationship_value"}, new Object[]{0L, 0, 0, 0L}, MaterialProvider$ReportBubbleReq.class);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBInt32Field bubble_token = PBField.initInt32(0);
    public final PBEnumField relationship_type = PBField.initEnum(0);
    public final PBUInt64Field relationship_value = PBField.initUInt64(0);
}
