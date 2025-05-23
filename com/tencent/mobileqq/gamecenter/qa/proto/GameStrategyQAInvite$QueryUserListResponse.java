package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$QueryUserListResponse extends MessageMicro<GameStrategyQAInvite$QueryUserListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"recommends", "invitees"}, new Object[]{0L, 0L}, GameStrategyQAInvite$QueryUserListResponse.class);
    public final PBRepeatField<Long> invitees;
    public final PBRepeatField<Long> recommends;

    public GameStrategyQAInvite$QueryUserListResponse() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.recommends = PBField.initRepeat(pBUInt64Field);
        this.invitees = PBField.initRepeat(pBUInt64Field);
    }
}
