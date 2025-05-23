package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq extends MessageMicro<GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"to_openid", "to_roleid", "from_roleid"}, new Object[]{"", "", ""}, GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq.class);
    public final PBStringField to_openid = PBField.initString("");
    public final PBStringField to_roleid = PBField.initString("");
    public final PBStringField from_roleid = PBField.initString("");
}
