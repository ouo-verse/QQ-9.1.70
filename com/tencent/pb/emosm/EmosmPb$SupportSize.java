package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SupportSize extends MessageMicro<EmosmPb$SupportSize> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u32_Width", "u32_height"}, new Object[]{0, 0}, EmosmPb$SupportSize.class);
    public final PBUInt32Field u32_Width = PBField.initUInt32(0);
    public final PBUInt32Field u32_height = PBField.initUInt32(0);
}
