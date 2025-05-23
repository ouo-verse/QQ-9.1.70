package com.tencent.mobileqq.pb.financial;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class FinancialLogin$Cookie extends MessageMicro<FinancialLogin$Cookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"name", "value", "is_http_only", "domain", "path", "expires"}, new Object[]{"", "", Boolean.FALSE, "", "", 0L}, FinancialLogin$Cookie.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField value = PBField.initString("");
    public final PBBoolField is_http_only = PBField.initBool(false);
    public final PBStringField domain = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBInt64Field expires = PBField.initInt64(0);
}
