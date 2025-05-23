package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StModifyUgcRightReq extends MessageMicro<FeedCloudWrite$StModifyUgcRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "feed"}, new Object[]{null, null}, FeedCloudWrite$StModifyUgcRightReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
}
