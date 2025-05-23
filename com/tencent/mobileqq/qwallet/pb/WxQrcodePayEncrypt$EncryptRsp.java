package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class WxQrcodePayEncrypt$EncryptRsp extends MessageMicro<WxQrcodePayEncrypt$EncryptRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "token"}, new Object[]{0, "", ""}, WxQrcodePayEncrypt$EncryptRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
