package com.tencent.mobileqq.pb.qwallet;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayRecognitionPB$VerifyReq extends MessageMicro<PayRecognitionPB$VerifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id_key", "token_id", CGNonAgeReport.EVENT_CHANNEL}, new Object[]{"", "", ""}, PayRecognitionPB$VerifyReq.class);
    public final PBStringField id_key = PBField.initString("");
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField channel_info = PBField.initString("");
}
