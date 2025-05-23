package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$CaptchaToken extends MessageMicro<ECQshopOrderSvr$CaptchaToken> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ticket", "rand_str"}, new Object[]{"", ""}, ECQshopOrderSvr$CaptchaToken.class);
    public final PBStringField ticket = PBField.initString("");
    public final PBStringField rand_str = PBField.initString("");
}
