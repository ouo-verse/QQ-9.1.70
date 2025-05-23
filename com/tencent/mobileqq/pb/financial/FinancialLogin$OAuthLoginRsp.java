package com.tencent.mobileqq.pb.financial;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class FinancialLogin$OAuthLoginRsp extends MessageMicro<FinancialLogin$OAuthLoginRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"retcode", "retmsg", "cookie"}, new Object[]{0L, "", null}, FinancialLogin$OAuthLoginRsp.class);
    public final PBUInt64Field retcode = PBField.initUInt64(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBRepeatMessageField<FinancialLogin$Cookie> cookie = PBField.initRepeatMessage(FinancialLogin$Cookie.class);
}
