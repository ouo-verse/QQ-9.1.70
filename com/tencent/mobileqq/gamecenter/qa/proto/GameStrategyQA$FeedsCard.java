package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$FeedsCard extends MessageMicro<GameStrategyQA$FeedsCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"question", "answer"}, new Object[]{null, null}, GameStrategyQA$FeedsCard.class);
    public GameStrategyQA$QuestionBase question = new GameStrategyQA$QuestionBase();
    public GameStrategyQA$AnswerBase answer = new GameStrategyQA$AnswerBase();
}
