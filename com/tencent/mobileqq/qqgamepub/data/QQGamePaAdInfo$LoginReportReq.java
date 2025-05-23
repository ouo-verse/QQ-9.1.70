package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QQGamePaAdInfo$LoginReportReq extends MessageMicro<QQGamePaAdInfo$LoginReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"deviceInfo", "uin", "gcPskey", "source"}, new Object[]{"", 0L, "", 0}, QQGamePaAdInfo$LoginReportReq.class);
    public final PBStringField deviceInfo = PBField.initString("");
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBStringField gcPskey = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(0);
}
