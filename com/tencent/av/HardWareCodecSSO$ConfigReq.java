package com.tencent.av;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class HardWareCodecSSO$ConfigReq extends MessageMicro<HardWareCodecSSO$ConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"app_id", "app_ver", "chip", DeviceType.DeviceCategory.MOBILE, "os_version"}, new Object[]{0, "", "", "", 0}, HardWareCodecSSO$ConfigReq.class);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBStringField app_ver = PBField.initString("");
    public final PBStringField chip = PBField.initString("");
    public final PBStringField mobile = PBField.initString("");
    public final PBUInt32Field os_version = PBField.initUInt32(0);
}
