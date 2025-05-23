package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$ButtonInfo extends MessageMicro<PayGatewayProto$ButtonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "url"}, new Object[]{"", ""}, PayGatewayProto$ButtonInfo.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
