package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class SafeOuterClass$QQAvReportProofReq extends MessageMicro<SafeOuterClass$QQAvReportProofReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "content_id", "eviluin"}, new Object[]{0L, 0L, 0L}, SafeOuterClass$QQAvReportProofReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field content_id = PBField.initUInt64(0);
    public final PBUInt64Field eviluin = PBField.initUInt64(0);
}
