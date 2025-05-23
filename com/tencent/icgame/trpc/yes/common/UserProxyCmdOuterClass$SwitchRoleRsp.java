package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$SwitchRoleRsp extends MessageMicro<UserProxyCmdOuterClass$SwitchRoleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"request_id"}, new Object[]{""}, UserProxyCmdOuterClass$SwitchRoleRsp.class);
    public final PBStringField request_id = PBField.initString("");
}
