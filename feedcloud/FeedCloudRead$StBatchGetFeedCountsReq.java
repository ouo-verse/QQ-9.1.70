package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedCountsReq extends MessageMicro<FeedCloudRead$StBatchGetFeedCountsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"vecFeed", "fields", "filterFeed"}, new Object[]{null, 0, Boolean.FALSE}, FeedCloudRead$StBatchGetFeedCountsReq.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBRepeatField<Integer> fields = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBBoolField filterFeed = PBField.initBool(false);
}
