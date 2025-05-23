package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StClearCountReq extends MessageMicro<FeedCloudRead$StClearCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "userId", "clearCountInfos"}, new Object[]{null, "", null}, FeedCloudRead$StClearCountReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StClearCountInfo> clearCountInfos = PBField.initRepeatMessage(FeedCloudRead$StClearCountInfo.class);
}
