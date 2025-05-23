package com.tencent.mobileqq.vas.unilog;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class UniLogServer$ReportReq extends MessageMicro<UniLogServer$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"source", "action", "ret", "msg"}, new Object[]{0, 0, 0, ""}, UniLogServer$ReportReq.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f311143msg = PBField.initString("");
}
