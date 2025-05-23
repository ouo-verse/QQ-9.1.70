package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$ReportStrikeResultReq extends MessageMicro<intchk$ReportStrikeResultReq> {
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
    public static final int UINT32_STRIKE_RESULT_FIELD_NUMBER = 3;
    public static final int UINT32_STRIKE_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_intchk_id", "uint32_strike_type", "uint32_strike_result"}, new Object[]{0, 0, 0}, intchk$ReportStrikeResultReq.class);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strike_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strike_result = PBField.initUInt32(0);
}
