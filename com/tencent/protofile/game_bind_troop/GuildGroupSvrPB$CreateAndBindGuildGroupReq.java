package com.tencent.protofile.game_bind_troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class GuildGroupSvrPB$CreateAndBindGuildGroupReq extends MessageMicro<GuildGroupSvrPB$CreateAndBindGuildGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_id", "guild_id", "group_name", "group_pic"}, new Object[]{"", "", "", ""}, GuildGroupSvrPB$CreateAndBindGuildGroupReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField group_pic = PBField.initString("");
}
