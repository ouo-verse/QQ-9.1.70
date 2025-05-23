package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class MidasOrder$SsoMakeOrderRsp extends MessageMicro<MidasOrder$SsoMakeOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "token", "url_params"}, new Object[]{0, "", ""}, MidasOrder$SsoMakeOrderRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField token = PBField.initString("");
    public final PBStringField url_params = PBField.initString("");
}
