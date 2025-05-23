package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$AddWatchLaterEntry extends MessageMicro<FeedCloudWatchlater$AddWatchLaterEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_id", "watch_time"}, new Object[]{"", 0L}, FeedCloudWatchlater$AddWatchLaterEntry.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field watch_time = PBField.initUInt64(0);
}
