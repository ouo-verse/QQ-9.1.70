package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudAdrepull$GetADRePullRsp extends MessageMicro<FeedCloudAdrepull$GetADRePullRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feeds", "attach_info", "client_info"}, new Object[]{null, "", ByteStringMicro.EMPTY}, FeedCloudAdrepull$GetADRePullRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBytesField client_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
