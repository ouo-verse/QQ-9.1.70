package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$BatchGetMedalInfoReq extends MessageMicro<ilive_user_basic_info$BatchGetMedalInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"medal_id_list"}, new Object[]{0}, ilive_user_basic_info$BatchGetMedalInfoReq.class);
    public final PBRepeatField<Integer> medal_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
