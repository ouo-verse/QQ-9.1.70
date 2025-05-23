package com.tencent.trpcprotocol.kuolie.login_svr.login_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class LoginSvr$GetLoginTimeStampRsp extends MessageMicro<LoginSvr$GetLoginTimeStampRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "time_stamps"}, new Object[]{0, "", null}, LoginSvr$GetLoginTimeStampRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<LoginSvr$LoginTime> time_stamps = PBField.initRepeatMessage(LoginSvr$LoginTime.class);
}
