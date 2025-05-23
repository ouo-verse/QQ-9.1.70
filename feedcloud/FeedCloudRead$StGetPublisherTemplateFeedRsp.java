package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPublisherTemplateFeedRsp extends MessageMicro<FeedCloudRead$StGetPublisherTemplateFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"template_feed"}, new Object[]{null}, FeedCloudRead$StGetPublisherTemplateFeedRsp.class);
    public FeedCloudMeta$StFeed template_feed = new FeedCloudMeta$StFeed();
}
