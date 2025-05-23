package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class signature$SignatureReport extends MessageMicro<signature$SignatureReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64}, new String[]{"u64_uin", "u32_client_type", "u32_is_repack", "str_packname", "str_version", "str_md5", "str_signature", "u32_protocol_version"}, new Object[]{0L, 0, 0, "", "", "", "", 0}, signature$SignatureReport.class);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0);
    public final PBUInt32Field u32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_is_repack = PBField.initUInt32(0);
    public final PBStringField str_packname = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBStringField str_md5 = PBField.initString("");
    public final PBStringField str_signature = PBField.initString("");
    public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
}
