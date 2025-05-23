package com.tencent.im.msg.hummer.resv12;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class MarketFaceExtPb$SupportSize extends MessageMicro<MarketFaceExtPb$SupportSize> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_width", "uint32_height"}, new Object[]{0, 0}, MarketFaceExtPb$SupportSize.class);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
}
