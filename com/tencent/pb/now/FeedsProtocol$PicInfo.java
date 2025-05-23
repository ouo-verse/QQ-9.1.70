package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$PicInfo extends MessageMicro<FeedsProtocol$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"url", "hight", "width"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, FeedsProtocol$PicInfo.class);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hight = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
}
