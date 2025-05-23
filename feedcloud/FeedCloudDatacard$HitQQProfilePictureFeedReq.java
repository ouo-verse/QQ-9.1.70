package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$HitQQProfilePictureFeedReq extends MessageMicro<FeedCloudDatacard$HitQQProfilePictureFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feed_owner", "feed_id", QQWinkConstants.FEEDTIME}, new Object[]{"", "", 0L}, FeedCloudDatacard$HitQQProfilePictureFeedReq.class);
    public final PBStringField feed_owner = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field feed_time = PBField.initInt64(0);
}
