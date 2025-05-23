package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$PushBoxInfo extends MessageMicro<FeedCloudRead$PushBoxInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48}, new String[]{"push_feed", "box_list", "push_time", "push_cnt", "shared_scheme", "update_time"}, new Object[]{null, null, 0, 0, "", 0}, FeedCloudRead$PushBoxInfo.class);
    public FeedCloudMeta$StFeed push_feed = new FeedCloudMeta$StFeed();
    public final PBRepeatMessageField<FeedCloudRead$PushBoxDetail> box_list = PBField.initRepeatMessage(FeedCloudRead$PushBoxDetail.class);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
    public final PBUInt32Field push_cnt = PBField.initUInt32(0);
    public final PBStringField shared_scheme = PBField.initString("");
    public final PBUInt32Field update_time = PBField.initUInt32(0);
}
