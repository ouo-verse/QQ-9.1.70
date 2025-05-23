package com.tencent.trpcprotocol.gamecenter.sgame_team.sgame_team;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class SgameTeamPB$GetTeamLinkReq extends MessageMicro<SgameTeamPB$GetTeamLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"appid", "peer_openid", "peer_roleid", "self_roleid", "self_openid"}, new Object[]{0L, "", "", "", ""}, SgameTeamPB$GetTeamLinkReq.class);
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBStringField peer_openid = PBField.initString("");
    public final PBStringField peer_roleid = PBField.initString("");
    public final PBStringField self_roleid = PBField.initString("");
    public final PBStringField self_openid = PBField.initString("");
}
