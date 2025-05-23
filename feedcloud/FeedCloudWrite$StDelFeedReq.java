package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDelFeedReq extends MessageMicro<FeedCloudWrite$StDelFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "feed", "from", "src"}, new Object[]{null, null, 0, 0}, FeedCloudWrite$StDelFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
}
