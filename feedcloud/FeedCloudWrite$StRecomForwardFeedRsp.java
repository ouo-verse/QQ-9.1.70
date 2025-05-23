package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StRecomForwardFeedRsp extends MessageMicro<FeedCloudWrite$StRecomForwardFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "feed", "busiRspData", "comment"}, new Object[]{null, null, ByteStringMicro.EMPTY, null}, FeedCloudWrite$StRecomForwardFeedRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
}
