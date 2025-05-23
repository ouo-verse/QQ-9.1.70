package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$TryLockWorkerReq extends MessageMicro<UserProxyCmdOuterClass$TryLockWorkerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_id", "game_id"}, new Object[]{"", ""}, UserProxyCmdOuterClass$TryLockWorkerReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField game_id = PBField.initString("");
}
