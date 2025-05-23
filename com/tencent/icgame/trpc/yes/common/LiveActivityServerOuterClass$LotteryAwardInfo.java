package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$LotteryAwardInfo extends MessageMicro<LiveActivityServerOuterClass$LotteryAwardInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"award_desc", "time_desc", "award_type", "addr_status", "icon"}, new Object[]{"", "", 0, 0, ""}, LiveActivityServerOuterClass$LotteryAwardInfo.class);
    public final PBStringField award_desc = PBField.initString("");
    public final PBStringField time_desc = PBField.initString("");
    public final PBInt32Field award_type = PBField.initInt32(0);
    public final PBInt32Field addr_status = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
}
