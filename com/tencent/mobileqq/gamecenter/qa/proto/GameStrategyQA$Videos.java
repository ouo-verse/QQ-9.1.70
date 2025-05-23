package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$Videos extends MessageMicro<GameStrategyQA$Videos> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"video_infos"}, new Object[]{null}, GameStrategyQA$Videos.class);
    public final PBRepeatMessageField<GameStrategyQA$VideoInfo> video_infos = PBField.initRepeatMessage(GameStrategyQA$VideoInfo.class);
}
