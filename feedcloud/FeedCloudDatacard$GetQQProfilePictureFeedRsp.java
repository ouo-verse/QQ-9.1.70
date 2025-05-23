package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetQQProfilePictureFeedRsp extends MessageMicro<FeedCloudDatacard$GetQQProfilePictureFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"user_id", "feed", "update_time"}, new Object[]{"", null, 0L}, FeedCloudDatacard$GetQQProfilePictureFeedRsp.class);
    public final PBStringField user_id = PBField.initString("");
    public FeedCloudMeta$StFeedAbstract feed = new FeedCloudMeta$StFeedAbstract();
    public final PBUInt64Field update_time = PBField.initUInt64(0);
}
