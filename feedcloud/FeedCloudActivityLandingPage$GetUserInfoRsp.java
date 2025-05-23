package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetUserInfoRsp extends MessageMicro<FeedCloudActivityLandingPage$GetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"activity_rule", "rank_info"}, new Object[]{"", null}, FeedCloudActivityLandingPage$GetUserInfoRsp.class);
    public final PBStringField activity_rule = PBField.initString("");
    public FeedCloudActivityLandingPage$ActivityRankInfo rank_info = new FeedCloudActivityLandingPage$ActivityRankInfo();
}
