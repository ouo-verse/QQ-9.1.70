package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetFeedsRsp extends MessageMicro<FeedCloudActivityLandingPage$GetFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"feed_items", "is_finish", "attach_info"}, new Object[]{null, Boolean.FALSE, null}, FeedCloudActivityLandingPage$GetFeedsRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feed_items = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
    public final PBBoolField is_finish = PBField.initBool(false);
    public FeedCloudActivityLandingPage$AttachInfo attach_info = new FeedCloudActivityLandingPage$AttachInfo();
}
