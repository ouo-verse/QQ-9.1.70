package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThemeAuth$ReqBody extends MessageMicro<ThemeAuth$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58}, new String[]{"uint32_sub_cmd", "int32_plat_id", "str_qq_version", "uint32_qq_version", "msg_subcmd0x1_req_auth", "msg_subcmd0x2_req_check", "msg_subcmd0x3_req_set"}, new Object[]{0, 0, "", 0, null, null, null}, ThemeAuth$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBInt32Field int32_plat_id = PBField.initInt32(0);
    public final PBStringField str_qq_version = PBField.initString("");
    public final PBUInt32Field uint32_qq_version = PBField.initUInt32(0);
    public ThemeAuth$SubCmd0x1ReqAuth msg_subcmd0x1_req_auth = new ThemeAuth$SubCmd0x1ReqAuth();
    public ThemeAuth$SubCmd0x2ReqCheck msg_subcmd0x2_req_check = new ThemeAuth$SubCmd0x2ReqCheck();
    public ThemeAuth$SubCmd0x3ReqSet msg_subcmd0x3_req_set = new ThemeAuth$SubCmd0x3ReqSet();
}
