package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$ChangeOnLineStatusReq extends MessageMicro<GameStrategyQA$ChangeOnLineStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"guild_id", "channel_id", "game_appid", "is_online"}, new Object[]{"", "", 0, Boolean.FALSE}, GameStrategyQA$ChangeOnLineStatusReq.class);
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBUInt32Field game_appid = PBField.initUInt32(0);
    public final PBBoolField is_online = PBField.initBool(false);
}
