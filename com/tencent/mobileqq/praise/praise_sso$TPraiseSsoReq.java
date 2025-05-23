package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class praise_sso$TPraiseSsoReq extends MessageMicro<praise_sso$TPraiseSsoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"i32_cmd", "i32_implat", "str_qq_ver", "st_cmd0x1_req"}, new Object[]{0, 0, "", null}, praise_sso$TPraiseSsoReq.class);
    public final PBInt32Field i32_cmd = PBField.initInt32(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public final PBStringField str_qq_ver = PBField.initString("");
    public praise_sso$TSsoCmd0x1Req st_cmd0x1_req = new praise_sso$TSsoCmd0x1Req();
}
