package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterArkMsgSenderSvr$GameMsgRoles extends MessageMicro<GameCenterArkMsgSenderSvr$GameMsgRoles> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"from_role_id", "to_role_id", "from_nick"}, new Object[]{"", "", ""}, GameCenterArkMsgSenderSvr$GameMsgRoles.class);
    public final PBStringField from_role_id = PBField.initString("");
    public final PBStringField to_role_id = PBField.initString("");
    public final PBStringField from_nick = PBField.initString("");
}
