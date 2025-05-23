package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$BNReportConfigRsp extends MessageMicro<BnrReport$BNReportConfigRsp> {
    public static final int CFGLIST_FIELD_NUMBER = 2;
    public static final int RET_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret_info", "cfglist"}, new Object[]{null, null}, BnrReport$BNReportConfigRsp.class);
    public BnrReport$RetInfo ret_info = new BnrReport$RetInfo();
    public final PBRepeatMessageField<BnrReport$BNReportConfig> cfglist = PBField.initRepeatMessage(BnrReport$BNReportConfig.class);
}
