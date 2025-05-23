package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetOnLineStatusReq extends MessageMicro<GameStrategyQA$GetOnLineStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"guild_id", "channel_id", "game_appid"}, new Object[]{"", "", 0}, GameStrategyQA$GetOnLineStatusReq.class);
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBUInt32Field game_appid = PBField.initUInt32(0);
}
