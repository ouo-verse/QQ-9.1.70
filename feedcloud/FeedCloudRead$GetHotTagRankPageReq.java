package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetHotTagRankPageReq extends MessageMicro<FeedCloudRead$GetHotTagRankPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "feedAttachInfo"}, new Object[]{null, ""}, FeedCloudRead$GetHotTagRankPageReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField feedAttachInfo = PBField.initString("");
}
