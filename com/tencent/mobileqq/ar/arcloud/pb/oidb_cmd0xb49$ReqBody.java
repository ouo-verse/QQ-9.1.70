package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_cmd0xb49$ReqBody extends MessageMicro<oidb_cmd0xb49$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82}, new String[]{"int32_lat", "int32_lon", "msg_ar_classify_req"}, new Object[]{900000000, 900000000, null}, oidb_cmd0xb49$ReqBody.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public oidb_cmd0xb49$ARClassifyLBSCheckReq msg_ar_classify_req = new oidb_cmd0xb49$ARClassifyLBSCheckReq();
}
