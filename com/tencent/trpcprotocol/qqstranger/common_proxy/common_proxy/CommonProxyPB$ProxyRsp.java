package com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class CommonProxyPB$ProxyRsp extends MessageMicro<CommonProxyPB$ProxyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "biz_buf"}, new Object[]{0, "", ByteStringMicro.EMPTY}, CommonProxyPB$ProxyRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBytesField biz_buf = PBField.initBytes(ByteStringMicro.EMPTY);
}
