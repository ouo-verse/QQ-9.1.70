package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes10.dex */
public final class CommonPayInfo$ItemInfo extends MessageMicro<CommonPayInfo$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"businessType", "itemId", "itemSubId", "buyNum", "itemExtendInfo"}, new Object[]{0, "", "", 0, ""}, CommonPayInfo$ItemInfo.class);
    public final PBInt32Field businessType = PBField.initInt32(0);
    public final PBStringField itemId = PBField.initString("");
    public final PBStringField itemSubId = PBField.initString("");
    public final PBInt32Field buyNum = PBField.initInt32(0);
    public final PBStringField itemExtendInfo = PBField.initString("");
}
