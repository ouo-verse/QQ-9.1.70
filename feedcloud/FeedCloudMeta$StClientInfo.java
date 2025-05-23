package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StClientInfo extends MessageMicro<FeedCloudMeta$StClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feedclientkey", "clientMap"}, new Object[]{"", null}, FeedCloudMeta$StClientInfo.class);
    public final PBStringField feedclientkey = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> clientMap = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
