package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$QueryUserResponseV2 extends MessageMicro<GameStrategyQAInvite$QueryUserResponseV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"qq_title_status", "users", "guru_config"}, new Object[]{0, null, null}, GameStrategyQAInvite$QueryUserResponseV2.class);
    public final PBEnumField qq_title_status = PBField.initEnum(0);
    public final PBRepeatMessageField<GameStrategyQAInvite$UserV2> users = PBField.initRepeatMessage(GameStrategyQAInvite$UserV2.class);
    public GameStrategyQAInvite$GuruConfig guru_config = new GameStrategyQAInvite$GuruConfig();
}
