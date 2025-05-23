package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeUndealmsg$FcUndealMsgsReq extends MessageMicro<FeedCloudEeveeUndealmsg$FcUndealMsgsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"appid", "uid", "clientInfo", "visitScene", "visitPage", "signalMsg", "attachInfo"}, new Object[]{0, "", null, 0, 0, null, null}, FeedCloudEeveeUndealmsg$FcUndealMsgsReq.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBStringField uid = PBField.initString("");
    public FeedCloudEeveeBase$ClientInfo clientInfo = new FeedCloudEeveeBase$ClientInfo();
    public final PBEnumField visitScene = PBField.initEnum(0);
    public final PBEnumField visitPage = PBField.initEnum(0);
    public FeedCloudEeveeUndealmsg$SignalMsg signalMsg = new FeedCloudEeveeUndealmsg$SignalMsg();
    public final PBRepeatMessageField<FeedCloudEeveeBase$StEeveeAttachInfo> attachInfo = PBField.initRepeatMessage(FeedCloudEeveeBase$StEeveeAttachInfo.class);
}
