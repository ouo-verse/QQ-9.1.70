package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedDetailReq extends MessageMicro<FeedCloudRead$StBatchGetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{"extInfo", "from", "feedIndex", "source", "readControll"}, new Object[]{null, 0, null, 0, null}, FeedCloudRead$StBatchGetFeedDetailReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feedIndex = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudRead$StReadControll readControll = new FeedCloudRead$StReadControll();
}
