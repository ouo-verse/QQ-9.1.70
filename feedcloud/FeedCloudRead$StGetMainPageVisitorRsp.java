package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMainPageVisitorRsp extends MessageMicro<FeedCloudRead$StGetMainPageVisitorRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 66, 74, 82}, new String[]{"total_data", "total_count", "day_data", "day_count", "video", "comment", "interact", "topic", "shared", "banner"}, new Object[]{null, 0L, null, 0L, null, null, null, null, null, null}, FeedCloudRead$StGetMainPageVisitorRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$VisitorEntry> total_data = PBField.initRepeatMessage(FeedCloudRead$VisitorEntry.class);
    public final PBUInt64Field total_count = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudRead$VisitorEntry> day_data = PBField.initRepeatMessage(FeedCloudRead$VisitorEntry.class);
    public final PBUInt64Field day_count = PBField.initUInt64(0);
    public FeedCloudRead$VideoGuide video = new MessageMicro<FeedCloudRead$VideoGuide>() { // from class: feedcloud.FeedCloudRead$VideoGuide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feed_list", "guide_info", "jump_scheme"}, new Object[]{null, null, ""}, FeedCloudRead$VideoGuide.class);
        public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feed_list = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
        public FeedCloudRead$GuideEntry guide_info = new FeedCloudRead$GuideEntry();
        public final PBRepeatField<String> jump_scheme = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public FeedCloudRead$CommentGuide comment = new MessageMicro<FeedCloudRead$CommentGuide>() { // from class: feedcloud.FeedCloudRead$CommentGuide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"imagesUrl", "guide_info"}, new Object[]{"", null}, FeedCloudRead$CommentGuide.class);
        public final PBRepeatField<String> imagesUrl = PBField.initRepeat(PBStringField.__repeatHelper__);
        public FeedCloudRead$GuideEntry guide_info = new FeedCloudRead$GuideEntry();
    };
    public FeedCloudRead$InteractGuide interact = new MessageMicro<FeedCloudRead$InteractGuide>() { // from class: feedcloud.FeedCloudRead$InteractGuide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guide_info"}, new Object[]{null}, FeedCloudRead$InteractGuide.class);
        public FeedCloudRead$GuideEntry guide_info = new FeedCloudRead$GuideEntry();
    };
    public final PBRepeatMessageField<FeedCloudRead$TopicGuide> topic = PBField.initRepeatMessage(FeedCloudRead$TopicGuide.class);
    public FeedCloudRead$SharedGuide shared = new MessageMicro<FeedCloudRead$SharedGuide>() { // from class: feedcloud.FeedCloudRead$SharedGuide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guide_info"}, new Object[]{null}, FeedCloudRead$SharedGuide.class);
        public FeedCloudRead$GuideEntry guide_info = new FeedCloudRead$GuideEntry();
    };
    public FeedCloudRead$VisitorBanner banner = new MessageMicro<FeedCloudRead$VisitorBanner>() { // from class: feedcloud.FeedCloudRead$VisitorBanner
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40}, new String[]{"text", "count", "icons", "url", "type"}, new Object[]{"", 0L, "", "", 0L}, FeedCloudRead$VisitorBanner.class);
        public final PBStringField text = PBField.initString("");
        public final PBUInt64Field count = PBField.initUInt64(0);
        public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField url = PBField.initString("");
        public final PBUInt64Field type = PBField.initUInt64(0);
    };
}
