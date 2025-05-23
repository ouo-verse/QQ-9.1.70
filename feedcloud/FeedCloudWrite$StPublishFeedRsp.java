package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StPublishFeedRsp extends MessageMicro<FeedCloudWrite$StPublishFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "feed", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudWrite$StPublishFeedRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
