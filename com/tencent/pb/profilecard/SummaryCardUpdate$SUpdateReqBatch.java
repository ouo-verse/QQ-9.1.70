package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardUpdate$SUpdateReqBatch extends MessageMicro<SummaryCardUpdate$SUpdateReqBatch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"reqs"}, new Object[]{null}, SummaryCardUpdate$SUpdateReqBatch.class);
    public final PBRepeatMessageField<SummaryCardUpdate$SUpdateReq> reqs = PBField.initRepeatMessage(SummaryCardUpdate$SUpdateReq.class);
}
