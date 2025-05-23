package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketCoverRsp extends MessageMicro<FeedCloudDatacard$GetRedPocketCoverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cover", "feed"}, new Object[]{null, null}, FeedCloudDatacard$GetRedPocketCoverRsp.class);
    public FeedCloudDatacard$RedPocketCoverInfo cover = new FeedCloudDatacard$RedPocketCoverInfo();
    public FeedCloudMeta$StFeedAbstract feed = new FeedCloudMeta$StFeedAbstract();
}
