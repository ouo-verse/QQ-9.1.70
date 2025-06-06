package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class get_config$RspBody extends MessageMicro<get_config$RspBody> {
    public static final int STR_CONFIG_NAME_FIELD_NUMBER = 4;
    public static final int STR_DOWNLOAD_LINK_FIELD_NUMBER = 8;
    public static final int STR_MD5_FIELD_NUMBER = 7;
    public static final int U32_CONFIG_VERSION_FIELD_NUMBER = 5;
    public static final int U32_EFFECT_TIME_FIELD_NUMBER = 6;
    public static final int U32_PROTO_VERSION_FIELD_NUMBER = 3;
    public static final int U32_SEQ_FIELD_NUMBER = 2;
    public static final int U64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66}, new String[]{"u64_uin", "u32_seq", "u32_proto_version", "str_config_name", "u32_config_version", "u32_effect_time", "str_md5", "str_download_link"}, new Object[]{0L, 0, 0, "", 0, 0, "", ""}, get_config$RspBody.class);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_proto_version = PBField.initUInt32(0);
    public final PBStringField str_config_name = PBField.initString("");
    public final PBUInt32Field u32_config_version = PBField.initUInt32(0);
    public final PBUInt32Field u32_effect_time = PBField.initUInt32(0);
    public final PBStringField str_md5 = PBField.initString("");
    public final PBStringField str_download_link = PBField.initString("");
}
