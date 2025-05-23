package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$RecvTaskReq extends MessageMicro<LiveActivityServerOuterClass$RecvTaskReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"task_id", AudienceReportConst.ROOM_ID, "skey", "uid", "type"}, new Object[]{0, "", "", 0L, ""}, LiveActivityServerOuterClass$RecvTaskReq.class);
    public final PBInt32Field task_id = PBField.initInt32(0);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField type = PBField.initString("");
}
