package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp extends MessageMicro<GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK}, new Object[]{""}, GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp.class);
    public final PBStringField link = PBField.initString("");
}
