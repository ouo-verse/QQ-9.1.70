package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAAuth$JoinAnswerUserRequest extends MessageMicro<GameStrategyQAAuth$JoinAnswerUserRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"appid"}, new Object[]{0}, GameStrategyQAAuth$JoinAnswerUserRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
