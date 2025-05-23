package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$QueryUserListResponseV2 extends MessageMicro<GameStrategyQAInvite$QueryUserListResponseV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"recommends", "invitees"}, new Object[]{"", ""}, GameStrategyQAInvite$QueryUserListResponseV2.class);
    public final PBRepeatField<String> invitees;
    public final PBRepeatField<String> recommends;

    public GameStrategyQAInvite$QueryUserListResponseV2() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.recommends = PBField.initRepeat(pBStringField);
        this.invitees = PBField.initRepeat(pBStringField);
    }
}
