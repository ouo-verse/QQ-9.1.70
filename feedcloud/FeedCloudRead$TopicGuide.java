package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$TopicGuide extends MessageMicro<FeedCloudRead$TopicGuide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"name", "desc", "topic_count", "guide_info"}, new Object[]{"", "", 0L, null}, FeedCloudRead$TopicGuide.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt64Field topic_count = PBField.initUInt64(0);
    public FeedCloudRead$GuideEntry guide_info = new FeedCloudRead$GuideEntry();
}
