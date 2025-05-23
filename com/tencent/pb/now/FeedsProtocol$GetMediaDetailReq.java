package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$GetMediaDetailReq extends MessageMicro<FeedsProtocol$GetMediaDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"querystring"}, new Object[]{ByteStringMicro.EMPTY}, FeedsProtocol$GetMediaDetailReq.class);
    public final PBBytesField querystring = PBField.initBytes(ByteStringMicro.EMPTY);
}
