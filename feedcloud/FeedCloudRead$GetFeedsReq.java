package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFeedsReq extends MessageMicro<FeedCloudRead$GetFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"conditions", "from", "attachInfo"}, new Object[]{null, 0, null}, FeedCloudRead$GetFeedsReq.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> conditions = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public FeedCloudRead$GetFeedsAttachInfo attachInfo = new FeedCloudRead$GetFeedsAttachInfo();
}
