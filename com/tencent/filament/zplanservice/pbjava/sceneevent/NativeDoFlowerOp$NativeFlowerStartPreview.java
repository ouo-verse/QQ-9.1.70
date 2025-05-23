package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerViewData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NativeFlowerStartPreview extends MessageMicro<NativeDoFlowerOp$NativeFlowerStartPreview> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene_address", "uin", "flower_view_list"}, new Object[]{0L, 0L, null}, NativeDoFlowerOp$NativeFlowerStartPreview.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<HuatengSvr$FlowerViewData> flower_view_list = PBField.initRepeatMessage(HuatengSvr$FlowerViewData.class);
}
