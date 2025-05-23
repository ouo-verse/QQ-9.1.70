package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StUserCommentInfo extends MessageMicro<FeedCloudMeta$StUserCommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"opType", "reply", "comment", "feed", "feed_status", "row_id"}, new Object[]{0, null, null, null, 0, ""}, FeedCloudMeta$StUserCommentInfo.class);
    public final PBUInt32Field opType = PBField.initUInt32(0);
    public FeedCloudMeta$StReply reply = new FeedCloudMeta$StReply();
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBUInt32Field feed_status = PBField.initUInt32(0);
    public final PBStringField row_id = PBField.initString("");
}
