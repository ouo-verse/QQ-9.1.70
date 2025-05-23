package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NativeDoFlowerOpRsp extends MessageMicro<NativeDoFlowerOp$NativeDoFlowerOpRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"scene_address", "do_op_result", "do_op_message", "flower_data", "gif_url"}, new Object[]{0L, 0, "", null, ""}, NativeDoFlowerOp$NativeDoFlowerOpRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt32Field do_op_result = PBField.initUInt32(0);
    public final PBStringField do_op_message = PBField.initString("");
    public HuatengSvr$FlowerData flower_data = new HuatengSvr$FlowerData();
    public final PBStringField gif_url = PBField.initString("");
}
