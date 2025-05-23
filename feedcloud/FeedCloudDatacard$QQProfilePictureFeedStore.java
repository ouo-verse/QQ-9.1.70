package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$QQProfilePictureFeedStore extends MessageMicro<FeedCloudDatacard$QQProfilePictureFeedStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58}, new String[]{"feed_owner", "feed_id", QQWinkConstants.FEEDTIME, "update_time", "flag", "dynamic_pfp_file_id", "static_pfp_file_id"}, new Object[]{"", "", 0L, 0L, null, "", ""}, FeedCloudDatacard$QQProfilePictureFeedStore.class);
    public final PBStringField feed_owner = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field feed_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public FeedCloudDatacard$QQProfilePictureFlag flag = new MessageMicro<FeedCloudDatacard$QQProfilePictureFlag>() { // from class: feedcloud.FeedCloudDatacard$QQProfilePictureFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_hit"}, new Object[]{Boolean.FALSE}, FeedCloudDatacard$QQProfilePictureFlag.class);
        public final PBBoolField is_hit = PBField.initBool(false);
    };
    public final PBStringField dynamic_pfp_file_id = PBField.initString("");
    public final PBStringField static_pfp_file_id = PBField.initString("");
}
