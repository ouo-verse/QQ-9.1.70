package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$AddLotteryAddressReq extends MessageMicro<LiveActivityServerOuterClass$AddLotteryAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{AudienceReportConst.ROOM_ID, "skey", "uid", "name", "phone", "address", "type"}, new Object[]{"", "", 0L, "", "", "", ""}, LiveActivityServerOuterClass$AddLotteryAddressReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField phone = PBField.initString("");
    public final PBStringField address = PBField.initString("");
    public final PBStringField type = PBField.initString("");
}
