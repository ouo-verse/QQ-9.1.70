package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class COMM$User extends MessageMicro<COMM$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "appid", "openid"}, new Object[]{0, "", ""}, COMM$User.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
}
