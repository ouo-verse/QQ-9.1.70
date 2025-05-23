package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoTopProfileFeedReq extends MessageMicro<FeedCloudWrite$StDoTopProfileFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"extInfo", "topFeedType", "feed", "from"}, new Object[]{null, 0, null, 0}, FeedCloudWrite$StDoTopProfileFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field topFeedType = PBField.initUInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
}
