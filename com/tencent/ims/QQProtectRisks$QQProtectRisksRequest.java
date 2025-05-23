package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QQProtectRisks$QQProtectRisksRequest extends MessageMicro<QQProtectRisks$QQProtectRisksRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48}, new String[]{"uint32_sec_cmd", "str_package_name", "uint32_app_id", "uint32_country", "str_mask_phone", "support_more_security_check"}, new Object[]{0, "", 0, 0, "", Boolean.FALSE}, QQProtectRisks$QQProtectRisksRequest.class);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
    public final PBStringField str_package_name = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_country = PBField.initUInt32(0);
    public final PBStringField str_mask_phone = PBField.initString("");
    public final PBBoolField support_more_security_check = PBField.initBool(false);
}
