package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class RemindPB$ReqBody extends MessageMicro<RemindPB$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_method", "rep_set_info", "rep_clear_uin"}, new Object[]{0, null, 0L}, RemindPB$ReqBody.class);
    public final PBUInt32Field uint32_method = PBField.initUInt32(0);
    public final PBRepeatMessageField<RemindPB$RemindItem> rep_set_info = PBField.initRepeatMessage(RemindPB$RemindItem.class);
    public final PBRepeatField<Long> rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
