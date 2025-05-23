package com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class CommonProxyPB$ProxyReq extends MessageMicro<CommonProxyPB$ProxyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"service", "method", "appid", "biz_buf"}, new Object[]{"", "", 0, ByteStringMicro.EMPTY}, CommonProxyPB$ProxyReq.class);
    public final PBStringField service = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBBytesField biz_buf = PBField.initBytes(ByteStringMicro.EMPTY);
}
