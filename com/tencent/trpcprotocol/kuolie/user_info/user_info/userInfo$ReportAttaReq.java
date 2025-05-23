package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$ReportAttaReq extends MessageMicro<userInfo$ReportAttaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"atta_id", "token", "fields", "escape"}, new Object[]{"", "", "", Boolean.FALSE}, userInfo$ReportAttaReq.class);
    public final PBStringField atta_id = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBRepeatField<String> fields = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField escape = PBField.initBool(false);
}
