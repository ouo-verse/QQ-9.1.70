package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewChannelAnswerReply extends MessageMicro<GameStrategyQA$NewChannelAnswerReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"answer_id", "ark_json"}, new Object[]{0L, ""}, GameStrategyQA$NewChannelAnswerReply.class);
    public final PBInt64Field answer_id = PBField.initInt64(0);
    public final PBStringField ark_json = PBField.initString("");
}
