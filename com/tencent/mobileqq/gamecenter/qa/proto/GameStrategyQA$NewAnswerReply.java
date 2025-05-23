package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewAnswerReply extends MessageMicro<GameStrategyQA$NewAnswerReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"answer_id"}, new Object[]{0L}, GameStrategyQA$NewAnswerReply.class);
    public final PBInt64Field answer_id = PBField.initInt64(0);
}
