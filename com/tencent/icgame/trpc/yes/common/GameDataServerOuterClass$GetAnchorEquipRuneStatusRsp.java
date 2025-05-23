package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetAnchorEquipRuneStatusRsp extends MessageMicro<GameDataServerOuterClass$GetAnchorEquipRuneStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"anchor_status_list"}, new Object[]{null}, GameDataServerOuterClass$GetAnchorEquipRuneStatusRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$AnchorEquipRuneStatus> anchor_status_list = PBField.initRepeatMessage(GameDataServerOuterClass$AnchorEquipRuneStatus.class);
}
