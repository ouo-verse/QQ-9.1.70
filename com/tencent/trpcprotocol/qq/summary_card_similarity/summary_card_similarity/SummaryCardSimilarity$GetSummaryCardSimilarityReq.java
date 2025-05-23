package com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SummaryCardSimilarity$GetSummaryCardSimilarityReq extends MessageMicro<SummaryCardSimilarity$GetSummaryCardSimilarityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, SummaryCardSimilarity$GetSummaryCardSimilarityReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
