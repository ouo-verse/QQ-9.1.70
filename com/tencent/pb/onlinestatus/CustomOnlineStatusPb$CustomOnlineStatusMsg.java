package com.tencent.pb.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CustomOnlineStatusPb$CustomOnlineStatusMsg extends MessageMicro<CustomOnlineStatusPb$CustomOnlineStatusMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uHasCustomInfo", "sCustomDesc", "sCustomModel", "uUpdateInterval"}, new Object[]{0, "", "", 0}, CustomOnlineStatusPb$CustomOnlineStatusMsg.class);
    public final PBUInt32Field uHasCustomInfo = PBField.initUInt32(0);
    public final PBStringField sCustomDesc = PBField.initString("");
    public final PBStringField sCustomModel = PBField.initString("");
    public final PBUInt32Field uUpdateInterval = PBField.initUInt32(0);
}
