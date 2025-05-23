package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class COMM$Result extends MessageMicro<COMM$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", "msg"}, new Object[]{0, ""}, COMM$Result.class);
    public final PBInt32Field retCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105223msg = PBField.initString("");
}
