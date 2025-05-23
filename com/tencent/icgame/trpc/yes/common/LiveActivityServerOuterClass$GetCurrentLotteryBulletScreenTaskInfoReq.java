package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoReq extends MessageMicro<LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{AudienceReportConst.ROOM_ID, "uid", "skey", "pskey"}, new Object[]{"", 0L, "", null}, LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField skey = PBField.initString("");
    public CommonOuterClass$PSKey pskey = new CommonOuterClass$PSKey();
}
