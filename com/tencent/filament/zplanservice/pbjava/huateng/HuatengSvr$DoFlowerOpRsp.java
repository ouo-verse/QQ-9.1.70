package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class HuatengSvr$DoFlowerOpRsp extends MessageMicro<HuatengSvr$DoFlowerOpRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"do_op_result", "do_op_message", "flower_data", "gif_url", "anim_res"}, new Object[]{0, "", null, "", ""}, HuatengSvr$DoFlowerOpRsp.class);
    public final PBUInt32Field do_op_result = PBField.initUInt32(0);
    public final PBStringField do_op_message = PBField.initString("");
    public HuatengSvr$FlowerData flower_data = new HuatengSvr$FlowerData();
    public final PBStringField gif_url = PBField.initString("");
    public final PBStringField anim_res = PBField.initString("");
}
