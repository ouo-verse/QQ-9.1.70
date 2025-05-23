package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFeedsRsp extends MessageMicro<FeedCloudRead$GetFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"feeds", "isEnd", "attachInfo"}, new Object[]{null, Boolean.FALSE, null}, FeedCloudRead$GetFeedsRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBBoolField isEnd = PBField.initBool(false);
    public FeedCloudRead$GetFeedsAttachInfo attachInfo = new FeedCloudRead$GetFeedsAttachInfo();
}
