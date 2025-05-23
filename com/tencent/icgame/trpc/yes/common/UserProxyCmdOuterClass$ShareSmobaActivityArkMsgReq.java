package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$ShareSmobaActivityArkMsgReq extends MessageMicro<UserProxyCmdOuterClass$ShareSmobaActivityArkMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"jump_url", "uin_list"}, new Object[]{"", 0L}, UserProxyCmdOuterClass$ShareSmobaActivityArkMsgReq.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
