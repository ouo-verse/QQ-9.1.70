package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NativeFlowerStopPreview extends MessageMicro<NativeDoFlowerOp$NativeFlowerStopPreview> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_address", "uin"}, new Object[]{0L, 0L}, NativeDoFlowerOp$NativeFlowerStopPreview.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
