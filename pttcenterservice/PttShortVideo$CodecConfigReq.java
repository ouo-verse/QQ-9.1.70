package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PttShortVideo$CodecConfigReq extends MessageMicro<PttShortVideo$CodecConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_platform_chipinfo", "str_os_version", "str_device_name"}, new Object[]{"", "", ""}, PttShortVideo$CodecConfigReq.class);
    public final PBStringField str_platform_chipinfo = PBField.initString("");
    public final PBStringField str_os_version = PBField.initString("");
    public final PBStringField str_device_name = PBField.initString("");
}
