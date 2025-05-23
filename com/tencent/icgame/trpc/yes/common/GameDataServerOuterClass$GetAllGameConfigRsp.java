package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetAllGameConfigRsp extends MessageMicro<GameDataServerOuterClass$GetAllGameConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"config_list"}, new Object[]{null}, GameDataServerOuterClass$GetAllGameConfigRsp.class);
    public final PBRepeatMessageField<YesGameInfoOuterClass$GameConfigInfo> config_list = PBField.initRepeatMessage(YesGameInfoOuterClass$GameConfigInfo.class);
}
