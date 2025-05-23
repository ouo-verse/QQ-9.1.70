package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$SendArkMsgRsp extends MessageMicro<UserProxyCmdOuterClass$SendArkMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"err_msg"}, new Object[]{""}, UserProxyCmdOuterClass$SendArkMsgRsp.class);
    public final PBRepeatField<String> err_msg = PBField.initRepeat(PBStringField.__repeatHelper__);
}
