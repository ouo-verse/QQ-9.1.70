package com.tencent.icgame.user;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$UserExtraInfo extends MessageMicro<ilive_user_basic_info$UserExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56}, new String[]{"uin", "medal_info_list", "uint32_level", "uint32_point", "uint32_next_point", "uint32_pre_point", "version"}, new Object[]{0L, null, 0, 0, 0, 0, 0}, ilive_user_basic_info$UserExtraInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<ilive_user_basic_info$MedalInfo> medal_info_list = PBField.initRepeatMessage(ilive_user_basic_info$MedalInfo.class);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pre_point = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
