package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPushPageRsp extends MessageMicro<FeedCloudRead$StGetPushPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField minRate = PBField.initFloat(0.0f);
    public final PBFloatField maxRate = PBField.initFloat(0.0f);
    public final PBFloatField limit = PBField.initFloat(0.0f);
    public final PBUInt64Field userRocketCount = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudRead$PopStUserInfo> popUser = PBField.initRepeatMessage(FeedCloudRead$PopStUserInfo.class);
    public final PBStringField taskCenterJumpUrl = PBField.initString("");
    public final PBStringField rulesJumpUrl = PBField.initString("");
    public final PBStringField exchangeText = PBField.initString("");
    public FeedCloudMeta$PushBrokeToast push_broke_toast = new FeedCloudMeta$PushBrokeToast();

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29, 32, 42, 50, 58, 66, 74}, new String[]{"minRate", "maxRate", "limit", "userRocketCount", "popUser", "taskCenterJumpUrl", "rulesJumpUrl", "exchangeText", "push_broke_toast"}, new Object[]{valueOf, valueOf, valueOf, 0L, null, "", "", "", null}, FeedCloudRead$StGetPushPageRsp.class);
    }
}
