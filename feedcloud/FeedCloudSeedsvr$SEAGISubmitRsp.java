package feedcloud;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGISubmitRsp extends MessageMicro<FeedCloudSeedsvr$SEAGISubmitRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField taskID = PBField.initString("");
    public final PBFloatField estimatedTimeCost = PBField.initFloat(0.0f);
    public final PBFloatField queryInterval = PBField.initFloat(0.0f);

    static {
        String[] strArr = {a.f36094d, "estimatedTimeCost", "queryInterval"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 29}, strArr, new Object[]{"", valueOf, valueOf}, FeedCloudSeedsvr$SEAGISubmitRsp.class);
    }
}
