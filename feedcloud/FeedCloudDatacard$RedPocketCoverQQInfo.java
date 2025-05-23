package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$RedPocketCoverQQInfo extends MessageMicro<FeedCloudDatacard$RedPocketCoverQQInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66, 74}, new String[]{"id", "title", "default_skin_url", "aio_res_url", "type", "pop_res_url", "merchant", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "stories"}, new Object[]{"", "", "", "", 0, "", null, null, null}, FeedCloudDatacard$RedPocketCoverQQInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398429id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField default_skin_url = PBField.initString("");
    public final PBStringField aio_res_url = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField pop_res_url = PBField.initString("");
    public FeedCloudDatacard$Merchant merchant = new MessageMicro<FeedCloudDatacard$Merchant>() { // from class: feedcloud.FeedCloudDatacard$Merchant
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "logo"}, new Object[]{"", ""}, FeedCloudDatacard$Merchant.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
    };
    public FeedCloudDatacard$Activity activity = new MessageMicro<FeedCloudDatacard$Activity>() { // from class: feedcloud.FeedCloudDatacard$Activity
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "url", "icon"}, new Object[]{"", "", ""}, FeedCloudDatacard$Activity.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
    };
    public final PBRepeatMessageField<FeedCloudDatacard$Story> stories = PBField.initRepeatMessage(FeedCloudDatacard$Story.class);
}
