package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$Feed extends MessageMicro<FeedCloudWatchlater$Feed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"feed_info", "add_time", "watch_time", "is_completed"}, new Object[]{null, 0L, 0L, Boolean.FALSE}, FeedCloudWatchlater$Feed.class);
    public FeedCloudMeta$StFeed feed_info = new FeedCloudMeta$StFeed();
    public final PBUInt64Field add_time = PBField.initUInt64(0);
    public final PBUInt64Field watch_time = PBField.initUInt64(0);
    public final PBBoolField is_completed = PBField.initBool(false);
}
