package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$BatchUpdateFeedStatusReq extends MessageMicro<FeedCloudWatchlater$BatchUpdateFeedStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{null}, FeedCloudWatchlater$BatchUpdateFeedStatusReq.class);
    public final PBRepeatMessageField<FeedCloudWatchlater$Feed> feeds = PBField.initRepeatMessage(FeedCloudWatchlater$Feed.class);
}
