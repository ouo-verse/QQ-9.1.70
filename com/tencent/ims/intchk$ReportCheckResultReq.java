package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$ReportCheckResultReq extends MessageMicro<intchk$ReportCheckResultReq> {
    public static final int RPT_MSG_CHECK_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_intchk_id", "rpt_msg_check_result"}, new Object[]{0, null}, intchk$ReportCheckResultReq.class);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<intchk$CheckResult> rpt_msg_check_result = PBField.initRepeatMessage(intchk$CheckResult.class);
}
