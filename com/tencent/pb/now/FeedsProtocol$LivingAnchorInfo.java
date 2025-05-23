package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$LivingAnchorInfo extends MessageMicro<FeedsProtocol$LivingAnchorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{AudienceReportConst.ANCHOR_ID, AudienceReportConst.ROOM_ID, "subroom_id", "start_time", "logo_key"}, new Object[]{0L, 0, 0, 0L, 0}, FeedsProtocol$LivingAnchorInfo.class);
    public final PBUInt64Field anchor_id = PBField.initUInt64(0);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field subroom_id = PBField.initUInt32(0);
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt32Field logo_key = PBField.initUInt32(0);
}
