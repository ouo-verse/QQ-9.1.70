package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class MaterialProvider$ReportBubbleRsp extends MessageMicro<MaterialProvider$ReportBubbleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"relationship_value", "door_plate_info", "delta_resource"}, new Object[]{0L, null, null}, MaterialProvider$ReportBubbleRsp.class);
    public final PBUInt64Field relationship_value = PBField.initUInt64(0);
    public WowoConnEmtity$DoorPlate door_plate_info = new WowoConnEmtity$DoorPlate();
    public MaterialProvider$ReportBubbleDeltaRes delta_resource = new MessageMicro<MaterialProvider$ReportBubbleDeltaRes>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.MaterialProvider$ReportBubbleDeltaRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"delta_value", "delta_res_id", "delta_action_id"}, new Object[]{0L, "", ""}, MaterialProvider$ReportBubbleDeltaRes.class);
        public final PBInt64Field delta_value = PBField.initInt64(0);
        public final PBStringField delta_res_id = PBField.initString("");
        public final PBStringField delta_action_id = PBField.initString("");
    };
}
