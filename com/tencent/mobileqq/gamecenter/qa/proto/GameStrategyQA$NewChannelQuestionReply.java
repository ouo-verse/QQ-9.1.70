package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewChannelQuestionReply extends MessageMicro<GameStrategyQA$NewChannelQuestionReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"question_id", "ark_json"}, new Object[]{0L, ""}, GameStrategyQA$NewChannelQuestionReply.class);
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField ark_json = PBField.initString("");
}
