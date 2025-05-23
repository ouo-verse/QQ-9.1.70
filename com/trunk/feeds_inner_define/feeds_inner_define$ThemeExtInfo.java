package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds_inner_define$ThemeExtInfo extends MessageMicro<feeds_inner_define$ThemeExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"rpt_talker_uins", "uint64_open_uin", "uint32_msg_count"}, new Object[]{0L, 0L, 0}, feeds_inner_define$ThemeExtInfo.class);
    public final PBRepeatField<Long> rpt_talker_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_count = PBField.initUInt32(0);
}
