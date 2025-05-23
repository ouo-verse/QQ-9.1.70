package com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SummaryCardSimilarity$Similarity extends MessageMicro<SummaryCardSimilarity$Similarity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icon", "title", "wordings"}, new Object[]{"", "", ""}, SummaryCardSimilarity$Similarity.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatField<String> wordings = PBField.initRepeat(PBStringField.__repeatHelper__);
}
