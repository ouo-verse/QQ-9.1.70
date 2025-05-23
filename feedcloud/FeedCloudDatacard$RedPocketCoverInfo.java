package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$RedPocketCoverInfo extends MessageMicro<FeedCloudDatacard$RedPocketCoverInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72}, new String[]{"id", "owner", "feed_owner", "feed_id", QQWinkConstants.FEEDTIME, "cover_image", "first_frame", "update_time", "status"}, new Object[]{"", "", "", "", 0L, null, null, 0L, 0L}, FeedCloudDatacard$RedPocketCoverInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398428id = PBField.initString("");
    public final PBStringField owner = PBField.initString("");
    public final PBStringField feed_owner = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field feed_time = PBField.initInt64(0);
    public FeedCloudMeta$StImage cover_image = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StImage first_frame = new FeedCloudMeta$StImage();
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBInt64Field status = PBField.initInt64(0);
}
