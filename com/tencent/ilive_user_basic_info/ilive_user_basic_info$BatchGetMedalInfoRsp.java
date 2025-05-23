package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$BatchGetMedalInfoRsp extends MessageMicro<ilive_user_basic_info$BatchGetMedalInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"medalinfo_list", "result"}, new Object[]{null, 0}, ilive_user_basic_info$BatchGetMedalInfoRsp.class);
    public final PBRepeatMessageField<ilive_user_basic_info$MedalInfo> medalinfo_list = PBField.initRepeatMessage(ilive_user_basic_info$MedalInfo.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
