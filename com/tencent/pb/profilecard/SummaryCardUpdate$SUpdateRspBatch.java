package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardUpdate$SUpdateRspBatch extends MessageMicro<SummaryCardUpdate$SUpdateRspBatch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rsps"}, new Object[]{null}, SummaryCardUpdate$SUpdateRspBatch.class);
    public final PBRepeatMessageField<SummaryCardUpdate$SUpdateRsp> rsps = PBField.initRepeatMessage(SummaryCardUpdate$SUpdateRsp.class);
}
