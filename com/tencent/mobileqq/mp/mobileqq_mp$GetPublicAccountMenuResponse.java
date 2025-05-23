package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetPublicAccountMenuResponse extends MessageMicro<mobileqq_mp$GetPublicAccountMenuResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64}, new String[]{"ret_info", "seqno", "uin", "button_info", "update_type", "luin", "update_internal", "menu_type"}, new Object[]{null, 0, 0, null, 0, 0L, 0, 0}, mobileqq_mp$GetPublicAccountMenuResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$ButtonInfo> button_info = PBField.initRepeatMessage(mobileqq_mp$ButtonInfo.class);
    public final PBUInt32Field update_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field update_internal = PBField.initUInt32(0);
    public final PBUInt32Field menu_type = PBField.initUInt32(0);
}
