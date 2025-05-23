package com.tencent.mobileqq.vas.pay.api.impl.pbFile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes20.dex */
public final class midasPayCoinb$TokenInfo extends MessageMicro<midasPayCoinb$TokenInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"type", "open_id", "open_key", "connectAppid", "domainID"}, new Object[]{0, "", "", 0, 0}, midasPayCoinb$TokenInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField open_key = PBField.initString("");
    public final PBUInt32Field connectAppid = PBField.initUInt32(0);
    public final PBUInt32Field domainID = PBField.initUInt32(0);
}
