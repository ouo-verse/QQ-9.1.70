package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$CheckListEntry extends MessageMicro<FeedCloudWatchlater$CheckListEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_id", "is_in_watch_later"}, new Object[]{"", Boolean.FALSE}, FeedCloudWatchlater$CheckListEntry.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBBoolField is_in_watch_later = PBField.initBool(false);
}
