package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_cmd0xb49$ARClassifyLBSCheckRsp extends MessageMicro<oidb_cmd0xb49$ARClassifyLBSCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_id", "uint32_lbs_result", "msg_nearest_point"}, new Object[]{"", 0, null}, oidb_cmd0xb49$ARClassifyLBSCheckRsp.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_lbs_result = PBField.initUInt32(0);
    public oidb_cmd0xb49$LBSPoint msg_nearest_point = new oidb_cmd0xb49$LBSPoint();
}
