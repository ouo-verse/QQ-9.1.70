package com.tencent.mobileqq.pb.qwallet;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayRecognitionPB$AuthenReq extends MessageMicro<PayRecognitionPB$AuthenReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"token_id", CGNonAgeReport.EVENT_CHANNEL, "name", "cre_type", "cre_id"}, new Object[]{"", "", "", 0, ""}, PayRecognitionPB$AuthenReq.class);
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField channel_info = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBEnumField cre_type = PBField.initEnum(0);
    public final PBStringField cre_id = PBField.initString("");
}
