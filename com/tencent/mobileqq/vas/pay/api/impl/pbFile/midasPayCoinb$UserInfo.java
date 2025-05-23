package com.tencent.mobileqq.vas.pay.api.impl.pbFile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes20.dex */
public final class midasPayCoinb$UserInfo extends MessageMicro<midasPayCoinb$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"token", "platform", "account_type"}, new Object[]{null, 0, 0}, midasPayCoinb$UserInfo.class);
    public midasPayCoinb$TokenInfo token = new midasPayCoinb$TokenInfo();
    public final PBEnumField platform = PBField.initEnum(0);
    public final PBInt32Field account_type = PBField.initInt32(0);
}
