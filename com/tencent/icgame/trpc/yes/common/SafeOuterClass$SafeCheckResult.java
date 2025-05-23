package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SafeOuterClass$SafeCheckResult extends MessageMicro<SafeOuterClass$SafeCheckResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "check_msg", "verify_url"}, new Object[]{0, "", ""}, SafeOuterClass$SafeCheckResult.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField check_msg = PBField.initString("");
    public final PBStringField verify_url = PBField.initString("");
}
