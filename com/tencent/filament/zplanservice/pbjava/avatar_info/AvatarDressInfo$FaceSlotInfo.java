package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$FaceSlotInfo extends MessageMicro<AvatarDressInfo$FaceSlotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{MiniAppReportManager2.KEY_SLOT_ID, "item_id", "inst_id", "control_points"}, new Object[]{0, 0, 0L, null}, AvatarDressInfo$FaceSlotInfo.class);
    public final PBUInt32Field slot_id = PBField.initUInt32(0);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field inst_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<AvatarDressInfo$FaceControlData> control_points = PBField.initRepeatMessage(AvatarDressInfo$FaceControlData.class);
}
