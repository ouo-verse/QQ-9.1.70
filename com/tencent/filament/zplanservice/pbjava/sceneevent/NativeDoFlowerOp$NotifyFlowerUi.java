package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NotifyFlowerUi extends MessageMicro<NativeDoFlowerOp$NotifyFlowerUi> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 53}, new String[]{"scene_address", "room_host_uin", "host_have_flower", "flower_data", "ui_coord", "tween_time"}, new Object[]{0L, 0L, Boolean.FALSE, null, null, Float.valueOf(0.0f)}, NativeDoFlowerOp$NotifyFlowerUi.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field room_host_uin = PBField.initUInt64(0);
    public final PBBoolField host_have_flower = PBField.initBool(false);
    public HuatengSvr$FlowerData flower_data = new HuatengSvr$FlowerData();
    public NativeDoFlowerOp$ScreenCoord ui_coord = new NativeDoFlowerOp$ScreenCoord();
    public final PBFloatField tween_time = PBField.initFloat(0.0f);
}
