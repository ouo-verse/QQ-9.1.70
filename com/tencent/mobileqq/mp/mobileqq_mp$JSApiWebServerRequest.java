package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$JSApiWebServerRequest extends MessageMicro<mobileqq_mp$JSApiWebServerRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"versionInfo", "cmd", "body"}, new Object[]{"", 0, ""}, mobileqq_mp$JSApiWebServerRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField body = PBField.initString("");
}
