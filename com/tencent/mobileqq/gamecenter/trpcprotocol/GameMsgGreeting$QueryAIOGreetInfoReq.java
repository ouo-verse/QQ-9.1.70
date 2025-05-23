package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryAIOGreetInfoReq extends MessageMicro<GameMsgGreeting$QueryAIOGreetInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"fromRoleID", "toRoleID"}, new Object[]{"", ""}, GameMsgGreeting$QueryAIOGreetInfoReq.class);
    public final PBStringField fromRoleID = PBField.initString("");
    public final PBStringField toRoleID = PBField.initString("");
}
