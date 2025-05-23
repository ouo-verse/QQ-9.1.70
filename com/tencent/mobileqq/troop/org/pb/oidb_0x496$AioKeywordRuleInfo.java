package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$AioKeywordRuleInfo extends MessageMicro<oidb_0x496$AioKeywordRuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"rule_id", "start_time", "end_time", "postion_flag", "match_group_class", "version"}, new Object[]{0, 0, 0, 0, 0, 0}, oidb_0x496$AioKeywordRuleInfo.class);
    public final PBUInt32Field rule_id = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBUInt32Field postion_flag = PBField.initUInt32(0);
    public final PBRepeatField<Integer> match_group_class = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
