package com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SummaryCardSimilarity$GetSummaryCardSimilarityRsp extends MessageMicro<SummaryCardSimilarity$GetSummaryCardSimilarityRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"ret_code", "err_msg", "similarities", "is_strong_similarity", "strong_similarity"}, new Object[]{0, "", null, Boolean.FALSE, null}, SummaryCardSimilarity$GetSummaryCardSimilarityRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<SummaryCardSimilarity$Similarity> similarities = PBField.initRepeatMessage(SummaryCardSimilarity$Similarity.class);
    public final PBBoolField is_strong_similarity = PBField.initBool(false);
    public SummaryCardSimilarity$StrongSimilarity strong_similarity = new SummaryCardSimilarity$StrongSimilarity();
}
