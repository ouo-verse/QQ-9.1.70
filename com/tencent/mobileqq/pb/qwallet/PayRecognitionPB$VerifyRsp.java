package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class PayRecognitionPB$VerifyRsp extends MessageMicro<PayRecognitionPB$VerifyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"result"}, new Object[]{0}, PayRecognitionPB$VerifyRsp.class);
    public final PBEnumField result = PBField.initEnum(0);
}
