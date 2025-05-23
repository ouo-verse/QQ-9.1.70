package com.tencent.trpcprotocol.kuolie.login_svr.login_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class LoginSvr$GetLoginTimeStampReq extends MessageMicro<LoginSvr$GetLoginTimeStampReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_ids"}, new Object[]{""}, LoginSvr$GetLoginTimeStampReq.class);
    public final PBRepeatField<String> open_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
