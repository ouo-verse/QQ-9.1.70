package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetSessionInfoReq extends MessageMicro<UserProxyCmdOuterClass$GetSessionInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", "from_qq_user_id", "to_qq_user_id"}, new Object[]{0L, 0L, null, null}, UserProxyCmdOuterClass$GetSessionInfoReq.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId from_qq_user_id = new CommonOuterClass$QQUserId();
    public CommonOuterClass$QQUserId to_qq_user_id = new CommonOuterClass$QQUserId();
}
