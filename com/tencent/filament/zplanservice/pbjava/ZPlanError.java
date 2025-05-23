package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class ZPlanError extends MessageMicro<ZPlanError> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"domain", "code", "message"}, new Object[]{"", 0, ""}, ZPlanError.class);
    public final PBStringField domain = PBField.initString("");
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
}
