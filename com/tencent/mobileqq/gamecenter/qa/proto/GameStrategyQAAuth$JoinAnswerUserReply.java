package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAAuth$JoinAnswerUserReply extends MessageMicro<GameStrategyQAAuth$JoinAnswerUserReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"can_join"}, new Object[]{Boolean.FALSE}, GameStrategyQAAuth$JoinAnswerUserReply.class);
    public final PBBoolField can_join = PBField.initBool(false);
}
