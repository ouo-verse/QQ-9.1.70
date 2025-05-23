package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$GetCRMMenuResponse extends MessageMicro<StructMsg$GetCRMMenuResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"ret_info", "seqno", "uin", "button_info", "update_type"}, new Object[]{null, 0, 0L, null, 0}, StructMsg$GetCRMMenuResponse.class);
    public StructMsg$RetInfo ret_info = new StructMsg$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<StructMsg$ButtonInfo> button_info = PBField.initRepeatMessage(StructMsg$ButtonInfo.class);
    public final PBUInt32Field update_type = PBField.initUInt32(0);
}
