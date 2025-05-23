package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$ControlReqHead extends MessageMicro<PreloadInfoCheckUpdate$ControlReqHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58}, new String[]{"protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin", "mem", "ext1"}, new Object[]{0, 0, "", "", 0L, 0, ""}, PreloadInfoCheckUpdate$ControlReqHead.class);
    public final PBInt32Field protocol_ver = PBField.initInt32(0);
    public final PBInt32Field client_plat_id = PBField.initInt32(0);
    public final PBStringField client_ver = PBField.initString("");
    public final PBStringField os_ver = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field mem = PBField.initUInt32(0);
    public final PBStringField ext1 = PBField.initString("");
}
