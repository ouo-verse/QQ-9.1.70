package com.tencent.pb.webview;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class UrlQuery$UrlQueryRsp extends MessageMicro<UrlQuery$UrlQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_result", "uint32_jump_result", "bytes_jump_url"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, UrlQuery$UrlQueryRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_result = PBField.initUInt32(0);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
