package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$Merchant extends MessageMicro<RedPackSkin$Merchant> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "logo"}, new Object[]{"", ""}, RedPackSkin$Merchant.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
}
