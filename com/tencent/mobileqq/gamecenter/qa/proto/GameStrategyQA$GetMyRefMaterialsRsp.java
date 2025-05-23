package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetMyRefMaterialsRsp extends MessageMicro<GameStrategyQA$GetMyRefMaterialsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"list", "is_over"}, new Object[]{null, Boolean.FALSE}, GameStrategyQA$GetMyRefMaterialsRsp.class);
    public final PBRepeatMessageField<GameStrategyQA$RefMaterialInfo> list = PBField.initRepeatMessage(GameStrategyQA$RefMaterialInfo.class);
    public final PBBoolField is_over = PBField.initBool(false);
}
