package com.tencent.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class group_activity_info$RspBody extends MessageMicro<group_activity_info$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"error_code", "group_code", "info_list"}, new Object[]{0, 0L, null}, group_activity_info$RspBody.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<group_activity_info$GroupActInfo> info_list = PBField.initRepeatMessage(group_activity_info$GroupActInfo.class);
}
