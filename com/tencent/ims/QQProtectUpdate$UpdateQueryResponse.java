package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QQProtectUpdate$UpdateQueryResponse extends MessageMicro<QQProtectUpdate$UpdateQueryResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56}, new String[]{"uint32_sec_cmd", "int32_status", "uint32_file_id", "uint32_file_version", "string_file_hash", "string_file_url", "uint32_zip_flag"}, new Object[]{0, 0, 0, 0, "", "", 0}, QQProtectUpdate$UpdateQueryResponse.class);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
    public final PBInt32Field int32_status = PBField.initInt32(0);
    public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_version = PBField.initUInt32(0);
    public final PBStringField string_file_hash = PBField.initString("");
    public final PBStringField string_file_url = PBField.initString("");
    public final PBUInt32Field uint32_zip_flag = PBField.initUInt32(0);
}
