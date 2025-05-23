package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$AioKeywordInfo extends MessageMicro<oidb_0x496$AioKeywordInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"word", "rule_id"}, new Object[]{"", 0}, oidb_0x496$AioKeywordInfo.class);
    public final PBStringField word = PBField.initString("");
    public final PBRepeatField<Integer> rule_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
