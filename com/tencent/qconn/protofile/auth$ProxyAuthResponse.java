package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class auth$ProxyAuthResponse extends MessageMicro<auth$ProxyAuthResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"code", "expires_in"}, new Object[]{"", 0L}, auth$ProxyAuthResponse.class);
    public final PBStringField code = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0);
}
