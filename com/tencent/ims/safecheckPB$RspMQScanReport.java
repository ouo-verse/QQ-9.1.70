package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class safecheckPB$RspMQScanReport extends MessageMicro<safecheckPB$RspMQScanReport> {
    public static final int RPT_CHECK_ITEM_FIELD_NUMBER = 3;
    public static final int UINT32_CHECK_COUNT_FIELD_NUMBER = 2;
    public static final int UINT32_CHECK_UID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_check_uid", "uint32_check_count", "rpt_check_item"}, new Object[]{0, 0, null}, safecheckPB$RspMQScanReport.class);
    public final PBUInt32Field uint32_check_uid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_check_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<safecheckPB$ReportItem> rpt_check_item = PBField.initRepeatMessage(safecheckPB$ReportItem.class);
}
