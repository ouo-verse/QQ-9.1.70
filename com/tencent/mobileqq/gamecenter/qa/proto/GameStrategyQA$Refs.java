package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$Refs extends MessageMicro<GameStrategyQA$Refs> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"refs"}, new Object[]{null}, GameStrategyQA$Refs.class);
    public final PBRepeatMessageField<GameStrategyQA$RefInfo> refs = PBField.initRepeatMessage(GameStrategyQA$RefInfo.class);
}
