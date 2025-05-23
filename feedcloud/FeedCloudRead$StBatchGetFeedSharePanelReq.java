package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedSharePanelReq extends MessageMicro<FeedCloudRead$StBatchGetFeedSharePanelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feed_id", "source", "extInfo", "shareStyleType"}, new Object[]{"", 0, null, 0}, FeedCloudRead$StBatchGetFeedSharePanelReq.class);
    public final PBRepeatField<String> feed_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field shareStyleType = PBField.initInt32(0);
}
