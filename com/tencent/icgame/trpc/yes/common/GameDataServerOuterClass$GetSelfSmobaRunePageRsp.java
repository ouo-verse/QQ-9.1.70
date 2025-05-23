package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetSelfSmobaRunePageRsp extends MessageMicro<GameDataServerOuterClass$GetSelfSmobaRunePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rune_pages"}, new Object[]{null}, GameDataServerOuterClass$GetSelfSmobaRunePageRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaRunePage> rune_pages = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaRunePage.class);
}
