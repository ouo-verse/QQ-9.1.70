package com.tencent.protofile.game_bind_troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class GuildGroupSvrPB$CreateAndBindGuildGroupRsp extends MessageMicro<GuildGroupSvrPB$CreateAndBindGuildGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ret", "group_code"}, new Object[]{0L, 0L}, GuildGroupSvrPB$CreateAndBindGuildGroupRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
