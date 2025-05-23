package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetPowerIndexRsp extends MessageMicro<LiveActivityServerOuterClass$GetPowerIndexRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "uid"}, new Object[]{0L, 0L}, LiveActivityServerOuterClass$GetPowerIndexRsp.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
