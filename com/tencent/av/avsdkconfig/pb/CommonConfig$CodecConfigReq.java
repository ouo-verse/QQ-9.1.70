package com.tencent.av.avsdkconfig.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class CommonConfig$CodecConfigReq extends MessageMicro<CommonConfig$CodecConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"app_id", "app_version", "scenes", "platform_chipinfo", "os_version", "device_name"}, new Object[]{0L, "", 0, "", "", ""}, CommonConfig$CodecConfigReq.class);
    public final PBInt64Field app_id = PBField.initInt64(0);
    public final PBStringField app_version = PBField.initString("");
    public final PBEnumField scenes = PBField.initEnum(0);
    public final PBStringField platform_chipinfo = PBField.initString("");
    public final PBStringField os_version = PBField.initString("");
    public final PBStringField device_name = PBField.initString("");
}
