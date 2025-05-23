package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardUpdate$SUpdateRsp extends MessageMicro<SummaryCardUpdate$SUpdateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58}, new String[]{"cmd", "code", "version", "url", "interv", "buff", "appname"}, new Object[]{3, 0, "", "", 0, "", ""}, SummaryCardUpdate$SUpdateRsp.class);
    public final PBEnumField cmd = PBField.initEnum(3);
    public final PBUInt32Field code = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field interv = PBField.initUInt32(0);
    public final PBStringField buff = PBField.initString("");
    public final PBStringField appname = PBField.initString("");
}
