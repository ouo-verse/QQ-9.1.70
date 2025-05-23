package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayRecognitionPB$GetFaceParamsReq extends MessageMicro<PayRecognitionPB$GetFaceParamsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"channel_id", "name", "cre_type", "cre_id", "timestamp"}, new Object[]{"", "", 0, "", 0L}, PayRecognitionPB$GetFaceParamsReq.class);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBEnumField cre_type = PBField.initEnum(0);
    public final PBStringField cre_id = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
}
