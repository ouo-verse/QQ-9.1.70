package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes18.dex */
public final class QqlogPushPb$SetLogLevelReq extends MessageMicro<QqlogPushPb$SetLogLevelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"seq", "product", "platform", "uins", "log_level", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{0, "", "", "", 0, 0L}, QqlogPushPb$SetLogLevelReq.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField uins = PBField.initString("");
    public final PBInt32Field log_level = PBField.initInt32(0);
    public final PBInt64Field expire_time = PBField.initInt64(0);
}
