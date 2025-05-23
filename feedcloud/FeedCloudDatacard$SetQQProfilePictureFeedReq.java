package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$SetQQProfilePictureFeedReq extends MessageMicro<FeedCloudDatacard$SetQQProfilePictureFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"feed_owner", "feed_id", QQWinkConstants.FEEDTIME, "dynamic_pfp_file_id", "static_pfp_file_id"}, new Object[]{"", "", 0L, "", ""}, FeedCloudDatacard$SetQQProfilePictureFeedReq.class);
    public final PBStringField feed_owner = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field feed_time = PBField.initInt64(0);
    public final PBStringField dynamic_pfp_file_id = PBField.initString("");
    public final PBStringField static_pfp_file_id = PBField.initString("");
}
