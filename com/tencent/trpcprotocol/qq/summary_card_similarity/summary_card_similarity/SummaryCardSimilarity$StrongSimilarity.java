package com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SummaryCardSimilarity$StrongSimilarity extends MessageMicro<SummaryCardSimilarity$StrongSimilarity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"icon", "content", "time_thread", "start_display", "display_time"}, new Object[]{"", "", 0, 0, 0}, SummaryCardSimilarity$StrongSimilarity.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field time_thread = PBField.initUInt32(0);
    public final PBUInt32Field start_display = PBField.initUInt32(0);
    public final PBUInt32Field display_time = PBField.initUInt32(0);
}
