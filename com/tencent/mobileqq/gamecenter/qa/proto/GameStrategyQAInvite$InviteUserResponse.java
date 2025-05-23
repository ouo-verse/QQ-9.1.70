package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$InviteUserResponse extends MessageMicro<GameStrategyQAInvite$InviteUserResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uins"}, new Object[]{0L}, GameStrategyQAInvite$InviteUserResponse.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
