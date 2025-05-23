package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class QqlogPushPb$PushCmdReq extends MessageMicro<QqlogPushPb$PushCmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"seq", "product", "platform", "uins", "cmd", "params"}, new Object[]{0, "", "", "", 0, ""}, QqlogPushPb$PushCmdReq.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField uins = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField params = PBField.initString("");
}
