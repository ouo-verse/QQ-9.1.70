package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$BatchGetUserInfoReq extends MessageMicro<ilive_user_basic_info$BatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin_list", "op_type", "from_type"}, new Object[]{0L, 0, 0}, ilive_user_basic_info$BatchGetUserInfoReq.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field op_type = PBField.initUInt32(0);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
}
