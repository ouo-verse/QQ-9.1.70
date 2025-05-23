package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes12.dex */
public final class GameStrategyQA$Pics extends MessageMicro<GameStrategyQA$Pics> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pic_infos"}, new Object[]{null}, GameStrategyQA$Pics.class);
    public final PBRepeatMessageField<GameStrategyQA$PicInfo> pic_infos = PBField.initRepeatMessage(GameStrategyQA$PicInfo.class);
}
