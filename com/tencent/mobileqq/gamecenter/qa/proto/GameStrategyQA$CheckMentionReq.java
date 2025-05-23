package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$CheckMentionReq extends MessageMicro<GameStrategyQA$CheckMentionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"guild_id", "channel_id"}, new Object[]{"", ""}, GameStrategyQA$CheckMentionReq.class);
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
}
