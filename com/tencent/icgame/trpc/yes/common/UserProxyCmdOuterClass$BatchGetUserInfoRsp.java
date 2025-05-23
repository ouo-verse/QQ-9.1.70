package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$BatchGetUserInfoRsp extends MessageMicro<UserProxyCmdOuterClass$BatchGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ret_user_info_list"}, new Object[]{null}, UserProxyCmdOuterClass$BatchGetUserInfoRsp.class);
    public final PBRepeatMessageField<UserProxyCmdOuterClass$RetQQUserInfo> ret_user_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$RetQQUserInfo.class);
}
