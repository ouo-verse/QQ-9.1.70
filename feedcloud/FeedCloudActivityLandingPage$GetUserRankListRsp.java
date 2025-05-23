package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetUserRankListRsp extends MessageMicro<FeedCloudActivityLandingPage$GetUserRankListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rank_list"}, new Object[]{null}, FeedCloudActivityLandingPage$GetUserRankListRsp.class);
    public final PBRepeatMessageField<FeedCloudActivityLandingPage$ActivityRankInfo> rank_list = PBField.initRepeatMessage(FeedCloudActivityLandingPage$ActivityRankInfo.class);
}
