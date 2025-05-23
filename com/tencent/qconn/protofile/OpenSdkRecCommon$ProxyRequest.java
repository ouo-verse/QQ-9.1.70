package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$ProxyRequest extends MessageMicro<OpenSdkRecCommon$ProxyRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "token"}, new Object[]{0L, ByteStringMicro.EMPTY}, OpenSdkRecCommon$ProxyRequest.class);
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
}
