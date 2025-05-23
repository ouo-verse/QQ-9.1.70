package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$FaceControlData extends MessageMicro<AvatarDressInfo$FaceControlData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"control_index", "x_per", "y_per", "side_x_per", "side_y_per"}, new Object[]{0, 0, 0, 0, 0}, AvatarDressInfo$FaceControlData.class);
    public final PBUInt32Field control_index = PBField.initUInt32(0);
    public final PBInt32Field x_per = PBField.initInt32(0);
    public final PBInt32Field y_per = PBField.initInt32(0);
    public final PBInt32Field side_x_per = PBField.initInt32(0);
    public final PBInt32Field side_y_per = PBField.initInt32(0);
}
