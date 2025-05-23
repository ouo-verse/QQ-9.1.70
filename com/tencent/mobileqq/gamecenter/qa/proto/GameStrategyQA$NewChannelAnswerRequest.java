package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewChannelAnswerRequest extends MessageMicro<GameStrategyQA$NewChannelAnswerRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 64, 74}, new String[]{"appid", "question_id", "content", c.PICS, "source", "guild_id", "channel_id", "ark_random", "videos"}, new Object[]{0, 0L, "", null, 0, 0L, 0L, 0L, null}, GameStrategyQA$NewChannelAnswerRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField content = PBField.initString("");
    public GameStrategyQA$Pics pics = new GameStrategyQA$Pics();
    public final PBEnumField source = PBField.initEnum(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field ark_random = PBField.initUInt64(0);
    public GameStrategyQA$Videos videos = new GameStrategyQA$Videos();
}
