package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$BNReportConfigReq extends MessageMicro<BnrReport$BNReportConfigReq> {
    public static final int GROUP_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"group_info"}, new Object[]{null}, BnrReport$BNReportConfigReq.class);
    public final PBRepeatMessageField<BnrReport$BNReportGroupInfo> group_info = PBField.initRepeatMessage(BnrReport$BNReportGroupInfo.class);
}
