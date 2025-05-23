package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$ExposeGuruUserRequest extends MessageMicro<GameStrategyQAInvite$ExposeGuruUserRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"appid", "exposed_users", "encoded_exposed_users"}, new Object[]{0, 0L, ""}, GameStrategyQAInvite$ExposeGuruUserRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBRepeatField<Long> exposed_users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<String> encoded_exposed_users = PBField.initRepeat(PBStringField.__repeatHelper__);
}
