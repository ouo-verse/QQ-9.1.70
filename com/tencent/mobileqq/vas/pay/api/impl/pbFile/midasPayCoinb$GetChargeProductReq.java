package com.tencent.mobileqq.vas.pay.api.impl.pbFile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes20.dex */
public final class midasPayCoinb$GetChargeProductReq extends MessageMicro<midasPayCoinb$GetChargeProductReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"access_appid"}, new Object[]{0}, midasPayCoinb$GetChargeProductReq.class);
    public final PBInt32Field access_appid = PBField.initInt32(0);
}
