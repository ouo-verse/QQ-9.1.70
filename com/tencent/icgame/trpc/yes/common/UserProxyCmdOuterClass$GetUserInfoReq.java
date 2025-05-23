package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetUserInfoReq extends MessageMicro<UserProxyCmdOuterClass$GetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "qq_user_id"}, new Object[]{0L, null}, UserProxyCmdOuterClass$GetUserInfoReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId qq_user_id = new CommonOuterClass$QQUserId();
}
