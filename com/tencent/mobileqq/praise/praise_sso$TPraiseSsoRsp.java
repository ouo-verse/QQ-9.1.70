package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes16.dex */
public final class praise_sso$TPraiseSsoRsp extends MessageMicro<praise_sso$TPraiseSsoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"i32_ret", "st_cmd0x1_rsp"}, new Object[]{0, null}, praise_sso$TPraiseSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public praise_sso$TSsoCmd0x1Rsp st_cmd0x1_rsp = new praise_sso$TSsoCmd0x1Rsp();
}
