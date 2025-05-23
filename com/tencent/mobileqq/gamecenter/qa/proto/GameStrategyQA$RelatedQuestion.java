package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RelatedQuestion extends MessageMicro<GameStrategyQA$RelatedQuestion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"question_info", "like", "answer_num"}, new Object[]{null, 0L, 0L}, GameStrategyQA$RelatedQuestion.class);
    public GameStrategyQA$QuestionInfo question_info = new GameStrategyQA$QuestionInfo();
    public final PBInt64Field like = PBField.initInt64(0);
    public final PBInt64Field answer_num = PBField.initInt64(0);
}
