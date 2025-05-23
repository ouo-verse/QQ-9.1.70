package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloCyminiID extends MessageMicro<SmobaDataOuterClass$YoloCyminiID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"serverid", "roomid"}, new Object[]{0, 0L}, SmobaDataOuterClass$YoloCyminiID.class);
    public final PBInt32Field serverid = PBField.initInt32(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
}
