package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import qqcircle.QQCircleFeedBase$StPolyLike;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoRewardPersonReq extends MessageMicro<FeedCloudWrite$StDoRewardPersonReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "toUser", "rewardInfo", "from", "src"}, new Object[]{null, null, null, 0, 0}, FeedCloudWrite$StDoRewardPersonReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUser toUser = new FeedCloudMeta$StUser();
    public QQCircleFeedBase$StPolyLike rewardInfo = new QQCircleFeedBase$StPolyLike();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
}
