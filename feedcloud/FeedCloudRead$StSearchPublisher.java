package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchPublisher extends MessageMicro<FeedCloudRead$StSearchPublisher> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"items", "extInfo"}, new Object[]{null, null}, FeedCloudRead$StSearchPublisher.class);
    public final PBRepeatMessageField<FeedCloudRead$StSearchSmallItem> items = PBField.initRepeatMessage(FeedCloudRead$StSearchSmallItem.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
