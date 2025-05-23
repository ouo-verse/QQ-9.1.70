package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$TagChallengeRankItem extends MessageMicro<FeedCloudRead$TagChallengeRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"tagInfo", "feedList", "innerAttchInfo"}, new Object[]{null, null, ""}, FeedCloudRead$TagChallengeRankItem.class);
    public FeedCloudMeta$StTagInfo tagInfo = new FeedCloudMeta$StTagInfo();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField innerAttchInfo = PBField.initString("");
}
