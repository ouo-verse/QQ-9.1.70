package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedAbstractRsp extends MessageMicro<FeedCloudRead$StBatchGetFeedAbstractRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "feeds", "moreFeedInfos"}, new Object[]{null, null, null}, FeedCloudRead$StBatchGetFeedAbstractRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> moreFeedInfos = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
