package com.tencent.protofile.game_bind_troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class GuildGroupSvrPB$QueryGuildGroupInfoReq extends MessageMicro<GuildGroupSvrPB$QueryGuildGroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app_id", "guild_id"}, new Object[]{0, ""}, GuildGroupSvrPB$QueryGuildGroupInfoReq.class);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBStringField guild_id = PBField.initString("");
}
