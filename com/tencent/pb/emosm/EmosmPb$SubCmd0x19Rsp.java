package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x19Rsp extends MessageMicro<EmosmPb$SubCmd0x19Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 61}, new String[]{"uint32_package_id", "str_ip_url", "str_ip_name", "str_ip_detail", "str_op_name", "str_jump_url", "fixed32_time"}, new Object[]{0, "", "", "", "", "", 0}, EmosmPb$SubCmd0x19Rsp.class);
    public final PBUInt32Field uint32_package_id = PBField.initUInt32(0);
    public final PBStringField str_ip_url = PBField.initString("");
    public final PBStringField str_ip_name = PBField.initString("");
    public final PBStringField str_ip_detail = PBField.initString("");
    public final PBStringField str_op_name = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBFixed32Field fixed32_time = PBField.initFixed32(0);
}
