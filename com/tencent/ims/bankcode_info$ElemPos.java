package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class bankcode_info$ElemPos extends MessageMicro<bankcode_info$ElemPos> {
    public static final int END_OFFSET_FIELD_NUMBER = 2;
    public static final int START_OFFSET_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_offset", "end_offset"}, new Object[]{0, 0}, bankcode_info$ElemPos.class);
    public final PBUInt32Field start_offset = PBField.initUInt32(0);
    public final PBUInt32Field end_offset = PBField.initUInt32(0);
}
