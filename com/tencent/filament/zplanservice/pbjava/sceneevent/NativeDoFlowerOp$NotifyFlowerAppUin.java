package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NotifyFlowerAppUin extends MessageMicro<NativeDoFlowerOp$NotifyFlowerAppUin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"scene_address", "room_host_uin", "host_have_flower"}, new Object[]{0L, 0L, Boolean.FALSE}, NativeDoFlowerOp$NotifyFlowerAppUin.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field room_host_uin = PBField.initUInt64(0);
    public final PBBoolField host_have_flower = PBField.initBool(false);
}
