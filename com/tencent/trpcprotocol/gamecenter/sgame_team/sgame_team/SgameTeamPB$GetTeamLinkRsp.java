package com.tencent.trpcprotocol.gamecenter.sgame_team.sgame_team;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class SgameTeamPB$GetTeamLinkRsp extends MessageMicro<SgameTeamPB$GetTeamLinkRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"team_url"}, new Object[]{""}, SgameTeamPB$GetTeamLinkRsp.class);
    public final PBStringField team_url = PBField.initString("");
}
