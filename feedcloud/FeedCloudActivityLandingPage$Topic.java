package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$Topic extends MessageMicro<FeedCloudActivityLandingPage$Topic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, new String[]{"id", "name", "order", "play_count", "feed_count", "feed_items", "publish_schema"}, new Object[]{"", "", 0, 0, 0, null, ""}, FeedCloudActivityLandingPage$Topic.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398426id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field order = PBField.initInt32(0);
    public final PBInt32Field play_count = PBField.initInt32(0);
    public final PBInt32Field feed_count = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feed_items = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
    public final PBStringField publish_schema = PBField.initString("");
}
