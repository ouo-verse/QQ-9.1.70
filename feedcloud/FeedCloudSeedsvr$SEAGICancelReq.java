package feedcloud;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGICancelReq extends MessageMicro<FeedCloudSeedsvr$SEAGICancelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"taskType", a.f36094d}, new Object[]{0, ""}, FeedCloudSeedsvr$SEAGICancelReq.class);
    public final PBEnumField taskType = PBField.initEnum(0);
    public final PBStringField taskID = PBField.initString("");
}
