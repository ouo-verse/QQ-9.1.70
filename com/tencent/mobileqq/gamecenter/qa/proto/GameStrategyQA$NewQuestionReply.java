package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewQuestionReply extends MessageMicro<GameStrategyQA$NewQuestionReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"question_id"}, new Object[]{0L}, GameStrategyQA$NewQuestionReply.class);
    public final PBInt64Field question_id = PBField.initInt64(0);
}
