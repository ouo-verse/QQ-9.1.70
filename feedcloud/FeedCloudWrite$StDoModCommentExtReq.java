package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoModCommentExtReq extends MessageMicro<FeedCloudWrite$StDoModCommentExtReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "feed", "comment", "extType"}, new Object[]{null, null, null, 0}, FeedCloudWrite$StDoModCommentExtReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public final PBInt32Field extType = PBField.initInt32(0);
}
