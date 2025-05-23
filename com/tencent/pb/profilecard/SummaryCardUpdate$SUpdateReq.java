package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardUpdate$SUpdateReq extends MessageMicro<SummaryCardUpdate$SUpdateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"cmd", "uin", "version", "client_version", "platform", "appname"}, new Object[]{3, 0L, "", "4.7.0", 0, ""}, SummaryCardUpdate$SUpdateReq.class);
    public final PBEnumField cmd = PBField.initEnum(3);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField client_version = PBField.initString("4.7.0");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField appname = PBField.initString("");
}
