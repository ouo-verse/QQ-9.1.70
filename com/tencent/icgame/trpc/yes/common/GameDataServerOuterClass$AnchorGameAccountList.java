package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$AnchorGameAccountList extends MessageMicro<GameDataServerOuterClass$AnchorGameAccountList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "account_list"}, new Object[]{0L, null}, GameDataServerOuterClass$AnchorGameAccountList.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBRepeatMessageField<GameDataServerOuterClass$AnchorGameAccountInfo> account_list = PBField.initRepeatMessage(GameDataServerOuterClass$AnchorGameAccountInfo.class);
}
