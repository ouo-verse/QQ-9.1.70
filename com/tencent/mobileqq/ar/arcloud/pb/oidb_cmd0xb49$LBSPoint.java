package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class oidb_cmd0xb49$LBSPoint extends MessageMicro<oidb_cmd0xb49$LBSPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"int32_lat", "int32_lon", "str_name", "str_addr", "uint32_dist"}, new Object[]{900000000, 900000000, "", "", 0}, oidb_cmd0xb49$LBSPoint.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_addr = PBField.initString("");
    public final PBUInt32Field uint32_dist = PBField.initUInt32(0);
}
