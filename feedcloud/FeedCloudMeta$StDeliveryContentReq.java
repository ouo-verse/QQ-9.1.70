package feedcloud;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StDeliveryContentReq extends MessageMicro<FeedCloudMeta$StDeliveryContentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{a.f36094d, "tag", "ContentID", "DisType", "SingleFeedExposure", "MaxExposure", "StartTime", "EndTime", "Opt", "MainDisType"}, new Object[]{0L, "", 0L, 0, 0, 0, 0L, 0L, 0, 0}, FeedCloudMeta$StDeliveryContentReq.class);
    public final PBInt64Field taskID = PBField.initInt64(0);
    public final PBStringField tag = PBField.initString("");
    public final PBRepeatField<Long> ContentID = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBUInt32Field DisType = PBField.initUInt32(0);
    public final PBUInt32Field SingleFeedExposure = PBField.initUInt32(0);
    public final PBUInt32Field MaxExposure = PBField.initUInt32(0);
    public final PBInt64Field StartTime = PBField.initInt64(0);
    public final PBInt64Field EndTime = PBField.initInt64(0);
    public final PBUInt32Field Opt = PBField.initUInt32(0);
    public final PBUInt32Field MainDisType = PBField.initUInt32(0);
}
