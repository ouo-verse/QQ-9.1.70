package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$InnerInvitee extends MessageMicro<GameStrategyQAInvite$InnerInvitee> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"way", "appid", "inviter", "invitee", "update_time"}, new Object[]{0, 0, 0L, 0L, 0L}, GameStrategyQAInvite$InnerInvitee.class);
    public final PBEnumField way = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field inviter = PBField.initUInt64(0);
    public final PBUInt64Field invitee = PBField.initUInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
}
