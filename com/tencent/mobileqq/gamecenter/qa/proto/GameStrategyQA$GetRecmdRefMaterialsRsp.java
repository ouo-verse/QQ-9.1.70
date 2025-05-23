package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetRecmdRefMaterialsRsp extends MessageMicro<GameStrategyQA$GetRecmdRefMaterialsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, GameStrategyQA$GetRecmdRefMaterialsRsp.class);
    public final PBRepeatMessageField<GameStrategyQA$RefMaterialInfo> list = PBField.initRepeatMessage(GameStrategyQA$RefMaterialInfo.class);
}
