package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetStarListReq extends MessageMicro<GameStrategyQA$GetStarListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"guild_id", "channel_id", "game_appid", "page", WidgetCacheConstellationData.NUM}, new Object[]{"", "", 0, 0, 0}, GameStrategyQA$GetStarListReq.class);
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBUInt32Field game_appid = PBField.initUInt32(0);
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
}
