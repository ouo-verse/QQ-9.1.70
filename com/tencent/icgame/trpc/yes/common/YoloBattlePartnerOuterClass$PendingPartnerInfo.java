package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$PendingPartnerInfo extends MessageMicro<YoloBattlePartnerOuterClass$PendingPartnerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 64, 74}, new String[]{"uid", "pay_score", "left_postpone_change", "total_postpone_change", "last_pay_time", "pay_nickname", "last_invite_time", "player_status", "pay_in_7_days_text"}, new Object[]{0L, 0L, 0, 0, 0L, "", 0L, 0, ""}, YoloBattlePartnerOuterClass$PendingPartnerInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field pay_score = PBField.initUInt64(0);
    public final PBInt32Field left_postpone_change = PBField.initInt32(0);
    public final PBInt32Field total_postpone_change = PBField.initInt32(0);
    public final PBUInt64Field last_pay_time = PBField.initUInt64(0);
    public final PBStringField pay_nickname = PBField.initString("");
    public final PBUInt64Field last_invite_time = PBField.initUInt64(0);
    public final PBEnumField player_status = PBField.initEnum(0);
    public final PBStringField pay_in_7_days_text = PBField.initString("");
}
