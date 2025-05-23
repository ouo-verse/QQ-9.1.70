package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$BatchGetUserInfoReq extends MessageMicro<UserProxyCmdOuterClass$BatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid_list", "qq_user_id_list"}, new Object[]{0L, null}, UserProxyCmdOuterClass$BatchGetUserInfoReq.class);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> qq_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
}
