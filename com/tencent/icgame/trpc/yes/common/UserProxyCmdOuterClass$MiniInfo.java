package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$MiniInfo extends MessageMicro<UserProxyCmdOuterClass$MiniInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42}, new String[]{"base_info", "avatar", "long_nick"}, new Object[]{null, "", ""}, UserProxyCmdOuterClass$MiniInfo.class);
    public UserProxyCmdOuterClass$BaseInfo base_info = new UserProxyCmdOuterClass$BaseInfo();
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField long_nick = PBField.initString("");
}
