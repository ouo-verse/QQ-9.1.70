package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$AioKeyword extends MessageMicro<oidb_0x496$AioKeyword> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"keywords", "rules", "version"}, new Object[]{null, null, 0}, oidb_0x496$AioKeyword.class);
    public final PBRepeatMessageField<oidb_0x496$AioKeywordInfo> keywords = PBField.initRepeatMessage(oidb_0x496$AioKeywordInfo.class);
    public final PBRepeatMessageField<oidb_0x496$AioKeywordRuleInfo> rules = PBField.initRepeatMessage(oidb_0x496$AioKeywordRuleInfo.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
