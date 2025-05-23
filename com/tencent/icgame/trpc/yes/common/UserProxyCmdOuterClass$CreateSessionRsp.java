package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$CreateSessionRsp extends MessageMicro<UserProxyCmdOuterClass$CreateSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"server_session", "role", "players_max", "request_id"}, new Object[]{"", "", 0, ""}, UserProxyCmdOuterClass$CreateSessionRsp.class);
    public final PBStringField server_session = PBField.initString("");
    public final PBStringField role = PBField.initString("");
    public final PBInt32Field players_max = PBField.initInt32(0);
    public final PBStringField request_id = PBField.initString("");
}
