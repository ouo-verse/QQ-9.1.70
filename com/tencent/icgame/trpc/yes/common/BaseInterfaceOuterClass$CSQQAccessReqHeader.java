package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class BaseInterfaceOuterClass$CSQQAccessReqHeader extends MessageMicro<BaseInterfaceOuterClass$CSQQAccessReqHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"cmd", "seq", "lock_key"}, new Object[]{0, 0L, ""}, BaseInterfaceOuterClass$CSQQAccessReqHeader.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBStringField lock_key = PBField.initString("");
}
