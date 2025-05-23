package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$ReqData extends MessageMicro<oidb_0xfe1$ReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"rpt_basic_fieldids", "ext_fieldids", "enum_req_src", "uint32_max_package_size"}, new Object[]{0, null, 0, 0}, oidb_0xfe1$ReqData.class);
    public final PBRepeatField<Integer> rpt_basic_fieldids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xfe1$ReqDataExtFieldIdItem> ext_fieldids = PBField.initRepeatMessage(oidb_0xfe1$ReqDataExtFieldIdItem.class);
    public final PBEnumField enum_req_src = PBField.initEnum(0);
    public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
}
