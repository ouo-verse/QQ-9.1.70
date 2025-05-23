package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WebSsoBody$WebSsoRequestBody extends MessageMicro<WebSsoBody$WebSsoRequestBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 42, 50}, new String[]{"version", "type", "data", "login_sig", "bytes_openid"}, new Object[]{0, 0, "", null, ByteStringMicro.EMPTY}, WebSsoBody$WebSsoRequestBody.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField data = PBField.initString("");
    public WebSsoBody$WebLoginSig login_sig = new WebSsoBody$WebLoginSig();
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
}
