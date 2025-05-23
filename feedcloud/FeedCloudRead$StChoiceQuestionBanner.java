package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StChoiceQuestionBanner extends MessageMicro<FeedCloudRead$StChoiceQuestionBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 7994}, new String[]{"type", "title", "options", "ext_info"}, new Object[]{0, "", null, null}, FeedCloudRead$StChoiceQuestionBanner.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StChoiceQuestionBannerOption> options = PBField.initRepeatMessage(FeedCloudRead$StChoiceQuestionBannerOption.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> ext_info = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
