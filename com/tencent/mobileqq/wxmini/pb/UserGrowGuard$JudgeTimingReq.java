package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class UserGrowGuard$JudgeTimingReq extends MessageMicro<UserGrowGuard$JudgeTimingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"ext_info", "appid", "fact_type", "duration", "total_time"}, new Object[]{null, "", 0, 0, 0}, UserGrowGuard$JudgeTimingReq.class);
    public UserGrowGuard$CommonExt ext_info = new UserGrowGuard$CommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field fact_type = PBField.initInt32(0);
    public final PBInt32Field duration = PBField.initInt32(0);
    public final PBInt32Field total_time = PBField.initInt32(0);
}
