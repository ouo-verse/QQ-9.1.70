package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$Label extends MessageMicro<SummaryCardBusiEntry$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, 1, null, null, 0, 0}, SummaryCardBusiEntry$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(1);
    public SummaryCardBusiEntry$Color text_color = new SummaryCardBusiEntry$Color();
    public SummaryCardBusiEntry$Color edging_color = new SummaryCardBusiEntry$Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
