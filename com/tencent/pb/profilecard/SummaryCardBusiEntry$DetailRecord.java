package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$DetailRecord extends MessageMicro<SummaryCardBusiEntry$DetailRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"fuin", "source", "vtime", "mod", "hideFlag"}, new Object[]{0, 0, 0, 0, 0}, SummaryCardBusiEntry$DetailRecord.class);
    public final PBUInt32Field fuin = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field vtime = PBField.initUInt32(0);
    public final PBInt32Field mod = PBField.initInt32(0);
    public final PBInt32Field hideFlag = PBField.initInt32(0);
}
