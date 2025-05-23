package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$RetQQUserInfo extends MessageMicro<UserProxyCmdOuterClass$RetQQUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"ret", "uid", "user_info", "qq_user_id"}, new Object[]{0, 0L, null, null}, UserProxyCmdOuterClass$RetQQUserInfo.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public UserProxyCmdOuterClass$QQUserInfo user_info = new UserProxyCmdOuterClass$QQUserInfo();
    public CommonOuterClass$QQUserId qq_user_id = new CommonOuterClass$QQUserId();
}
