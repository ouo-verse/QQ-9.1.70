package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$Business extends MessageMicro<ClientPerformance$Business> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app", "token"}, new Object[]{0, ""}, ClientPerformance$Business.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField token = PBField.initString("");
}
