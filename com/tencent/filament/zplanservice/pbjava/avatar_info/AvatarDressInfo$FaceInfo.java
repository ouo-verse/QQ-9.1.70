package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$FaceInfo extends MessageMicro<AvatarDressInfo$FaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "slot_arr"}, new Object[]{0, null}, AvatarDressInfo$FaceInfo.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatMessageField<AvatarDressInfo$FaceSlotInfo> slot_arr = PBField.initRepeatMessage(AvatarDressInfo$FaceSlotInfo.class);
}
