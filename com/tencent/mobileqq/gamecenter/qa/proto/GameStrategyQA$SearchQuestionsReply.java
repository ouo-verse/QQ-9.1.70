package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$SearchQuestionsReply extends MessageMicro<GameStrategyQA$SearchQuestionsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"questions"}, new Object[]{null}, GameStrategyQA$SearchQuestionsReply.class);
    public final PBRepeatMessageField<GameStrategyQA$RelatedQuestion> questions = PBField.initRepeatMessage(GameStrategyQA$RelatedQuestion.class);
}
