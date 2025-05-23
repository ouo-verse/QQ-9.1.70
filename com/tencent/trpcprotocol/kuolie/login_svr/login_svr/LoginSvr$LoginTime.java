package com.tencent.trpcprotocol.kuolie.login_svr.login_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class LoginSvr$LoginTime extends MessageMicro<LoginSvr$LoginTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"first_login_time", "last_login_time"}, new Object[]{0L, 0L}, LoginSvr$LoginTime.class);
    public final PBUInt64Field first_login_time = PBField.initUInt64(0);
    public final PBUInt64Field last_login_time = PBField.initUInt64(0);
}
