package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$BatchAddToWatchLaterReq extends MessageMicro<FeedCloudWatchlater$BatchAddToWatchLaterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_list"}, new Object[]{null}, FeedCloudWatchlater$BatchAddToWatchLaterReq.class);
    public final PBRepeatMessageField<FeedCloudWatchlater$AddWatchLaterEntry> feed_list = PBField.initRepeatMessage(FeedCloudWatchlater$AddWatchLaterEntry.class);
}
