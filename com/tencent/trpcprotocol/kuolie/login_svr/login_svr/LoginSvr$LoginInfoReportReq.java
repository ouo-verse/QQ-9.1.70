package com.tencent.trpcprotocol.kuolie.login_svr.login_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class LoginSvr$LoginInfoReportReq extends MessageMicro<LoginSvr$LoginInfoReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"login_source", "sub_source"}, new Object[]{0, 0}, LoginSvr$LoginInfoReportReq.class);
    public final PBEnumField login_source = PBField.initEnum(0);
    public final PBInt32Field sub_source = PBField.initInt32(0);
}
