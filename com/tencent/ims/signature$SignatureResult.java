package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class signature$SignatureResult extends MessageMicro<signature$SignatureResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 72, 80, 88}, new String[]{"u64_uin", "str_packname", "u32_check_result", "str_title", "str_content", "str_left_button", "str_right_button", "str_url", "u32_timeout", "u32_protocol_version", "u32_cache_time"}, new Object[]{0L, "", 0, "", "", "", "", "", 0, 0, 0}, signature$SignatureResult.class);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0);
    public final PBStringField str_packname = PBField.initString("");
    public final PBUInt32Field u32_check_result = PBField.initUInt32(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_left_button = PBField.initString("");
    public final PBStringField str_right_button = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field u32_timeout = PBField.initUInt32(0);
    public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
    public final PBUInt32Field u32_cache_time = PBField.initUInt32(0);
}
