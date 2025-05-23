package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeUndealmsg$FcUndealMsgsRsp extends MessageMicro<FeedCloudEeveeUndealmsg$FcUndealMsgsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"result", "intervalCtl", "msgs", "attachInfo"}, new Object[]{null, null, null, null}, FeedCloudEeveeUndealmsg$FcUndealMsgsRsp.class);
    public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
    public FeedCloudEeveeUndealmsg$IntervalControl intervalCtl = new FeedCloudEeveeUndealmsg$IntervalControl();
    public final PBRepeatMessageField<FeedCloudEeveeUndealmsg$BizUndealMsg> msgs = PBField.initRepeatMessage(FeedCloudEeveeUndealmsg$BizUndealMsg.class);
    public final PBRepeatMessageField<FeedCloudEeveeBase$StEeveeAttachInfo> attachInfo = PBField.initRepeatMessage(FeedCloudEeveeBase$StEeveeAttachInfo.class);
}
