package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class antiphishingAlertQuery$RequestPack extends MessageMicro<antiphishingAlertQuery$RequestPack> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{"u32_app_type", "str_url", "i32_xoffset", "i32_yoffset", "u32_ctrl_width", "u32_ctrl_height", "u64_input_uin", "u32_account_type", "u32_cli_url_ver", "u32_seq", "u32_proto_ver"}, new Object[]{0, "", 0, 0, 0, 0, 0L, 0, 0, 0, 0}, antiphishingAlertQuery$RequestPack.class);
    public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field i32_xoffset = PBField.initInt32(0);
    public final PBInt32Field i32_yoffset = PBField.initInt32(0);
    public final PBUInt32Field u32_ctrl_width = PBField.initUInt32(0);
    public final PBUInt32Field u32_ctrl_height = PBField.initUInt32(0);
    public final PBUInt64Field u64_input_uin = PBField.initUInt64(0);
    public final PBUInt32Field u32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_cli_url_ver = PBField.initUInt32(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_proto_ver = PBField.initUInt32(0);
}
