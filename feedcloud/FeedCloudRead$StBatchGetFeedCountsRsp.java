package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedCountsRsp extends MessageMicro<FeedCloudRead$StBatchGetFeedCountsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feedCountInfo", "nextReqTimeInterval"}, new Object[]{null, 0L}, FeedCloudRead$StBatchGetFeedCountsRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$FeedCountEntry> feedCountInfo = PBField.initRepeatMessage(FeedCloudRead$FeedCountEntry.class);
    public final PBUInt64Field nextReqTimeInterval = PBField.initUInt64(0);
}
